package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.ReseñaDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Reseña;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReseñaMapper {

    ReseñaMapper INSTANCE = Mappers.getMapper(ReseñaMapper.class);

    ReseñaDTO toReseñaDTO(Reseña reseña);

    Reseña toReseña(ReseñaDTO reseñaDTO);

    List<ReseñaDTO> toReseñaDTOs(List<Reseña> reseñas);

    List<Reseña> toReseñas(List<ReseñaDTO> reseñaDTOs);

    void updateEntityFromDto(ReseñaDTO reseñaDTO, @MappingTarget Reseña reseña);
}