package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.CheckInDTO;

import java.util.List;
import java.util.Optional;

public interface ICheckInService {

    String realizarCheckIn(Long clienteId);

    List<CheckInDTO> obtenerTodosLosCheckIns();

    Optional<CheckInDTO> obtenerCheckInPorId(Long id);

    CheckInDTO registrarCheckIn(CheckInDTO checkInDTO);

    CheckInDTO actualizarCheckIn(Long id, CheckInDTO checkInDTO);

    void eliminarCheckIn(Long id);
}