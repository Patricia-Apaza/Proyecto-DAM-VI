package pe.edu.upeu.sysgestionturismo.dtos;

import java.time.LocalDate;

public class CheckInDTO {

    private Long id;
    private Long clienteId;
    private Long hospedajeId;
    private LocalDate fechaCheckIn;
    private String estado; // Ej: "Confirmado", "Pendiente", "Cancelado"
    private String detalles; // Detalles adicionales sobre el check-in

    // Constructor vacío
    public CheckInDTO() {
    }

    // Constructor con todos los parámetros
    public CheckInDTO(Long id, Long clienteId, Long hospedajeId, LocalDate fechaCheckIn, String estado, String detalles) {
        this.id = id;
        this.clienteId = clienteId;
        this.hospedajeId = hospedajeId;
        this.fechaCheckIn = fechaCheckIn;
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

    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
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