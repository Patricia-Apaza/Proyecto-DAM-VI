package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ResenaDto {
    private Long idResena;
    private String comentario;
    private Integer calificacion;
    private Long idCliente;
    private Long idDestino;
}
