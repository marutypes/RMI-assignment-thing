package bouncingball;

import java.awt.Color;
import java.rmi.Remote;
import java.util.ArrayList;

public interface BallSession extends Remote {
	public void newSprite(int x, int y, Color c) throws java.rmi.RemoteException;
	public ArrayList<Sprite> getList() throws java.rmi.RemoteException;
	public int getSize() throws java.rmi.RemoteException;
}
