package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CarritoDetalleDto {
    private Long idCarrito;
    private Long idCliente;
    private String estado;
    private LocalDateTime fechaCreacion;
    private Double total;
    private List<CarritoItemDetalleDto> items;
}
