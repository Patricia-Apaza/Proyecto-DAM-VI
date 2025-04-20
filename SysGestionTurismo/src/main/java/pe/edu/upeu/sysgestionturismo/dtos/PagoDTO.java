package pe.edu.upeu.sysgestionturismo.dtos;

import java.util.Date;

public class PagoDTO {

    private Long id;                      // Identificador único del pago
    private Long clienteId;               // ID del cliente que realiza el pago
    private Long usuarioId;               // ID del usuario que registró la reserva
    private double monto;                 // Monto total del pago
    private String metodoPago;            // Método de pago (por ejemplo: VISA, Yape, Plin)
    private String estado;                // Estado del pago (por ejemplo: 'pendiente', 'completado', 'fallido')
    private Date fechaPago;               // Fecha en la que se realizó el pago
    private String descripcion;           // Descripción del pago (por ejemplo: "Pago por hospedaje y actividades")

    // Constructor vacío
    public PagoDTO() {
    }

    // Constructor con parámetros
    public PagoDTO(Long id, Long clienteId, Long usuarioId, double monto, String metodoPago, String estado, Date fechaPago, String descripcion) {
        this.id = id;
        this.clienteId = clienteId;
        this.usuarioId = usuarioId;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}