import java.awt.Graphics;

public class ObjectManager {

	Player player;

	Wall wall;
	
	ObjectManager(Player player) {
		this.player = player;
		this.wall = new Wall(250,250, 10, 100, 1, false);
	}

	void draw(Graphics g) {
		player.draw(g);
		wall.draw(g);
	}

	void update() {
		player.update();
	}

	void checkCollisions() {
		
	}
	
}
