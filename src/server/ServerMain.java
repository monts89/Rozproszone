/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ca.CellSpace;
import computing.node.ComputingNode;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.ServerController;
import server.visualization.MyWindow;
import server.visualization.SelectModeWindow;

/**
 *
 * @author Lukasz
 */
public class ServerMain {

    //private static MyWindow window = new MyWindow();
    private static SelectModeWindow window = new SelectModeWindow();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                window.setVisible(true);
            }
        });  
    }
}
