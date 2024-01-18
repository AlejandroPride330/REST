/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTILS;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Utils {
    public Utils()throws IOException{
    File f = new File("conf");

        if (!f.isDirectory() || !f.exists()) {
        try {
            throw new IOException("Debe existir el directorio");
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        } else {
            File[] files = f.listFiles();
            for (File file : files) {
                //System.out.println(file);
                if (getFileExtension(file).equals("json")) {
                    FicherosJSON ljson = new FicherosJSON();
                    
                } else if (getFileExtension(file).equals("xml")) {
                    FicherosXML lxml = new FicherosXML();
                    
                } else {
                    System.out.println("Excluyendo el fichero " + file.getName());
                }
            }
                
        }
    
}
  private String getFileExtension(File file) {
        String[] fname = file.getName().split("\\.");
        return fname[fname.length - 1];

    }   
    

 
    
}
