package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;
import pe.edu.upeu.sysgestionturismo.repositorio.UsuarioRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}