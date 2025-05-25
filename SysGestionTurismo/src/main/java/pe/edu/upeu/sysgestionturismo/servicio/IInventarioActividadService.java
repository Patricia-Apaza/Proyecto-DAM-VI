package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.InventarioActividadDto;

import java.util.List;

public interface IInventarioActividadService {
    List<InventarioActividadDto> getAll();
    InventarioActividadDto getById(Long id);
    InventarioActividadDto create(InventarioActividadDto dto);
    InventarioActividadDto update(Long id, InventarioActividadDto dto);
    void delete(Long id);
}
