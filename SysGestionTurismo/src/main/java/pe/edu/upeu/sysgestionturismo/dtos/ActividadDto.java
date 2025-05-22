package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ActividadDto {
    private Long idActividad;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String nivelRiesgo;
    private String whatsappContacto;
    private String imagenPath;
    private Long idDestino;
}