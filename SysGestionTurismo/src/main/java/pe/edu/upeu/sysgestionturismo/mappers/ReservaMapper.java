package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaDto;
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;

public class ReservaMapper {

    public static ReservaDto toDto(Reserva reserva) {
        ReservaDto dto = new ReservaDto();
        dto.setId_reserva(reserva.getIdReserva());
        dto.setId_cliente(reserva.getCliente() != null ? reserva.getCliente().getIdCliente() : null);
        dto.setTipo_reserva(reserva.getTipoReserva());
        dto.setId_paquete(reserva.getPaqueteTuristico() != null ? reserva.getPaqueteTuristico().getIdPaqueteTuristico() : null);
        dto.setEstado_reserva(reserva.getEstadoReserva());
        dto.setFecha_inicio(reserva.getFechaInicio());
        dto.setFecha_fin(reserva.getFechaFin());
        dto.setNumero_personas(reserva.getNumeroPersonas());
        dto.setTotal_pago(reserva.getTotalPago());
        dto.setObservaciones(reserva.getObservaciones());
        return dto;
    }

    public static Reserva toEntity(ReservaDto dto) {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(dto.getId_reserva());
        reserva.setTipoReserva(dto.getTipo_reserva());
        reserva.setEstadoReserva(dto.getEstado_reserva());
        reserva.setFechaInicio(dto.getFecha_inicio());
        reserva.setFechaFin(dto.getFecha_fin());
        reserva.setNumeroPersonas(dto.getNumero_personas());
        reserva.setTotalPago(dto.getTotal_pago());
        reserva.setObservaciones(dto.getObservaciones());

        if (dto.getId_cliente() != null) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(dto.getId_cliente());
            reserva.setCliente(cliente);
        }

        if (dto.getId_paquete() != null) {
            PaqueteTuristico paquete = new PaqueteTuristico();
            paquete.setIdPaqueteTuristico(dto.getId_paquete());
            reserva.setPaqueteTuristico(paquete);
        }

        return reserva;
    }
}