package ejerciciosclasead2.ejercicio3;

import java.io.File;

public class CrearDirectorio {

    public static void crearDirectorio(String ruta) {
        File directorio = new File(ruta);

        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado exitosamente en: " + ruta);
            } else {
                System.out.println("No se pudo crear el directorio en la ruta especificada.");
            }
        } else {
            System.out.println("El directorio ya existe en: " + ruta);
        }
    }
}
