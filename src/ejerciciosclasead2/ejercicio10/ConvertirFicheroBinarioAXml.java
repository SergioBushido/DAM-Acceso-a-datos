package ejerciciosclasead2.ejercicio10;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConvertirFicheroBinarioAXml {

    public static void convertirBinarioAXml(String rutaBinario, String rutaXml) {
        int registros = 7; // Número de registros en el fichero binario
        int tamañoRegistro = 40; // Tamaño en bytes de cada registro (ajustable si es necesario)

        try (RandomAccessFile fichero = new RandomAccessFile(rutaBinario, "r")) {
            // Crear el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            // Crear el elemento raíz <alumnos>
            Element root = documento.createElement("alumnos");
            documento.appendChild(root);

            for (int i = 0; i < registros; i++) {
                // Posicionar el puntero en el registro actual
                fichero.seek(i * tamañoRegistro);

                // Leer datos del fichero binario
                String apellido = fichero.readUTF();
                int edad = fichero.readInt();
                double nota = fichero.readDouble();

                // Crear el elemento <alumno>
                Element alumno = documento.createElement("alumno");
                
                // Crear y agregar el elemento <apellido>
                Element apellidoElem = documento.createElement("apellido");
                apellidoElem.appendChild(documento.createTextNode(apellido));
                alumno.appendChild(apellidoElem);

                // Crear y agregar el elemento <edad>
                Element edadElem = documento.createElement("edad");
                edadElem.appendChild(documento.createTextNode(String.valueOf(edad)));
                alumno.appendChild(edadElem);

                // Crear y agregar el elemento <nota>
                Element notaElem = documento.createElement("nota");
                notaElem.appendChild(documento.createTextNode(String.valueOf(nota)));
                alumno.appendChild(notaElem);

                // Agregar <alumno> a <alumnos>
                root.appendChild(alumno);
            }

            // Transformar el DOM a un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(rutaXml));
            transformer.transform(source, result);

            System.out.println("Fichero binario convertido exitosamente a XML en: " + rutaXml);

        } catch (IOException e) {
            System.out.println("Error al leer el fichero binario.");
            e.printStackTrace();
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Error al crear el fichero XML.");
            e.printStackTrace();
        }
    }
}
