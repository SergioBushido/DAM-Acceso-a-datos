package ejerciciosclasead2.ejercicio8;

import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroBinarioAleatorio {

    public static void escribirFicheroBinarioAleatorio(String ruta) {
        String[] apellidos = {"FERNANDEZ", "LOPEZ", "GOMEZ", "CHEN", "SERRANO", "CASILLAS", "ALONSO"};
        int[] edades = {17, 20, 18, 17, 19, 21, 20};
        double[] notas = {7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};

        try (RandomAccessFile fichero = new RandomAccessFile(ruta, "rw")) {
            for (int i = 0; i < apellidos.length; i++) {
                // Mover el puntero a una posición aleatoria
                long posicion = i * 40; // Cada registro ocupará 40 bytes (ajústalo si es necesario)
                fichero.seek(posicion);
                
                // Escribir datos en el archivo de forma aleatoria
                fichero.writeUTF(apellidos[i]); // Escribe el apellido
                fichero.writeInt(edades[i]);    // Escribe la edad
                fichero.writeDouble(notas[i]);  // Escribe la nota
            }
            System.out.println("Datos de los alumnos escritos en el fichero binario de forma aleatoria: " + ruta);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero binario de acceso aleatorio.");
            e.printStackTrace();
        }
    }
}
