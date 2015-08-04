/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author pc
 */
public class Cl_Descargar_Instalador {

    public static void down(String zip) {

        String url = "http://www.lunasystemsperu.com/uploads_sm/" + zip + ".zip";
        String name = zip + ".zip";

        // datos basicos para una descarga
        String folder = "uploads/";

        // crea el directorio de destino en caso de que no exista
        File dir = new File(folder);

        if (!dir.exists()) {
            if (!dir.mkdir()) {
                return; // no se pudo crear la carpeta de destino
            }
        }
        // Crea el archivo destino
        File file = new File(folder + name);

        try {

            // establece la conexion con la url
            URLConnection conn = new URL(url).openConnection();
            conn.connect();

            System.out.println("\nempezando descarga: \n");
            System.out.println(">> URL: " + url);
            System.out.println(">> Nombre: " + name);
            System.out.println(">> tamaño: " + conn.getContentLength()
                    + " bytes");

            // Abre los streams
            InputStream in = conn.getInputStream();
            OutputStream out = new FileOutputStream(file);

            int b = 0;

            // este ciclo lee de a un byte por vez y los escribe en un archivo
            // el -1 significa que se llego al final
            while (b != -1) {
                b = in.read();

                if (b != -1) {
                    out.write(b);
                }
            }

            // Cierra los streams
            out.close();
            in.close();

            System.out.println("\ndescarga finalizada\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("la url: " + url + " no es valida!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
