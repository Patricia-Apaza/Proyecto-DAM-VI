package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ActividadDto;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;

public class ActividadMapper {

    public static ActividadDto toDto(Actividad actividad) {
        ActividadDto dto = new ActividadDto();
        dto.setIdActividad(actividad.getIdActividad());
        dto.setIdDestino(actividad.getDestino() != null ? actividad.getDestino().getIdDestino() : null);
        dto.setNombre(actividad.getNombre());
        dto.setDescripcion(actividad.getDescripcion());
        dto.setNivelRiesgo(actividad.getNivelRiesgo());
        dto.setWhatsappContacto(actividad.getWhatsappContacto());
        dto.setPrecio(actividad.getPrecio());
        dto.setImagenPath(actividad.getImagenPath());
        return dto;
    }

    public static Actividad toEntity(ActividadDto dto) {
        Actividad actividad = new Actividad();
        actividad.setIdActividad(dto.getIdActividad());

        if (dto.getIdDestino() != null) {
            Destino destino = new Destino();
            destino.setIdDestino(dto.getIdDestino());
            actividad.setDestino(destino);
        }

        actividad.setNombre(dto.getNombre());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setNivelRiesgo(dto.getNivelRiesgo());
        actividad.setWhatsappContacto(dto.getWhatsappContacto());
        actividad.setPrecio(dto.getPrecio());
        actividad.setImagenPath(dto.getImagenPath());

        return actividad;
    }
}