import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends GameObject {

	Rectangle collisionLine1;
	Rectangle collisionLine2;
	Rectangle collisionLine3;
	Rectangle collisionLine4;

	int yVelocity = 0;
	
	Player(int x, int y) {
		super(x, y);

		health = 20;

		speed = 5;

		width = 20;
		height = 20;

		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);

		collisionLine1 = new Rectangle(x - 6, y + 10, 6, 1);
		collisionLine3 = new Rectangle(x + width, y + 10, 6, 1);
		collisionLine2 = new Rectangle(x + 10, y - 6, 1, 6);
		collisionLine4 = new Rectangle(x + 10, y + height, 1, 6);

		collisionLine1.setBounds(collisionLine1);
		collisionLine2.setBounds(collisionLine2);
		collisionLine3.setBounds(collisionLine3);
		collisionLine4.setBounds(collisionLine4);

	}

	void update() {

		super.update();

		yVelocity += Evolution.panel.gravity;
		collisionBox.y += yVelocity;
		
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

		x = getCBX();
		y = getCBY();

		collisionLine1.x = x - 5;
		collisionLine1.y = y + 10;

		collisionLine2.x = x + 10;
		collisionLine2.y = y - 5;

		collisionLine3.x = x + width;
		collisionLine3.y = y + 10;

		collisionLine4.x = x + 10;
		collisionLine4.y = y + height;

	}

	void draw(Graphics g) {

//		g.setColor(Color.YELLOW);
//		g.fillRect(getCBX(), getCBY(), width, height);

		g.setColor(Color.red);
		g.fillRect(collisionLine1.x, collisionLine1.y, collisionLine1.width, collisionLine1.height);
		g.fillRect(collisionLine2.x, collisionLine2.y, collisionLine2.width, collisionLine2.height);
		g.fillRect(collisionLine3.x, collisionLine3.y, collisionLine3.width, collisionLine3.height);
		g.fillRect(collisionLine4.x, collisionLine4.y, collisionLine4.width, collisionLine4.height);

		
		if (invincible) {
			g.setColor(Color.pink);
			g.fillRect(getCBX(), getCBY(), width, height);
		} else {
			g.setColor(Color.blue);
			g.fillRect(x, y, width, height);
		}
	}

	void jump() {
		yVelocity = -20;
	}
	
	void setX(int newx) {
		x = newx;
	}

	void setY(int newy) {
		y = newy;
	}

	void setPos(int newx, int newy) {
		x = newx;
		y = newy;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	int getCBX() {
		return collisionBox.x;
	}

	int getCBY() {
		return collisionBox.y;
	}

	void setCBPos(int newx, int newy) {
		collisionBox.x = newx;
		collisionBox.y = newy;
	}

	void isIntersecting(boolean change) {
		intersecting = change;
	}

	void isAlive(boolean change) {
		alive = change;
	}

	Rectangle getCollisionBox() {
		return collisionBox;
	}

	void manageDir(int keyPressed, boolean change) {

		if (keyPressed == KeyEvent.VK_UP) {
			UP = change;
		}
		if (keyPressed == KeyEvent.VK_DOWN) {
			DOWN = change;
		}
		if (keyPressed == KeyEvent.VK_LEFT) {
			LEFT = change;
		}
		if (keyPressed == KeyEvent.VK_RIGHT) {
			RIGHT = change;
		}
	}

	public int getSpeed() {
		return speed;
	}

}
