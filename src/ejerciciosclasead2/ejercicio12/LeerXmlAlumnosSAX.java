package ejerciciosclasead2.ejercicio12;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class LeerXmlAlumnosSAX {

    public static void leerXmlAlumnosSAX(String rutaXml) {
        try {
            // Configurar el parser SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Definir el handler para procesar los eventos SAX
            DefaultHandler handler = new DefaultHandler() {
                boolean apellido = false;
                boolean edad = false;
                boolean nota = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("alumno")) {
                        System.out.println("Alumno:");
                    } else if (qName.equalsIgnoreCase("apellido")) {
                        apellido = true;
                    } else if (qName.equalsIgnoreCase("edad")) {
                        edad = true;
                    } else if (qName.equalsIgnoreCase("nota")) {
                        nota = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (apellido) {
                        System.out.println("  Apellido: " + new String(ch, start, length));
                        apellido = false;
                    } else if (edad) {
                        System.out.println("  Edad: " + new String(ch, start, length));
                        edad = false;
                    } else if (nota) {
                        System.out.println("  Nota: " + new String(ch, start, length));
                        nota = false;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("alumno")) {
                        System.out.println();
                    }
                }
            };

            // Leer el archivo XML usando el handler
            saxParser.parse(new File(rutaXml), handler);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al leer el archivo XML usando SAX.");
            e.printStackTrace();
        }
    }
}
