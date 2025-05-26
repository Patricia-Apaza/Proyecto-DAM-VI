package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioRestaurante;
import pe.edu.upeu.sysgestionturismo.repositorio.InventarioRestauranteRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioRestauranteService;

import java.util.List;

@Service
public class InventarioRestauranteServiceImpl implements IInventarioRestauranteService {

    @Autowired
    private InventarioRestauranteRepository repo;

    @Override
    public InventarioRestaurante save(InventarioRestaurante inv) {
        return repo.save(inv);
    }

    @Override
    public InventarioRestaurante update(InventarioRestaurante inv) {
        return repo.save(inv);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public InventarioRestaurante findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<InventarioRestaurante> findAll() {
        return repo.findAll();
    }
}
