package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.PagoDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Pago;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    PagoMapper INSTANCE = Mappers.getMapper(PagoMapper.class);

    @Mapping(source = "reserva.usuario.id", target = "usuarioId")
    PagoDTO toPagoDTO(Pago pago);

    Pago toPago(PagoDTO pagoDTO);

    void updateEntityFromDto(PagoDTO pagoDTO, @MappingTarget Pago pago);
}