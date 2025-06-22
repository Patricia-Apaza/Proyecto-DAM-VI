package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.NivelPaquete;
import pe.edu.upeu.sysgestionturismo.repositorio.NivelPaqueteRepository;
import pe.edu.upeu.sysgestionturismo.servicio.INivelPaqueteService;

import java.util.List;

@Service
public class NivelPaqueteServiceImpl implements INivelPaqueteService {

    @Autowired
    private NivelPaqueteRepository nivelPaqueteRepository;

    @Override
    public NivelPaquete save(NivelPaquete nivel) {
        return nivelPaqueteRepository.save(nivel);
    }

    @Override
    public NivelPaquete update(NivelPaquete nivel) {
        return nivelPaqueteRepository.save(nivel);
    }

    @Override
    public void delete(Long id) {
        nivelPaqueteRepository.deleteById(id);
    }

    @Override
    public NivelPaquete findById(Long id) {
        return nivelPaqueteRepository.findById(id).orElse(null);
    }

    @Override
    public List<NivelPaquete> findAll() {
        return nivelPaqueteRepository.findAll();
    }
}
