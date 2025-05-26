package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaNinosDto;
import pe.edu.upeu.sysgestionturismo.modelo.*;

public class ReservaNinosMapper {

    public static ReservaNinosDto toDto(ReservaNinos entidad) {
        ReservaNinosDto dto = new ReservaNinosDto();
        dto.setIdReservaNinos(entidad.getIdReservaNinos());
        dto.setNombre(entidad.getNombre());
        dto.setApellido(entidad.getApellido());
        dto.setEdad(entidad.getEdad());
        dto.setTipoDocumento(entidad.getTipoDocumento());
        dto.setNumDocumento(entidad.getNumDocumento());
        dto.setDireccion(entidad.getDireccion());
        dto.setRegistradoPorClienteId(entidad.getRegistradoPorClienteId());

        dto.setIdReservaHospedaje(entidad.getReservaHospedaje() != null ? entidad.getReservaHospedaje().getIdReservaHospedaje() : null);
        dto.setIdReservaActividad(entidad.getReservaActividad() != null ? entidad.getReservaActividad().getIdReservaActividad() : null);
        dto.setIdReservaPaquete(entidad.getReservaPaquete() != null ? entidad.getReservaPaquete().getIdReservaPaqueteTuristico() : null);
        dto.setIdReservaRestaurante(entidad.getReservaRestaurante() != null ? entidad.getReservaRestaurante().getIdReservaRestaurante() : null);

        return dto;
    }

    public static ReservaNinos toEntity(ReservaNinosDto dto) {
        ReservaNinos entidad = new ReservaNinos();
        entidad.setIdReservaNinos(dto.getIdReservaNinos());
        entidad.setNombre(dto.getNombre());
        entidad.setApellido(dto.getApellido());
        entidad.setEdad(dto.getEdad());
        entidad.setTipoDocumento(dto.getTipoDocumento());
        entidad.setNumDocumento(dto.getNumDocumento());
        entidad.setDireccion(dto.getDireccion());
        entidad.setRegistradoPorClienteId(dto.getRegistradoPorClienteId());

        if (dto.getIdReservaHospedaje() != null) {
            ReservaHospedaje rh = new ReservaHospedaje();
            rh.setIdReservaHospedaje(dto.getIdReservaHospedaje());
            entidad.setReservaHospedaje(rh);
        }

        if (dto.getIdReservaActividad() != null) {
            ReservaActividad ra = new ReservaActividad();
            ra.setIdReservaActividad(dto.getIdReservaActividad());
            entidad.setReservaActividad(ra);
        }

        if (dto.getIdReservaPaquete() != null) {
            ReservaPaqueteTuristico rp = new ReservaPaqueteTuristico();
            rp.setIdReservaPaqueteTuristico(dto.getIdReservaPaquete());
            entidad.setReservaPaquete(rp);
        }

        if (dto.getIdReservaRestaurante() != null) {
            ReservaRestaurante rr = new ReservaRestaurante();
            rr.setIdReservaRestaurante(dto.getIdReservaRestaurante());
            entidad.setReservaRestaurante(rr);
        }

        return entidad;
    }
}
