import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.omg.CORBA.Current;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Player player;
	TextManager tManager;
	public static BufferedImage heartImg;
	public static BufferedImage brokenHeartImg;
	public static BufferedImage damagedHeartImg;

	String tutorial1 = "Game is still buggy, so you'll be stuck moving forward\nJust hold the direction your stuck moving to become unstuck\nYou can also do some cool jumps on walls. Those are also buggy";
	String tutorial2 = "Be careful of spikes. They're sharp";
	boolean tutorialComplete;
	boolean refreshed = false;
	int CurrentGameState = 1;
	int Game = 0;
	int tutorial = 1;
	int LevelBuilder = 2;

	boolean showMiniMap = true;

	boolean doorAccept = false;;

	int boostRuntime = 0;
	boolean playerBoost;

	int currentRoomX;
	int currentRoomY;

	int playerDir;

	int gravity = 1;
	int friction = 1;

	int sWidth = Evolution.width - 250;
	int sHeight = Evolution.height;

	Timer timer;
	Timer boostBuffer;

	ObjectManager oManager;
	FloorManager fManager;

	GamePanel() {

		player = new Player(0, 0);
		tManager = new TextManager("null");

		try {
			heartImg = ImageIO.read(this.getClass().getResourceAsStream("Heart.png"));
			damagedHeartImg = ImageIO.read(this.getClass().getResourceAsStream("DamagedHeart.png"));
			brokenHeartImg = ImageIO.read(this.getClass().getResourceAsStream("BrokenHeart.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		boostBuffer = new Timer(1000 / 60, this);
		timer = new Timer(1000 / 60, this);

		oManager = new ObjectManager(player);
		fManager = new FloorManager(4, player);
		currentRoomX = fManager.spawnFloorX;
		currentRoomY = fManager.spawnFloorY;
		oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);
		player.setPos(fManager.spawnX, fManager.spawnY);

	}

	void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		manageDoors();
		oManager.update();
		checkCollisions();
		repaint();

		if (player.health < 1) {
			player = new Player(0, 0);
			tManager = new TextManager("null");

			try {
				heartImg = ImageIO.read(this.getClass().getResourceAsStream("Heart.png"));
				damagedHeartImg = ImageIO.read(this.getClass().getResourceAsStream("DamagedHeart.png"));
				brokenHeartImg = ImageIO.read(this.getClass().getResourceAsStream("BrokenHeart.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}

			boostBuffer = new Timer(1000 / 60, this);
			timer = new Timer(1000 / 60, this);

			oManager = new ObjectManager(player);
			fManager = new FloorManager(4, player);
			currentRoomX = fManager.spawnFloorX;
			currentRoomY = fManager.spawnFloorY;
			oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);
			player.setPos(fManager.spawnX, fManager.spawnY);

			JOptionPane.showMessageDialog(null, "Why'd you die?");
		}

		if (tutorialComplete) {
			fManager = new FloorManager(1, player);
			currentRoomX = fManager.spawnFloorX;
			currentRoomY = fManager.spawnFloorY;
			oManager.changeCurrentRoom(fManager.floor[currentRoomX][currentRoomY]);
			player.setPos(fManager.spawnX, fManager.spawnY);
			tutorialComplete = false;
		}

	}

	void updateTutorial() {

		manageDoors();
		oManager.update();
		checkCollisions();
		repaint();

	}

	void drawTutorial(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Evolution.width, Evolution.height);

		g.setColor(Color.gray);
		g.fillRect(sWidth + 50, 0, 200, sHeight);

		if (showMiniMap == true) {
			fManager.drawMiniMap(g);
		}

		oManager.draw(g);
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

		// if (CurrentGameState == tutorial) {
		// drawTutorial(g);
		// }

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyPressed = e.getKeyCode();

		player.manageDir(keyPressed, true);

		if (keyPressed == KeyEvent.VK_SPACE) {
			if (player.grinding) {
				player.wallJump();
			} else {
				player.jump();
			}

		}

		if (keyPressed == KeyEvent.VK_SHIFT && !player.Boosting) {

			if (player.ableBoost) {
				player.boost();
			}
		}

		if (keyPressed == KeyEvent.VK_S) {
			doorAccept = true;
		} else {
			doorAccept = false;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyPressed = e.getKeyCode();
		player.manageDir(keyPressed, false);

		if (keyPressed == KeyEvent.VK_DOWN) {
			doorAccept = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

		int keyPressed = e.getKeyCode();

	}

	void checkCollisions() {
		oManager.checkAllCollisions();
	}

	void manageDoors() {

		if (oManager.sDoor && doorAccept) {

			oManager.sDoor = false;
			currentRoomY++;

			oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));
			player.setPos(player.x, fManager.getRoom(currentRoomX, currentRoomY).walls[1].door.y
					+ fManager.getRoom(currentRoomX, currentRoomY).wallWidth);
			player.yVelocity = 0;
			if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-zero")) {
				JOptionPane.showMessageDialog(null, tutorial1);

			} else if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-one")) {
				JOptionPane.showMessageDialog(null, tutorial2);

			} else if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-two")) {

				JOptionPane.showMessageDialog(null,
						"You win Unfinished Game. It was very short huh. We should yell at the devs.");
			}

		} else if (oManager.nDoor) {

			oManager.nDoor = false;
			currentRoomY--;

			oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));

			player.setPos(player.x, fManager.getRoom(currentRoomX, currentRoomY).walls[3].door.y
					- fManager.getRoom(currentRoomX, currentRoomY).wallWidth);
			player.yVelocity = 0;
			if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-zero")) {
				JOptionPane.showMessageDialog(null, tutorial1);

			} else if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-one")) {
				JOptionPane.showMessageDialog(null, tutorial2);

			}

		} else if (oManager.wDoor) {

			oManager.wDoor = false;
			currentRoomX--;

			oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));

			player.setPos(fManager.getRoom(currentRoomX, currentRoomY).walls[2].door.x - player.width,
					fManager.getRoom(currentRoomX, currentRoomY).walls[2].door.y
							+ fManager.getRoom(currentRoomX, currentRoomY).doorSize - player.height);

			player.xVelocity = 0;
			if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-zero")) {
				JOptionPane.showMessageDialog(null, tutorial1);

			} else if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-one")) {
				JOptionPane.showMessageDialog(null, tutorial2);

			}

		} else if (oManager.eDoor) {

			oManager.eDoor = false;
			currentRoomX++;

			oManager.changeCurrentRoom(fManager.getRoom(currentRoomX, currentRoomY));

			player.setPos(
					fManager.getRoom(currentRoomX, currentRoomY).walls[0].door.x
							+ fManager.getRoom(currentRoomX, currentRoomY).wallWidth,
					fManager.getRoom(currentRoomX, currentRoomY).walls[0].door.y
							+ fManager.getRoom(currentRoomX, currentRoomY).doorSize - player.height);
			player.xVelocity = 0;
			if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-zero")) {
				JOptionPane.showMessageDialog(null, tutorial1);

			} else if (fManager.floor[currentRoomX][currentRoomY].modeKey.equals("one-one")) {
				JOptionPane.showMessageDialog(null, tutorial2);

			}
		}

		fManager.pX = currentRoomX;
		fManager.pY = currentRoomY;

		for (int i = 0; i < fManager.floor[currentRoomX][currentRoomY].lasers.size(); i++) {
			if (fManager.floor[currentRoomX][currentRoomY].lasers.get(i).state == true) {
				fManager.floor[currentRoomX][currentRoomY].lasers.get(i).timerStart();

			} else if (fManager.floor[currentRoomX][currentRoomY].lasers.get(i).state == false) {
				fManager.floor[currentRoomX][currentRoomY].lasers.get(i).timerStop();
				fManager.floor[currentRoomX][currentRoomY].lasers.get(i).stop();

			}

		}

	}

}
