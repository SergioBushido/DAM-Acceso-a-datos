package ejerciciosclasead2.ejercicio7;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerFicheroBinario {

    public static void leerFicheroBinario(String ruta) {
        try (DataInputStream entrada = new DataInputStream(new FileInputStream(ruta))) {
            System.out.println("Contenido del fichero binario:");
            
            while (entrada.available() > 0) { // Leer mientras haya datos disponibles
                String departamento = entrada.readUTF();  // Leer nombre del departamento
                int numeroEmpleados = entrada.readInt();  // Leer número de empleados
                System.out.println("Departamento: " + departamento + ", Número de Empleados: " + numeroEmpleados);
            }
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero binario.");
            e.printStackTrace();
        }
    }
}
