package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.CheckinDto;
import pe.edu.upeu.sysgestionturismo.mappers.CheckinMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Checkin;
import pe.edu.upeu.sysgestionturismo.modelo.Reserva;
import pe.edu.upeu.sysgestionturismo.repositorio.CheckinRepository;
import pe.edu.upeu.sysgestionturismo.servicio.ICheckinService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckinServiceImpl implements ICheckinService {

    @Autowired
    private CheckinRepository repository;

    @Autowired
    private CheckinMapper mapper;

    @Override
    public List<CheckinDto> getAll() {
        List<Checkin> list = repository.findAll();
        return list.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CheckinDto getById(Long id) {
        Checkin checkin = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkin no encontrado con id: " + id));
        return mapper.toDto(checkin);
    }

    @Override
    public CheckinDto create(CheckinDto dto) {
        Checkin entity = mapper.toEntity(dto);
        Checkin saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public CheckinDto update(Long id, CheckinDto dto) {
        Checkin existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkin no encontrado con id: " + id));

        // Actualizamos campos
        existing.setTipoReserva(dto.getTipoReserva());
        existing.setFechaCheckin(dto.getFechaCheckin());
        existing.setEstadoCheckin(dto.getEstadoCheckin());
        existing.setRegistradoPor(dto.getRegistradoPor());
        existing.setObservacion(dto.getObservacion());

        // Actualizamos la reserva relacionada
        if(dto.getIdReserva() != null) {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(dto.getIdReserva());
            existing.setReserva(reserva);
        } else {
            existing.setReserva(null);
        }

        Checkin updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        Checkin existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkin no encontrado con id: " + id));
        repository.delete(existing);
    }
}
