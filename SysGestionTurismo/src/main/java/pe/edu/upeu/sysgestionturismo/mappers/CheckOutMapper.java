package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.ActividadDTO;
import pe.edu.upeu.sysgestionturismo.dtos.CheckOutDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.CheckOut;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CheckOutMapper {

    CheckOutMapper INSTANCE = Mappers.getMapper(CheckOutMapper.class);

    CheckOutDTO toCheckOutDTO(CheckOut checkOut);

    CheckOut toCheckOut(CheckOutDTO checkOutDTO);

    List<CheckOutDTO> toCheckOutDTOs(List<CheckOut> checkOuts);

    List<CheckOut> toCheckOuts(List<CheckOutDTO> checkOutDTOs);

    void updateEntityFromDto(CheckOutDTO dto, @MappingTarget CheckOut checkOut);
}