package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.ReservaDTO;

import java.util.List;

public interface IReservaService {

    List<ReservaDTO> obtenerTodasLasReservas();

    ReservaDTO obtenerReservaPorId(Long id);

    ReservaDTO registrarReserva(ReservaDTO reservaDTO);

    ReservaDTO actualizarReserva(Long id, ReservaDTO reservaDTO);

    void eliminarReserva(Long id);
}