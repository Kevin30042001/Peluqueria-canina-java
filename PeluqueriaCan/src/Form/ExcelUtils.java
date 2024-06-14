/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {

    public static void exportarTablaAExcel(JTable tabla, String nombreArchivo) {
       Workbook workbook = null;
    FileOutputStream archivoSalida = null;

    try {
        workbook = new HSSFWorkbook();
        Sheet hoja = workbook.createSheet("Empleados");

            // Obtener los datos de la tabla
            int filas = tabla.getRowCount();
            int columnas = tabla.getColumnCount();

            // Escribir los encabezados de columna
            Row filaEncabezados = hoja.createRow(0);
            for (int i = 0; i < columnas; i++) {
                Cell celda = filaEncabezados.createCell(i);
                celda.setCellValue(tabla.getColumnName(i));
            }

            // Escribir los datos de la tabla
            for (int i = 0; i < filas; i++) {
                Row fila = hoja.createRow(i + 1);
                for (int j = 0; j < columnas; j++) {
                    Cell celda = fila.createCell(j);
                    Object valor = tabla.getValueAt(i, j);
                    if (valor != null) {
                        celda.setCellValue(valor.toString());
                    }
                }
            }

            // Guardar el archivo de Excel
           archivoSalida = new FileOutputStream(nombreArchivo + ".xls");
        workbook.write(archivoSalida);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (archivoSalida != null) {
                archivoSalida.close();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }}
    }
}