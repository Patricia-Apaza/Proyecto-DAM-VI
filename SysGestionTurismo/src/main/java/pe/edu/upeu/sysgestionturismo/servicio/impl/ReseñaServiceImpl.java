package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.ReseñaDTO;
import pe.edu.upeu.sysgestionturismo.mappers.ReseñaMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Reseña;
import pe.edu.upeu.sysgestionturismo.repositorio.IReseñaRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReseñaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReseñaServiceImpl implements IReseñaService {

    @Autowired
    private IReseñaRepository reseñaRepository;

    @Autowired
    private ReseñaMapper reseñaMapper;

    @Autowired
    private IReseñaRepository iReseñaRepository;

    @Override
    public List<ReseñaDTO> obtenerTodasLasReseñas() {
        List<Reseña> reseñas = reseñaRepository.findAll();
        return reseñas.stream()
                .map(reseñaMapper::toReseñaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReseñaDTO> listarReseñas() {
        // Llamar al repositorio para obtener todas las reseñas
        List<Reseña> reseñas = reseñaRepository.findAll();
        // Convertir las reseñas a DTOs usando el mapper
        return reseñas.stream()
                .map(reseñaMapper::toReseñaDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ReseñaDTO obtenerReseñaPorId(Long id) {
        Reseña reseña = reseñaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
        return reseñaMapper.toReseñaDTO(reseña);
    }

    @Override
    public ReseñaDTO registrarReseña(ReseñaDTO reseñaDTO) {
        Reseña reseña = reseñaMapper.toReseña(reseñaDTO);
        Reseña reseñaGuardada = reseñaRepository.save(reseña);
        return reseñaMapper.toReseñaDTO(reseñaGuardada);
    }

    @Override
    public ReseñaDTO actualizarReseña(Long id, ReseñaDTO reseñaDTO) {
        Reseña reseñaExistente = reseñaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
        reseñaMapper.updateEntityFromDto(reseñaDTO, reseñaExistente);
        Reseña reseñaActualizada = reseñaRepository.save(reseñaExistente);
        return reseñaMapper.toReseñaDTO(reseñaActualizada);
    }

    @Override
    public void eliminarReseña(Long id) {
        reseñaRepository.deleteById(id);
    }



}