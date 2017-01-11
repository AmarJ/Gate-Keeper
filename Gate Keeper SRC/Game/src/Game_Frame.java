import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game_Frame extends JPanel implements ActionListener {

	Timer mainTimer;
	Player player;
	wall wall;
	
	int enemyCount = 25;
	int level = 1;
	
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static ArrayList<missile> missiles = new ArrayList<missile>();
	static ArrayList<wall> walls = new ArrayList<wall>();
	
	Random rand =  new Random();
	
	public Game_Frame() {
		setFocusable(true);
		
		player = new Player(300, 690);
		addKeyListener(new KeyAdapt(player));
		
		wall = new wall(20, 760);
		addKeyListener(new KeyAdapt(wall));
		
		mainTimer = new Timer(10, this);	
		mainTimer.start();
		
		startgame();
		
		}
				
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		player.draw(g2d);
		wall.draw(g2d);
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
		
		for (int i = 0; i <missiles.size(); i++) {
			missile m = missiles.get(i);
		    m.draw(g2d);
		    	    
		}
	}

	public static ArrayList<wall> getwalList() {
		return walls;
	
	}
	
	public void actionPerformed(ActionEvent arg0) {
		player.update();
		wall.update();
		
		    
	for (int i = 0; i <walls.size(); i++) {
		wall tempwall = walls.get(i);
		tempwall.update();
	}
		
	for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.update();
}
		
	for (int i = 0; i <missiles.size(); i++) {
			missile m = missiles.get(i);
			m.update();		
}
			checkEnd();
		
			repaint();	
}	
		
	public static void addEnemy(Enemy e) {
		enemies.add(e);
}
	
	public static void removeEnemy(Enemy e) {
		enemies.remove(e);
		
}
	
	public static ArrayList<Enemy> getEnemyList() {
		return enemies;
		
}
	
	public static void addmissile(missile m) {
		missiles.add(m);
}
	
	public static void removemissile(missile m) {
		missiles.remove(m);
		
}
	
	public static ArrayList<missile> getmissileList() {
		return missiles;
		
}

	public static void addwall(wall w) {
	walls.add(w);
}

	public static void removewall(wall w) {
	walls.remove(w);
	
}

public static ArrayList<wall> getwallList() {
	return walls;
	
}

	public void startgame() {
		enemyCount = level * 6;
		
		for (int i = 0; i < enemyCount; i++) {
			addEnemy(new Enemy(rand.nextInt(500), -10 + -rand.nextInt(700)));
			
		}
}
	
	public void checkEnd() {
		if (enemies.size() == 0) {
			enemies.clear();
			missiles.clear();
			JOptionPane.showMessageDialog(null, "You just Won Level " + level + ". Congradulations! Moving on to next level...");
			level++;
			startgame();
			
		}
	}
}


