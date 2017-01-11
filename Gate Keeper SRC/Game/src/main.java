import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Amar's Gate Keeper Game");
		frame.setSize(560, 900);
		ImageIcon img = new ImageIcon("images/player.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new Game_Frame());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}        



       