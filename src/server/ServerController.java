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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrewman
 */
//Klasa odzwierciedla póki co serwer.
public class ServerController {

    private CellSpace cellSpace;
    private ArrayList<RemoteNodeInterface> currentNodesList = new ArrayList<RemoteNodeInterface>();
    private ArrayList<String> hostNames = new ArrayList<String>();
    private Map<String, Double> hm = new HashMap<String, Double>();
    
    public ServerController(CellSpace space) {
        this.cellSpace = space;
    }

    public ArrayList<RemoteNodeInterface> getCurrentNodesList() {
        return currentNodesList;
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

    public boolean bindRemoteNodes() {
        currentNodesList.clear();
        for (String host : hostNames) {

            try {
                String[] names = Naming.list(String.format("rmi://%s:1099", host));
                for (String name : names) {
                    currentNodesList.add((RemoteNodeInterface) Naming.lookup(name));
                }
            } catch (RemoteException remoteException) {
            } catch (MalformedURLException malformedURLException) {
            } catch (NotBoundException notBoundException) {
            }

        }
        return true;
    }

    public void clearCurrentNodes() {
        currentNodesList.clear();
    }

    public ArrayList<String> getNodesNames() {
        ArrayList<String> names = new ArrayList<String>();

        try {
            for (RemoteNodeInterface node : currentNodesList) {
                names.add(node.getNodeName());
            }
        } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        }
        return names;
    }

    public ArrayList<String> getHostsNames() {
        return hostNames;
    }

    public void addHost(String address) {
        if (!hostNames.contains(address)) {
            hostNames.add(address);
        }
    }

    public boolean makeRemoteCall() {

        ArrayList<Area> areas = new ArrayList<Area>();

        int i = 0;
        int nodesCount = currentNodesList.size();
        int spaceHeight = this.cellSpace.getHeight();
        int part = spaceHeight / nodesCount;
        final ArrayList<Area> tmpAreas = areas;
        
        ArrayList node_name = getNodesNames();
        Boolean add = true;
        if( node_name.size() != hm.size())
        {
            for(int e=0;e<node_name.size();e++)
            {
                for(int f=0;f<hm.size();f++)
                {
                    if(hm.containsKey(node_name.get(e)))
                    {
                        add = false;
                        break;
                    }
                    else
                    {
                        add = true;
                    }     
                }
                if( add == true)
                    hm.put((String)node_name.get(e), 0.0);
            }
            
        }
        
        final Map<String, Double> temp_map = hm;
        

        
        
        try {

            for (RemoteNodeInterface node : currentNodesList) {

                final RemoteNodeInterface tmpNode = node;
                final CellSpace tmpCellSpace = cellSpace;
                final int tmpPart = part;
                final int tmpI = i;
                final int tmpNodesCount = nodesCount;
                final int tmpSpaceHeight = spaceHeight;
                ArrayList<Thread> threadsList = new ArrayList<Thread>();

                //   if (i != nodesCount - 1) {
                threadsList.add(new Thread(new Runnable() {  
                
                
                    @Override
                    public void run() {
                        try {
                            if (tmpI != tmpNodesCount - 1) {
                                tmpAreas.add((Area) tmpNode.computeIteration(new Area(tmpCellSpace, tmpPart * tmpI, (tmpPart * (tmpI + 1))), temp_map ));
                                //tmpNode.get_local_map();
                                hm.put(tmpNode.getNodeName(), (double)tmpNode.get_local_map().get(tmpNode.getNodeName()));     
                            } else {
                                tmpAreas.add((Area) tmpNode.computeIteration(new Area(tmpCellSpace, tmpPart * tmpI, tmpSpaceHeight), temp_map ));
                                hm.put(tmpNode.getNodeName(), (double)tmpNode.get_local_map().get(tmpNode.getNodeName()));
                            }

                            //  tmpAreas.add((Area) tmpNode.computeIteration(new Area(tmpCellSpace, tmpPart * tmpI, (tmpPart * (tmpI + 1)))));
                        } catch (RemoteException ex) {
                            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }));
                //areas.add((Area) node.computeIteration(new Area(this.cellSpace, part * i, (part * (i + 1)))));
                for (Thread thread : threadsList) {
                    thread.start();

                }

                for (Thread thread : threadsList) {
                    thread.join();
                }

//                } else {
//                    areas.add((Area) node.computeIteration(new Area(this., part * i, spaceHeight)));
//                 
//                }
                i++;
            }

        } catch (Exception remoteException) {
            remoteException.printStackTrace();
            return false;
        }


        for (Area area : tmpAreas) {
            
            writeAreaToCellSpace(area);
        }




        return true;
    }
}