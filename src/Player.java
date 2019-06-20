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

	ArrayList<Rectangle> collisionBoxes;

	Player(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub

		information.Object.equals("Player");
		this.speed = speed;

		collisionBoxes = new ArrayList<Rectangle>();

	}

	void update() {

		super.update();

		if (UP) {
			collisionBox.y -= speed;
		}
		if (DOWN) {
			collisionBox.y += speed;
		}
		checkCollisions();

		if (CBIntersecting == true) {
			collisionBox.y = y;
			CBIntersecting = false;
		} else if (CBIntersecting == false) {
			y = collisionBox.y;

		}

		if (LEFT) {
			collisionBox.x -= speed;
		}
		if (RIGHT) {
			collisionBox.x += speed;
		}
		checkCollisions();

		if (CBIntersecting == true) {
			collisionBox.x = x;
			CBIntersecting = false;
		} else if (CBIntersecting == false) {
			x = collisionBox.x;

		}

	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);

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

//make a big check collision method like you did in league invaders and change the
//players position within the object manager class using getters and setters,after
//all the object manager class MANAGES all aspects of an object the object class 
//itself is just an object, its not supposed to do anything by itself, not really
	

}