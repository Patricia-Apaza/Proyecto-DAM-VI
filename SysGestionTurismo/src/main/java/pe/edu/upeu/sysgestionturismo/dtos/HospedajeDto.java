package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class HospedajeDto {
    private Long idHospedaje;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String whatsappContacto;
    private Double precioPorNoche;
    private String imagenPath;
    private Long idDestino;
}