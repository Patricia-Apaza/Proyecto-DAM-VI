package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class ReservaHospedaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservaHospedaje;

    private Boolean disponible = true;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private Integer cantidadHabitaciones;
    private Integer cantidadPersonas;
    private Boolean incluyeNinos = false;
    private Integer cantidadNinos = 0;
    private Boolean incluyeDesayuno = false;
    private String estadoReserva = "pendiente";

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_inventario_hospedaje")
    private InventarioHospedaje inventarioHospedaje;
}
