package bouncingball;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class BallPanel extends JPanel {

	BallPit pit;
	ArrayList<Sprite> balls;
	
	public BallPanel(BallPit pit){
		this.pit = pit;
		addMouseListener(new Mouse());
	}
	
	public void animate() {
	    while (true){
	    	
	    	try {
				balls = pit.getList();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        repaint();
	        //sleep while waiting to display the next frame of the animation
	        try {
	            Thread.sleep(40);  // wake up roughly 25 frames per second
	        }
	        catch ( InterruptedException exception ) {
	            exception.printStackTrace();
	        }
	    }
	}
	
	private class Mouse extends MouseAdapter {
		@Override
	    public void mousePressed( final MouseEvent event ){
	        try {
				pit.newSprite(event.getX(), event.getY());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
}
