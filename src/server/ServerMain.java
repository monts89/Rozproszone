/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ca.CellSpace;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ServerController;
import server.visualization.MyWindow;

/**
 *
 * @author Lukasz
 */
public class ServerMain {

    private static MyWindow window = new MyWindow();
    private static ServerController serverController;
    private static SimulationController simulationController;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                window.setVisible(true);
            }
        });

        CellSpace newSpace = new CellSpace(100, 100, 100);

        simulationController = new SimulationController(newSpace, 100, 0);
        simulationController.init(SimulationController.PREDEFINED_CONDITIONS.Ball);
        serverController = new ServerController(newSpace);
        window.setSimulationController(simulationController);
        window.setServerController(serverController);

        try {
            serverController.createRmiRegistry();
        } catch (RemoteException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
