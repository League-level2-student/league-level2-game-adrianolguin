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

	Rectangle collisionLine1;
	Rectangle collisionLine2;
	Rectangle collisionLine3;
	Rectangle collisionLine4;

	Rectangle collisionBox;

	ArrayList<Rectangle> collisionBoxes;

	Player(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub

		collisionBox = new Rectangle(x, y, width, height);
		collisionBoxes = new ArrayList<Rectangle>();

		collisionLine1 = new Rectangle(x, y + height / 2, 1, 1);
		collisionLine2 = new Rectangle(x + height / 2, y, 1, 1);
		collisionLine3 = new Rectangle(x + width, y + height / 2, 1, 1);
		collisionLine4 = new Rectangle(x + width / 2, y + width, 1, 1);

		collisionLine1.setBounds(collisionLine1);
		collisionLine2.setBounds(collisionLine2);
		collisionLine3.setBounds(collisionLine3);
		collisionLine4.setBounds(collisionLine4);
	}

	void update() {

		super.update();

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

		// check if collisionBox is intersecting with another collisionBox

		checkCollisions();

		// if it is intersecting then make it so the player does not move

		if (CBIntersecting) {

			CBIntersecting = false;
		} else {
			x = collisionBox.x;
			y = collisionBox.y;

			collisionLine1.setLocation(x, y);
			collisionLine2.setLocation(x, y);
			collisionLine3.setLocation(x, y);
			collisionLine4.setLocation(x, y);

			collisionLine1.setBounds(collisionLine1);
			collisionLine2.setBounds(collisionLine2);
			collisionLine3.setBounds(collisionLine3);
			collisionLine4.setBounds(collisionLine4);

		}

	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);

		g.setColor(Color.GREEN);
		g.fillRect(collisionLine1.x, collisionLine1.y, collisionLine1.width, collisionLine1.height);
		g.fillRect(collisionLine2.x, collisionLine2.y, collisionLine2.width, collisionLine2.height);
		g.fillRect(collisionLine3.x, collisionLine3.y, collisionLine3.width, collisionLine3.height);
		g.fillRect(collisionLine4.x, collisionLine4.y, collisionLine4.width, collisionLine4.height);

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

	void addCollisionBox(Rectangle r) {
		collisionBoxes.add(r);
	}

	void checkCollisions() {

		for (Rectangle r : collisionBoxes) {
			if (collisionBox.intersects(r)) {

				CBIntersecting = true;
				System.out.println("intersecting");

			}
		}

	}

}