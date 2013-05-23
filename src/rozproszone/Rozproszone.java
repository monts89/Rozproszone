/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rozproszone;

import ca.CellSpace;
import server.ServerMain;

/**
 *
 * @author Lukasz
 */
public class Rozproszone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerMain main = new ServerMain(new CellSpace(10, 10, 1));

        main.writeSpace();

    }
}
