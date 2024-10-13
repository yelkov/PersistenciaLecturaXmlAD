package edu.badpals.lectura;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LectorDOM {
    private static final String RUTA_REPETIDORES = "src/main/resources/repetidores.xml";

    public static void leerXml(){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.parse(new File(RUTA_REPETIDORES));
            doc.getDocumentElement().normalize();

            System.out.println("\n===== Lector de xml usando DOM =====");

            Element raiz = doc.getDocumentElement();
            NodeList nodosAlumnos = raiz.getChildNodes();

            for(int i = 0; i < nodosAlumnos.getLength(); i++){
                Node nodoAlumno = nodosAlumnos.item(i);
                if (nodoAlumno.getNodeType() == Node.ELEMENT_NODE){
                    Element alumno = (Element) nodoAlumno;
                    System.out.println("\nAlumno :");

                    NodeList hijosAlumno = alumno.getChildNodes();
                    for(int j = 0; j < hijosAlumno.getLength(); j++){
                        Node nodoHijo = hijosAlumno.item(j);
                        if(nodoHijo.getNodeType() == Node.ELEMENT_NODE){
                            Element hijo = (Element) nodoHijo;
                            System.out.println("\tEtiqueta: "+hijo.getNodeName());
                            System.out.println("\t\ttexto: "+ hijo.getTextContent());
                        }
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            System.out.println("Error al leer xml con DOM.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
