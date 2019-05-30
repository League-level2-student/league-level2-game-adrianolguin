import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class ObjectManager {

	int Vertical = 0;
	int Horizontal = 1;

	Player player;

	Room r;

	Wall wall;

	ObjectManager(Player player) {
		this.player = player;
		this.r = new Room(250, 250, player.width, 240, player);
		this.wall = new Wall(250, 250, player.width * 2, 240, Vertical);
	}

	void draw(Graphics g) {

		// r.draw(g);
		player.draw(g);
		wall.draw(g);
	}

	void update() {

		checkCollisions();
		player.update();

	}

	void checkCollisions() {
		wall.checkCollisions(player);
		// r.checkCollisions();
	}

}
