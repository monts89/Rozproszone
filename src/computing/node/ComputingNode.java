package computing.node;

import java.rmi.Naming;
import computing.node.RemoteNodeInterfaceImpl;
import java.util.Random;

public class ComputingNode {
	public static void main(String[] args) throws Exception{
		RemoteNodeInterfaceImpl rMIDemoImpl = new RemoteNodeInterfaceImpl();
                int number = new Random().nextInt();
		Naming.rebind(String.format("ComputingNode%d", number), rMIDemoImpl);
		System.out.printf("Serwer obliczeniowy nr %d",number);

	}

}
