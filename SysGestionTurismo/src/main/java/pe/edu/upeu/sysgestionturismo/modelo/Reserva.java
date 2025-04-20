package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaReserva;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private int cantidadPersonas;

    private String estado; // Ejemplo: "PENDIENTE", "CONFIRMADA", "CANCELADA"

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "paquete_id")
    private PaqueteTuristico paqueteTuristico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}