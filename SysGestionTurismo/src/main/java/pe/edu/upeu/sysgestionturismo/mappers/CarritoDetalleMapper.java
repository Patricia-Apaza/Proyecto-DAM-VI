package pe.edu.upeu.sysgestionturismo.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoDetalleDto;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoItemDetalleDto;
import pe.edu.upeu.sysgestionturismo.dtos.ItemDetalleDto;
import pe.edu.upeu.sysgestionturismo.modelo.Carrito;
import pe.edu.upeu.sysgestionturismo.repositorio.ActividadRepository;
import pe.edu.upeu.sysgestionturismo.repositorio.HospedajeRepository;
import pe.edu.upeu.sysgestionturismo.repositorio.MenuDiarioRepository;
import pe.edu.upeu.sysgestionturismo.repositorio.PaqueteTuristicoRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class CarritoDetalleMapper {

    @Autowired
    private ActividadRepository actividadRepository;
    @Autowired
    private HospedajeRepository hospedajeRepository;
    @Autowired
    private MenuDiarioRepository menuDiarioRepository;
    @Autowired
    private PaqueteTuristicoRepository paqueteTuristicoRepository;

    public CarritoDetalleDto toDto(Carrito carrito) {
        CarritoDetalleDto dto = new CarritoDetalleDto();
        dto.setIdCarrito(carrito.getIdCarrito());
        dto.setIdCliente(carrito.getCliente().getIdCliente());
        dto.setEstado(carrito.getEstado().name());
        dto.setFechaCreacion(carrito.getFechaCreacion());

        AtomicReference<Double> total = new AtomicReference<>(0.0);

        List<CarritoItemDetalleDto> itemsDto = carrito.getItems().stream().map(item -> {
            CarritoItemDetalleDto i = new CarritoItemDetalleDto();
            i.setIdCarritoItem(item.getIdCarritoItem());
            i.setTipoItem(item.getTipoItem().name());
            i.setIdReferencia(item.getIdReferencia());
            i.setCantidad(item.getCantidad());
            i.setObservaciones(item.getObservaciones());
            i.setFechaAgregado(item.getFechaAgregado());

            ItemDetalleDto detalle = new ItemDetalleDto();

            switch (item.getTipoItem()) {
                case ACTIVIDAD -> {
                    var act = actividadRepository.findById(item.getIdReferencia()).orElse(null);
                    if (act != null) {
                        detalle.setNombre(act.getNombre());
                        detalle.setDescripcion(act.getDescripcion());
                        detalle.setImagen(act.getImagenPath());
                        detalle.setPrecio(act.getPrecio());
                        i.setPrecioUnitario(act.getPrecio());
                        i.setSubtotal(act.getPrecio() * item.getCantidad());
                    }
                }
                case HOSPEDAJE -> {
                    var hosp = hospedajeRepository.findById(item.getIdReferencia()).orElse(null);
                    if (hosp != null) {
                        detalle.setNombre(hosp.getNombre());
                        detalle.setDescripcion(hosp.getDescripcion());
                        detalle.setImagen(hosp.getImagenPath());
                        detalle.setPrecio(hosp.getPrecioPorNoche());
                        i.setPrecioUnitario(hosp.getPrecioPorNoche());
                        i.setSubtotal(hosp.getPrecioPorNoche() * item.getCantidad());
                    }
                }
                case MENU -> {
                    var menu = menuDiarioRepository.findById(item.getIdReferencia()).orElse(null);
                    if (menu != null) {
                        detalle.setNombre(menu.getNombrePlato());
                        detalle.setDescripcion(menu.getDescripcion());
                        detalle.setImagen(menu.getImagenPath());
                        detalle.setPrecio(menu.getPrecio().doubleValue());
                        i.setPrecioUnitario(menu.getPrecio().doubleValue());
                        i.setSubtotal(menu.getPrecio().doubleValue() * item.getCantidad());
                    }
                }
                case PAQUETE -> {
                    var paquete = paqueteTuristicoRepository.findById(item.getIdReferencia()).orElse(null);
                    if (paquete != null) {
                        detalle.setNombre(paquete.getNombre());
                        detalle.setDescripcion(paquete.getDescripcion());
                        detalle.setImagen(paquete.getImagenPath());
                        detalle.setPrecio(paquete.getPrecioTotal());
                        i.setPrecioUnitario(paquete.getPrecioTotal());
                        i.setSubtotal(paquete.getPrecioTotal() * item.getCantidad());
                    }
                }
                default -> {
                    detalle.setNombre("Desconocido");
                }
            }

            if (i.getSubtotal() != null) {
                total.updateAndGet(v -> v + i.getSubtotal());
            }

            i.setDetalle(detalle);
            return i;
        }).toList();

        dto.setItems(itemsDto);
        dto.setTotal(total.get());

        return dto;
    }
}
