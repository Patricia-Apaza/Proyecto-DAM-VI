package pe.edu.upeu.sysgestionturismo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // Método para formatear una fecha a un string con el formato deseado
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    // Método para convertir un string a una fecha con un formato específico
    public static Date parseDate(String dateString, String pattern) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(dateString);
    }

    // Método para obtener la fecha actual en un formato específico
    public static String getCurrentDate(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        return dateFormat.format(date);
    }
}