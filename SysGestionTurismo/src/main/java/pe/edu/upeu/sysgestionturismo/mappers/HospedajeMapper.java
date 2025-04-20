package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.CheckOutDTO;
import pe.edu.upeu.sysgestionturismo.dtos.HospedajeDTO;
import pe.edu.upeu.sysgestionturismo.modelo.CheckOut;
import pe.edu.upeu.sysgestionturismo.modelo.Hospedaje;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HospedajeMapper {

    HospedajeMapper INSTANCE = Mappers.getMapper(HospedajeMapper.class);

    HospedajeDTO toHospedajeDTO(Hospedaje hospedaje);

    Hospedaje toHospedaje(HospedajeDTO hospedajeDTO);

    List<HospedajeDTO> toHospedajeDTOs(List<Hospedaje> hospedajes);

    List<Hospedaje> toHospedajes(List<HospedajeDTO> hospedajeDTOs);

    void updateEntityFromDto(HospedajeDTO dto, @MappingTarget Hospedaje hospedaje);
}