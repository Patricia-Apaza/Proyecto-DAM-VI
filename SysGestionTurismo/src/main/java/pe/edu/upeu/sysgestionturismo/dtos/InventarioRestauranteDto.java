package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class InventarioRestauranteDto {
    private Long idInventarioRestaurante;
    private Long idRestaurante;
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
