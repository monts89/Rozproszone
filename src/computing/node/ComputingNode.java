package computing.node;

import java.rmi.Naming;
import computing.node.RemoteNodeInterfaceImpl;

public class ComputingNode {
	public static void main(String[] args) throws Exception{
		RemoteNodeInterfaceImpl rMIDemoImpl = new RemoteNodeInterfaceImpl();
		Naming.rebind("RMIDemo", rMIDemoImpl);
		System.out.println("RMIDemo object bound to the name 'RMIDemo' and is ready for use... ");

	}

}
