import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class wall extends Entity {


	public static int size;

	public wall(int x, int y) {
		super(x, y);
		
}
		
	public void update() {
				
}
			
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getwallImg(), x, y, null);
		g2d.draw(getBounds());
}
			
	public Image getwallImg() {
		ImageIcon ic = new ImageIcon("images/wall.png");
		return ic.getImage();
					
}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getwallImg().getWidth(null),
		getwallImg().getHeight(null));      
			
}

	}

			