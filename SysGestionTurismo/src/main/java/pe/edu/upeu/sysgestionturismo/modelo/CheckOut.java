package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "check_out")
public class CheckOut implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_check_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCheckOut;

    @Column(name = "numero_habitacion", nullable = false)
    private String numeroHabitacion;

    @Column(name = "monto_pago", nullable = false)
    private Double montoPago;

    @Column(name = "comentarios", length = 500)
    private String comentarios;

    // Constructor vacío
    public CheckOut() {
    }

    // Constructor con parámetros
    public CheckOut(Cliente cliente, Date fechaCheckOut, String numeroHabitacion, Double montoPago, String comentarios) {
        this.cliente = cliente;
        this.fechaCheckOut = fechaCheckOut;
        this.numeroHabitacion = numeroHabitacion;
        this.montoPago = montoPago;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(Date fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}