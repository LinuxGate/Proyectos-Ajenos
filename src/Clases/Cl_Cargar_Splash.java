/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JProgressBar;

/**
 *
 * @author CONTABILIDAD 02
 */
public class Cl_Cargar_Splash extends Thread {
    JProgressBar progreso;
    
    public Cl_Cargar_Splash (JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            progreso.setValue(i);
            pausa(20);
        }
    }
    
    public void pausa(int mlSeg) {
        try {
            Thread.sleep(mlSeg);
            } catch (Exception ex) {
            
            }
    }
}
