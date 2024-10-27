package ejerciciosclasead2.ejercicio6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFicheroBinario {

    public static void escribirFicheroBinario(String ruta) {
        String[] departamentos = {"Contabilidad", "Informática", "Dirección", "Análisis", "Finanzas", "Hardware"};
        int[] numeroEmpleados = {3, 10, 2, 5, 4, 8};

        try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(ruta))) {
            for (int i = 0; i < departamentos.length; i++) {
                salida.writeUTF(departamentos[i]); // Escribir el nombre del departamento como texto
                salida.writeInt(numeroEmpleados[i]); // Escribir el número de empleados como entero
            }
            System.out.println("Datos escritos exitosamente en el fichero binario: " + ruta);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero binario.");
            e.printStackTrace();
        }
    }
}
