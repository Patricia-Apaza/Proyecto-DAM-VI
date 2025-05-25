package pe.edu.upeu.sysgestionturismo.mappers;

import org.springframework.stereotype.Component;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioActividadDto;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioActividad;

@Component
public class InventarioActividadMapper {

    public InventarioActividadDto toDto(InventarioActividad entity) {
        InventarioActividadDto dto = new InventarioActividadDto();
        dto.setIdInventarioActividad(entity.getIdInventarioActividad());
        dto.setIdActividad(entity.getActividad() != null ? entity.getActividad().getIdActividad() : null);
        dto.setNombreActividad(entity.getNombreActividad());
        dto.setFechaSesion(entity.getFechaSesion());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setHoraFin(entity.getHoraFin());
        dto.setCapacidadPersonas(entity.getCapacidadPersonas());
        dto.setPersonasRegistradas(entity.getPersonasRegistradas());
        dto.setCantidadDisponible(entity.getCantidadDisponible());
        dto.setPrecioPorPersona(entity.getPrecioPorPersona());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

    public InventarioActividad toEntity(InventarioActividadDto dto) {
        InventarioActividad entity = new InventarioActividad();
        entity.setIdInventarioActividad(dto.getIdInventarioActividad());
        if (dto.getIdActividad() != null) {
            Actividad actividad = new Actividad();
            actividad.setIdActividad(dto.getIdActividad());
            entity.setActividad(actividad);
        } else {
            entity.setActividad(null);
        }
        entity.setNombreActividad(dto.getNombreActividad());
        entity.setFechaSesion(dto.getFechaSesion());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());
        entity.setCapacidadPersonas(dto.getCapacidadPersonas());
        entity.setPersonasRegistradas(dto.getPersonasRegistradas());
        entity.setCantidadDisponible(dto.getCantidadDisponible());
        entity.setPrecioPorPersona(dto.getPrecioPorPersona());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }
}
