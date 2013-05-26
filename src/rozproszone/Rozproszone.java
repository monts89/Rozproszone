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

/**
 *
 * @author Lukasz
 */
public class Rozproszone {

    //TODO MS: Podział na program kliencki i serwerowy
    public static void main(String[] args) {
        ServerMain main = new ServerMain(new CellSpace(10, 10, 1));
        try {
            LocateRegistry.createRegistry(1099);
            main.bindRemoteNodes("localhost");
            
            for(int i=0; i<5; i++){
                main.makeRemoteCall();
            }
            
            main.writeSpace();
        } catch (Exception ex) {
            System.out.println("Prawdopodobnie jeden z wezlow jest wylaczony " + ex.getMessage());
        }
    }
}
