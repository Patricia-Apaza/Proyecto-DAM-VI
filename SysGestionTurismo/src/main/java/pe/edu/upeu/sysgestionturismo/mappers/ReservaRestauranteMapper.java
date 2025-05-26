package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaRestauranteDto;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaRestaurante;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

public class ReservaRestauranteMapper {

    public static ReservaRestauranteDto toDto(ReservaRestaurante entidad) {
        ReservaRestauranteDto dto = new ReservaRestauranteDto();
        dto.setIdReservaRestaurante(entidad.getIdReservaRestaurante());
        dto.setFecha(entidad.getFecha());
        dto.setHora(entidad.getHora());
        dto.setCantidadPersonas(entidad.getCantidadPersonas());
        dto.setIncluyeNinos(entidad.getIncluyeNinos());
        dto.setCantidadNinos(entidad.getCantidadNinos());
        dto.setEstado(entidad.getEstado());

        dto.setIdReserva(entidad.getReserva() != null ? entidad.getReserva().getIdReserva() : null);
        dto.setIdRestaurante(entidad.getRestaurante() != null ? entidad.getRestaurante().getIdRestaurante() : null);

        return dto;
    }

    public static ReservaRestaurante toEntity(ReservaRestauranteDto dto) {
        ReservaRestaurante entidad = new ReservaRestaurante();
        entidad.setIdReservaRestaurante(dto.getIdReservaRestaurante());
        entidad.setFecha(dto.getFecha());
        entidad.setHora(dto.getHora());
        entidad.setCantidadPersonas(dto.getCantidadPersonas());
        entidad.setIncluyeNinos(dto.getIncluyeNinos());
        entidad.setCantidadNinos(dto.getCantidadNinos());
        entidad.setEstado(dto.getEstado());

        if (dto.getIdReserva() != null) {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(dto.getIdReserva());
            entidad.setReserva(reserva);
        }

        if (dto.getIdRestaurante() != null) {
            Restaurante restaurante = new Restaurante();
            restaurante.setIdRestaurante(dto.getIdRestaurante());
            entidad.setRestaurante(restaurante);
        }

        return entidad;
    }
}
