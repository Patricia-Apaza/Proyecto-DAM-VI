package pe.edu.upeu.sysgestionturismo.dtos;

import java.util.Date;

public class ReservaDTO {

    private Long id;                          // Identificador único de la reserva
    private Long clienteId;                   // Identificador del cliente que realiza la reserva
    private Long paqueteId;                   // Identificador del paquete turístico reservado
    private Date fechaReserva;                // Fecha en que se realiza la reserva
    private Date fechaIngreso;                // Fecha de ingreso del turista al destino
    private Date fechaSalida;                 // Fecha de salida del turista del destino
    private double total;                     // Total de la reserva (precio)
    private String estado;                    // Estado de la reserva (Ej. Confirmada, Pendiente, Cancelada)
    private String comentarios;               // Comentarios adicionales sobre la reserva

    // Constructor vacío
    public ReservaDTO() {
    }

    // Constructor con parámetros
    public ReservaDTO(Long id, Long clienteId, Long paqueteId, Date fechaReserva, Date fechaIngreso,
                      Date fechaSalida, double total, String estado, String comentarios) {
        this.id = id;
        this.clienteId = clienteId;
        this.paqueteId = paqueteId;
        this.fechaReserva = fechaReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.total = total;
        this.estado = estado;
        this.comentarios = comentarios;
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

    public Long getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(Long paqueteId) {
        this.paqueteId = paqueteId;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}