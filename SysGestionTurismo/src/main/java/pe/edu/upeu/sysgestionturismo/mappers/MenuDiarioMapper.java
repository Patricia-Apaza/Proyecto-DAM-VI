package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.MenuDiarioDto;
import pe.edu.upeu.sysgestionturismo.modelo.MenuDiario;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

public class MenuDiarioMapper {

    public static MenuDiarioDto toDto(MenuDiario entity) {
        MenuDiarioDto dto = new MenuDiarioDto();
        dto.setIdMenu(entity.getIdMenu());
        dto.setIdRestaurante(entity.getRestaurante() != null ? entity.getRestaurante().getIdRestaurante() : null);
        dto.setFecha(entity.getFecha());
        dto.setNombrePlato(entity.getNombrePlato());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio());
        dto.setImagenPath(entity.getImagenPath());
        return dto;
    }

    public static MenuDiario toEntity(MenuDiarioDto dto) {
        MenuDiario entity = new MenuDiario();
        entity.setIdMenu(dto.getIdMenu());
        if (dto.getIdRestaurante() != null) {
            Restaurante r = new Restaurante();
            r.setIdRestaurante(dto.getIdRestaurante());
            entity.setRestaurante(r);
        }
        entity.setFecha(dto.getFecha());
        entity.setNombrePlato(dto.getNombrePlato());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setImagenPath(dto.getImagenPath());
        return entity;
    }
}
