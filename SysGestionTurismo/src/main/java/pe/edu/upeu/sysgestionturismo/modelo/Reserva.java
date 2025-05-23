package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private LocalDate fechaReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer numeroPersonas;

    private String tipoReserva;
    private String estadoReserva;
    private Double totalPago;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idPaquete")
    private PaqueteTuristico paqueteTuristico;
}

