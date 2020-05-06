/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto.de.venta;

import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Jospam
 */
public class PuntoDeVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventas ventas = new Ventas();
        //ventas.pack();
        //ventas.setLocationRelativeTo(null);
        ventas.setExtendedState(ventas.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        //ventas.setUndecorated(true);
        ventas.setVisible(true);
        
    }

}
