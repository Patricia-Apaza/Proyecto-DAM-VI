package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteDestinoDto;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteDestino;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;

public class PaqueteDestinoMapper {

    public static PaqueteDestinoDto toDto(PaqueteDestino entity) {
        PaqueteDestinoDto dto = new PaqueteDestinoDto();
        dto.setIdPaqueteDestino(entity.getIdPaqueteDestino());
        dto.setIdPaqueteTuristico(entity.getPaqueteTuristico().getIdPaqueteTuristico());
        dto.setIdDestino(entity.getDestino().getIdDestino());
        return dto;
    }

    public static PaqueteDestino toEntity(PaqueteDestinoDto dto) {
        PaqueteDestino entity = new PaqueteDestino();
        entity.setIdPaqueteDestino(dto.getIdPaqueteDestino());

        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setIdPaqueteTuristico(dto.getIdPaqueteTuristico());
        entity.setPaqueteTuristico(paquete);

        Destino destino = new Destino();
        destino.setIdDestino(dto.getIdDestino());
        entity.setDestino(destino);

        return entity;
    }
}
