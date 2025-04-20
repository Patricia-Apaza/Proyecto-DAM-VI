package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.DestinoDTO;
import pe.edu.upeu.sysgestionturismo.mappers.DestinoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.repositorio.IDestinoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IDestinoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoServiceImpl implements IDestinoService {

    @Autowired
    private IDestinoRepository destinoRepository;

    @Autowired
    private DestinoMapper destinoMapper;

    @Override
    public List<DestinoDTO> listarDestinos() {
        List<Destino> destinos = destinoRepository.findAll();
        return destinos.stream()
                .map(destinoMapper::toDestinoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DestinoDTO obtenerDestinoPorId(Long id) {
        Destino destino = destinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino no encontrado"));
        return destinoMapper.toDestinoDTO(destino);
    }

    @Override
    public DestinoDTO registrarDestino(DestinoDTO destinoDTO) {
        Destino destino = destinoMapper.toEntity(destinoDTO);
        Destino destinoGuardado = destinoRepository.save(destino);
        return destinoMapper.toDestinoDTO(destinoGuardado);
    }

    @Override
    public DestinoDTO actualizarDestino(Long id, DestinoDTO destinoDTO) {
        Destino destinoExistente = destinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino no encontrado"));
        destinoMapper.updateEntityFromDto(destinoDTO, destinoExistente);
        Destino destinoActualizado = destinoRepository.save(destinoExistente);
        return destinoMapper.toDestinoDTO(destinoActualizado);
    }

    @Override
    public void eliminarDestino(Long id) {
        destinoRepository.deleteById(id);
    }
}