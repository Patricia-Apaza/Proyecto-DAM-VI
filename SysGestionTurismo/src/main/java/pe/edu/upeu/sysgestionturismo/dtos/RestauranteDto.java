package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class RestauranteDto {
    private Long idRestaurante;
    private Long idDestino;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String whatsappContacto;
    private String imagenPath;
}