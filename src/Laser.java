import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Laser extends GameObject implements ActionListener {

	boolean UP = true;
	boolean DOWN = false;

	Timer shootingDelay;

	Rectangle laserHitbox;

	boolean shooting;

	boolean dir;

	int laserLength;

	Laser(int x, int y, boolean dir, int laserLength) {
		super(x, y);
		this.dir = dir;
		this.laserLength = laserLength;

		laserHitbox = new Rectangle(0, 0, 0, 0);

		width = 25;
		height = 25;

		shootingDelay = new Timer(1000, this);
		shootingDelay.start();
	}

	void draw(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		if (dir == UP) {
			g.fillRect(x + width / 4, y - 5, width / 2, height);
		} else if (dir == DOWN) {
			g.fillRect(x + width / 4, y + height, width / 2, 5);
		}
		g.setColor(Color.red);
		g.fillRect(laserHitbox.x, laserHitbox.y, laserHitbox.width, laserHitbox.height);

	}

	void shoot() {

		if (dir == UP) {
			laserHitbox = new Rectangle(x + width / 4, y - 5 - laserLength, width / 2, laserLength);
		} else if (dir == DOWN) {
			laserHitbox = new Rectangle(x + width / 4, y + height + 5, width / 2, laserLength);
		}
	}

	void stopShooting() {
		laserHitbox = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (!shooting) {
			shoot();
			shooting = true;
		} else {
			stopShooting();
			shooting = false;
		}
	}

}
