package computing.node.interfaces;
// komentarz 
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteNodeInterface extends Remote {

    public String doCommunicate(String name) throws RemoteException;
}
