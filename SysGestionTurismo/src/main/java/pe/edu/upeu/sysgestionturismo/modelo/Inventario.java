package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreItem;

    private String descripcion;

    private int cantidad;

    private LocalDate fechaRegistro;

    private String estado;

     @ManyToOne
     @JoinColumn(name = "hospedaje_id")
     private Hospedaje hospedaje;

     @ManyToOne
     @JoinColumn(name = "restaurante_id")
     private Restaurante restaurante;
}