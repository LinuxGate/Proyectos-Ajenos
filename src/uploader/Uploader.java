/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploader;

import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author CONTABILIDAD 02
 */
public class Uploader {

    private static ServerSocket SERVER_SOCKET;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frm_loader loader = new frm_loader();
        try {
            SERVER_SOCKET = new ServerSocket(1334);
            loader.setVisible(true);
        } catch (IOException x) {
            System.out.print(x);
            System.out.println("Otra instancia de la aplicación se está ejecutando...");
            JOptionPane.showMessageDialog(null, "La Aplicacion ya se esta ejecutando.");
            System.exit(0);
        }
    }

}
