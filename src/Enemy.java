
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject {

	boolean canLeft = true;
	boolean canRight = true;
	boolean canUp = true;
	boolean canDown = true;

	int attackBuffer;

	int px, py;

	Player player;

	Rectangle collisionLine1;
	Rectangle collisionLine2;
	Rectangle collisionLine3;
	Rectangle collisionLine4;

	Enemy(int x, int y, Player player) {
		super(x, y);

		speed = 1;

		this.player = player;

		px = player.x + player.width / 2;
		py = player.y + player.height / 2;

		width = 10;
		height = 10;

		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);

		collisionLine1 = new Rectangle(x - 6, y + width / 2, 6, 1);
		collisionLine3 = new Rectangle(x + width - 1, y + width / 2, 6, 1);
		collisionLine2 = new Rectangle(x + height / 2, y - 6, 1, 6);
		collisionLine4 = new Rectangle(x + height / 2, y + height, 1, 6);

		collisionLine1.setBounds(collisionLine1);
		collisionLine2.setBounds(collisionLine2);
		collisionLine3.setBounds(collisionLine3);
		collisionLine4.setBounds(collisionLine4);

	}

	void update() {
		super.update();

		collisionLine1 = new Rectangle(x - 6, y + width / 2, 6, 1);
		collisionLine3 = new Rectangle(x + width, y + width / 2, 6, 1);
		collisionLine2 = new Rectangle(x + height / 2, y - 6, 1, 6);
		collisionLine4 = new Rectangle(x + height / 2, y + height, 1, 6);

		collisionLine1.setBounds(collisionLine1);
		collisionLine2.setBounds(collisionLine2);
		collisionLine3.setBounds(collisionLine3);
		collisionLine4.setBounds(collisionLine4);

		attackBuffer = player.width * 4;

		px = player.x + player.width / 2;
		py = player.y + player.height / 2;

		attack();

		x = collisionBox.x;
		y = collisionBox.y;

	}

	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);

		g.fillRect(collisionLine1.x, collisionLine1.y, collisionLine1.width, collisionLine1.height);
		g.fillRect(collisionLine2.x, collisionLine2.y, collisionLine2.width, collisionLine2.height);
		g.fillRect(collisionLine3.x, collisionLine3.y, collisionLine3.width, collisionLine3.height);
		g.fillRect(collisionLine4.x, collisionLine4.y, collisionLine4.width, collisionLine4.height);

	}

	void setX(int newx) {
		x = newx;
	}

	void setY(int newy) {
		y = newy;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	Rectangle getCollisionBox() {
		return collisionBox;
	}

	void attack() {

		if (collisionBox.x < px && canRight) {
			if (Math.abs(collisionBox.x - px) >= attackBuffer) {
				collisionBox.x += speed;
			}
		} else if (collisionBox.x > px && canLeft) {
			if (Math.abs(collisionBox.x - px) >= attackBuffer) {
				collisionBox.x -= speed;
			}
		}

		if (collisionBox.y < py && canDown) {
			if (Math.abs(collisionBox.y - py) >= attackBuffer) {
				collisionBox.y += speed;
			}
		} else if (collisionBox.y > py && canUp) {
			if (Math.abs(collisionBox.y - py) >= attackBuffer) {
				collisionBox.y -= speed;
			}
		}
	}

	int getSpeed() {
		return speed;
	}

	void setCBPos(int newx, int newy) {
		x = newx;
		y = newy;
	}
}
