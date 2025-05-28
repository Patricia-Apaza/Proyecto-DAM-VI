package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NivelPaquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivelPaquete;

    private String nombreNivel;
    private String descripcion;
}
