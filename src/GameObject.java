import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	boolean alive = true;
	boolean canMove = true;
	
	int x;
	int y;
	int width;
	int height;
	int speed;
	Rectangle collisionBox;

	GameObject(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		collisionBox = new Rectangle(x, y, height, width);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {

	}

}
