package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CarritoItemDetalleDto {
    private Long idCarritoItem;
    private String tipoItem;
    private Long idReferencia;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private String observaciones;
    private LocalDateTime fechaAgregado;
    private ItemDetalleDto detalle;
}
