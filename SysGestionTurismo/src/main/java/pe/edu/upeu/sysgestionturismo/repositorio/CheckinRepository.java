package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgestionturismo.modelo.Checkin;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Long> {

}
