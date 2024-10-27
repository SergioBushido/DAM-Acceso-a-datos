package ejerciciosclasead2.ejercicio11;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeerXmlAlumnos {

    public static void leerXmlAlumnos(String rutaXml) {
        try {
            // Configurar y parsear el documento XML
            File archivoXml = new File(rutaXml);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(archivoXml);
            documento.getDocumentElement().normalize();

            System.out.println("Lectura del archivo XML: " + rutaXml);
            System.out.println("Lista de Alumnos:");

            // Obtener todos los elementos <alumno>
            NodeList listaAlumnos = documento.getElementsByTagName("alumno");

            for (int i = 0; i < listaAlumnos.getLength(); i++) {
                Node nodoAlumno = listaAlumnos.item(i);

                if (nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoAlumno = (Element) nodoAlumno;

                    // Extraer los datos de cada alumno
                    String apellido = elementoAlumno.getElementsByTagName("apellido").item(0).getTextContent();
                    String edad = elementoAlumno.getElementsByTagName("edad").item(0).getTextContent();
                    String nota = elementoAlumno.getElementsByTagName("nota").item(0).getTextContent();

                    System.out.println("Alumno " + (i + 1) + ":");
                    System.out.println("  Apellido: " + apellido);
                    System.out.println("  Edad: " + edad);
                    System.out.println("  Nota: " + nota);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al leer el archivo XML.");
            e.printStackTrace();
        }
    }
}
