package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.Reseña;

public interface IReseñaRepository extends JpaRepository<Reseña, Long> {
}