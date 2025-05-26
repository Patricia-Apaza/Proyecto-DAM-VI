package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ReservaRestauranteDto {

    private Long idReservaRestaurante;
    private Long idReserva;
    private Long idRestaurante;
    private Date fecha;
    private Time hora;
    private Integer cantidadPersonas;
    private Boolean incluyeNinos = false;
    private Integer cantidadNinos = 0;
    private String estado = "Pendiente";

}
