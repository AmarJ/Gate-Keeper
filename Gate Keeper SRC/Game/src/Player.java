import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Entity {

	int velX = 0;
	int speed = 5;
	
	public Player(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		x += velX;
		
		checkCollisions();
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(), x, y, null); 
		//g2d.draw(getBounds());
	}
	
	public Image getPlayerImg() {
		ImageIcon ic = new ImageIcon("images/player.png");
		return ic.getImage();
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	
		 if (key == KeyEvent.VK_A) {
			velX = -speed;
		} else if (key == KeyEvent.VK_D) {
			velX = speed;
		} else if (key == KeyEvent.VK_SPACE) {
			Game_Frame.addmissile(new missile(x+26, y));  
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		 if (key == KeyEvent.VK_A) {
			velX = 0;
		} else if (key == KeyEvent.VK_D) {
			velX = 0;
		} 
	}
	
	public void checkCollisions() {
		ArrayList<Enemy> enemies = Game_Frame.getEnemyList();
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			
			if (getBounds().intersects(tempEnemy.getBounds())) {
				System.exit(0);
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getPlayerImg().getWidth(null), 
				getPlayerImg().getHeight(null));
		
	}
}



