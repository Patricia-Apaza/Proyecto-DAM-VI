package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaMenuDto;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaMenu;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaRestaurante;
import pe.edu.upeu.sysgestionturismo.modelo.MenuDiario;

public class ReservaMenuMapper {

    public static ReservaMenuDto toDto(ReservaMenu entidad) {
        ReservaMenuDto dto = new ReservaMenuDto();
        dto.setIdReservaMenu(entidad.getIdReservaMenu());
        dto.setDisponible(entidad.getDisponible());
        dto.setCantidad(entidad.getCantidad());
        dto.setObservaciones(entidad.getObservaciones());

        dto.setIdReservaRestaurante(entidad.getReservaRestaurante() != null ? entidad.getReservaRestaurante().getIdReservaRestaurante() : null);
        dto.setIdMenu(entidad.getMenuDiario() != null ? entidad.getMenuDiario().getIdMenu() : null);

        return dto;
    }

    public static ReservaMenu toEntity(ReservaMenuDto dto) {
        ReservaMenu entidad = new ReservaMenu();
        entidad.setIdReservaMenu(dto.getIdReservaMenu());
        entidad.setDisponible(dto.getDisponible());
        entidad.setCantidad(dto.getCantidad());
        entidad.setObservaciones(dto.getObservaciones());

        if (dto.getIdReservaRestaurante() != null) {
            ReservaRestaurante reservaRestaurante = new ReservaRestaurante();
            reservaRestaurante.setIdReservaRestaurante(dto.getIdReservaRestaurante());
            entidad.setReservaRestaurante(reservaRestaurante);
        }

        if (dto.getIdMenu() != null) {
            MenuDiario menuDiario = new MenuDiario();
            menuDiario.setIdMenu(dto.getIdMenu());
            entidad.setMenuDiario(menuDiario);
        }

        return entidad;
    }
}
