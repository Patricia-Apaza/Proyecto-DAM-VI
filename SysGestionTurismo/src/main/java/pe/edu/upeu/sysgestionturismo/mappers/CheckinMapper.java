package pe.edu.upeu.sysgestionturismo.mappers;

import org.springframework.stereotype.Component;
import pe.edu.upeu.sysgestionturismo.dtos.CheckinDto;
import pe.edu.upeu.sysgestionturismo.modelo.Checkin;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;

@Component
public class CheckinMapper {

    public CheckinDto toDto(Checkin model) {
        CheckinDto dto = new CheckinDto();
        dto.setIdCheckin(model.getIdCheckin());
        dto.setIdReserva(model.getReserva() != null ? model.getReserva().getIdReserva() : null);
        dto.setTipoReserva(model.getTipoReserva());
        dto.setFechaCheckin(model.getFechaCheckin());
        dto.setEstadoCheckin(model.getEstadoCheckin());
        dto.setRegistradoPor(model.getRegistradoPor());
        dto.setObservacion(model.getObservacion());
        return dto;
    }

    public Checkin toEntity(CheckinDto dto) {
        Checkin model = new Checkin();
        model.setIdCheckin(dto.getIdCheckin());
        if(dto.getIdReserva() != null) {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(dto.getIdReserva());
            model.setReserva(reserva);
        } else {
            model.setReserva(null);
        }
        model.setTipoReserva(dto.getTipoReserva());
        model.setFechaCheckin(dto.getFechaCheckin());
        model.setEstadoCheckin(dto.getEstadoCheckin());
        model.setRegistradoPor(dto.getRegistradoPor());
        model.setObservacion(dto.getObservacion());
        return model;
    }
}
