import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	public static BufferedImage heartImg;
	public static BufferedImage brokenHeartImg;
	public static BufferedImage damagedHeartImg;

	boolean showMiniMap = true;

	boolean doorAccept = false;;

	int currentRoomX;
	int currentRoomY;

	int gravity = 1;

	int sWidth = Evolution.width - 250;
	int sHeight = Evolution.height;

	Timer timer;
	Player player;
	ObjectManager oManager;
	FloorManager fManager;

	GamePanel() {

		try {
			heartImg = ImageIO.read(this.getClass().getResourceAsStream("Heart.png"));
			damagedHeartImg = ImageIO.read(this.getClass().getResourceAsStream("DamagedHeart.png"));
			brokenHeartImg = ImageIO.read(this.getClass().getResourceAsStream("BrokenHeart.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		timer = new Timer(1000 / 60, this);
		player = new Player(200, 100);

		oManager = new ObjectManager(player);
		fManager = new FloorManager(2, player);
		currentRoomX = 0;
		currentRoomY = 0;
		oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);

	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		manageDoors();

		oManager.update();

		checkCollisions();

		repaint();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Evolution.width, Evolution.height);

		g.setColor(Color.gray);
		g.fillRect(sWidth + 50, 0, 200, sHeight);

		if (showMiniMap == true) {
			fManager.drawMiniMap(g);
		}

		oManager.draw(g);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyPressed = e.getKeyCode();

		player.manageDir(keyPressed, true);

		if (keyPressed == KeyEvent.VK_SPACE) {
			player.jump();
		}

		if (keyPressed == KeyEvent.VK_DOWN) {
			doorAccept = true;
		}

		if (keyPressed == KeyEvent.VK_M) {
			if (showMiniMap == false) {
				showMiniMap = true;
			} else {
				showMiniMap = false;
			}
		}

		if (keyPressed == KeyEvent.VK_P) {
			System.out.println(currentRoomX + ", " + currentRoomY);
		}

		if (keyPressed == KeyEvent.VK_0) {
			player.health++;
			oManager.healthBar.currentHealth = player.health;
		}

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

	void manageDoors() {

		if (doorAccept) {
			if (oManager.sDoor) {

				oManager.sDoor = false;
				currentRoomY++;
				oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));
				player.setPos(fManager.getRoom(currentRoomX, currentRoomY).walls[1].door.x,
						fManager.getRoom(currentRoomX, currentRoomY).walls[1].door.y
								+ fManager.getRoom(currentRoomX, currentRoomY).wallWidth);
				player.yVelocity = 0;

			}
		} else if (oManager.nDoor) {

			oManager.nDoor = false;
			currentRoomY--;
			oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));

			player.setPos(fManager.getRoom(currentRoomX, currentRoomY).walls[3].door.x,
					fManager.getRoom(currentRoomX, currentRoomY).walls[3].door.y
							- fManager.getRoom(currentRoomX, currentRoomY).wallWidth);
			player.yVelocity = 0;

		} else if (oManager.wDoor) {

			oManager.wDoor = false;
			currentRoomX--;
			oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));

		} else if (oManager.eDoor) {

			oManager.eDoor = false;
			currentRoomX++;
			oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));

		}

		fManager.pX = currentRoomX;
		fManager.pY = currentRoomY;

	}

}
