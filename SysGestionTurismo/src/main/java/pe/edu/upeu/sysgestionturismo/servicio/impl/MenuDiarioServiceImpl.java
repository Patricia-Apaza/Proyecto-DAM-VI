package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.MenuDiario;
import pe.edu.upeu.sysgestionturismo.repositorio.MenuDiarioRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IMenuDiarioService;

import java.util.List;

@Service
public class MenuDiarioServiceImpl implements IMenuDiarioService {

    @Autowired
    private MenuDiarioRepository repository;

    @Override
    public MenuDiario save(MenuDiario menu) {
        return repository.save(menu);
    }

    @Override
    public MenuDiario update(MenuDiario menu) {
        return repository.save(menu);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MenuDiario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MenuDiario> findAll() {
        return repository.findAll();
    }
}
