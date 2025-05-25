package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteActividad;
import pe.edu.upeu.sysgestionturismo.repositorio.PaqueteActividadRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteActividadService;

import java.util.List;

@Service
public class PaqueteActividadServiceImpl implements IPaqueteActividadService {

    @Autowired
    private PaqueteActividadRepository repository;

    @Override
    public PaqueteActividad save(PaqueteActividad entity) {
        return repository.save(entity);
    }

    @Override
    public PaqueteActividad update(PaqueteActividad entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PaqueteActividad findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PaqueteActividad> findAll() {
        return repository.findAll();
    }
}
