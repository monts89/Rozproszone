package rozproszone;

import java.rmi.Naming;

public class RMIDemoServer2 {

	public static void main(String[] args) throws Exception{
		RMIDemoImpl rMIDemoImpl2 = new RMIDemoImpl();
		Naming.rebind("RMIDemo2", rMIDemoImpl2);
		System.out.println("Serwer 2 wystartowal ");

	}

}
