/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ca.Area;
import ca.CellSpace;
import java.rmi.Naming;
import computing.node.interfaces.RemoteNodeInterface;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Andrewman
 */
//Klasa odzwierciedla póki co serwer.
public class ServerMain {

    private CellSpace cellSpace;
    private ArrayList<RemoteNodeInterface> currentNodesList = new ArrayList<RemoteNodeInterface>();

    public ServerMain(CellSpace space) {
        this.cellSpace = space;
    }
    //Wypisanie

    public void writeSpace() {
        for (int i = 0; i < cellSpace.getWidth(); i++) {
            for (int j = 0; j < cellSpace.getHeight(); j++) {
                for (int k = 0; k < 1; k++) {
                    System.out.print(cellSpace.getValue(i, j, k) + " ");
                }
            }
            System.out.println();
        }
    }

    public void test() {
        this.writeAreaToCellSpace(new Area(this.cellSpace, 3, 10));
    }

    // Zapis obszaru do głównej przestrzeni automatów
    public void writeAreaToCellSpace(Area area) {
        for (int i = 0; i < this.cellSpace.getWidth(); i++) {
            int ai = 1;
            for (int j = area.getStartHeight(); j < area.getEndHeight(); j++) {
                for (int k = 0; k < this.cellSpace.getDepth(); k++) {
                    this.cellSpace.setValue(i, j, k, area.getValue(i, ai, k));
                }
                ai++;
            }
        }
    }

    public boolean bindRemoteNodes() throws NotBoundException, MalformedURLException, RemoteException {

        currentNodesList.add((RemoteNodeInterface) Naming.lookup("rmi://localhost/ComputingNode"));
        currentNodesList.add((RemoteNodeInterface) Naming.lookup("rmi://localhost/ComputingNode2"));

        return true;
    }

    public void makeRemoteCall() throws RemoteException, NotBoundException, MalformedURLException {
        int i = 0;
        for (RemoteNodeInterface node : currentNodesList) {
            System.out.println(node.doCommunicate(String.format("Przeslany argument nr %d", i++)));
        }
    }
}