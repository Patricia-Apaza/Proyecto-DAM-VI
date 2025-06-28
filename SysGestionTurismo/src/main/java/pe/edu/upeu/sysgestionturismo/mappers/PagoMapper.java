package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.PagoDto;
import pe.edu.upeu.sysgestionturismo.modelo.Pago;

public class PagoMapper {

    public static PagoDto toDto(Pago entity) {
        PagoDto dto = new PagoDto();
        dto.setIdPago(entity.getIdPago());
        dto.setIdCarrito(entity.getCarrito() != null ? entity.getCarrito().getIdCarrito() : null);
        dto.setMontoOriginal(entity.getMontoOriginal());
        dto.setMontoConvertido(entity.getMontoConvertido());
        dto.setMoneda(entity.getMoneda());
        dto.setTasaCambio(entity.getTasaCambio());
        dto.setMetodoPago(entity.getMetodoPago());
        dto.setRutaComprobante(entity.getRutaComprobante());
        dto.setEstado(entity.getEstado().name());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaConfirmacion(entity.getFechaConfirmacion());
        return dto;
    }
}
