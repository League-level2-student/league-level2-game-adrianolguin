import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	boolean alive = true;
	boolean canMove = true;

	ObjectInfo information;

	int x;
	int y;
	int width;
	int height;
	int speed;
	Rectangle collisionBox;

	GameObject(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, height, width);

		information = new ObjectInfo(x, y, width, height, speed, "", collisionBox);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {

	}

}
