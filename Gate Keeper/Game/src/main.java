import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Amar's Gate Keeper Game");
		frame.setSize(600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.add(new Game_Frame());
		frame.setVisible(true);
		
	}

}        

       