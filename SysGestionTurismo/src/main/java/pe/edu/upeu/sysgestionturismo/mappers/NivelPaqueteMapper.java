package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.NivelPaqueteDto;
import pe.edu.upeu.sysgestionturismo.modelo.NivelPaquete;

public class NivelPaqueteMapper {

    public static NivelPaqueteDto toDto(NivelPaquete nivelPaquete) {
        NivelPaqueteDto dto = new NivelPaqueteDto();
        dto.setIdNivelPaquete(nivelPaquete.getIdNivelPaquete());
        dto.setNombreNivel(nivelPaquete.getNombreNivel());
        dto.setDescripcion(nivelPaquete.getDescripcion());
        return dto;
    }

    public static NivelPaquete toEntity(NivelPaqueteDto dto) {
        NivelPaquete nivelPaquete = new NivelPaquete();
        nivelPaquete.setIdNivelPaquete(dto.getIdNivelPaquete());
        nivelPaquete.setNombreNivel(dto.getNombreNivel());
        nivelPaquete.setDescripcion(dto.getDescripcion());
        return nivelPaquete;
    }
}
