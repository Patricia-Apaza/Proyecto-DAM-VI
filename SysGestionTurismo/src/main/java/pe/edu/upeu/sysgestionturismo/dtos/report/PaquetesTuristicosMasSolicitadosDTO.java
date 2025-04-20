package pe.edu.upeu.sysgestionturismo.dtos.report;

public interface PaquetesTuristicosMasSolicitadosDTO {

    // Método para obtener el nombre del paquete turístico
    String getNombrePaquete();

    // Método para obtener el número de veces que el paquete fue solicitado
    Long getNumeroSolicitudes();

    // Método para obtener la fecha de la última solicitud (opcional)
    String getFechaUltimaSolicitud();

    // Método para obtener la duración del paquete (opcional)
    String getDuracionPaquete();
}
