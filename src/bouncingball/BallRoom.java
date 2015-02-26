package bouncingball;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BallRoom extends UnicastRemoteObject implements BallPit {

	private final static int DIME = 400;
	private ArrayList<Sprite> ballz;
	
	protected BallRoom() throws RemoteException {
		super();
		ballz = new ArrayList<Sprite>();
	}

	public void move() {
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
	public void newSprite(int x, int y) throws RemoteException {
		Sprite ball = new Sprite(x,y);
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
