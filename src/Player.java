import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameObject {

	boolean UP;
	boolean DOWN;
	boolean LEFT;
	boolean RIGHT;

	Player(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		if (canMove) {
			if (UP) {
				y -= speed;
			}
			if (DOWN) {
				y += speed;
			}
			if (LEFT) {
				x -= speed;
			}
			if (RIGHT) {
				x += speed;
			}
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
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

}
