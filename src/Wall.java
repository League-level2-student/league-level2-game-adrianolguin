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

	Wall(int x, int y, int width, int height, int dir) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dir = dir;

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
