package ejerciciosclasead2.ejercicio5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VisualizarFicheroTexto {

    public static void visualizarFichero(String ruta) {
        FileReader lectorArchivo = null;
        BufferedReader lectorBuffer = null;
        
        try {
            lectorArchivo = new FileReader(ruta);
            lectorBuffer = new BufferedReader(lectorArchivo);
            String linea;

            System.out.println("Contenido del fichero:");
            while ((linea = lectorBuffer.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero.");
            e.printStackTrace();
        } finally {
            try {
                if (lectorBuffer != null) lectorBuffer.close();
                if (lectorArchivo != null) lectorArchivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
