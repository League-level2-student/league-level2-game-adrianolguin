import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	boolean UP;
	boolean DOWN;
	boolean RIGHT;
	boolean LEFT;

	boolean invincible = false;
	boolean intersecting = false;
	boolean alive = true;
	
	int x;
	int y;
	int width;
	int height;

	int speed;

	int health;

	Rectangle collisionBox;

	GameObject(int x, int y) {
		this.x = x;
		this.y = y;

	}

	void manageDir() {

	}

	void update() {

	}

	void draw(Graphics g) {

	}

}
