package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteRestaurante;
import java.util.List;

public interface PaqueteRestauranteRepository extends JpaRepository<PaqueteRestaurante, Long> {
    void deleteByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
    List<PaqueteRestaurante> findByPaqueteTuristicoIdPaqueteTuristico(Long idPaquete);
}
