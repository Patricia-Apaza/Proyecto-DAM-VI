package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteDestino;
import java.util.List;

public interface PaqueteDestinoRepository extends JpaRepository<PaqueteDestino, Long> {
    void deleteByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
    List<PaqueteDestino> findByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
}
