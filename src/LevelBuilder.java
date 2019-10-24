import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelBuilder {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		// frame.getContentPane().setPreferredSize(new Dimension(500, 500));
		frame.setSize(500, 500);
		frame.pack();
	}

	LevelBuilder() {

		setup();

	}

}
