package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaMenu;
import pe.edu.upeu.sysgestionturismo.repositorio.ReservaMenuRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaMenuService;

import java.util.List;

@Service
public class ReservaMenuServiceImpl implements IReservaMenuService {

    @Autowired
    private ReservaMenuRepository reservaMenuRepository;

    @Override
    public ReservaMenu save(ReservaMenu entidad) {
        return reservaMenuRepository.save(entidad);
    }

    @Override
    public ReservaMenu update(ReservaMenu entidad) {
        return reservaMenuRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        reservaMenuRepository.deleteById(id);
    }

    @Override
    public ReservaMenu findById(Long id) {
        return reservaMenuRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservaMenu> findAll() {
        return reservaMenuRepository.findAll();
    }
}
