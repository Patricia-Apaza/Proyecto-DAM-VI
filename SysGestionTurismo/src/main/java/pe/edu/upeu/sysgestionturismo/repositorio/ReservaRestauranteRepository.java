package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaRestaurante;

public interface ReservaRestauranteRepository extends JpaRepository<ReservaRestaurante, Long> {
}
