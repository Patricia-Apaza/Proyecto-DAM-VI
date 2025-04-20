package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.CheckOutDTO;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaDTO;
import pe.edu.upeu.sysgestionturismo.modelo.CheckOut;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    ReservaDTO toReservaDTO(Reserva reserva);

    Reserva toReserva(ReservaDTO reservaDTO);

    List<ReservaDTO> toReservaDTOs(List<Reserva> reservas);

    List<Reserva> toReservas(List<ReservaDTO> reservaDTOs);

    void updateEntityFromDto(ReservaDTO dto, @MappingTarget Reserva reserva);
}