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
	ObjectManager oManager;
	//FloorManager fManager;

	boolean test;

	GamePanel() {

		timer = new Timer(1000 / 60, this);
		player = new Player(200, 100);
		oManager = new ObjectManager(player);
//		fManager = new FloorManager(player);
//		fManager.createFloor();
	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		oManager.update();

		checkCollisions();
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Evolution.width, Evolution.height);

		oManager.draw(g);
		//fManager.draw(g);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyPressed = e.getKeyCode();
		player.manageDir(keyPressed, true);

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyPressed = e.getKeyCode();
		player.manageDir(keyPressed, false);

	}

	@Override
	public void keyTyped(KeyEvent e) {

		int keyPressed = e.getKeyCode();

	}


	void checkCollisions() {
		oManager.checkAllCollisions();
	}

}
