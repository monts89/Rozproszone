package computing.node.interfaces;
// komentarz 
import java.rmi.Remote;
import java.rmi.RemoteException;
import ca.Area;

public interface RemoteNodeInterface extends Remote {

    public Area doCommunicate(Area area) throws RemoteException;
}
