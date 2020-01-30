import java.awt.Color;
import java.awt.Font;
import java.time.format.TextStyle;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.xml.soap.Text;

public class TextManager {

	JTextArea textArea;
	Font font;

	String mode;
	boolean refreshed = false;

	public TextManager(String mode) {
		this.mode = mode;
		font = new Font("Arial", Font.BOLD, 32);
		textArea = new JTextArea();
		textArea.setFont(font);
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setVisible(true);

	}

	void setMode(String newMode) {
		mode = newMode;
	}

	void setText() {
		if (refreshed == false) {
			if (mode.equals("zero-zero")) {
				JOptionPane.showMessageDialog(null, "Press SPACE to jump.");
				refreshed = true;

			} else if (mode.equals("zero-one")) {
				JOptionPane.showMessageDialog(null, "I Don't know");
				refreshed = true;
				
			} else if (mode.equals("one-one")) {

			} else if (mode.equals("one-two")) {

			}

		}
	}

}
