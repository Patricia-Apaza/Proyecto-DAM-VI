package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class CarritoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarritoItem;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;

    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;

    private Long idReferencia;

    private Integer cantidad = 1;

    private String observaciones;

    private LocalDateTime fechaAgregado = LocalDateTime.now();

    public enum TipoItem {
        ACTIVIDAD,
        HOSPEDAJE,
        MENU,
        RESTAURANTE,
        PAQUETE,
        DESTINO
    }
}
