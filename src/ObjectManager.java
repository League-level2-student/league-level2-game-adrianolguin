import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {

	int healthBuffer1;
	int healthBuffer2;

	int sWidth = Evolution.width - 250;
	int sHeight = Evolution.height;

	boolean open = true;
	boolean close = false;

	boolean touchNorthDoor;
	boolean touchEastDoor;
	boolean touchSouthDoor;
	boolean touchWestDoor;

	Timer iFrames;

	Player player;

	Room currentRoom;

	ObjectManager(Player player) {

		this.player = player;

		iFrames = new Timer(1000, this);
	}

	void draw(Graphics g) {

		player.draw(g);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				g.drawImage(GamePanel.brokenHeartImg, (sWidth + 40) + i * 40, 240 + j * 40, 64, 64, null);
				g.drawImage(GamePanel.heartImg, (sWidth + 40) + i * 40, 240 + j * 40, 64, 64, null);
			}
		}

		for(int x = 0; x < (player.health - 10) / 2; x++) {
			
		}
		
		if (currentRoom != null) {
			currentRoom.draw(g);
		}
	}

	void update() {

		player.update();

	}

	void checkAllCollisions() {
		checkWallCollisions();
		checkEnemyCollisions();
	}

	void checkEnemyCollisions() {

	}

	void checkWallCollisions() {

		for (int x = 0; x < 4; x++) {
			if (currentRoom != null) {
				checkWall(currentRoom.walls[x]);
			}
		}

	}

	void checkWall(Wall w) {
		if (player.getCollisionBox().intersects(w.collisionBox)) {

			if (player.collisionLine1.intersects(w.door)) {
				touchWestDoor = true;
			} else if (player.collisionLine1.intersects(w.collisionBox)) {
				player.setX(player.getX() + player.getSpeed());
				player.setCBPos(player.getX(), player.getY());
			}
			if (player.collisionLine2.intersects(w.door)) {
				touchNorthDoor = true;
			} else if (player.collisionLine2.intersects(w.collisionBox)) {
				player.setY(player.getY() + player.getSpeed());
				player.setCBPos(player.getX(), player.getY());
			}
			if (player.collisionLine3.intersects(w.door)) {
				touchEastDoor = true;
			} else if (player.collisionLine3.intersects(w.collisionBox)) {
				player.setX(player.getX() - player.getSpeed());
				player.setCBPos(player.getX(), player.getY());
			}
			if (player.collisionLine4.intersects(w.door)) {
				touchSouthDoor = true;
			} else if (player.collisionLine4.intersects(w.collisionBox)) {
				player.setY(player.getY() - player.getSpeed());
				player.setCBPos(player.getX(), player.getY());
			}

		}
	}

	void checkEnemy(Enemy e) {
		if (player.invincible) {

		} else {
			if (player.getCollisionBox().intersects(e.getCollisionBox())) {
				player.health--;
				player.invincible = true;
				iFrames.start();
				System.out.println(player.health);
			}
		}
	}

	void changeCurrentRoom(Room r) {
		currentRoom = r;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		player.invincible = false;
		iFrames.stop();
	}

}
