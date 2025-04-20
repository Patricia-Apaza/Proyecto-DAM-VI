package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hospedaje")
public class Hospedaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private String direccion;

    private String telefono;

    private Double precioPorNoche;

    private String imagenUrl;

    // Relación con el destino
    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;
}