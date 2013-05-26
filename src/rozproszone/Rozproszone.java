/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rozproszone;

import ca.CellSpace;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ServerMain;
import visualization.MyWindow;

/**
 *
 * @author Lukasz
 */
public class Rozproszone {
    private static MyWindow window = new MyWindow();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerMain main = new ServerMain(new CellSpace(10, 10, 1));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                window.setVisible(true);
            }
        });
        
        //Tests/////////////////////////////////////////////////////
        CellSpace newSpace = new CellSpace(100, 100, 100);
        newSpace.setValue(30, 30, 0, 100);
        newSpace.setValue(50, 50, 0, 100);
        newSpace.setValue(20, 40, 0, 100);
        newSpace.setValue(90, 70, 0, 100);
        
        newSpace.setValue(90, 30, 1, 1);
        newSpace.setValue(90, 50, 1, 1);
        newSpace.setValue(90, 40, 1, 1);
        newSpace.setValue(90, 70, 1, 1);
        
        window.setCellSpace(newSpace);
        /////////////////////////////////////
        
        main.writeSpace();
        try {
            LocateRegistry.createRegistry(1099);
            main.bindRemoteNodes();
            main.makeRemoteCall();
            main.writeSpace();
        } catch (Exception ex) {
            System.out.println("Prawdopodobnie jeden z wezlow jest wylaczony " + ex.getMessage());
        }
    }
}
