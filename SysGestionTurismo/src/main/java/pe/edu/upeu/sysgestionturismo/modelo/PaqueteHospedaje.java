package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PaqueteHospedaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaqueteHospedaje;

    @ManyToOne
    @JoinColumn(name = "id_paquete_turistico")
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "id_hospedaje")
    private Hospedaje hospedaje;
}
