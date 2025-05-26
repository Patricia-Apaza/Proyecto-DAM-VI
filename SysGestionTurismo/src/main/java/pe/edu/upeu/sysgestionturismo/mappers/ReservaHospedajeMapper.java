package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaHospedajeDto;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioHospedaje;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaHospedaje;

public class ReservaHospedajeMapper {

    public static ReservaHospedajeDto toDto(ReservaHospedaje entidad) {
        ReservaHospedajeDto dto = new ReservaHospedajeDto();
        dto.setIdReservaHospedaje(entidad.getIdReservaHospedaje());
        dto.setDisponible(entidad.getDisponible());
        dto.setFechaInicio(entidad.getFechaInicio());
        dto.setFechaFin(entidad.getFechaFin());
        dto.setCantidadHabitaciones(entidad.getCantidadHabitaciones());
        dto.setCantidadPersonas(entidad.getCantidadPersonas());
        dto.setIncluyeNinos(entidad.getIncluyeNinos());
        dto.setCantidadNinos(entidad.getCantidadNinos());
        dto.setIncluyeDesayuno(entidad.getIncluyeDesayuno());
        dto.setEstadoReserva(entidad.getEstadoReserva());

        dto.setIdReserva(entidad.getReserva() != null ? entidad.getReserva().getIdReserva() : null);
        dto.setIdInventarioHospedaje(entidad.getInventarioHospedaje() != null ? entidad.getInventarioHospedaje().getIdInventarioHospedaje() : null);

        return dto;
    }

    public static ReservaHospedaje toEntity(ReservaHospedajeDto dto) {
        ReservaHospedaje entidad = new ReservaHospedaje();
        entidad.setIdReservaHospedaje(dto.getIdReservaHospedaje());
        entidad.setDisponible(dto.getDisponible());
        entidad.setFechaInicio(dto.getFechaInicio());
        entidad.setFechaFin(dto.getFechaFin());
        entidad.setCantidadHabitaciones(dto.getCantidadHabitaciones());
        entidad.setCantidadPersonas(dto.getCantidadPersonas());
        entidad.setIncluyeNinos(dto.getIncluyeNinos());
        entidad.setCantidadNinos(dto.getCantidadNinos());
        entidad.setIncluyeDesayuno(dto.getIncluyeDesayuno());
        entidad.setEstadoReserva(dto.getEstadoReserva());

        if (dto.getIdReserva() != null) {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(dto.getIdReserva());
            entidad.setReserva(reserva);
        }

        if (dto.getIdInventarioHospedaje() != null) {
            InventarioHospedaje inventario = new InventarioHospedaje();
            inventario.setIdInventarioHospedaje(dto.getIdInventarioHospedaje());
            entidad.setInventarioHospedaje(inventario);
        }

        return entidad;
    }
}
