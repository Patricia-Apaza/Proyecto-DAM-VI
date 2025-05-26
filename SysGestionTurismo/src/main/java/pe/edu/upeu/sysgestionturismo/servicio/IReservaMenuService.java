package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.ReservaMenu;
import java.util.List;

public interface IReservaMenuService {
    ReservaMenu save(ReservaMenu entidad);
    ReservaMenu update(ReservaMenu entidad);
    void delete(Long id);
    ReservaMenu findById(Long id);
    List<ReservaMenu> findAll();
}
