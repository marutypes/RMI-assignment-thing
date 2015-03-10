package bouncingball;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class BallRoom extends UnicastRemoteObject implements BallPit {

	private final static int DIME = 400;
	private ArrayList<Sprite> ballz;
	
	protected BallRoom() throws RemoteException {
		super();
		ballz = new ArrayList<Sprite>();
	}

	@Override
	public void move() throws RemoteException {
		for(Sprite ball:ballz){
			try {
				ball.move(getDime());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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
	public int getDime() throws RemoteException {
		return DIME;
	}

}
