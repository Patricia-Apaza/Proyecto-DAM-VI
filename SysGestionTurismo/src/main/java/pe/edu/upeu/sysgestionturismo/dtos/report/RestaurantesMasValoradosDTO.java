package pe.edu.upeu.sysgestionturismo.dtos.report;

public interface RestaurantesMasValoradosDTO {

    // Método para obtener el nombre del restaurante
    String getNombreRestaurante();

    // Método para obtener la calificación promedio del restaurante
    Double getCalificacionPromedio();

    // Método para obtener el número total de reseñas del restaurante
    Long getNumeroReseñas();

    // Método para obtener la categoría o tipo de cocina del restaurante (opcional)
    String getCategoriaRestaurante();
}