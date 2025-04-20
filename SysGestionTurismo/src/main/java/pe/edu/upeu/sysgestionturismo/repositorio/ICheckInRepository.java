package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.CheckIn;

public interface ICheckInRepository extends JpaRepository<CheckIn, Long> {
}