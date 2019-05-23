import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	Player player;
	ObjectManager manager;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		player = new Player(Evo.width / 2, Evo.height / 2, 10, 10, 5);
		manager = new ObjectManager(player);
	}

	void start() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		manager.update();
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Evo.width, Evo.height);

		manager.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		player.manageDir(keyCode, true);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		player.manageDir(keyCode, false);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
