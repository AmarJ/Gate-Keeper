import javax.swing.JFrame;
import java.awt.*;

public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Amar's Gate Keeper Game");
		frame.setSize(560, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(new Game_Frame());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}        

       