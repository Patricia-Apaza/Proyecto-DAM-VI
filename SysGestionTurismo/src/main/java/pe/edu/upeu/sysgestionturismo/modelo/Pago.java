package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;

    private String metodoPago; // Ejemplo: "Tarjeta", "Transferencia", "Efectivo"

    private String estadoPago; // Ejemplo: "Completado", "Pendiente", "Fallido"

    private LocalDateTime fechaPago;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}