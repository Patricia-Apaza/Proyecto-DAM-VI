package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDTO;
import pe.edu.upeu.sysgestionturismo.mappers.PaqueteTuristicoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.repositorio.IPaqueteTuristicoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteTuristicoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaqueteTuristicoServiceImpl implements IPaqueteTuristicoService {

    @Autowired
    private IPaqueteTuristicoRepository paqueteTuristicoRepository;

    @Autowired
    private PaqueteTuristicoMapper paqueteTuristicoMapper;

    @Override
    public List<PaqueteTuristicoDTO> listarPaquetes() {
        List<PaqueteTuristico> paquetesTuristicos = paqueteTuristicoRepository.findAll();
        return paquetesTuristicos.stream()
                .map(paqueteTuristicoMapper::toPaqueteTuristicoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaqueteTuristicoDTO obtenerPaquetePorId(Long id) {
        PaqueteTuristico paqueteTuristico = paqueteTuristicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paquete turístico no encontrado"));
        return paqueteTuristicoMapper.toPaqueteTuristicoDTO(paqueteTuristico);
    }

    @Override
    public PaqueteTuristicoDTO registrarPaqueteTuristico(PaqueteTuristicoDTO paqueteTuristicoDTO) {
        PaqueteTuristico paqueteTuristico = paqueteTuristicoMapper.toPaqueteTuristico(paqueteTuristicoDTO);
        PaqueteTuristico paqueteTuristicoGuardado = paqueteTuristicoRepository.save(paqueteTuristico);
        return paqueteTuristicoMapper.toPaqueteTuristicoDTO(paqueteTuristicoGuardado);
    }

    @Override
    public PaqueteTuristicoDTO actualizarPaqueteTuristico(Long id, PaqueteTuristicoDTO paqueteTuristicoDTO) {
        PaqueteTuristico paqueteTuristicoExistente = paqueteTuristicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paquete turístico no encontrado"));
        paqueteTuristicoMapper.updateEntityFromDto(paqueteTuristicoDTO, paqueteTuristicoExistente);
        PaqueteTuristico paqueteTuristicoActualizado = paqueteTuristicoRepository.save(paqueteTuristicoExistente);
        return paqueteTuristicoMapper.toPaqueteTuristicoDTO(paqueteTuristicoActualizado);
    }

    @Override
    public void eliminarPaqueteTuristico(Long id) {
        paqueteTuristicoRepository.deleteById(id);
    }
}