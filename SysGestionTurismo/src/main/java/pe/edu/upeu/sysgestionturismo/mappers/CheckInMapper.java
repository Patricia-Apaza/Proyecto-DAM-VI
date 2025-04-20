package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.CheckInDTO;
import pe.edu.upeu.sysgestionturismo.dtos.CheckOutDTO;
import pe.edu.upeu.sysgestionturismo.modelo.CheckIn;
import pe.edu.upeu.sysgestionturismo.modelo.CheckOut;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CheckInMapper {

    CheckInMapper INSTANCE = Mappers.getMapper(CheckInMapper.class);

    CheckInDTO toCheckInDTO(CheckIn checkIn);

    CheckIn toCheckIn(CheckInDTO checkInDTO);

    List<CheckInDTO> toCheckInDTOs(List<CheckIn> checkIns);

    List<CheckIn> toCheckIns(List<CheckInDTO> checkInDTOs);

    void updateEntityFromDto(CheckInDTO dto, @MappingTarget CheckIn checkIn);
}