package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteHospedaje;
import pe.edu.upeu.sysgestionturismo.repositorio.PaqueteHospedajeRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteHospedajeService;

import java.util.List;

@Service
public class PaqueteHospedajeServiceImpl implements IPaqueteHospedajeService {

    @Autowired
    private PaqueteHospedajeRepository repository;

    @Override
    public PaqueteHospedaje save(PaqueteHospedaje entity) {
        return repository.save(entity);
    }

    @Override
    public PaqueteHospedaje update(PaqueteHospedaje entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PaqueteHospedaje findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PaqueteHospedaje> findAll() {
        return repository.findAll();
    }
}
