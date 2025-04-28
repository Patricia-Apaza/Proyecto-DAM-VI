package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Long id);
    Usuario findById(Long id);
    List<Usuario> findAll();
}
