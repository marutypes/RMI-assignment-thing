package bouncingball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.io.Serializable;;

public class Sprite implements Serializable{
	public final static Random randomR = new Random();
	public final static Random randomG = new Random();
	public final static Random randomB = new Random();
	public final static Random ranSpeed = new Random();
	
	final static int SIZE = 10;
	final static int MAX_SPEED = 5;
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private Color color;

	public Sprite (int x, int y)
	{
		this.x = x;
		this.y = y;
		this.dx = ranSpeed.nextInt(2*MAX_SPEED) - MAX_SPEED;
		this.dy = ranSpeed.nextInt(2*MAX_SPEED) - MAX_SPEED;
		this.color = new Color(randomR.nextInt(256),randomG.nextInt(256),randomB.nextInt(256));
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, SIZE, SIZE);
	}
	
	public void move(int dimensions) {
		
		// check for bounce and make the ball bounce if necessary
        //
        if (x < 0 && dx < 0){
            //bounce off the left wall 
            x = 0;
            dx = -dx;
        }
        if (y < 0 && dy < 0){
            //bounce off the top wall
            y = 0;
            dy = -dy;
        }
        if (x > dimensions - SIZE && dx > 0){
            //bounce off the right wall
        	x = dimensions - SIZE;
        	dx = - dx;
        }       
        if (y > dimensions - SIZE && dy > 0){
            //bounce off the bottom wall
        	y = dimensions - SIZE;
        	dy = -dy;
        }

        //make the ball move
        x += dx;
        y += dy;
		
	}
}
