package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysgestionturismo.modelo.Carrito;
import pe.edu.upeu.sysgestionturismo.modelo.CarritoItem;
import pe.edu.upeu.sysgestionturismo.modelo.CarritoItem.TipoItem;

import java.util.Optional;

public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {
    Optional<CarritoItem> findByCarritoAndTipoItemAndIdReferencia(Carrito carrito, TipoItem tipoItem, Long idReferencia);
}
