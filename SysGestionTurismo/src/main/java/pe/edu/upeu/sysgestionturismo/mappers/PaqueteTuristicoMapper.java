package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {DestinoMapper.class})
public interface PaqueteTuristicoMapper {

    PaqueteTuristicoMapper INSTANCE = Mappers.getMapper(PaqueteTuristicoMapper.class);

    @Mapping(source = "actividadesIncluidas", target = "actividades")
    @Mapping(source = "destinos", target = "destinos")
    @Mapping(source = "hospedaje", target = "hospedaje")
    @Mapping(source = "restaurante", target = "restaurante")
    PaqueteTuristicoDTO toPaqueteTuristicoDTO(PaqueteTuristico paqueteTuristico);

    @Mapping(source = "actividades", target = "actividadesIncluidas")
    @Mapping(source = "destinos", target = "destinos")
    @Mapping(source = "hospedaje", target = "hospedaje")
    @Mapping(source = "restaurante", target = "restaurante")
    PaqueteTuristico toPaqueteTuristico(PaqueteTuristicoDTO paqueteTuristicoDTO);

    List<PaqueteTuristicoDTO> toPaqueteTuristicoDTOs(List<PaqueteTuristico> paquetesTuristicos);
    List<PaqueteTuristico> toPaqueteTuristicos(List<PaqueteTuristicoDTO> paqueteTuristicoDTOs);

    // 👇 Este es el método que necesitabas
    @Mapping(source = "actividades", target = "actividadesIncluidas")
    @Mapping(source = "destinos", target = "destinos")
    @Mapping(source = "hospedaje", target = "hospedaje")
    @Mapping(source = "restaurante", target = "restaurante")
    void updateEntityFromDto(PaqueteTuristicoDTO dto, @MappingTarget PaqueteTuristico entity);

    default List<String> mapActividadesToNombres(List<Actividad> actividades) {
        if (actividades == null) return null;
        return actividades.stream().map(Actividad::getNombre).collect(Collectors.toList());
    }
}