package pe.edu.upeu.sysgestionturismo.dtos;

import java.util.List;

public class PaqueteTuristicoDTO {

    private Long id;                          // Identificador único del paquete turístico
    private String nombre;                    // Nombre del paquete turístico
    private String descripcion;               // Descripción del paquete turístico
    private List<DestinoDTO> destinos;        // Lista de destinos incluidos en el paquete
    private HospedajeDTO hospedaje;           // Hospedaje incluido en el paquete (solo uno)
    private List<ActividadDTO> actividades;   // Lista de actividades incluidas en el paquete
    private RestauranteDTO restaurante;       // Restaurante incluido en el paquete (solo uno)
    private double precio;                    // Precio total del paquete turístico
    private boolean disponible;               // Indica si el paquete está disponible para reservas

    // Constructor vacío
    public PaqueteTuristicoDTO() {
    }

    // Constructor con parámetros
    public PaqueteTuristicoDTO(Long id, String nombre, String descripcion, List<DestinoDTO> destinos,
                               HospedajeDTO hospedaje, List<ActividadDTO> actividades,
                               RestauranteDTO restaurante, double precio, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destinos = destinos;
        this.hospedaje = hospedaje;
        this.actividades = actividades;
        this.restaurante = restaurante;
        this.precio = precio;
        this.disponible = disponible;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DestinoDTO> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<DestinoDTO> destinos) {
        this.destinos = destinos;
    }

    public HospedajeDTO getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeDTO hospedaje) {
        this.hospedaje = hospedaje;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }

    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}