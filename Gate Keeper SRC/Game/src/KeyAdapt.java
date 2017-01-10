import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class KeyAdapt extends KeyAdapter {

	Player p;
	wall u;
	
	public KeyAdapt(Player player) {
		p = player;	
	}
	
	public KeyAdapt(wall wall) {
		u = wall;		
	}
	
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
}
