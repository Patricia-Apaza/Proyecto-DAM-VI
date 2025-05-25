package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioActividadDto;
import pe.edu.upeu.sysgestionturismo.mappers.InventarioActividadMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioActividad;
import pe.edu.upeu.sysgestionturismo.repositorio.InventarioActividadRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioActividadService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioActividadServiceImpl implements IInventarioActividadService {

    @Autowired
    private InventarioActividadRepository repository;

    @Autowired
    private InventarioActividadMapper mapper;

    @Override
    public List<InventarioActividadDto> getAll() {
        List<InventarioActividad> list = repository.findAll();
        return list.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public InventarioActividadDto getById(Long id) {
        InventarioActividad entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("InventarioActividad no encontrado con id: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public InventarioActividadDto create(InventarioActividadDto dto) {
        InventarioActividad entity = mapper.toEntity(dto);
        InventarioActividad saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public InventarioActividadDto update(Long id, InventarioActividadDto dto) {
        InventarioActividad existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("InventarioActividad no encontrado con id: " + id));

        existing.setNombreActividad(dto.getNombreActividad());
        existing.setFechaSesion(dto.getFechaSesion());
        existing.setHoraInicio(dto.getHoraInicio());
        existing.setHoraFin(dto.getHoraFin());
        existing.setCapacidadPersonas(dto.getCapacidadPersonas());
        existing.setPersonasRegistradas(dto.getPersonasRegistradas());
        existing.setCantidadDisponible(dto.getCantidadDisponible());
        existing.setPrecioPorPersona(dto.getPrecioPorPersona());
        existing.setDescripcion(dto.getDescripcion());

        if(dto.getIdActividad() != null) {
            Actividad actividad = new Actividad();
            actividad.setIdActividad(dto.getIdActividad());
            existing.setActividad(actividad);
        } else {
            existing.setActividad(null);
        }

        InventarioActividad updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        InventarioActividad existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("InventarioActividad no encontrado con id: " + id));
        repository.delete(existing);
    }
}
