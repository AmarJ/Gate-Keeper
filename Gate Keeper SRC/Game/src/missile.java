import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class missile extends Entity {

	public missile(int x, int y) {
		super(x, y);
	}

	public void update() {
		y -= 5;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getmissileImg(), x, y, null);
	}
	
	public Image getmissileImg() {
		ImageIcon ic = new ImageIcon("images/bullet.gif");
		return ic.getImage();
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getmissileImg().getWidth(null), 
				getmissileImg().getHeight(null));
	}
	
}

