package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgestionturismo.modelo.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}
