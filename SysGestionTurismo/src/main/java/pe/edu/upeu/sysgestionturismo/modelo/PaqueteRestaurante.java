package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "paquete_restaurante")
@Data
public class PaqueteRestaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaqueteRestaurante;

    @ManyToOne
    @JoinColumn(name = "id_paquete_turistico")
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;
}
