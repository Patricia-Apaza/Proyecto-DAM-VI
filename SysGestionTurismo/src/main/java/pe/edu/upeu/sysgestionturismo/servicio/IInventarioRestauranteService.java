package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.InventarioRestaurante;

import java.util.List;

public interface IInventarioRestauranteService {
    InventarioRestaurante save(InventarioRestaurante inv);
    InventarioRestaurante update(InventarioRestaurante inv);
    void delete(Long id);
    InventarioRestaurante findById(Long id);
    List<InventarioRestaurante> findAll();
}
