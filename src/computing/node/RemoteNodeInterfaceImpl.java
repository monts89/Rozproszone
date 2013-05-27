package computing.node;

import computing.node.interfaces.RemoteNodeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ca.Area;
import computing.methodsinterfaces.IterationMethodI;

public class RemoteNodeInterfaceImpl extends UnicastRemoteObject implements RemoteNodeInterface {

    private static final long serialVersionUID = 1L;
    private IterationMethodI method = null;
    private static int iteration = 0;
    
    protected RemoteNodeInterfaceImpl(IterationMethodI methodInterface) throws RemoteException {
        super();
        this.method = methodInterface;
    }

    @Override
    public Area computeIteration(Area area) throws RemoteException {
        this.method.nextIteration(area);
        System.out.printf("Iteration:%d \n", iteration++);
        return area;
    }
}
