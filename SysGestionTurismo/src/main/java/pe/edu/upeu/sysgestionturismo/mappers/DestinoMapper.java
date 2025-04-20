
package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.DestinoDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DestinoMapper {

    DestinoMapper INSTANCE = Mappers.getMapper(DestinoMapper.class);

    @Mapping(target = "actividades", source = "actividades")
    DestinoDTO toDestinoDTO(Destino destino);

    default List<String> mapActividadesToString(List<Actividad> actividades) {
        if (actividades == null) return null;
        return actividades.stream()
                .map(Actividad::getNombre)
                .collect(Collectors.toList());
    }

    default List<Actividad> mapActividadesFromString(List<String> nombresActividades) {
        if (nombresActividades == null) return null;
        return nombresActividades.stream()
                .map(nombre -> new Actividad(nombre, "Descripción no disponible", 60, 0.0))
                .collect(Collectors.toList());
    }

    @Mapping(target = "actividades", source = "actividades")
    Destino toEntity(DestinoDTO destinoDTO);

    @Mapping(target = "actividades", expression = "java(mapActividadesFromString(destinoDTO.getActividades()))")
    void updateEntityFromDto(DestinoDTO destinoDTO, @MappingTarget Destino destino);
}