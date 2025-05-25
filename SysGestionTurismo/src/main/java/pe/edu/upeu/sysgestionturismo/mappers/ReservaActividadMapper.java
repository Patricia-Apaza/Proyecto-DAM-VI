package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaActividadDto;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaActividad;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioActividad;

public class ReservaActividadMapper {

    public static ReservaActividadDto toDto(ReservaActividad entidad) {
        ReservaActividadDto dto = new ReservaActividadDto();
        dto.setIdReservaActividad(entidad.getIdReservaActividad());
        dto.setDisponible(entidad.getDisponible());
        dto.setCantidadPersonas(entidad.getCantidadPersonas());
        dto.setIncluyeNinos(entidad.getIncluyeNinos());
        dto.setCantidadNinos(entidad.getCantidadNinos());
        dto.setEstadoReserva(entidad.getEstadoReserva());
        dto.setFechaReserva(entidad.getFechaReserva());

        dto.setIdReserva(entidad.getReserva() != null ? entidad.getReserva().getIdReserva() : null);
        dto.setIdInventarioActividad(entidad.getInventarioActividad() != null ? entidad.getInventarioActividad().getIdInventarioActividad() : null);

        return dto;
    }

    public static ReservaActividad toEntity(ReservaActividadDto dto) {
        ReservaActividad entidad = new ReservaActividad();
        entidad.setIdReservaActividad(dto.getIdReservaActividad());
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

        if (dto.getIdInventarioActividad() != null) {
            InventarioActividad inventarioActividad = new InventarioActividad();
            inventarioActividad.setIdInventarioActividad(dto.getIdInventarioActividad());
            entidad.setInventarioActividad(inventarioActividad);
        }

        return entidad;
    }
}
