package UTILS;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class FicherosJSON {
      public FicherosJSON() {
    }

    public static HashMap<String, String> leerJSON() {
        JSONParser parser = new JSONParser();
        HashMap<String, String> mapita = new HashMap<String, String>();
        try {
            Object obj = parser.parse(new FileReader("./conf/config.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject loggingConf = (JSONObject) jsonObject.get("logging");
            for (Object element : loggingConf.keySet()) {
              
                String elemento = (String) loggingConf.get((String)element);
                mapita.put((String) element, elemento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapita;
    }
    public static void saveJSON(HashMap<String, String> mapa, String extension){
        if (extension.equals("json")) {
           File f = new File("./conf/propiedades.json");
            JSONObject jsonObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : mapa.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    jsonObject.put(key, value);
                }
                FileWriter fileWriter = new FileWriter(f);
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.close();
                System.out.println(" Archivo JSON generado en " + f);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("No introdujiste una extension correcta.");
        }
    }
    
}
