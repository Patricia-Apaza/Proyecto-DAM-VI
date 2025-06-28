package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PagoDto {
    private Long idPago;
    private Long idCarrito;
    private BigDecimal montoOriginal;
    private BigDecimal montoConvertido;
    private String moneda;
    private BigDecimal tasaCambio;
    private String metodoPago;
    private String rutaComprobante;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaConfirmacion;
}
