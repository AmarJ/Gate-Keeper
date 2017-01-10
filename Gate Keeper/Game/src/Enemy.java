import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy extends Entity {

	private int startY;
	
	public Enemy(int x, int y) {
		super(x, y);
		startY = y;

	}
	  
	public void update() {
		y += 1;
		checkCollisions1();
		checkCollisions();
		checkOffScreen();
		
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImg(), x, y, null);
		g2d.draw(getBounds());
	}
	
	public Image getEnemyImg() {
		ImageIcon ic = new ImageIcon("images/zombie.png");
		return ic.getImage();
		
	}
	
	public void checkCollisions1() {
		ArrayList<wall> walls = Game_Frame.getwallList();
		
		for (int i = 0; i < wall.size; i++) {
			wall tempwall = walls.get(i);
			
			if (getBounds().intersects(tempwall.getBounds())) {
				System.exit(i);
			}
		}			
	}
			
	public void checkCollisions() {
		for (int i = 0; i <Game_Frame.getmissileList().size(); ++i) {
			missile m = Game_Frame.getmissileList().get(i);
			
			if (getBounds().intersects(m.getBounds())) {
				Game_Frame.removeEnemy(this);
				Game_Frame.removemissile(m);
				
			}
		}
	}
	
	public void checkOffScreen() {
		if (y >= 800) {
			y = startY;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getEnemyImg().getWidth(null), 
				getEnemyImg().getHeight(null));
	}
	
		}