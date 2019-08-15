import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

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

	Health healthBar;

	ObjectManager(Player player) {

		this.player = player;

		iFrames = new Timer(1000, this);

		healthBar = new Health(Evolution.width - 200, 200);
	}

	void draw(Graphics g) {

		player.draw(g);

		healthBar.draw(g);

		if (currentRoom != null) {
			currentRoom.draw(g);
		}
	}

	void update() {

		player.update();

		currentRoom.updateContents();

	}

	void checkAllCollisions() {
		checkWallCollisions();
		checkEnemyCollisions();
	}

	void checkEnemyCollisions() {

		for (int x = 0; x < currentRoom.containing.size(); x++) {
			if (currentRoom.containing.get(x).getClass() == Enemy.class) {
				checkEnemy((Enemy) currentRoom.containing.get(x));
			}
		}

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
				healthBar.currentHealth = player.health;
				iFrames.start();
				System.out.println(player.health);
			}
		}

		for (int i = 0; i < currentRoom.containing.size(); i++) {
			if (e != currentRoom.containing.get(i)) {
				if (e.collisionLine1.intersects(currentRoom.containing.get(i).collisionBox)) {
					e.collisionBox.x += e.width + e.collisionLine1.width;
					e.canLeft = false;
				}

				if (e.collisionLine2.intersects(currentRoom.containing.get(i).collisionBox)) {
					e.collisionBox.y -= e.speed + e.collisionLine2.height;
					e.canUp = false;
				}

				if (e.collisionLine3.intersects(currentRoom.containing.get(i).collisionBox)) {
					e.collisionBox.x += e.speed + e.collisionLine3.width;
					e.canRight = false;
				}

				if (e.collisionLine4.intersects(currentRoom.containing.get(i).collisionBox)) {
					e.collisionBox.y -= e.speed + e.collisionLine3.height;
					e.canDown = false;
				}
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
