package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Inventario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    InventarioMapper INSTANCE = Mappers.getMapper(InventarioMapper.class);

    InventarioDTO toInventarioDTO(Inventario inventario);

    Inventario toInventario(InventarioDTO inventarioDTO);

    List<InventarioDTO> toInventarioDTOs(List<Inventario> inventarios);

    List<Inventario> toInventarios(List<InventarioDTO> inventarioDTOs);

    // Actualiza la entidad Inventario con los valores de InventarioDTO
    void updateEntityFromDto(InventarioDTO inventarioDTO, @MappingTarget Inventario inventario);
}