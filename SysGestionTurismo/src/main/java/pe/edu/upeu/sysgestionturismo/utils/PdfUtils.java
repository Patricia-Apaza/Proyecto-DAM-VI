package pe.edu.upeu.sysgestionturismo.utils;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.File;
import java.io.IOException;

public class PdfUtils {

    /**
     * Método para generar un PDF básico con información de un paquete turístico.
     * @param destino El nombre del destino turístico.
     * @param actividades Lista de actividades para el destino.
     * @param precio El precio del paquete turístico.
     * @param outputFile Ruta donde se guardará el archivo PDF.
     * @throws IOException Si hay un error al escribir el archivo.
     */
    public static void generarPdfPaqueteTuristico(String destino, String[] actividades, double precio, String outputFile) throws IOException {
        // Crear un escritor de PDF
        PdfWriter writer = new PdfWriter(outputFile);

        // Crear el documento PDF
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Añadir título
        document.add(new Paragraph("Paquete Turístico: " + destino)
                .setFontSize(20)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));

        // Añadir una descripción
        document.add(new Paragraph("Este paquete incluye las siguientes actividades:")
                .setFontSize(14)
                .setTextAlignment(TextAlignment.LEFT));

        // Crear tabla de actividades
        Table table = new Table(1);
        for (String actividad : actividades) {
            table.addCell(new Paragraph(actividad));
        }
        document.add(table);

        // Añadir el precio
        document.add(new Paragraph("Precio: S/ " + precio)
                .setFontSize(14)
                .setTextAlignment(TextAlignment.LEFT)
                .setBold());

        // Cerrar el documento
        document.close();
    }

    /**
     * Método para generar un PDF de ejemplo simple.
     * @param outputFile Ruta donde se guardará el archivo PDF.
     * @throws IOException Si hay un error al escribir el archivo.
     */
    public static void generarPdfSimple(String outputFile) throws IOException {
        // Crear un escritor de PDF
        PdfWriter writer = new PdfWriter(outputFile);

        // Crear el documento PDF
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Añadir contenido simple
        document.add(new Paragraph("Bienvenido a SysGestionTurismo")
                .setFontSize(18)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));

        // Cerrar el documento
        document.close();
    }
}