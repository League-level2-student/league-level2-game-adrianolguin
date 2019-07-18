import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {

	FloorManager fManager;

	boolean open = true;
	boolean close = false;

	Timer iFrames;

	Player player;

	Room currentRoom;

	ObjectManager(Player player, FloorManager fManager) {

		this.fManager = fManager;

		this.player = player;

		iFrames = new Timer(1000, this);
	}

	void draw(Graphics g) {

		player.draw(g);

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
			} else if (player.collisionLine1.intersects(w.collisionBox)) {
				player.setX(player.getX() + player.getSpeed());
				player.setCBPos(player.getX(), player.getY());
			}
			if (player.collisionLine2.intersects(w.door)) {

			} else if (player.collisionLine2.intersects(w.collisionBox)) {
				player.setY(player.getY() + player.getSpeed());
				player.setCBPos(player.getX(), player.getY());
			}
			if (player.collisionLine3.intersects(w.door)) {
				fManager.floorX++;
				changeCurrentRoom(fManager.floor[fManager.floorX][fManager.floorY]);

				player.setPos(300, 300);

			} else if (player.collisionLine3.intersects(w.collisionBox)) {
				player.setX(player.getX() - player.getSpeed());
				player.setCBPos(player.getX(), player.getY());
			}
			if (player.collisionLine4.intersects(w.door)) {
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
