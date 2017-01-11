import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class wall extends Entity {


	public static int size;

	public wall(int x, int y) {
		super(x, y);
		
}
		
	public void update() {
		checkCollision();
				
}
			
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getwallImg(), x, y, null);
		g2d.draw(getBounds());
}
			
	public Image getwallImg() {
		ImageIcon ic = new ImageIcon("images/wall.png");
		return ic.getImage();
					
}
	public void checkCollision() {
		ArrayList<Enemy> enemies = Game_Frame.getEnemyList();
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			
			if (getBounds().intersects(tempEnemy.getBounds())) {
				JOptionPane.showMessageDialog(null, "Sorry, you lost. Better luck next time.");
				System.exit(0);
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getwallImg().getWidth(null),
		getwallImg().getHeight(null));      
			
}

	}

			