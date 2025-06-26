package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CarritoDto {
    private Long idCarrito;
    private Long idCliente;
    private String estado;
    private LocalDateTime fechaCreacion;
    private List<CarritoItemDto> items;
}
