package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.InventarioHospedajeDto;
import pe.edu.upeu.sysgestionturismo.modelo.Hospedaje;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioHospedaje;

public class InventarioHospedajeMapper {

    public static InventarioHospedajeDto toDto(InventarioHospedaje inv) {
        InventarioHospedajeDto dto = new InventarioHospedajeDto();
        dto.setIdInventarioHospedaje(inv.getIdInventarioHospedaje());
        dto.setIdHospedaje(inv.getHospedaje() != null ? inv.getHospedaje().getIdHospedaje() : null);
        dto.setTipoCuarto(inv.getTipoCuarto());
        dto.setTipoCama(inv.getTipoCama());
        dto.setBanoPrivado(inv.getBanoPrivado());
        dto.setPrecioPorNoche(inv.getPrecioPorNoche());
        dto.setDescripcion(inv.getDescripcion());
        dto.setCantidadTotal(inv.getCantidadTotal());
        dto.setCantidadDisponible(inv.getCantidadDisponible());
        return dto;
    }

    public static InventarioHospedaje toEntity(InventarioHospedajeDto dto) {
        InventarioHospedaje inv = new InventarioHospedaje();
        inv.setIdInventarioHospedaje(dto.getIdInventarioHospedaje());
        inv.setTipoCuarto(dto.getTipoCuarto());
        inv.setTipoCama(dto.getTipoCama());
        inv.setBanoPrivado(dto.getBanoPrivado());
        inv.setPrecioPorNoche(dto.getPrecioPorNoche());
        inv.setDescripcion(dto.getDescripcion());
        inv.setCantidadTotal(dto.getCantidadTotal());
        inv.setCantidadDisponible(dto.getCantidadDisponible());

        if (dto.getIdHospedaje() != null) {
            Hospedaje h = new Hospedaje();
            h.setIdHospedaje(dto.getIdHospedaje());
            inv.setHospedaje(h);
        }

        return inv;
    }
}
