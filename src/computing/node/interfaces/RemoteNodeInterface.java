package computing.node.interfaces;
// komentarz 
import java.rmi.Remote;
import java.rmi.RemoteException;
import ca.Area;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface RemoteNodeInterface extends Remote {

    public Area computeIteration(Area area, Map hm) throws RemoteException;
    public String getNodeName() throws RemoteException;
    public Map get_local_map() throws RemoteException;
}
