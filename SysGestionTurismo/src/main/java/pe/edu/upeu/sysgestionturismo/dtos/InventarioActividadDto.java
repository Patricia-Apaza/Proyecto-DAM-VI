package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Data
public class InventarioActividadDto {
    private Long idInventarioActividad;
    private Long idActividad;
    private String nombreActividad;
    private Date fechaSesion;
    private Time horaInicio;
    private Time horaFin;
    private Integer capacidadPersonas;
    private Integer personasRegistradas;
    private Integer cantidadDisponible;
    private BigDecimal precioPorPersona;
    private String descripcion;
}
