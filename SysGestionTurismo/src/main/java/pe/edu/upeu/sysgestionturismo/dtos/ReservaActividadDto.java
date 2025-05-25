package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class ReservaActividadDto {
    private Long idReservaActividad;
    private Long idReserva;
    private Long idInventarioActividad;
    private Boolean disponible = true;
    private Integer cantidadPersonas;
    private Boolean incluyeNinos = false;
    private Integer cantidadNinos = 0;
    private String estadoReserva = "pendiente";
    private Timestamp fechaReserva;
}
