package computing.node;

import java.rmi.Naming;

public class ComputingNode2 {

	public static void main(String[] args) throws Exception{
		RemoteNodeInterfaceImpl rMIDemoImpl2 = new RemoteNodeInterfaceImpl();
		Naming.rebind("RMIDemo2", rMIDemoImpl2);
		System.out.println("Serwer 2 wystartowal ");

	}

}
