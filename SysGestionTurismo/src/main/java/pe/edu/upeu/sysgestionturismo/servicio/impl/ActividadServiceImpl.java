package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.ActividadDTO;
import pe.edu.upeu.sysgestionturismo.mappers.ActividadMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.repositorio.IActividadRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IActividadService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActividadServiceImpl implements IActividadService {


    @Autowired
    private IActividadRepository actividadRepository;

    @Autowired
    private ActividadMapper actividadMapper;

    @Override
    public List<ActividadDTO> obtenerTodasLasActividades() {
        List<Actividad> actividades = actividadRepository.findAll();
        return actividades.stream()
                .map(actividadMapper::toActividadDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ActividadDTO> obtenerActividadPorId(Long id) {
        Actividad actividad = actividadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
        return Optional.of(actividadMapper.toActividadDTO(actividad));  // Envolvemos el resultado en un Optional
    }

    @Override
    public ActividadDTO registrarActividad(ActividadDTO actividadDTO) {
        Actividad actividad = actividadMapper.toActividad(actividadDTO);
        Actividad actividadGuardada = actividadRepository.save(actividad);
        return actividadMapper.toActividadDTO(actividadGuardada);
    }

    @Override
    public ActividadDTO actualizarActividad(Long id, ActividadDTO actividadDTO) {
        Actividad actividadExistente = actividadRepository.findById(id).orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
        actividadMapper.updateEntityFromDto(actividadDTO, actividadExistente);
        Actividad actividadActualizada = actividadRepository.save(actividadExistente);
        return actividadMapper.toActividadDTO(actividadActualizada);
    }

    @Override
    public void eliminarActividad(Long id) {
        actividadRepository.deleteById(id);
    }
}