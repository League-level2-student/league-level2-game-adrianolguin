import java.awt.Dimension;
import java.io.Console;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Evolution {

	JTextArea area;
	JFrame frame = new JFrame();
	static GamePanel panel = new GamePanel();

	static final int width = 1200;
	static final int height = 690;

	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.setSize(width, height);
		frame.pack();

	}

	public static void main(String[] args) {

		Evolution Evolution = new Evolution();
		Evolution.setup();

		panel.startGame();
		JOptionPane.showMessageDialog(null,
				"Welcome to Unfinished Game, an unfinished game. Full release... never, probably.\nPress SPACE to jump and SHIFT to boost.\nGood luck");

	}

}
