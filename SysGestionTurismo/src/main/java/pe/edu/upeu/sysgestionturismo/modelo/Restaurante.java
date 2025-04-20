package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "restaurante")

public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    private String telefono;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Reseña> reseñas;
}