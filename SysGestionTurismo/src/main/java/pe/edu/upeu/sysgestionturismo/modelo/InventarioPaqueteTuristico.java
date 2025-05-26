package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class InventarioPaqueteTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventarioPaqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "idPaqueteTuristico")
    private PaqueteTuristico paqueteTuristico;

    private LocalDate fechaSalida;
    private LocalDate fechaRetorno;
    private LocalTime horaSalida;
    private Integer capacidadPersonas;
    private Integer personasRegistradas;
    private BigDecimal precioPorPersona;
    private String descripcion;
    private String imagenPath;
}
