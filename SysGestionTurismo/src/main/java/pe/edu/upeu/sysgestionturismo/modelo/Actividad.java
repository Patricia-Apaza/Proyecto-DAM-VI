package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    private String nombre;
    private String descripcion;
    private Double precio;
    private String nivelRiesgo;
    private String whatsappContacto;
    private String imagenPath;

    @ManyToOne
    @JoinColumn(name = "idDestino")
    private Destino destino;
}