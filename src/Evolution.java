import java.awt.Dimension;

import javax.swing.JFrame;

public class Evolution {

	static final int width = 950;
	static final int height = 690;

	JFrame frame = new JFrame();
	static GamePanel panel = new GamePanel();

	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.setSize(width, height);
	}

	public static void main(String[] args) {

		Evolution Evolution = new Evolution();
		Evolution.setup();
		
		panel.startGame();

	}

}
