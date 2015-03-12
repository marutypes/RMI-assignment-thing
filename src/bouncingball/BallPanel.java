package bouncingball;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

public class BallPanel extends JPanel {

	BallSession pit;
	ArrayList<Sprite> balls;
	private Color color;
	
	public BallPanel(BallSession pit){
		this.pit = pit;
		addMouseListener(new Mouse());
		Random random = new Random();
		color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
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
	    }
	}
	
	private class Mouse extends MouseAdapter {
		@Override
	    public void mousePressed( final MouseEvent event ){
	        try {
				pit.newSprite(event.getX(), event.getY(), color);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (balls != null){
			for(Sprite ball : balls){
				ball.draw(g);
			}
		}
	}
}
