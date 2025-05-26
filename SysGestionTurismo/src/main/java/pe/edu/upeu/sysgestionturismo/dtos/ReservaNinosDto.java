package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ReservaNinosDto {
    private Long idReservaNinos;
    private Long idReservaHospedaje;
    private Long idReservaActividad;
    private Long idReservaPaquete;
    private Long idReservaRestaurante;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String tipoDocumento;
    private String numDocumento;
    private String direccion;
    private Long registradoPorClienteId;
}
