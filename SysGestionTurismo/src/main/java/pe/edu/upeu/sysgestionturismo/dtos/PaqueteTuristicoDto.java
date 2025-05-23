package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;
import java.util.List;

@Data
public class PaqueteTuristicoDto {
    private Long idPaqueteTuristico;  // nuevo nombre
    private Long idDestino;
    private String nombre;
    private String descripcion;
    private int duracionDias;
    private String whatsappContacto;
    private Double precioTotal;
    private String imagenPath;
}
