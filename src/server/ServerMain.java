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
    public static void main(String[] args) throws Exception {

        int answer = JOptionPane.showConfirmDialog(null,"Do you want to run as Node? No - run as serwer","Run form", JOptionPane.YES_NO_OPTION);
        
        if(answer == 1)
        {      
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
            // do testowania czy działa ( interacje przechodza ale wywala jakies rzeczy w NetBeansie )
            answer = JOptionPane.showConfirmDialog(null,"Would you like to run Node as well?","Node run", JOptionPane.YES_NO_OPTION);
            
        }
        
        
        if( answer == 0)
        {
            if( serverController != null)
            {
                ComputingNode.main(args);
            }
            else
               JOptionPane.showMessageDialog(null,"Error no serwer found","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
