package computing.node;

import computing.node.interfaces.RemoteNodeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ca.Area;
import computing.methodsinterfaces.IterationMethodI;
import java.util.ArrayList;

public class RemoteNodeInterfaceImpl extends UnicastRemoteObject implements RemoteNodeInterface {

    private static final long serialVersionUID = 1L;
    private IterationMethodI method = null;
    private static int iteration = 0;
    private String nodeName;
    
    protected RemoteNodeInterfaceImpl(IterationMethodI methodInterface, String nodeName) throws RemoteException {
        super();
        this.method = methodInterface;
        this.nodeName = nodeName;
    }

    @Override
    public Area computeIteration(Area area) throws RemoteException {
        this.method.nextIteration(area);
        System.out.printf("Iteration:%d \n", iteration++);
        return area;
    }
    
    public String getNodeName(){
        return nodeName;
    }
}
