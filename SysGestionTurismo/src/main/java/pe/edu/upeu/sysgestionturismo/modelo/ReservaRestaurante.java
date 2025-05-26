package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "reserva_restaurante")
public class ReservaRestaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva_restaurante")
    private Long idReservaRestaurante;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time hora;

    @Column(name = "cantidad_personas", nullable = false)
    private Integer cantidadPersonas;

    @Column(name = "incluye_ninos")
    private Boolean incluyeNinos = false;

    @Column(name = "cantidad_ninos")
    private Integer cantidadNinos = 0;

    @Column(length = 20)
    private String estado = "Pendiente";

}
