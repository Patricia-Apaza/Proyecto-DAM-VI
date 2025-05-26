package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.InventarioRestauranteDto;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioRestaurante;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

public class InventarioRestauranteMapper {

    public static InventarioRestauranteDto toDto(InventarioRestaurante inv) {
        InventarioRestauranteDto dto = new InventarioRestauranteDto();
        dto.setIdInventarioRestaurante(inv.getIdInventarioRestaurante());
        dto.setIdRestaurante(inv.getRestaurante() != null ? inv.getRestaurante().getIdRestaurante() : null);
        dto.setTipoProducto(inv.getTipoProducto());
        dto.setNombreProducto(inv.getNombreProducto());
        dto.setCantidadDisponibleProducto(inv.getCantidadDisponibleProducto());
        dto.setCantidadTotalProducto(inv.getCantidadTotalProducto());
        dto.setTotalMesas(inv.getTotalMesas());
        dto.setMesasDisponibles(inv.getMesasDisponibles());
        dto.setCapacidadPorMesa(inv.getCapacidadPorMesa());
        dto.setPrecio(inv.getPrecio());
        dto.setObservaciones(inv.getObservaciones());
        return dto;
    }

    public static InventarioRestaurante toEntity(InventarioRestauranteDto dto) {
        InventarioRestaurante inv = new InventarioRestaurante();
        inv.setIdInventarioRestaurante(dto.getIdInventarioRestaurante());
        inv.setTipoProducto(dto.getTipoProducto());
        inv.setNombreProducto(dto.getNombreProducto());
        inv.setCantidadDisponibleProducto(dto.getCantidadDisponibleProducto());
        inv.setCantidadTotalProducto(dto.getCantidadTotalProducto());
        inv.setTotalMesas(dto.getTotalMesas());
        inv.setMesasDisponibles(dto.getMesasDisponibles());
        inv.setCapacidadPorMesa(dto.getCapacidadPorMesa());
        inv.setPrecio(dto.getPrecio());
        inv.setObservaciones(dto.getObservaciones());

        if (dto.getIdRestaurante() != null) {
            Restaurante r = new Restaurante();
            r.setIdRestaurante(dto.getIdRestaurante());
            inv.setRestaurante(r);
        }

        return inv;
    }
}
