package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.CarritoItemDto;
import pe.edu.upeu.sysgestionturismo.modelo.CarritoItem;

public class CarritoItemMapper {

    public static CarritoItemDto toDto(CarritoItem entity) {
        CarritoItemDto dto = new CarritoItemDto();
        dto.setIdCarritoItem(entity.getIdCarritoItem());
        dto.setIdCarrito(entity.getCarrito() != null ? entity.getCarrito().getIdCarrito() : null);
        dto.setTipoItem(entity.getTipoItem().name());
        dto.setIdReferencia(entity.getIdReferencia());
        dto.setCantidad(entity.getCantidad());
        dto.setObservaciones(entity.getObservaciones());
        dto.setFechaAgregado(entity.getFechaAgregado());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setSubtotal(entity.getSubtotal());
        return dto;
    }
}
