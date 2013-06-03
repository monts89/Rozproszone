package computing.node;

import computing.methods.FeForwardMethod3D;
import java.rmi.Naming;
import computing.node.RemoteNodeInterfaceImpl;
import java.util.Random;
import server.visualization.NodeWindow;


public class ComputingNode {

    public static void main(String[] args) throws Exception {
        int number = new Random().nextInt();
        
        final NodeWindow window = new NodeWindow();
        window.getjLabel1().setText("Serwer obliczeniowy nr " + number);
        
        RemoteNodeInterfaceImpl rMIDemoImpl = 
                new RemoteNodeInterfaceImpl(new FeForwardMethod3D(), String.format("ComputingNode%d", number), window);
                // do testow Rule_30()
                //new RemoteNodeInterfaceImpl(new Rule_30(), String.format("ComputingNode%d", number));
                
        Naming.rebind(rMIDemoImpl.getNodeName(), rMIDemoImpl);
        System.out.printf("Serwer obliczeniowy nr %d \n", number);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                window.setVisible(true);
            }
        });
    }
}
