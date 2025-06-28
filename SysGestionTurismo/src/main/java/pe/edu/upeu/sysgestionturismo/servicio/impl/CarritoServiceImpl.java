package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.AgregarCarritoDto;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoDto;
import pe.edu.upeu.sysgestionturismo.mappers.CarritoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.*;
import pe.edu.upeu.sysgestionturismo.repositorio.*;
import pe.edu.upeu.sysgestionturismo.servicio.ICarritoService;

import java.util.Collections;
import java.util.ArrayList;

@Service
public class CarritoServiceImpl implements ICarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private HospedajeRepository hospedajeRepository;

    @Autowired
    private MenuDiarioRepository menuRepository;

    @Autowired
    private PaqueteTuristicoRepository paqueteTuristicoRepository;

    @Override
    public CarritoDto agregarAlCarrito(AgregarCarritoDto dto) {
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Carrito carrito = carritoRepository.findByClienteAndEstado(cliente, Carrito.EstadoCarrito.ACTIVO)
                .orElseGet(() -> {
                    Carrito nuevo = new Carrito();
                    nuevo.setCliente(cliente);
                    nuevo.setEstado(Carrito.EstadoCarrito.ACTIVO);
                    nuevo.setItems(new ArrayList<>());
                    return carritoRepository.save(nuevo);
                });

        CarritoItem.TipoItem tipoItemEnum = CarritoItem.TipoItem.valueOf(dto.getTipoItem().toUpperCase());

        CarritoItem item = carritoItemRepository
                .findByCarritoAndTipoItemAndIdReferencia(carrito, tipoItemEnum, dto.getIdReferencia())
                .orElseGet(() -> {
                    CarritoItem nuevoItem = new CarritoItem();
                    nuevoItem.setCarrito(carrito);
                    nuevoItem.setTipoItem(tipoItemEnum);
                    nuevoItem.setIdReferencia(dto.getIdReferencia());
                    nuevoItem.setCantidad(0);
                    return nuevoItem;
                });

        int cantidad = dto.getCantidad() != null ? dto.getCantidad() : 1;
        item.setCantidad(item.getCantidad() + cantidad);
        item.setObservaciones(dto.getObservaciones());

        // Buscar el precio real
        java.math.BigDecimal precioUnitario = java.math.BigDecimal.ZERO;

        switch (tipoItemEnum) {
            case ACTIVIDAD:
                precioUnitario = java.math.BigDecimal.valueOf(
                        actividadRepository.findById(dto.getIdReferencia())
                                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"))
                                .getPrecio()
                );
                break;
            case HOSPEDAJE:
                precioUnitario = java.math.BigDecimal.valueOf(
                        hospedajeRepository.findById(dto.getIdReferencia())
                                .orElseThrow(() -> new RuntimeException("Hospedaje no encontrado"))
                                .getPrecioPorNoche()
                );
                break;
            case MENU:
                precioUnitario = menuRepository.findById(dto.getIdReferencia())
                        .orElseThrow(() -> new RuntimeException("Menú no encontrado"))
                        .getPrecio();
                break;
            case PAQUETE:
                precioUnitario = java.math.BigDecimal.valueOf(
                        paqueteTuristicoRepository.findById(dto.getIdReferencia())
                                .orElseThrow(() -> new RuntimeException("Paquete no encontrado"))
                                .getPrecioTotal()
                );
                break;
            default:
                throw new RuntimeException("Tipo de item no soportado");
        }

        item.setPrecioUnitario(precioUnitario);
        item.setSubtotal(precioUnitario.multiply(java.math.BigDecimal.valueOf(item.getCantidad())));

        carritoItemRepository.save(item);
        carrito.getItems().add(item);

        Carrito carritoConItems = carritoRepository.findConItemsById(carrito.getIdCarrito())
                .orElseThrow(() -> new RuntimeException("Error al recuperar carrito con ítems"));

        return CarritoMapper.toDto(carritoConItems);
    }
}
