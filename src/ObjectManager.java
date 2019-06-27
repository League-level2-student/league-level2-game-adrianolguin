import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;

public class ObjectManager {

	

	int Vertical = 0;
	int Horizontal = 1;

	Player player;

	Enemy enemy;

	Room room;

	Wall wall;
	Wall wall2;

	Timer iFrames;

	// timer that handles invincibility frames();

	ObjectManager(Player player) {
		this.player = player;

		enemy = new Enemy(200, 100, 10, 10, 1);

		wall = new Wall(100, 100, player.width, 100);
		wall2 = new Wall(100, 100, 100, player.width);
	}

	void draw(Graphics g) {

		wall.draw(g);
		wall2.draw(g);
		enemy.draw(g);

		player.draw(g);
	}

	void update() {

		player.update();

		enemy.update();

		checkAllCollisions();

	}

	void checkAllCollisions() {
		checkWallCollisions();

		checkEnemyCollisions();

		checkBulletCollisions();
	}

	void checkBulletCollisions() {
		// if bullet then take damage
		// get rid of bullet

		// if your bullet enemy
		// enemy damage
		// get rid of bullet
	}

	void checkEnemyCollisions() {

		if (player.collisionBox.intersects(enemy.collisionBox)) {

			player.invincible = true;

			player.health--;
			System.out.println(player.health);
		}

	}

	void checkWallCollisions() {

		checkWall(wall.collisionBox);
		checkWall(wall2.collisionBox);
	}

	void checkWall(Rectangle wall) {
		if (player.collisionBox.intersects(wall)) {

			if (player.up.intersects(wall)) {
				player.y += player.speed;
				player.collisionBox.y = player.y;
			}
			if (player.down.intersects(wall)) {
				player.y -= player.speed;
				player.collisionBox.y = player.y;
			}
			if (player.left.intersects(wall)) {
				player.x += player.speed;
				player.collisionBox.x = player.x;
			}
			if (player.right.intersects(wall)) {
				player.x -= player.speed;
				player.collisionBox.x = player.x;
			}
		}

	}
}
