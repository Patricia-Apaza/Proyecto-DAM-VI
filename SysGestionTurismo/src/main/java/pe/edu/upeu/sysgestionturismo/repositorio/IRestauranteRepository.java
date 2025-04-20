package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;

public interface IRestauranteRepository extends JpaRepository<Restaurante, Long> {
}