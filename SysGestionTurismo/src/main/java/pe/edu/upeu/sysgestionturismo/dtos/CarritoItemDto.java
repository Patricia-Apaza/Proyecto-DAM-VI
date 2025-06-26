package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarritoItemDto {
    private Long idCarritoItem;
    private Long idCarrito;
    private String tipoItem;
    private Long idReferencia;
    private Integer cantidad;
    private String observaciones;
    private LocalDateTime fechaAgregado;
}
