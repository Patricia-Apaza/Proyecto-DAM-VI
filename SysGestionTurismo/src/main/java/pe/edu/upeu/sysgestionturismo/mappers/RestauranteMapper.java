package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.RestauranteDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    RestauranteDTO toRestauranteDTO(Restaurante restaurante);

    Restaurante toRestaurante(RestauranteDTO restauranteDTO);

    List<RestauranteDTO> toRestauranteDTOs(List<Restaurante> restaurantes);

    List<Restaurante> toRestaurantes(List<RestauranteDTO> restauranteDTOs);

    void updateEntityFromDto(RestauranteDTO restauranteDTO, @MappingTarget Restaurante restaurante);

}