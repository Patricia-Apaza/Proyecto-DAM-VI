package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paquete_actividad")
@Data
public class PaqueteActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaqueteActividad;

    @ManyToOne
    @JoinColumn(name = "id_paquete_turistico")
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private Actividad actividad;
}
