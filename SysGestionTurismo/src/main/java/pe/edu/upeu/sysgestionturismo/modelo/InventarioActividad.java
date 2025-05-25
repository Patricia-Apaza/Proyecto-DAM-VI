package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class InventarioActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventarioActividad;

    private String nombreActividad;
    private Date fechaSesion;
    private Time horaInicio;
    private Time horaFin;
    private Integer capacidadPersonas;
    private Integer personasRegistradas = 0;
    private Integer cantidadDisponible;
    private BigDecimal precioPorPersona;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private Actividad actividad;
}
