package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.CheckoutDto;
import pe.edu.upeu.sysgestionturismo.mappers.CheckoutMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Checkin;
import pe.edu.upeu.sysgestionturismo.modelo.Checkout;
import pe.edu.upeu.sysgestionturismo.repositorio.CheckoutRepository;
import pe.edu.upeu.sysgestionturismo.servicio.ICheckoutService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckoutServiceImpl implements ICheckoutService {

    @Autowired
    private CheckoutRepository repository;

    @Autowired
    private CheckoutMapper mapper;

    @Override
    public List<CheckoutDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CheckoutDto getById(Long id) {
        Checkout checkout = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkout no encontrado con id: " + id));
        return mapper.toDto(checkout);
    }

    @Override
    public CheckoutDto create(CheckoutDto dto) {
        Checkout entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CheckoutDto update(Long id, CheckoutDto dto) {
        Checkout existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkout no encontrado con id: " + id));

        existing.setTipoReserva(dto.getTipoReserva());
        existing.setFechaCheckout(dto.getFechaCheckout());
        existing.setEstadoCheckout(dto.getEstadoCheckout());
        existing.setRegistradoPor(dto.getRegistradoPor());
        existing.setObservacion(dto.getObservacion());

        if (dto.getIdCheckin() != null) {
            Checkin checkin = new Checkin();
            checkin.setIdCheckin(dto.getIdCheckin());
            existing.setCheckin(checkin);
        } else {
            existing.setCheckin(null);
        }

        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        Checkout existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkout no encontrado con id: " + id));
        repository.delete(existing);
    }
}
