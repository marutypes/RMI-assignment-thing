package bouncingball;

import java.rmi.Remote;
import java.util.ArrayList;

public interface BallPit extends Remote {

	public void newSprite(int x, int y) throws java.rmi.RemoteException;
	public ArrayList<Sprite> getList() throws java.rmi.RemoteException;
	public int getDime() throws java.rmi.RemoteException;
}
