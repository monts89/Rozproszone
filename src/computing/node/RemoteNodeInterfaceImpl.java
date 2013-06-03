package computing.node;

import computing.node.interfaces.RemoteNodeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ca.Area;
import com.sun.java.swing.plaf.windows.resources.windows;
import computing.methodsinterfaces.IterationMethodI;
import java.util.ArrayList;
import server.visualization.NodeWindow;

public class RemoteNodeInterfaceImpl extends UnicastRemoteObject implements RemoteNodeInterface {

    private static final long serialVersionUID = 1L;
    private IterationMethodI method = null;
    private static int iteration = 0;
    private String nodeName;
    private NodeWindow window;
    
    protected RemoteNodeInterfaceImpl(IterationMethodI methodInterface, String nodeName, NodeWindow window) throws RemoteException {
        super();
        this.method = methodInterface;
        this.nodeName = nodeName;
        this.window = window;
    }

    @Override
    public Area computeIteration(Area area) throws RemoteException {
        this.method.nextIteration(area);
        System.out.printf("Iteration:%d \n", iteration++);
        window.getjLabel2().setText("Iteration: "+iteration++);
        return area;
    }
    
    public String getNodeName(){
        return nodeName;
    }
}
