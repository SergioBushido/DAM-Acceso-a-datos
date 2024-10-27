package ejerciciosclasead2.ejercicio2;

import java.io.File;

public class ListadoDirectorios {

    public static void listarContenidoDirectorio(String ruta) {
        File directorio = new File(ruta);

        if (directorio.exists() && directorio.isDirectory()) {
            File[] contenido = directorio.listFiles();
            
            if (contenido != null) {
                System.out.println("Contenido del directorio: " + ruta);
                for (File archivo : contenido) {
                    if (archivo.isDirectory()) {
                        System.out.println("[Directorio] " + archivo.getName());
                    } else {
                        System.out.println("[Archivo] " + archivo.getName());
                    }
                }
            } else {
                System.out.println("No se pudo leer el contenido del directorio.");
            }
        } else {
            System.out.println("La ruta especificada no es un directorio o no existe.");
        }
    }
}
