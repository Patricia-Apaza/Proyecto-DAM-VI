package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.dtos.CrearPagoDto;
import pe.edu.upeu.sysgestionturismo.dtos.PagoDto;
import pe.edu.upeu.sysgestionturismo.mappers.PagoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Carrito;
import pe.edu.upeu.sysgestionturismo.modelo.CarritoItem;
import pe.edu.upeu.sysgestionturismo.modelo.Pago;
import pe.edu.upeu.sysgestionturismo.repositorio.CarritoRepository;
import pe.edu.upeu.sysgestionturismo.repositorio.PagoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IPagoService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public PagoDto crearPago(CrearPagoDto request) {
        Carrito carrito = carritoRepository.findById(request.getIdCarrito())
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        // SUMA DE LOS SUBTOTALES
        BigDecimal totalPen = carrito.getItems().stream()
                .map(CarritoItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal tasaCambio = BigDecimal.ONE;
        BigDecimal montoOriginal = totalPen;

        if (!request.getMoneda().equalsIgnoreCase("PEN")) {
            // Ejemplo de llamada a API
            String url = "https://v6.exchangerate-api.com/v6/d322f06c4df8cfbf6a5079cc/latest/PEN";
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            Map<String, Object> rates = (Map<String, Object>) response.get("conversion_rates");
            tasaCambio = new BigDecimal(String.valueOf(rates.get(request.getMoneda())));
            montoOriginal = totalPen.multiply(tasaCambio);
        }

        Pago pago = new Pago();
        pago.setCarrito(carrito);
        pago.setMoneda(request.getMoneda().toUpperCase());
        pago.setMetodoPago(request.getMetodoPago());
        pago.setMontoConvertido(totalPen);
        pago.setMontoOriginal(montoOriginal);
        pago.setTasaCambio(tasaCambio);
        pago.setEstado(Pago.EstadoPago.PENDIENTE);

        return PagoMapper.toDto(pagoRepository.save(pago));
    }

    @Override
    public PagoDto subirComprobante(Long idPago, MultipartFile file) throws IOException {
        Pago pago = pagoRepository.findById(idPago)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "comprobantes";
        File carpeta = new File(rutaBase);
        if (!carpeta.exists()) carpeta.mkdirs();

        String nombreArchivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File destino = new File(rutaBase, nombreArchivo);
        file.transferTo(destino);

        pago.setRutaComprobante("/uploads/comprobantes/" + nombreArchivo);
        return PagoMapper.toDto(pagoRepository.save(pago));
    }

    @Override
    public PagoDto confirmarPago(Long idPago) {
        Pago pago = pagoRepository.findById(idPago)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        pago.setEstado(Pago.EstadoPago.CONFIRMADO);
        pago.setFechaConfirmacion(java.time.LocalDateTime.now());
        return PagoMapper.toDto(pagoRepository.save(pago));
    }
}
