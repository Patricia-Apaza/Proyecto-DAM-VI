package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.InventarioPaqueteTuristico;

import java.util.List;

public interface IInventarioPaqueteTuristicoService {
    InventarioPaqueteTuristico save(InventarioPaqueteTuristico inv);
    InventarioPaqueteTuristico update(InventarioPaqueteTuristico inv);
    void delete(Long id);
    InventarioPaqueteTuristico findById(Long id);
    List<InventarioPaqueteTuristico> findAll();
}
