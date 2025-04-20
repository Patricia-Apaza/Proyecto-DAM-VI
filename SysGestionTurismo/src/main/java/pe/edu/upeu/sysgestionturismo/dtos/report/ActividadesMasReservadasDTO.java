package pe.edu.upeu.sysgestionturismo.dtos.report;

public interface ActividadesMasReservadasDTO {

    // Método para obtener el nombre de la actividad
    String getNombreActividad();

    // Método para obtener el número de reservas de la actividad
    Long getNumeroReservas();

    // Método para obtener la fecha de la última reserva (opcional)
    String getFechaUltimaReserva();

    // Método para obtener la categoría de la actividad (opcional)
    String getCategoriaActividad();
}