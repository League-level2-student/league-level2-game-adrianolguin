import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	int sWidth = Evolution.width;
	int sHeight = Evolution.height;

	Timer timer;
	Player player;
	ObjectManager oManager;

	FloorManager fManager;

	GamePanel() {

		timer = new Timer(1000 / 60, this);
		player = new Player(200, 100);

		fManager = new FloorManager(3, 2);
		fManager.setPos(0, 0);

		fManager.setRoom(0, 0, new Room(50, 50, sWidth - 100, sHeight - 100, false, false, true, false));
		fManager.setRoom(1, 0, new Room(50, 50, sWidth - 100, sHeight - 100, true, false, false, true));
		fManager.setRoom(1, 1, new Room(50, 50, sWidth - 100, sHeight - 100, false, true, true, false));
		fManager.setRoom(2, 1, new Room(50, 50, sWidth - 100, sHeight - 100, true, false, true, false));
		
		oManager = new ObjectManager(player, fManager);
		changeRoom(fManager.floor[fManager.floorX][fManager.floorY]);

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

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyPressed = e.getKeyCode();
		player.manageDir(keyPressed, true);

		// if (keyPressed == KeyEvent.VK_NUMPAD5) {
		// floorY--;
		// changeRoom(fManager.floor[floorX][floorY]);
		// } else if (keyPressed == KeyEvent.VK_NUMPAD2) {
		// floorY++;
		// changeRoom(fManager.floor[floorX][floorY]);
		// } else if (keyPressed == KeyEvent.VK_NUMPAD1) {
		// floorX--;
		// changeRoom(fManager.floor[floorX][floorY]);
		// } else if (keyPressed == KeyEvent.VK_NUMPAD3) {
		// floorX++;
		// changeRoom(fManager.floor[floorX][floorY]);
		// }

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

	void changeRoom(Room r) {
		oManager.changeCurrentRoom(r);
	}

}
