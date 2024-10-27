package ejerciciosclasead2.ejercicio4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearFicheroTexto {

    public static void crearFicheroTexto(String ruta) {
        File fichero = new File(ruta);

        // Texto que se escribirá en el fichero
        String contenido = "Ejemplo de escritura en un fichero de texto o txt";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero))) {
            escritor.write(contenido);
            System.out.println("Fichero creado y texto escrito exitosamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear o escribir en el fichero.");
            e.printStackTrace();
        }
    }
}
