package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaPaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaPaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioPaqueteTuristico;

public class ReservaPaqueteTuristicoMapper {

    public static ReservaPaqueteTuristicoDto toDto(ReservaPaqueteTuristico entidad) {
        ReservaPaqueteTuristicoDto dto = new ReservaPaqueteTuristicoDto();
        dto.setIdReservaPaqueteTuristico(entidad.getIdReservaPaqueteTuristico());
        dto.setDisponible(entidad.getDisponible());
        dto.setCantidadPersonas(entidad.getCantidadPersonas());
        dto.setIncluyeNinos(entidad.getIncluyeNinos());
        dto.setCantidadNinos(entidad.getCantidadNinos());
        dto.setEstadoReserva(entidad.getEstadoReserva());
        dto.setFechaReserva(entidad.getFechaReserva());

        dto.setIdReserva(entidad.getReserva() != null ? entidad.getReserva().getIdReserva() : null);
        dto.setIdInventarioPaquete(entidad.getInventarioPaqueteTuristico() != null ? entidad.getInventarioPaqueteTuristico().getIdInventarioPaqueteTuristico() : null);

        return dto;
    }

    public static ReservaPaqueteTuristico toEntity(ReservaPaqueteTuristicoDto dto) {
        ReservaPaqueteTuristico entidad = new ReservaPaqueteTuristico();
        entidad.setIdReservaPaqueteTuristico(dto.getIdReservaPaqueteTuristico());
        entidad.setDisponible(dto.getDisponible());
        entidad.setCantidadPersonas(dto.getCantidadPersonas());
        entidad.setIncluyeNinos(dto.getIncluyeNinos());
        entidad.setCantidadNinos(dto.getCantidadNinos());
        entidad.setEstadoReserva(dto.getEstadoReserva());
        entidad.setFechaReserva(dto.getFechaReserva());

        if (dto.getIdReserva() != null) {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(dto.getIdReserva());
            entidad.setReserva(reserva);
        }

        if (dto.getIdInventarioPaquete() != null) {
            InventarioPaqueteTuristico inventario = new InventarioPaqueteTuristico();
            inventario.setIdInventarioPaqueteTuristico(dto.getIdInventarioPaquete());
            entidad.setInventarioPaqueteTuristico(inventario);
        }

        return entidad;
    }
}
