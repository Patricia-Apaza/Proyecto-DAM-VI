package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ItemDetalleDto {
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
}
