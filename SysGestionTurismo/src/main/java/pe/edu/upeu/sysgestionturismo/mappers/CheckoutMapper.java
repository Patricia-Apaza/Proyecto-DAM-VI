package pe.edu.upeu.sysgestionturismo.mappers;

import org.springframework.stereotype.Component;
import pe.edu.upeu.sysgestionturismo.dtos.CheckoutDto;
import pe.edu.upeu.sysgestionturismo.modelo.Checkin;
import pe.edu.upeu.sysgestionturismo.modelo.Checkout;

@Component
public class CheckoutMapper {
    public CheckoutDto toDto(Checkout model) {
        CheckoutDto dto = new CheckoutDto();
        dto.setIdCheckout(model.getIdCheckout());
        // antes: dto.setIdReserva(...)
        dto.setIdCheckin(model.getCheckin() != null ? model.getCheckin().getIdCheckin() : null);
        dto.setTipoReserva(model.getTipoReserva());
        dto.setFechaCheckout(model.getFechaCheckout());
        dto.setEstadoCheckout(model.getEstadoCheckout());
        dto.setRegistradoPor(model.getRegistradoPor());
        dto.setObservacion(model.getObservacion());
        return dto;
    }

    public Checkout toEntity(CheckoutDto dto) {
        Checkout model = new Checkout();
        model.setIdCheckout(dto.getIdCheckout());
        // antes: si idReserva != null, setReserva
        if (dto.getIdCheckin() != null) {
            Checkin checkin = new Checkin();
            checkin.setIdCheckin(dto.getIdCheckin());
            model.setCheckin(checkin);
        }
        model.setTipoReserva(dto.getTipoReserva());
        model.setFechaCheckout(dto.getFechaCheckout());
        model.setEstadoCheckout(dto.getEstadoCheckout());
        model.setRegistradoPor(dto.getRegistradoPor());
        model.setObservacion(dto.getObservacion());
        return model;
    }
}
