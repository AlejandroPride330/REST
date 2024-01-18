package UTILS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alex
 */
public class FicherosXML {

    public FicherosXML() {

    }

    public static HashMap<String, String> leerXML() {
        HashMap<String, String> mapita = new HashMap<String, String>();
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("./conf/user.xml"));
            Element root = doc.getDocumentElement();
            NodeList user = root.getElementsByTagName("user");

            for (int i = 0; i < user.getLength(); i++) {
                Element name = (Element) user.item(i);
                String nombre = name.getElementsByTagName("name").item(0).getTextContent();
                mapita.put("name", nombre);

                Element rol = (Element) user.item(i);
                String rol1 = rol.getElementsByTagName("rol").item(0).getTextContent();
                mapita.put("rol", rol1);

                 Element yearBirth = (Element) user.item(i);
                String año = rol.getElementsByTagName("yearBirth").item(0).getTextContent();
                mapita.put("yearBirth", año);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapita;

    }

    public static void saveXML(HashMap<String, String> mapa, String extension) {
        File f = new File("./conf/propiedades.xml");
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        try {
            XMLStreamWriter xmlWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(f));
            xmlWriter.writeStartDocument();
            System.out.println("El archivo xml se creo satisfactoriamente " + f);

            xmlWriter.writeStartElement("config");//recuerda meter un elemento antes de nada y cerrarlo despues si no el xml no lo valida.
            for (Map.Entry<String, String> entry : mapa.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                xmlWriter.writeStartElement(entry.getKey());
                xmlWriter.writeCharacters(entry.getValue());
                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();
            xmlWriter.writeEndDocument();

        } catch (IOException | XMLStreamException e) {
            System.err.println(e);
        }
    }

}
