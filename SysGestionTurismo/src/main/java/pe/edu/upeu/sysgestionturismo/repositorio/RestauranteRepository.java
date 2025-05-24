package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
