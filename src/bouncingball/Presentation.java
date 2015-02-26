package bouncingball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;

public class Presentation {

	private JFrame frame;
	private BallPit pit;

    private BallPanel panel = new BallPanel(pit);
	
	public Presentation() {
		frame = new JFrame("BallPit Client");
		frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        lookupPit("10.70.234.57");
	}

	public void lookupPit(String host){
	try {
			pit = (BallPit)Naming.lookup("rmi://"+host+":8081/BallRoom");
		} catch(MalformedURLException e){
			System.out.println("MalformedURLException");
			System.out.println(e);
		} catch(RemoteException re){
			System.out.println("RemoteException");
			System.out.println(re);
		} catch(NotBoundException nbe){
			System.out.println("NotBoundException");
			System.out.println(nbe);
		}
	}
	
	public static void main(String[] args){
		new Presentation().panel.animate();
	}
}