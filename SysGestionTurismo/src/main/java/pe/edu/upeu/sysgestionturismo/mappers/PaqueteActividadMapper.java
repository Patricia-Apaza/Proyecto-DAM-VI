package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteActividadDto;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteActividad;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;

public class PaqueteActividadMapper {

    public static PaqueteActividadDto toDto(PaqueteActividad entity) {
        PaqueteActividadDto dto = new PaqueteActividadDto();
        dto.setIdPaqueteActividad(entity.getIdPaqueteActividad());
        dto.setIdPaqueteTuristico(entity.getPaqueteTuristico().getIdPaqueteTuristico());
        dto.setIdActividad(entity.getActividad().getIdActividad());
        return dto;
    }

    public static PaqueteActividad toEntity(PaqueteActividadDto dto) {
        PaqueteActividad entity = new PaqueteActividad();
        entity.setIdPaqueteActividad(dto.getIdPaqueteActividad());

        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setIdPaqueteTuristico(dto.getIdPaqueteTuristico());
        entity.setPaqueteTuristico(paquete);

        Actividad actividad = new Actividad();
        actividad.setIdActividad(dto.getIdActividad());
        entity.setActividad(actividad);

        return entity;
    }
}
