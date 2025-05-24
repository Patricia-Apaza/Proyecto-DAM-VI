package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.RestauranteDto;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

public class RestauranteMapper {

    public static RestauranteDto toDto(Restaurante restaurante) {
        RestauranteDto dto = new RestauranteDto();
        dto.setIdRestaurante(restaurante.getIdRestaurante());
        dto.setIdDestino(restaurante.getDestino() != null ? restaurante.getDestino().getIdDestino() : null);
        dto.setNombre(restaurante.getNombre());
        dto.setDescripcion(restaurante.getDescripcion());
        dto.setDireccion(restaurante.getDireccion());
        dto.setWhatsappContacto(restaurante.getWhatsappContacto());
        dto.setImagenPath(restaurante.getImagenPath());
        return dto;
    }

    public static Restaurante toEntity(RestauranteDto dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setIdRestaurante(dto.getIdRestaurante());
        restaurante.setNombre(dto.getNombre());
        restaurante.setDescripcion(dto.getDescripcion());
        restaurante.setDireccion(dto.getDireccion());
        restaurante.setWhatsappContacto(dto.getWhatsappContacto());
        restaurante.setImagenPath(dto.getImagenPath());

        if (dto.getIdDestino() != null) {
            Destino destino = new Destino();
            destino.setIdDestino(dto.getIdDestino());
            restaurante.setDestino(destino);
        }

        return restaurante;
    }
}
