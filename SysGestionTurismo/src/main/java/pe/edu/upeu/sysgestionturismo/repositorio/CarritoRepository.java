package pe.edu.upeu.sysgestionturismo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upeu.sysgestionturismo.modelo.Carrito;
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;

import java.util.Optional;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByClienteAndEstado(Cliente cliente, Carrito.EstadoCarrito estado);

    @Query("SELECT c FROM Carrito c LEFT JOIN FETCH c.items WHERE c.idCarrito = :id")
    Optional<Carrito> findConItemsById(@Param("id") Long id);
}
