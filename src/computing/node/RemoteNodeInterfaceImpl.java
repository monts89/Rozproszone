package computing.node;

import computing.node.interfaces.RemoteNodeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ca.Area;
import java.util.Random;

public class RemoteNodeInterfaceImpl extends UnicastRemoteObject implements RemoteNodeInterface {

	private static final long serialVersionUID = 1L;

	protected RemoteNodeInterfaceImpl() throws RemoteException {
		super();
		
	}

	@Override
	public Area doCommunicate(Area area) throws RemoteException {
		double d = new Random().nextDouble();
		for(int i=0; i<area.getRealWidth(); i++){
                    for(int j=0; j<area.getRealHeight(); j++){
                        for(int k=0; k<area.getRealDepht(); k++){
                            area.setValue(i, j, k, d);
                        }
                    }
                }
                
            return area;
	}

}
