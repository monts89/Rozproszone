package computing.node;

import computing.methods.FeForwardMethod3D;
import computing.methods.Rule_30;
import java.rmi.Naming;
import computing.node.RemoteNodeInterfaceImpl;
import java.util.Random;


public class ComputingNode {

    public static void main(String[] args) throws Exception {
        int number = new Random().nextInt();
        RemoteNodeInterfaceImpl rMIDemoImpl = 
                new RemoteNodeInterfaceImpl(new FeForwardMethod3D(), String.format("ComputingNode%d", number));
                // do testow Rule_30()
                //new RemoteNodeInterfaceImpl(new Rule_30(), String.format("ComputingNode%d", number));
                
        Naming.rebind(rMIDemoImpl.getNodeName(), rMIDemoImpl);
        System.out.printf("Serwer obliczeniowy nr %d \n", number);
    }
}
