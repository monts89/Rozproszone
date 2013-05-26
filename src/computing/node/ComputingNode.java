package computing.node;

import computing.methods.FeForwardMethod3D;
import java.rmi.Naming;
import computing.node.RemoteNodeInterfaceImpl;
import java.util.Random;

public class ComputingNode {
	public static void main(String[] args) throws Exception{
		RemoteNodeInterfaceImpl rMIDemoImpl = new RemoteNodeInterfaceImpl(new FeForwardMethod3D());
                int number = new Random().nextInt();
		Naming.rebind(String.format("ComputingNode%d", number), rMIDemoImpl);
		System.out.printf("Serwer obliczeniowy nr %d",number);
	}
}
