package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "paquete_turistico")
public class PaqueteTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private int duracionDias;

    @ManyToMany
    @JoinTable(
            name = "paquete_actividades",
            joinColumns = @JoinColumn(name = "paquete_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id")
    )
    private List<Actividad> actividadesIncluidas;

    @ManyToMany
    @JoinTable(
            name = "paquete_destinos",
            joinColumns = @JoinColumn(name = "paquete_id"),
            inverseJoinColumns = @JoinColumn(name = "destino_id")
    )
    private List<Destino> destinos;

    @ManyToOne
    @JoinColumn(name = "hospedaje_id")
    private Hospedaje hospedaje;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}