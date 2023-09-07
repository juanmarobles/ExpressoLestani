/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lestanitest.logica;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.printing.PDFPageable;
/**
 *
 * @author juanm
 */
public class GenerarPDFDuplicado {
    public static void main(String[] args) {
        try {
            PDDocument document = new PDDocument();

            // Crear la primera página y agregar contenido
            PDPage firstPage = new PDPage();
            document.addPage(firstPage);
            PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Contenido de la primera página");
            contentStream.endText();
            contentStream.close();

            // Clonar el contenido de la primera página y agregarlo debajo
            PDPageContentStream copiedContentStream = new PDPageContentStream(document, firstPage, PDPageContentStream.AppendMode.APPEND, true);
            copiedContentStream.beginText();
            copiedContentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            copiedContentStream.newLineAtOffset(100, 650);
            copiedContentStream.showText("Contenido clonado en la misma página");
            copiedContentStream.endText();
            copiedContentStream.close();

            // Guardar el documento en un archivo
            File outputFile = new File("archivo.pdf");
            document.save(new FileOutputStream(outputFile));
            document.close();

            // Imprimir el archivo PDF automáticamente
            PDDocument pdfDocument = PDDocument.load(outputFile);
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PDFPageable pageable = new PDFPageable(pdfDocument);
            printerJob.setPageable(pageable);
            printerJob.print();
            pdfDocument.close();

            JOptionPane.showMessageDialog(null, "El remito se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar o imprimir el remito.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generarPdfDuplicado() {
        try {
            PDDocument document = new PDDocument();

            // Crear la primera página y agregar contenido
            PDPage firstPage = new PDPage();
            document.addPage(firstPage);
            PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Contenido de la primera página");
            contentStream.endText();
            contentStream.close();

            // Clonar el contenido de la primera página y agregarlo debajo
            PDPageContentStream copiedContentStream = new PDPageContentStream(document, firstPage, PDPageContentStream.AppendMode.APPEND, true);
            copiedContentStream.beginText();
            copiedContentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            copiedContentStream.newLineAtOffset(100, 650);
            copiedContentStream.showText("Contenido clonado en la misma página");
            copiedContentStream.endText();
            copiedContentStream.close();

            // Guardar el documento en un archivo
            File outputFile = new File("archivo.pdf");
            document.save(new FileOutputStream(outputFile));
            document.close();

            // Imprimir el archivo PDF automáticamente
            PDDocument pdfDocument = PDDocument.load(outputFile);
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PDFPageable pageable = new PDFPageable(pdfDocument);
            printerJob.setPageable(pageable);
            printerJob.print();
            pdfDocument.close();

            JOptionPane.showMessageDialog(null, "El remito se generó e imprimió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar o imprimir el remito.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
