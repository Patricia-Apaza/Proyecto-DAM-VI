package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class CheckoutDto {
    private Long idCheckout;
    private Long idCheckin;
    private String tipoReserva;
    private Timestamp fechaCheckout;
    private Boolean estadoCheckout;
    private String registradoPor;
    private String observacion;
}
