package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.ActividadDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActividadMapper {

    ActividadMapper INSTANCE = Mappers.getMapper(ActividadMapper.class);

    ActividadDTO toActividadDTO(Actividad actividad);

    Actividad toActividad(ActividadDTO actividadDTO);

    List<ActividadDTO> toActividadDTOs(List<Actividad> actividades);

    List<Actividad> toActividades(List<ActividadDTO> actividadDTOs);

    void updateEntityFromDto(ActividadDTO dto, @MappingTarget Actividad entity);
}
