package pe.edu.upeu.sysgestionturismo.dtos.report;

public interface DestinosMasVisitadosDTO {

    // Método para obtener el nombre del destino
    String getNombreDestino();

    // Método para obtener el número de visitas al destino
    Long getNumeroVisitas();

    // Método para obtener la fecha de la última visita (opcional)
    String getFechaUltimaVisita();

    // Método para obtener la categoría del destino (opcional)
    String getCategoriaDestino();
}