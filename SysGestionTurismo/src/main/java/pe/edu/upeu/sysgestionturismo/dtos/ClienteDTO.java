package pe.edu.upeu.sysgestionturismo.dtos;

public class ClienteDTO {

    private Long id;               // Identificador único del cliente
    private String nombre;         // Nombre completo del cliente
    private String apellido;       // Apellido del cliente
    private String dni;            // Documento Nacional de Identidad (DNI) del cliente
    private String email;          // Correo electrónico del cliente
    private String telefono;       // Número de teléfono del cliente
    private String direccion;      // Dirección de residencia del cliente
    private String nacionalidad;   // Nacionalidad del cliente
    private String fechaNacimiento; // Fecha de nacimiento del cliente

    // Constructor vacío
    public ClienteDTO() {
    }

    // Constructor con parámetros
    public ClienteDTO(Long id, String nombre, String apellido, String dni, String email, String telefono, String direccion, String nacionalidad, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
