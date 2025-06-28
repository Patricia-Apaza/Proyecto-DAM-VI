package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class CrearPagoDto {
    private Long idCarrito;
    private String metodoPago;
    private String moneda; // USD, PEN, EUR
}
