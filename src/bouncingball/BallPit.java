package bouncingball;

import java.awt.Color;
import java.rmi.Remote;
import java.util.ArrayList;

public interface BallPit extends Remote {

	public void move() throws java.rmi.RemoteException;
	public void newSprite(int x, int y, Color c) throws java.rmi.RemoteException;
	public ArrayList<Sprite> getList() throws java.rmi.RemoteException;
	public int getDime() throws java.rmi.RemoteException;
}
