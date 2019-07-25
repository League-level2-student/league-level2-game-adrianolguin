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

	Enemy enemy1;

	Timer iFrames;

	Player player;

	Room currentRoom;
	
	Health healthBar;

	ObjectManager(Player player) {

		this.player = player;

		enemy1 = new Enemy(500, 500);

		iFrames = new Timer(1000, this);
	
		healthBar = new Health();
	}

	void draw(Graphics g) {

		player.draw(g);

		enemy1.draw(g);

		healthBar.draw(g);
		
//		for (int i = 0; i < 5; i++) {
//			g.drawImage(GamePanel.brokenHeartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
//			g.drawImage(GamePanel.damagedHeartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
//			g.drawImage(GamePanel.heartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
//		}
//		
//		for (int i = 0; i < 5; i++) {
//			g.drawImage(GamePanel.brokenHeartImg, (sWidth + 40) + i * 40, 240, 64, 64, null);
//			g.drawImage(GamePanel.damagedHeartImg, (sWidth + 40) + i * 40, 240, 64, 64, null);
//			g.drawImage(GamePanel.heartImg, (sWidth + 40) + i * 40, 240, 64, 64, null);
//		}
		
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
		checkEnemy(enemy1);
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
				healthBar.currentHealth--;
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
