import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Combostion {

	JFrame frame = new JFrame();
	static JPanel panel = new JPanel();

	static final int width = 950;
	static final int height = 690;

	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.setSize(width, height);
	}

	public static void main(String[] arg) {

	Combostion main = new Combostion();
	main.setup();
		
	}
}
