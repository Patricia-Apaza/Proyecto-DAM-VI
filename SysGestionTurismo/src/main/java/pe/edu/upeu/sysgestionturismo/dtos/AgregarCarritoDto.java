package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class AgregarCarritoDto {
    private Long idCliente;
    private Long idUsuario;
    private String tipoItem;
    private Long idReferencia;
    private Integer cantidad;
    private String observaciones;
}
