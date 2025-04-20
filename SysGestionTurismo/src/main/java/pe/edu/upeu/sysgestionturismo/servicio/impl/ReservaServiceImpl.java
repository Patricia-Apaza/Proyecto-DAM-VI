package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.ReservaDTO;
import pe.edu.upeu.sysgestionturismo.mappers.ReservaMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;
import pe.edu.upeu.sysgestionturismo.repositorio.IReservaRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    @Override
    public List<ReservaDTO> obtenerTodasLasReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas.stream()
                .map(reservaMapper::toReservaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDTO obtenerReservaPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return reservaMapper.toReservaDTO(reserva);
    }

    @Override
    public ReservaDTO registrarReserva(ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toReserva(reservaDTO);
        Reserva reservaGuardada = reservaRepository.save(reserva);
        return reservaMapper.toReservaDTO(reservaGuardada);
    }

    @Override
    public ReservaDTO actualizarReserva(Long id, ReservaDTO reservaDTO) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reservaMapper.updateEntityFromDto(reservaDTO, reservaExistente);
        Reserva reservaActualizada = reservaRepository.save(reservaExistente);
        return reservaMapper.toReservaDTO(reservaActualizada);
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}