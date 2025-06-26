package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.CarritoDto;
import pe.edu.upeu.sysgestionturismo.modelo.Carrito;

import java.util.stream.Collectors;

public class CarritoMapper {

    public static CarritoDto toDto(Carrito entity) {
        CarritoDto dto = new CarritoDto();
        dto.setIdCarrito(entity.getIdCarrito());
        dto.setIdCliente(entity.getCliente() != null ? entity.getCliente().getIdCliente() : null);
        dto.setEstado(entity.getEstado().name());
        dto.setFechaCreacion(entity.getFechaCreacion());

        if (entity.getItems() != null) {
            dto.setItems(entity.getItems().stream()
                    .map(CarritoItemMapper::toDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}
