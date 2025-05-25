package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaActividad;

public interface ReservaActividadRepository extends JpaRepository<ReservaActividad, Long> {
}
