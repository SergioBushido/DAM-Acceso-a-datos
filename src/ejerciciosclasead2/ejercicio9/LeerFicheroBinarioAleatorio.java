package ejerciciosclasead2.ejercicio9;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFicheroBinarioAleatorio {

    public static void leerFicheroBinarioAleatorio(String ruta) {
        int registros = 7; // Número de registros de alumnos que escribimos previamente
        int tamañoRegistro = 40; // Tamaño en bytes de cada registro (ajústalo si es necesario)
        
        try (RandomAccessFile fichero = new RandomAccessFile(ruta, "r")) {
            System.out.println("Contenido del fichero binario de alumnos:");
            
            for (int i = 0; i < registros; i++) {
                // Mover el puntero a la posición del registro actual
                fichero.seek(i * tamañoRegistro);
                
                // Leer datos del archivo
                String apellido = fichero.readUTF();
                int edad = fichero.readInt();
                double nota = fichero.readDouble();
                
                System.out.println("Alumno " + (i + 1) + ": Apellido: " + apellido + ", Edad: " + edad + ", Nota: " + nota);
            }
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero binario de acceso aleatorio.");
            e.printStackTrace();
        }
    }
}
