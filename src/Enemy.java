
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject {

	Enemy(int x, int y) {
		super(x, y);

		width = 10;
		height = 10;

		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);
	}

	void update() {
		super.update();

		
		
		x = collisionBox.x;
		y = collisionBox.y;
		
	}

	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
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

}
