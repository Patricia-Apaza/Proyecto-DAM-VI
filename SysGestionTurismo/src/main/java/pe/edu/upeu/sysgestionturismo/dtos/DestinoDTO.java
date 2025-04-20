package pe.edu.upeu.sysgestionturismo.dtos;

import java.util.List;

public class DestinoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private List<String> actividades;  // Cambiar de String a List<String>
    private String imagenUrl;
    private boolean activo;

    // Constructor vacío
    public DestinoDTO() {
    }

    // Constructor con parámetros
    public DestinoDTO(Long id, String nombre, String descripcion, String ubicacion, List<String> actividades, String imagenUrl, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.actividades = actividades;
        this.imagenUrl = imagenUrl;
        this.activo = activo;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getActividades() {
        return actividades;
    }

    public void setActividades(List<String> actividades) {
        this.actividades = actividades;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}