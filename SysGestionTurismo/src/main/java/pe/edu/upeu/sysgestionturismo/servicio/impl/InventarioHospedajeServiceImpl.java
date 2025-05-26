package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioHospedaje;
import pe.edu.upeu.sysgestionturismo.repositorio.InventarioHospedajeRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioHospedajeService;

import java.util.List;

@Service
public class InventarioHospedajeServiceImpl implements IInventarioHospedajeService {

    @Autowired
    private InventarioHospedajeRepository repo;

    @Override
    public InventarioHospedaje save(InventarioHospedaje inv) {
        return repo.save(inv);
    }

    @Override
    public InventarioHospedaje update(InventarioHospedaje inv) {
        return repo.save(inv);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public InventarioHospedaje findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<InventarioHospedaje> findAll() {
        return repo.findAll();
    }
}
