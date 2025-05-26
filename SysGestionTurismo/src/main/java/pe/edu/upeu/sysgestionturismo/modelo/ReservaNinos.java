package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reserva_ninos")
public class ReservaNinos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservaNinos;

    @ManyToOne
    @JoinColumn(name = "id_reserva_hospedaje")
    private ReservaHospedaje reservaHospedaje;

    @ManyToOne
    @JoinColumn(name = "id_reserva_actividad")
    private ReservaActividad reservaActividad;

    @ManyToOne
    @JoinColumn(name = "id_reserva_paquete")
    private ReservaPaqueteTuristico reservaPaquete;

    @ManyToOne
    @JoinColumn(name = "id_reserva_restaurante")
    private ReservaRestaurante reservaRestaurante;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @Column(nullable = false)
    private Integer edad;

    private String tipoDocumento;

    private String numDocumento;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @Column(name = "registrado_por_cliente_id", nullable = false)
    private Long registradoPorClienteId;

}
