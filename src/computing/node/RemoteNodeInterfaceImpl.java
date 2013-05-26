package computing.node;

import computing.node.interfaces.RemoteNodeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ca.Area;
import computing.methodsinterfaces.IterationMethodI;

public class RemoteNodeInterfaceImpl extends UnicastRemoteObject implements RemoteNodeInterface {

    private static final long serialVersionUID = 1L;
    private String host = "";
    private IterationMethodI method = null;

    protected RemoteNodeInterfaceImpl(IterationMethodI methodInterface) throws RemoteException {
        super();
        this.method = methodInterface;
    }

    @Override
    public Area computeIteration(Area area) throws RemoteException {
        for (int i = 0; i < area.getRealWidth(); i++) {
            for (int j = 0; j < area.getRealHeight(); j++) {
                for (int k = 0; k < area.getRealDepht(); k++) {
                    area.setValue(i, j, k, area.getValue(i, j, k) + 1.0);
                }
            }
        }
        this.method.nextIteration(area);
        return area;
    }

    @Override
    public String getHost() {
        return host;
    }
}
