package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InventarioRestaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventarioRestaurante;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    private String tipoProducto;
    private String nombreProducto;
    private Integer cantidadDisponibleProducto;
    private Integer cantidadTotalProducto;
    private Integer totalMesas;
    private Integer mesasDisponibles;
    private Integer capacidadPorMesa;
    private Double precio;
    private String observaciones;
}
