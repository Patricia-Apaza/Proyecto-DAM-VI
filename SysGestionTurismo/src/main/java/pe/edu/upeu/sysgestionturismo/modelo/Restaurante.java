package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurante;

    private String nombre;
    private String descripcion;
    private String direccion;
    private String whatsappContacto;
    private String imagenPath;

    @ManyToOne
    @JoinColumn(name = "idDestino")
    private Destino destino;
}