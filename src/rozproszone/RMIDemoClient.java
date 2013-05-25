package rozproszone;

import java.rmi.Naming;

public class RMIDemoClient {

	public static void main(String[] args) throws Exception {
		if(args.length==3){
			String url = new String("rmi://"+args[0]+"/RMIDemo");
                        String url2 = new String("rmi://"+args[0]+"/RMIDemo2");
                          
                        
			RMIDemo rMIDemo = (RMIDemo)Naming.lookup(url);
                        RMIDemo rMIDemo2 = (RMIDemo)Naming.lookup(url2);
                        
			String serverReply = rMIDemo.doCommunicate(args[1]);
                        String serverReply2 = rMIDemo2.doCommunicate(args[2]);
                         
			System.out.println("Server reply: "+serverReply);
                        System.out.println("Server2 reply: "+serverReply2);
		}else{
			System.err.println("Usage: RMIDemoClient <server> <name>");
			
		}

	}

}
