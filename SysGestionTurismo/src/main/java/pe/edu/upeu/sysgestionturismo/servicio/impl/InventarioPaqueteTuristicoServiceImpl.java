package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioPaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.repositorio.InventarioPaqueteTuristicoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioPaqueteTuristicoService;

import java.util.List;

@Service
public class InventarioPaqueteTuristicoServiceImpl implements IInventarioPaqueteTuristicoService {

    @Autowired
    private InventarioPaqueteTuristicoRepository repo;

    @Override
    public InventarioPaqueteTuristico save(InventarioPaqueteTuristico inv) {
        return repo.save(inv);
    }

    @Override
    public InventarioPaqueteTuristico update(InventarioPaqueteTuristico inv) {
        return repo.save(inv);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public InventarioPaqueteTuristico findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<InventarioPaqueteTuristico> findAll() {
        return repo.findAll();
    }
}
