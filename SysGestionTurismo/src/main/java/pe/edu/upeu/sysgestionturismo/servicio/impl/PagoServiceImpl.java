package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.PagoDTO;
import pe.edu.upeu.sysgestionturismo.mappers.PagoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Pago;
import pe.edu.upeu.sysgestionturismo.repositorio.IPagoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IPagoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private IPagoRepository pagoRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public List<PagoDTO> obtenerTodosLosPagos() {  // Cambié el nombre del método a 'obtenerTodosLosPagos'
        List<Pago> pagos = pagoRepository.findAll();
        return pagos.stream()
                .map(pagoMapper::toPagoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO obtenerPagoPorId(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return pagoMapper.toPagoDTO(pago);
    }

    @Override
    public PagoDTO registrarPago(PagoDTO pagoDTO) {
        Pago pago = pagoMapper.toPago(pagoDTO);
        Pago pagoGuardado = pagoRepository.save(pago);
        return pagoMapper.toPagoDTO(pagoGuardado);
    }

    @Override
    public PagoDTO actualizarPago(Long id, PagoDTO pagoDTO) {
        Pago pagoExistente = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        pagoMapper.updateEntityFromDto(pagoDTO, pagoExistente);
        Pago pagoActualizado = pagoRepository.save(pagoExistente);
        return pagoMapper.toPagoDTO(pagoActualizado);
    }

    @Override
    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }

    @Override
    public String procesarPago(PagoDTO pagoDTO) {
        // Aquí puedes agregar la lógica para procesar el pago (por ejemplo, validación de métodos de pago)
        // Por ahora, estamos simulando el procesamiento
        return "Pago procesado con éxito";
    }
}