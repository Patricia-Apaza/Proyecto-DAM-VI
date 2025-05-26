package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReservaHospedajeDto {
    private Long idReservaHospedaje;
    private Long idReserva;
    private Long idInventarioHospedaje;
    private Boolean disponible = true;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private Integer cantidadHabitaciones;
    private Integer cantidadPersonas;
    private Boolean incluyeNinos = false;
    private Integer cantidadNinos = 0;
    private Boolean incluyeDesayuno = false;
    private String estadoReserva = "pendiente";
}
