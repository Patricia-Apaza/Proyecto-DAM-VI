package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteHospedaje;
import java.util.List;

public interface PaqueteHospedajeRepository extends JpaRepository<PaqueteHospedaje, Long> {
    void deleteByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
    List<PaqueteHospedaje> findByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
}
