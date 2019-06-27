import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends GameObject {

	
	boolean CBIntersecting;

	boolean UP;
	boolean DOWN;
	boolean LEFT;
	boolean RIGHT;

	Rectangle left;
	Rectangle right;
	Rectangle up;
	Rectangle down;

	Player(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub

		this.speed = speed;

		health = 20;
		
		up = new Rectangle(x + 10, y - 5, 1, 5);
		down = new Rectangle(x + 10, y + height, 1, 5);
		left = new Rectangle(x - 5, y + 10, 5, 1);
		right = new Rectangle(x + height, y + 10, 5, 1);

		up.setBounds(up);
		down.setBounds(down);
		right.setBounds(right);
		left.setBounds(left);
	}

	void update() {

		if (UP) {
			collisionBox.y -= speed;
		}
		if (DOWN) {
			collisionBox.y += speed;
		}

		if (LEFT) {
			collisionBox.x -= speed;
		}
		if (RIGHT) {
			collisionBox.x += speed;
		}

		x = collisionBox.x;
		y = collisionBox.y;

		up.x = collisionBox.x + 10;
		up.y = collisionBox.y - 5;

		down.x = collisionBox.x + 10;
		down.y = collisionBox.y + height;

		left.x = collisionBox.x - 5;
		left.y = collisionBox.y + 10;

		right.x = collisionBox.x + height;
		right.y = collisionBox.y + 10;

		up.setBounds(up);
		down.setBounds(down);
		right.setBounds(right);
		left.setBounds(left);

	}

	// left right
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);

		g.setColor(Color.PINK);
		g.fillRect(up.x, up.y, up.width, up.height);
		g.fillRect(down.x, down.y, down.width, down.height);
		g.fillRect(left.x, left.y, left.width, left.height);
		g.fillRect(right.x, right.y, right.width, right.height);

	}

	void manageDir(int keyCode, boolean change) {

		if (keyCode == KeyEvent.VK_UP) {
			UP = change;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			DOWN = change;
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			LEFT = change;
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			RIGHT = change;
		}

	}

	// make a big check collision method like you did in league invaders and change
	// the
	// players position within the object manager class using getters and
	// setters,after
	// all the object manager class MANAGES all aspects of an object the object
	// class
	// itself is just an object, its not supposed to do anything by itself, not
	// really

}