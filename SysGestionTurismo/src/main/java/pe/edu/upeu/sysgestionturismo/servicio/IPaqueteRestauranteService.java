package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.PaqueteRestaurante;

import java.util.List;

public interface IPaqueteRestauranteService {
    PaqueteRestaurante save(PaqueteRestaurante entity);
    PaqueteRestaurante update(PaqueteRestaurante entity);
    void delete(Long id);
    PaqueteRestaurante findById(Long id);
    List<PaqueteRestaurante> findAll();
}
