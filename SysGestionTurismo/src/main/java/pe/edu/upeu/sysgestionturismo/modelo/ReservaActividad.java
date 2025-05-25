package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
public class ReservaActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservaActividad;

    private Boolean disponible = true;
    private Integer cantidadPersonas;
    private Boolean incluyeNinos = false;
    private Integer cantidadNinos = 0;
    private String estadoReserva = "pendiente";
    private Timestamp fechaReserva;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_inventario_actividad")
    private InventarioActividad inventarioActividad;
}
