package computing.node;

import computing.node.interfaces.RemoteNodeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteNodeInterfaceImpl extends UnicastRemoteObject implements RemoteNodeInterface {

	private static final long serialVersionUID = 1L;

	protected RemoteNodeInterfaceImpl() throws RemoteException {
		super();
		
	}

	@Override
	public String doCommunicate(String name) throws RemoteException {
		
		return "\nServer says: Hi "+name+"\n";
	}

}
