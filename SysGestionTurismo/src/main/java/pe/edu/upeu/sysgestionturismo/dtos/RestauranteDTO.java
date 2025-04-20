package pe.edu.upeu.sysgestionturismo.dtos;

public class RestauranteDTO {

    private Long id;                          // Identificador único del restaurante
    private String nombre;                    // Nombre del restaurante
    private String direccion;                 // Dirección física del restaurante
    private String tipoComida;                // Tipo de comida que ofrece el restaurante
    private String telefono;                  // Teléfono de contacto del restaurante
    private String horario;                   // Horarios de apertura del restaurante
    private String descripcion;               // Descripción adicional del restaurante

    // Constructor vacío
    public RestauranteDTO() {
    }

    // Constructor con parámetros
    public RestauranteDTO(Long id, String nombre, String direccion, String tipoComida,
                          String telefono, String horario, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoComida = tipoComida;
        this.telefono = telefono;
        this.horario = horario;
        this.descripcion = descripcion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}