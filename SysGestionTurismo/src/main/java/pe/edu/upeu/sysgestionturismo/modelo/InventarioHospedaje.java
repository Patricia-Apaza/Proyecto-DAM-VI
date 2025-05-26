package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InventarioHospedaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventarioHospedaje;

    private String tipoCuarto;
    private String tipoCama;
    private Boolean banoPrivado;
    private Double precioPorNoche;
    private String descripcion;
    private Integer cantidadTotal;
    private Integer cantidadDisponible;

    @ManyToOne
    @JoinColumn(name = "idHospedaje")
    private Hospedaje hospedaje;
}
