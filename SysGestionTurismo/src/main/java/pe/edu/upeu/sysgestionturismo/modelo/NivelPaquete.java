package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "nivel_paquete")
@Data
public class NivelPaquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivelPaquete;

    @Column(name = "nombre_nivel", nullable = false, length = 50)
    private String nombreNivel;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}
