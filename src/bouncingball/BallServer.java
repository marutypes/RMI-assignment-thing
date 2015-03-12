package bouncingball;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BallServer {
	
	public static void main(String[] args) {
		try{
		      BallRoom  b = new BallRoom();
		      
		      // This server runs the registry on port 8080
		      LocateRegistry.createRegistry(8081);
		      System.out.println( "Registry created" );
		      
		      // A client will need to look up the calculator remote object at this machine's
		      // address, using the service name "CalculatorService"
		      Naming.rebind("rmi://localhost:8081/BallRoom", b);
		      
		      b.start();
		      
		} catch (Exception e) {
			System.out.println("Danger Bart Simpson: " + e);
		}
	}
	
}
