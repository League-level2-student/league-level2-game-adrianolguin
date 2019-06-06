import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ObjectManager {

	int Vertical = 0;
	int Horizontal = 1;

	Player player;

	Room r;

	Wall wall;

	ArrayList<Rectangle> collisionBoxes;

	ObjectManager(Player player) {
		this.player = player;
		this.r = new Room(250, 250, player.width, 240, player);
		this.wall = new Wall(250, 250, player.width * 2, 240, Vertical);
		collisionBoxes = new ArrayList<Rectangle>();
	}

	void draw(Graphics g) {

		// r.draw(g);
	
		wall.draw(g);
		player.draw(g);
	}

	void update() {

		checkCollisions();
		player.update();

	}


	void checkCollisions() {
		player.addCollisionBox(wall.collisionBox);
		

	}

}
