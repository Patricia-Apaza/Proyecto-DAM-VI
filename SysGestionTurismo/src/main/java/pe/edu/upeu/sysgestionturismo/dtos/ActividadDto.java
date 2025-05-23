package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ActividadDto {
    private Long idActividad;
    private Long idDestino;
    private String nombre;
    private String descripcion;
    private String nivelRiesgo;
    private String whatsappContacto;
    private Double precio;
    private String imagenPath;
}