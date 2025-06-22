package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;
import java.util.List;

@Data
public class PaqueteTuristicoDto {
    private Long idPaqueteTuristico;
    private Long idDestino;
    private Long idNivelPaquete;
    private String nombre;
    private String descripcion;
    private int duracionDias;
    private String whatsappContacto;
    private Double precioTotal;
    private String imagenPath;

    // Listas de IDs para las relaciones
    private List<Long> actividadesIds;
    private List<Long> destinosIds;
    private List<Long> hospedajesIds;
    private List<Long> restaurantesIds;

    // Para mostrar información completa (solo lectura)
    private String nombreNivelPaquete;
    private String nombreDestino;
    private List<String> nombresActividades;
    private List<String> nombresDestinos;
    private List<String> nombresHospedajes;
    private List<String> nombresRestaurantes;
}
