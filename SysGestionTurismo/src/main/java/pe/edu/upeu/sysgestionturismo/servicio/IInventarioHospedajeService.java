package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.InventarioHospedaje;

import java.util.List;

public interface IInventarioHospedajeService {
    InventarioHospedaje save(InventarioHospedaje inv);
    InventarioHospedaje update(InventarioHospedaje inv);
    void delete(Long id);
    InventarioHospedaje findById(Long id);
    List<InventarioHospedaje> findAll();
}
