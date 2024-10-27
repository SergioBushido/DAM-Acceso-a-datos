package ejerciciosclasead2.ejercicio1;

import java.io.File;

public class InformacionFichero {

    public static void mostrarInformacionFichero(String ruta) {
        File archivo = new File(ruta);

        if (archivo.exists()) {
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Ruta Relativa: " + obtenerRutaRelativa(archivo));
            System.out.println("Ruta Absoluta: " + archivo.getAbsolutePath());
            System.out.println("¿Es legible? " + (archivo.canRead() ? "Sí" : "No"));
            System.out.println("¿Es escribible? " + (archivo.canWrite() ? "Sí" : "No"));
            System.out.println("Tamaño: " + archivo.length() + " bytes");
        } else {
            System.out.println("El archivo o directorio especificado no existe.");
        }
    }

    private static String obtenerRutaRelativa(File archivo) {
        try {
            String rutaAbsoluta = archivo.getCanonicalPath();
            String directorioTrabajo = new File(System.getProperty("user.dir")).getCanonicalPath();

            if (rutaAbsoluta.startsWith(directorioTrabajo)) {
                return "." + rutaAbsoluta.substring(directorioTrabajo.length());
            } else {
                return rutaAbsoluta;  // Si el archivo está fuera del directorio de trabajo, devuelve la ruta absoluta
            }
        } catch (Exception e) {
            e.printStackTrace();
            return archivo.getAbsolutePath();  // En caso de error, devuelve la ruta absoluta
        }
    }
}
