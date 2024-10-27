package ejerciciosclasead2;

import ejerciciosclasead2.ejercicio1.InformacionFichero;
import ejerciciosclasead2.ejercicio2.ListadoDirectorios;
import ejerciciosclasead2.ejercicio3.CrearDirectorio;
import ejerciciosclasead2.ejercicio4.CrearFicheroTexto;
import ejerciciosclasead2.ejercicio5.VisualizarFicheroTexto;
import ejerciciosclasead2.ejercicio6.EscribirFicheroBinario;
import ejerciciosclasead2.ejercicio7.LeerFicheroBinario;
import ejerciciosclasead2.ejercicio8.EscribirFicheroBinarioAleatorio;
import ejerciciosclasead2.ejercicio9.LeerFicheroBinarioAleatorio;
import ejerciciosclasead2.ejercicio10.ConvertirFicheroBinarioAXml;
import ejerciciosclasead2.ejercicio11.LeerXmlAlumnos;
import ejerciciosclasead2.ejercicio12.LeerXmlAlumnosSAX;
import java.util.Scanner;

public class EjerciciosClaseAD2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Seleccione el ejercicio a ejecutar:");
        System.out.println("1. Mostrar información de un archivo o directorio.");
        System.out.println("2. Listar todos los ficheros y subdirectorios de un directorio.");
        System.out.println("3. Crear un directorio vacío en la ruta especificada.");
        System.out.println("4. Crear un fichero de texto con contenido secuencial.");
        System.out.println("5. Visualizar el contenido de un fichero de texto.");
        System.out.println("6. Escribir un fichero binario con información de empleados.");
        System.out.println("7. Leer y mostrar el contenido de un fichero binario.");
        System.out.println("8. Escribir un fichero binario de alumnos con acceso aleatorio.");
        System.out.println("9. Leer y mostrar el contenido de un fichero binario de alumnos de acceso aleatorio.");
        System.out.println("10. Convertir el fichero binario de alumnos a XML.");
        System.out.println("11. Visualizar el fichero XML de alumnos usando DOM.");
        System.out.println("12. Visualizar el fichero XML de alumnos usando SAX.");
        System.out.print("Opción: ");
        
        int opcion = -1;
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume el salto de línea
        } else {
            System.out.println("Error: Debes ingresar un número para seleccionar la opción.");
            scanner.close();
            return;
        }

        switch (opcion) {
            case 1:
                System.out.print("Introduce la ruta del archivo o directorio: ");
                String ruta1 = scanner.nextLine();
                InformacionFichero.mostrarInformacionFichero(ruta1);
                break;
            case 2:
                System.out.print("Introduce la ruta del directorio: ");
                String ruta2 = scanner.nextLine();
                ListadoDirectorios.listarContenidoDirectorio(ruta2);
                break;
            case 3:
                System.out.print("Introduce la ruta donde deseas crear el directorio: ");
                String ruta3 = scanner.nextLine();
                CrearDirectorio.crearDirectorio(ruta3);
                break;
            case 4:
                System.out.print("Introduce la ruta donde deseas crear el fichero de texto: ");
                String ruta4 = scanner.nextLine();
                CrearFicheroTexto.crearFicheroTexto(ruta4);
                break;
            case 5:
                System.out.print("Introduce la ruta del fichero que deseas visualizar: ");
                String ruta5 = scanner.nextLine();
                VisualizarFicheroTexto.visualizarFichero(ruta5);
                break;
            case 6:
                System.out.print("Introduce la ruta donde deseas crear el fichero binario (ej: Empleados.dat): ");
                String ruta6 = scanner.nextLine();
                EscribirFicheroBinario.escribirFicheroBinario(ruta6);
                break;
            case 7:
                System.out.print("Introduce la ruta del fichero binario de empleados que deseas leer: ");
                String ruta7 = scanner.nextLine();
                LeerFicheroBinario.leerFicheroBinario(ruta7);
                break;
            case 8:
                System.out.print("Introduce la ruta donde deseas crear el fichero binario de alumnos (ej: Alumnos.dat): ");
                String ruta8 = scanner.nextLine();
                EscribirFicheroBinarioAleatorio.escribirFicheroBinarioAleatorio(ruta8);
                break;
            case 9:
                System.out.print("Introduce la ruta del fichero binario de alumnos que deseas leer: ");
                String ruta9 = scanner.nextLine();
                LeerFicheroBinarioAleatorio.leerFicheroBinarioAleatorio(ruta9);
                break;
            case 10:
                System.out.print("Introduce la ruta del fichero binario de alumnos: ");
                String rutaBinario = scanner.nextLine();
                System.out.print("Introduce la ruta del fichero XML de salida: ");
                String rutaXml = scanner.nextLine();
                ConvertirFicheroBinarioAXml.convertirBinarioAXml(rutaBinario, rutaXml);
                break;
            case 11:
                System.out.print("Introduce la ruta del fichero XML de alumnos que deseas leer con DOM: ");
                String rutaXmlAlumnosDOM = scanner.nextLine();
                LeerXmlAlumnos.leerXmlAlumnos(rutaXmlAlumnosDOM);
                break;
            case 12:
                System.out.print("Introduce la ruta del fichero XML de alumnos que deseas leer con SAX: ");
                String rutaXmlAlumnosSAX = scanner.nextLine();
                LeerXmlAlumnosSAX.leerXmlAlumnosSAX(rutaXmlAlumnosSAX);
                break;
            default:
                System.out.println("Opción no válida.");
        }
        
        scanner.close();
    }
}
