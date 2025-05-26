package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteDestino;
import pe.edu.upeu.sysgestionturismo.repositorio.PaqueteDestinoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteDestinoService;

import java.util.List;

@Service
public class PaqueteDestinoServiceImpl implements IPaqueteDestinoService {

    @Autowired
    private PaqueteDestinoRepository repository;

    @Override
    public PaqueteDestino save(PaqueteDestino entity) {
        return repository.save(entity);
    }

    @Override
    public PaqueteDestino update(PaqueteDestino entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PaqueteDestino findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PaqueteDestino> findAll() {
        return repository.findAll();
    }
}
