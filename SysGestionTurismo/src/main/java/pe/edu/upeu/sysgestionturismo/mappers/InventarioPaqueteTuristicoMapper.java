package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.InventarioPaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioPaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;

public class InventarioPaqueteTuristicoMapper {

    public static InventarioPaqueteTuristicoDto toDto(InventarioPaqueteTuristico inv) {
        InventarioPaqueteTuristicoDto dto = new InventarioPaqueteTuristicoDto();
        dto.setIdInventarioPaqueteTuristico(inv.getIdInventarioPaqueteTuristico());
        dto.setIdPaqueteTuristico(inv.getPaqueteTuristico() != null ? inv.getPaqueteTuristico().getIdPaqueteTuristico() : null);
        dto.setFechaSalida(inv.getFechaSalida());
        dto.setFechaRetorno(inv.getFechaRetorno());
        dto.setHoraSalida(inv.getHoraSalida());
        dto.setCapacidadPersonas(inv.getCapacidadPersonas());
        dto.setPersonasRegistradas(inv.getPersonasRegistradas());
        dto.setPrecioPorPersona(inv.getPrecioPorPersona());
        dto.setDescripcion(inv.getDescripcion());
        dto.setImagenPath(inv.getImagenPath());
        return dto;
    }

    public static InventarioPaqueteTuristico toEntity(InventarioPaqueteTuristicoDto dto) {
        InventarioPaqueteTuristico inv = new InventarioPaqueteTuristico();
        inv.setIdInventarioPaqueteTuristico(dto.getIdInventarioPaqueteTuristico());
        inv.setFechaSalida(dto.getFechaSalida());
        inv.setFechaRetorno(dto.getFechaRetorno());
        inv.setHoraSalida(dto.getHoraSalida());
        inv.setCapacidadPersonas(dto.getCapacidadPersonas());
        inv.setPersonasRegistradas(dto.getPersonasRegistradas());
        inv.setPrecioPorPersona(dto.getPrecioPorPersona());
        inv.setDescripcion(dto.getDescripcion());
        inv.setImagenPath(dto.getImagenPath());

        if (dto.getIdPaqueteTuristico() != null) {
            PaqueteTuristico p = new PaqueteTuristico();
            p.setIdPaqueteTuristico(dto.getIdPaqueteTuristico());
            inv.setPaqueteTuristico(p);
        }

        return inv;
    }
}
