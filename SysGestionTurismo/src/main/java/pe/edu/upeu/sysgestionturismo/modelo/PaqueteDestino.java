package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paquete_destino")
@Data
public class PaqueteDestino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaqueteDestino;

    @ManyToOne
    @JoinColumn(name = "id_paquete_turistico")
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;
}
