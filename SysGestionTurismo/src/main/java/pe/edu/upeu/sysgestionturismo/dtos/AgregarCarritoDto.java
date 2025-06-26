package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class AgregarCarritoDto {
    private Long idCliente;
    private String tipoItem; // "actividad", "menu", "restaurante", etc.
    private Long idReferencia;
    private Integer cantidad;
    private String observaciones;
}
