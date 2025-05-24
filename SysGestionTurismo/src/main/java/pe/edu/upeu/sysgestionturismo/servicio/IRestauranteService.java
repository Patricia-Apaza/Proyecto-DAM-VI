package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

import java.util.List;

public interface IRestauranteService {
    Restaurante save(Restaurante restaurante);
    Restaurante update(Restaurante restaurante);
    void delete(Long id);
    Restaurante findById(Long id);
    List<Restaurante> findAll();
}
