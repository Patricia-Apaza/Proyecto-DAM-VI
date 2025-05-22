package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ActividadDto;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;

public class ActividadMapper {

    public static ActividadDto toDto(Actividad actividad) {
        ActividadDto dto = new ActividadDto();
        dto.setIdActividad(actividad.getIdActividad());
        dto.setNombre(actividad.getNombre());
        dto.setDescripcion(actividad.getDescripcion());
        dto.setPrecio(actividad.getPrecio());
        dto.setNivelRiesgo(actividad.getNivelRiesgo());
        dto.setWhatsappContacto(actividad.getWhatsappContacto());
        dto.setImagenPath(actividad.getImagenPath());
        dto.setIdDestino(actividad.getDestino() != null ? actividad.getDestino().getIdDestino() : null);
        return dto;
    }

    public static Actividad toEntity(ActividadDto dto) {
        Actividad actividad = new Actividad();
        actividad.setIdActividad(dto.getIdActividad());
        actividad.setNombre(dto.getNombre());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setPrecio(dto.getPrecio());
        actividad.setNivelRiesgo(dto.getNivelRiesgo());
        actividad.setWhatsappContacto(dto.getWhatsappContacto());
        actividad.setImagenPath(dto.getImagenPath());

        if (dto.getIdDestino() != null) {
            Destino destino = new Destino();
            destino.setIdDestino(dto.getIdDestino());
            actividad.setDestino(destino);
        }

        return actividad;
    }
}