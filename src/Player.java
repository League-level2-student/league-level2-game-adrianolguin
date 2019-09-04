import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends GameObject {

	int yVelocity = 0;

	int xVelocity = 0;
	
	
	
	Player(int x, int y) {
		super(x, y);

		health = 20;

		speed = 5;

		width = 20;
		height = 20;

		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);

	}

	void update() {

		super.update();

		yVelocity += Evolution.panel.gravity;
		y += yVelocity;

		x += xVelocity;
		
		if(!LEFT || !RIGHT) {
			xVelocity = 0;
		}
		
		if (UP) {
			y -= speed;
		}
//		if (DOWN) {
//			y += speed;
//		}
		if (LEFT) {
			xVelocity = -speed;
		}
		if (RIGHT) {
			xVelocity = speed;
		}


	}

	void draw(Graphics g) {

		// g.setColor(Color.YELLOW);
		// g.fillRect(getCBX(), getCBY(), width, height);

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
