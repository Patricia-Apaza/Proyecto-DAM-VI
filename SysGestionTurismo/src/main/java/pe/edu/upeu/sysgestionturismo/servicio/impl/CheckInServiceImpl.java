package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.CheckInDTO;
import pe.edu.upeu.sysgestionturismo.mappers.CheckInMapper;
import pe.edu.upeu.sysgestionturismo.modelo.CheckIn;
import pe.edu.upeu.sysgestionturismo.repositorio.ICheckInRepository;
import pe.edu.upeu.sysgestionturismo.servicio.ICheckInService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckInServiceImpl implements ICheckInService {

    @Autowired
    private ICheckInRepository checkInRepository;

    @Autowired
    private CheckInMapper checkInMapper;

    @Override
    public List<CheckInDTO> obtenerTodosLosCheckIns() {
        List<CheckIn> checkIns = checkInRepository.findAll();
        return checkIns.stream()
                .map(checkInMapper::toCheckInDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CheckInDTO> obtenerCheckInPorId(Long id) {
        return checkInRepository.findById(id)
                .map(checkInMapper::toCheckInDTO);
    }

    @Override
    public CheckInDTO registrarCheckIn(CheckInDTO checkInDTO) {
        CheckIn checkIn = checkInMapper.toCheckIn(checkInDTO);
        CheckIn checkInGuardado = checkInRepository.save(checkIn);
        return checkInMapper.toCheckInDTO(checkInGuardado);
    }

    @Override
    public CheckInDTO actualizarCheckIn(Long id, CheckInDTO checkInDTO) {
        CheckIn checkInExistente = checkInRepository.findById(id).orElseThrow(() -> new RuntimeException("CheckIn no encontrado"));
        checkInMapper.updateEntityFromDto(checkInDTO, checkInExistente);
        CheckIn checkInActualizado = checkInRepository.save(checkInExistente);
        return checkInMapper.toCheckInDTO(checkInActualizado);
    }

    @Override
    public void eliminarCheckIn(Long id) {
        checkInRepository.deleteById(id);
    }

    @Override
    public String realizarCheckIn(Long clienteId) {
        // Aquí va la lógica de ejemplo, puedes personalizarla según lo que debe hacer
        return "Check-In realizado para el cliente con ID: " + clienteId;
    }

}