package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class PaqueteTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaqueteTuristico;

    private String nombre;
    private String descripcion;
    private int duracionDias;
    private String whatsappContacto;
    private Double precioTotal;
    private String imagenPath;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;
}