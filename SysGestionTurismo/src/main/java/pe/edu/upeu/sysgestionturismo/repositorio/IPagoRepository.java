package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.Pago;

public interface IPagoRepository extends JpaRepository<Pago, Long> {
}