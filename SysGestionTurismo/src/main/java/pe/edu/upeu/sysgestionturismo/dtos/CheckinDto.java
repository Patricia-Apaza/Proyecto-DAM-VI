package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CheckinDto {
    private Long idCheckin;
    private Long idReserva;
    private String tipoReserva;
    private Timestamp fechaCheckin;
    private Boolean estadoCheckin;
    private String registradoPor;
    private String observacion;
}
