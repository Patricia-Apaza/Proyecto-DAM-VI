package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteActividad;
import java.util.List;

public interface PaqueteActividadRepository extends JpaRepository<PaqueteActividad, Long> {
    void deleteByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
    List<PaqueteActividad> findByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
}
