/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import ca.Area;
import ca.CellSpace;
import java.rmi.Naming;
import rozproszone.RMIDemo;

/**
 *
 * @author Andrewman
 */

//Klasa odzwierciedla póki co serwer.
public class ServerMain {

    private CellSpace cellSpace;

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
    
    public void makeRemoteCall(String args[]) throws Exception
    {
        if(args.length==3){
             String url = new String("rmi://"+args[0]+"/RMIDemo");
             String url2 = new String("rmi://"+args[0]+"/RMIDemo2");
             
             RMIDemo rMIDemo = (RMIDemo)Naming.lookup(url);
             RMIDemo rMIDemo2 = (RMIDemo)Naming.lookup(url2);
                        
             String serverReply = rMIDemo.doCommunicate(args[1]);
             String serverReply2 = rMIDemo2.doCommunicate(args[2]);
             
                      
             System.out.println("Server reply to the ServerMain: "+serverReply);
             System.out.println("Server2 reply to the ServerMain: "+serverReply2);
        }else{
	
            System.err.println("Usage: RMIDemoClient <server> <name>");
			
	}
    
    }
    
}