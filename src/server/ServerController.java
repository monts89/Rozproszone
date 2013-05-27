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
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

/**
 *
 * @author Andrewman
 */
//Klasa odzwierciedla póki co serwer.
public class ServerController {

    private CellSpace cellSpace;
    private ArrayList<RemoteNodeInterface> currentNodesList = new ArrayList<RemoteNodeInterface>();

    public ServerController(CellSpace space) {
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

    public boolean createRmiRegistry() throws RemoteException {
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException ex) {
            ex.getStackTrace();
            return false;
        }
        return true;
    }

    public boolean bindRemoteNodes(String host) throws NotBoundException, MalformedURLException, RemoteException {
        String[] names = Naming.list(String.format("rmi://%s:1099", host));
        for (String name : names) {
            currentNodesList.add((RemoteNodeInterface) Naming.lookup(name));
        }
        return true;
    }

    public void makeRemoteCall() throws RemoteException, NotBoundException, MalformedURLException {
        ArrayList<Area> areas = new ArrayList<Area>();
        int i = 0;
        int nodesCount = currentNodesList.size();
        int spaceHeight = this.cellSpace.getHeight();
        int part = spaceHeight / nodesCount;

        for (RemoteNodeInterface node : currentNodesList) {
            if (i != nodesCount - 1) {
                areas.add((Area) node.computeIteration(new Area(this.cellSpace, part * i, (part * (i + 1)))));
            } else {
                areas.add((Area) node.computeIteration(new Area(this.cellSpace, part * i, spaceHeight)));
            }
            i++;
        }

        for (Area area : areas) {
            writeAreaToCellSpace(area);
        }
    }
}