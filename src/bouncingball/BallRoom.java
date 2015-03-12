package bouncingball;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class BallRoom extends UnicastRemoteObject implements BallSession {

	private final int SIZE;
	private ArrayList<Sprite> ballz;
	
	protected BallRoom() throws RemoteException {
		this(400);
	}
	protected BallRoom(int size) throws RemoteException {
	    super();
	    ballz = new ArrayList<Sprite>();
	    SIZE = size;
	}

	public void move() {
		for(Sprite ball:ballz){
			try {
				ball.move(getSize());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void start() {
		(new Thread(){
			public void run(){
			    while(true) {
			    	  try {
				            Thread.sleep(40);  // wake up roughly 25 frames per second
				        }
			    	  catch ( InterruptedException exception ) {
			    		  exception.printStackTrace();
				      }		    	  
			    	  move();
			      }
			}
		}).start();
	}
	
	@Override
	public void newSprite(int x, int y, Color c) throws RemoteException {
		Sprite ball = new Sprite(x,y,c);
		ballz.add(ball);
	}

	@Override
	public ArrayList<Sprite> getList() throws RemoteException {
		return ballz;
	}

	@Override
	public int getSize() throws RemoteException {
		return SIZE;
	}

}
