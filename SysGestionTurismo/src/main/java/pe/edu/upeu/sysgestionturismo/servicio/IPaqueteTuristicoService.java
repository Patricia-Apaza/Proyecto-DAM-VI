package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;
import java.util.List;

public interface IPaqueteTuristicoService {
    PaqueteTuristico save(PaqueteTuristico paquete);
    PaqueteTuristico update(PaqueteTuristico paquete);
    void delete(Long id);
    PaqueteTuristico findById(Long id);
    List<PaqueteTuristico> findAll();

    // Nuevos métodos para manejar relaciones
    PaqueteTuristico saveWithRelations(PaqueteTuristicoDto dto);
    PaqueteTuristico updateWithRelations(PaqueteTuristicoDto dto);
    PaqueteTuristicoDto findByIdWithRelations(Long id);
    List<PaqueteTuristicoDto> findAllWithRelations();
}
