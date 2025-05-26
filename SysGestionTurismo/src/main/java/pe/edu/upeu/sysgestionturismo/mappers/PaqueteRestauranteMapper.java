package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteRestauranteDto;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteRestaurante;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

public class PaqueteRestauranteMapper {

    public static PaqueteRestauranteDto toDto(PaqueteRestaurante entity) {
        PaqueteRestauranteDto dto = new PaqueteRestauranteDto();
        dto.setIdPaqueteRestaurante(entity.getIdPaqueteRestaurante());
        dto.setIdPaqueteTuristico(entity.getPaqueteTuristico().getIdPaqueteTuristico());
        dto.setIdRestaurante(entity.getRestaurante().getIdRestaurante());
        return dto;
    }

    public static PaqueteRestaurante toEntity(PaqueteRestauranteDto dto) {
        PaqueteRestaurante entity = new PaqueteRestaurante();
        entity.setIdPaqueteRestaurante(dto.getIdPaqueteRestaurante());

        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setIdPaqueteTuristico(dto.getIdPaqueteTuristico());
        entity.setPaqueteTuristico(paquete);

        Restaurante restaurante = new Restaurante();
        restaurante.setIdRestaurante(dto.getIdRestaurante());
        entity.setRestaurante(restaurante);

        return entity;
    }
}
