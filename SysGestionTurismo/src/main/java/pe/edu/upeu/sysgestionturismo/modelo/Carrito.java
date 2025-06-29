package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private EstadoCarrito estado = EstadoCarrito.ACTIVO;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarritoItem> items;

    public enum EstadoCarrito {
        ACTIVO, FINALIZADO
    }

    @PrePersist
    public void prePersist() {
        if (estado == null || (!estado.equals(EstadoCarrito.ACTIVO) && !estado.equals(EstadoCarrito.FINALIZADO))) {
            this.estado = EstadoCarrito.ACTIVO;
        }
    }
}
