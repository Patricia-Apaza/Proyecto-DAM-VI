package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.NivelPaqueteDto;
import pe.edu.upeu.sysgestionturismo.modelo.NivelPaquete;

public class NivelPaqueteMapper {

    public static NivelPaqueteDto toDto(NivelPaquete nivel) {
        NivelPaqueteDto dto = new NivelPaqueteDto();
        dto.setIdNivelPaquete(nivel.getIdNivelPaquete());
        dto.setNombreNivel(nivel.getNombreNivel());
        dto.setDescripcion(nivel.getDescripcion());
        return dto;
    }

    public static NivelPaquete toEntity(NivelPaqueteDto dto) {
        NivelPaquete nivel = new NivelPaquete();
        nivel.setIdNivelPaquete(dto.getIdNivelPaquete());
        nivel.setNombreNivel(dto.getNombreNivel());
        nivel.setDescripcion(dto.getDescripcion());
        return nivel;
    }
}
