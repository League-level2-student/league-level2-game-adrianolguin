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

	// public static BufferedImage rocketImg;
	public static BufferedImage heartImg;
	public static BufferedImage brokenHeartImg;
	public static BufferedImage damagedHeartImg;
	

	boolean showMiniMap = true;

	int currentRoomX;
	int currentRoomY;

	int sWidth = Evolution.width - 250;
	int sHeight = Evolution.height;

	Timer timer;
	Player player;
	ObjectManager oManager;
	FloorManager fManager;

	GamePanel() {

		try {
			heartImg = ImageIO.read(this.getClass().getResourceAsStream("Heart.png"));
			damagedHeartImg = ImageIO.read(this.getClass().getResourceAsStream("Heart.png"));
			brokenHeartImg = ImageIO.read(this.getClass().getResourceAsStream("Heart.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		timer = new Timer(1000 / 60, this);
		player = new Player(200, 100);

		oManager = new ObjectManager(player);
		fManager = new FloorManager(1);
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

		// g.drawImage(heartImg, 400, 400, 64 * 4, 64 * 4, null);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyPressed = e.getKeyCode();

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

	void manageDoors() {
		if (oManager.touchNorthDoor) {
			oManager.touchNorthDoor = false;
			currentRoomY--;
			fManager.pY--;
			oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);
			player.setCBPos(oManager.currentRoom.walls[3].door.x, oManager.currentRoom.walls[3].door.y - player.height);
		} else if (oManager.touchEastDoor) {
			oManager.touchEastDoor = false;
			currentRoomX++;
			fManager.pX++;
			oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);
			player.setCBPos(oManager.currentRoom.walls[0].door.x + player.height, oManager.currentRoom.walls[0].door.y);
		} else if (oManager.touchSouthDoor) {
			oManager.touchSouthDoor = false;
			currentRoomY++;
			fManager.pY++;
			oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);
			player.setCBPos(oManager.currentRoom.walls[1].door.x, oManager.currentRoom.walls[1].door.y + player.height);
		} else if (oManager.touchWestDoor) {
			oManager.touchWestDoor = false;
			currentRoomX--;
			fManager.pX--;
			oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);
			player.setCBPos(oManager.currentRoom.walls[2].door.x - player.height, oManager.currentRoom.walls[2].door.y);
		}
	}

}
