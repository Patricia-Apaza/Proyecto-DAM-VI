package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteRestaurante;
import pe.edu.upeu.sysgestionturismo.repositorio.PaqueteRestauranteRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteRestauranteService;

import java.util.List;

@Service
public class PaqueteRestauranteServiceImpl implements IPaqueteRestauranteService {

    @Autowired
    private PaqueteRestauranteRepository repository;

    @Override
    public PaqueteRestaurante save(PaqueteRestaurante entity) {
        return repository.save(entity);
    }

    @Override
    public PaqueteRestaurante update(PaqueteRestaurante entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PaqueteRestaurante findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PaqueteRestaurante> findAll() {
        return repository.findAll();
    }
}
