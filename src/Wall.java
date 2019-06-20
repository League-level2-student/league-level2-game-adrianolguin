import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Wall extends GameObject {

	int Vertical = 0;
	int Horizontal = 1;

	int dir;

	int doorScale = 3;

	Wall(int x, int y, int width, int height, int dir) {
		super(x, y, width, height);


		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dir = dir;

		if (dir == Vertical) {

			collisionBox = new Rectangle(x, y, width, height);
			collisionBox.setBounds(collisionBox);

		} else if (dir == Horizontal) {

			collisionBox = new Rectangle(x, y, height, width);
			collisionBox.setBounds(collisionBox);

		}
		
		information = new ObjectInfo(x,y,width,height,speed,"Wall",collisionBox);

	}

	void draw(Graphics g) {

		if (dir == Vertical) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);

		} else if (dir == Horizontal) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, height, width);
		}

	}

	void checkCollisions(Player player) {

	}

	void manageDoor(boolean open) {

	}

}
