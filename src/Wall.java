import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Wall {

	int Vertical = 0;
	int Horizontal = 1;

	int x;
	int y;
	int height;
	int width;
	int dir;

	int test = 5;

	int doorScale = 3;

	Rectangle collisionBox;

	Rectangle collisionLine1;
	Rectangle collisionLine2;
	Rectangle collisionLine3;
	Rectangle collisionLine4;

	Wall(int x, int y, int width, int height, int dir) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dir = dir;

		if (dir == Vertical) {

			this.collisionBox = new Rectangle(x, y, width, height);

			this.collisionLine1 = new Rectangle(x, y, 1, height);
			this.collisionLine3 = new Rectangle(x + width - 1, y, 1, height);

			this.collisionLine2 = new Rectangle(x, y, width, 1);
			this.collisionLine4 = new Rectangle(x, y + height - 1, width, 1);

		} else if (dir == Horizontal) {

			this.collisionBox = new Rectangle(x, y, height, width);

			this.collisionLine1 = new Rectangle(x, y, 1, width);
			this.collisionLine3 = new Rectangle(x + height - 1, y, 1, width);

			this.collisionLine2 = new Rectangle(x, y, height, 1);
			this.collisionLine4 = new Rectangle(x, y + width - 1, height, 1);

		}
		collisionBox.setBounds(collisionBox);
		collisionLine1.setBounds(collisionLine1);
		collisionLine2.setBounds(collisionLine2);
		collisionLine3.setBounds(collisionLine3);
		collisionLine4.setBounds(collisionLine4);

	}

	void draw(Graphics g) {

		if (dir == Vertical) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);

			g.setColor(Color.GREEN);
			g.fillRect(collisionLine1.x, collisionLine1.y, collisionLine1.width, collisionLine1.height);
			g.fillRect(collisionLine2.x, collisionLine2.y, collisionLine2.width, collisionLine2.height);
			g.fillRect(collisionLine3.x, collisionLine3.y, collisionLine3.width, collisionLine3.height);
			g.fillRect(collisionLine4.x, collisionLine4.y, collisionLine4.width, collisionLine4.height);

		} else if (dir == Horizontal) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, height, width);

			g.setColor(Color.GREEN);
			g.fillRect(collisionLine1.x, collisionLine1.y, collisionLine1.width, collisionLine1.height);
			g.fillRect(collisionLine2.x, collisionLine2.y, collisionLine2.width, collisionLine2.height);
			g.fillRect(collisionLine3.x, collisionLine3.y, collisionLine3.width, collisionLine3.height);
			g.fillRect(collisionLine4.x, collisionLine4.y, collisionLine4.width, collisionLine4.height);
		}

	}

	void checkCollisions(Player player) {

	}

	void manageDoor(boolean open) {

	}

}
