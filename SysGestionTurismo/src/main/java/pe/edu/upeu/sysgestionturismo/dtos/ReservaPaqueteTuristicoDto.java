package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReservaPaqueteTuristicoDto {
    private Long idReservaPaqueteTuristico;
    private Long idReserva;
    private Long idInventarioPaquete;
    private Boolean disponible = true;
    private Integer cantidadPersonas;
    private Boolean incluyeNinos = false;
    private Integer cantidadNinos = 0;
    private String estadoReserva = "pendiente";
    private Timestamp fechaReserva;
}
