package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class InventarioHospedajeDto {
    private Long idInventarioHospedaje;
    private Long idHospedaje;
    private String tipoCuarto;
    private String tipoCama;
    private Boolean banoPrivado;
    private Double precioPorNoche;
    private String descripcion;
    private Integer cantidadTotal;
    private Integer cantidadDisponible;
}
