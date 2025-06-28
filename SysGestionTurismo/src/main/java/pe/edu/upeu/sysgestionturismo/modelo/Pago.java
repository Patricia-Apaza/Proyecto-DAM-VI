package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;

    private BigDecimal montoOriginal;
    private BigDecimal montoConvertido;
    private String moneda;
    private BigDecimal tasaCambio;

    private String metodoPago;
    private String rutaComprobante;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado = EstadoPago.PENDIENTE;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private LocalDateTime fechaConfirmacion;

    public enum EstadoPago {
        PENDIENTE,
        CONFIRMADO,
        CANCELADO,
        RECHAZADO
    }

    @PrePersist
    public void prePersist() {
        if (estado == null) {
            estado = EstadoPago.PENDIENTE;
        }
    }
}
