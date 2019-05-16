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
	Room test;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		player = new Player(Evo.width / 2, Evo.height / 2, 10, 10, 5);
		test = new Room(100, 100, 10, 200);
		test.initialize();
	}

	void start() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkCollision();
		player.update();

		repaint();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Evo.width, Evo.height);

		test.draw(g);
		player.draw(g);
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

	void checkCollision() {
		if (player.collisionBox.intersects(test.collisionBox1)) {
			player.x += player.speed;
		}
		if (player.collisionBox.intersects(test.collisionBox2)) {
			player.touchingWU = true;
		}
		if (player.collisionBox.intersects(test.collisionBox3)) {
			player.x -= player.speed;
		}
		if (player.collisionBox.intersects(test.collisionBox4)) {
			player.y -= player.speed;
		}
	}

}
