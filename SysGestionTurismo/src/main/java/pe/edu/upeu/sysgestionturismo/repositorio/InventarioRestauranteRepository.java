package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.InventarioRestaurante;

public interface InventarioRestauranteRepository extends JpaRepository<InventarioRestaurante, Long> {
}
