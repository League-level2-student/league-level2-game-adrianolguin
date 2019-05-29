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

		if (dir == Vertical) {
			if (player.x + player.width == x && (player.y <= y + height && player.y >= y)) {
				// player.manageDir(KeyEvent.VK_RIGHT, false);
				player.x -= player.speed;

			} else if (player.x == x + width && (player.y <= y + height && player.y >= y)) {
				// player.manageDir(KeyEvent.VK_LEFT, false);
				player.x += player.speed;

			}

			if (player.y == y - width && (player.x + player.width >= x && player.x <= x)) {
				// player.manageDir(KeyEvent.VK_DOWN, false);
				player.y -= player.speed;

			} else if (player.y == y + height && (player.x + player.width >= x && player.x <= x)) {
				// player.manageDir(KeyEvent.VK_UP, false);\
				player.y += player.speed;

			}
		} else if (dir == Horizontal) {

			if (player.y == y - width && (player.x <= x + height && player.x >= x)) {
				// player.manageDir(KeyEvent.VK_DOWN, false);
				player.y -= player.speed;

			} else if (player.y == y + width && (player.x <= x + height && player.x >= x)) {
				// player.manageDir(KeyEvent.VK_UP, false);
				player.y += player.speed;

			}

			if (player.x == x - width && (player.y + player.width >= y && player.y <= y)) {
				// player.manageDir(KeyEvent.VK_RIGHT, false);
				player.x -= player.speed;

			} else if (player.x == x + height && (player.y + player.width >= y && player.y <= y)) {
				// player.manageDir(KeyEvent.VK_LEFT, false);
				player.x += player.speed;

			}

		}

	}

	void manageDoor(boolean open) {

	}

}
