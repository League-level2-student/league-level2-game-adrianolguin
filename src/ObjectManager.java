import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ObjectManager {

	int Vertical = 0;
	int Horizontal = 1;

	Player player;

	Enemy enemy;

	Room room;

	Wall wall;

	ObjectManager(Player player) {
		this.player = player;
		enemy = new Enemy(100, 100, 10, 10, 5);
		room = new Room(100, 100, 10, 100);
		wall = new Wall(200, 200, 10, 100, Vertical);
	}

	void draw(Graphics g) {
		enemy.draw(g);
		player.draw(g);
		room.draw(g);
		wall.draw(g);
	}

	void update() {

		for (int x = 0; x < 4; x++) {
			addCollisionBoxes(room.walls[x].information.collisionBox);
		}
		addCollisionBoxes(wall.collisionBox);
		player.update();
		enemy.update();

	}

	void addCollisionBoxes(Rectangle r) {

		player.addCollisionBox(r);

	}

	void checkCollisions() {

	}

}
