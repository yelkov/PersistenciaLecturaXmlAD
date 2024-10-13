package edu.badpals.lectura;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class LectorSAX {
    private static final String RUTA_REPETIDORES = "src/main/resources/repetidores.xml";

    public static void leerXml(){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            InputStream inputStream = new FileInputStream(RUTA_REPETIDORES);
            Reader reader = new InputStreamReader(inputStream,"UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            DefaultHandler handler = new DefaultHandler(){
                public void startElement(String uri, String localName, String qName, Attributes attributes ){

                    if(qName.equalsIgnoreCase("alumnos")){
                        System.out.println("Elemento raíz: alumnos");
                    } else if (qName.equalsIgnoreCase("alumno")) {
                        System.out.println("\tAlumno: ");
                    }else{
                        System.out.println("\t\tElemento: " + qName);
                    }
                }
                public void characters(char ch[], int start, int length){
                    String contenido = new String(ch, start, length).trim();
                    if (!contenido.isEmpty()) {
                        System.out.println("\t\t\tcontenido: " + contenido);
                    }
                }
                public void endElement(String uri, String localName,String qName){
                    if(qName.equalsIgnoreCase("alumnos")){
                        System.out.println("Fin de elemento raíz: alumnos.");
                    } else if (qName.equalsIgnoreCase("alumno")) {
                        System.out.println("\tFin de alumno.");

                    }else{
                        System.out.println("\t\tFinaliza elemento: " + qName);
                    }

                }

            };


            System.out.println("\n===== Lector de xml usando SAX =====");
            saxParser.parse(is,handler);



        } catch (ParserConfigurationException e) {
            System.out.println("Error al leer xml con SAX.");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Error al leer xml con SAX.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer xml con SAX.");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
