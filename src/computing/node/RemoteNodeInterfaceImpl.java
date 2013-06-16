package computing.node;

import computing.node.interfaces.RemoteNodeInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ca.Area;
import com.sun.java.swing.plaf.windows.resources.windows;
import computing.methodsinterfaces.IterationMethodI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import server.visualization.NodeWindow;

public class RemoteNodeInterfaceImpl extends UnicastRemoteObject implements RemoteNodeInterface {

    private static final long serialVersionUID = 1L;
    private IterationMethodI method = null;
    private static int iteration = 0;
    private String nodeName;
    private NodeWindow window;
    private Map<String, Double> local_map = new HashMap<String, Double>();
    
    protected RemoteNodeInterfaceImpl(IterationMethodI methodInterface, String nodeName, NodeWindow window) throws RemoteException {
        super();
        this.method = methodInterface;
        this.nodeName = nodeName;
        this.window = window;
    }

    @Override
    public Area computeIteration(Area area,Map hm) throws RemoteException {
        this.method.nextIteration(area);
        System.out.printf("Przeslany x:%d \n", hm.size());
        System.out.printf("Iteration:%d \n", iteration++);
        window.getjLabel2().setText("Iteration: "+iteration);
        local_map = hm;
        local_map.put(nodeName, local_map.get(nodeName)+1);
        //window.getjLabel2().setText("Rozmiar " + hm.size() + " " + this.getNodeName());
        return area;
    }
    @Override
    public String getNodeName(){
        return nodeName;
    }
    
    @Override
    public Map get_local_map(){
        return local_map;
    }
}
