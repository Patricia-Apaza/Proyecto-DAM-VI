package pe.edu.upeu.sysgestionturismo.dtos;

import java.time.LocalDate;

public class CheckOutDTO {

    private Long id;
    private Long clienteId;
    private Long hospedajeId;
    private LocalDate fechaCheckOut;
    private String estado; // Ej: "Confirmado", "Pendiente", "Cancelado"
    private String detalles; // Detalles adicionales sobre el check-out

    // Constructor vacío
    public CheckOutDTO() {
    }

    // Constructor con todos los parámetros
    public CheckOutDTO(Long id, Long clienteId, Long hospedajeId, LocalDate fechaCheckOut, String estado, String detalles) {
        this.id = id;
        this.clienteId = clienteId;
        this.hospedajeId = hospedajeId;
        this.fechaCheckOut = fechaCheckOut;
        this.estado = estado;
        this.detalles = detalles;
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

    public Long getHospedajeId() {
        return hospedajeId;
    }

    public void setHospedajeId(Long hospedajeId) {
        this.hospedajeId = hospedajeId;
    }

    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}