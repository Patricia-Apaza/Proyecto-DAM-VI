package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.MenuDiario;

import java.util.List;

public interface IMenuDiarioService {
    MenuDiario save(MenuDiario menu);
    MenuDiario update(MenuDiario menu);
    void delete(Long id);
    MenuDiario findById(Long id);
    List<MenuDiario> findAll();
}
