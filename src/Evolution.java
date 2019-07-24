import java.awt.Dimension;

import javax.swing.JFrame;

public class Evolution {

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

	}

}