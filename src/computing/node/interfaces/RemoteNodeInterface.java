package computing.node.interfaces;
// komentarz 
import java.rmi.Remote;
import java.rmi.RemoteException;
import ca.Area;
import java.util.ArrayList;

public interface RemoteNodeInterface extends Remote {

    public Area computeIteration(Area area) throws RemoteException;
    public String getNodeName() throws RemoteException;
}
