import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Laser extends GameObject implements ActionListener {

	Timer shootingDelay;

	Rectangle laserHitbox;

	boolean shooting;

	Laser(int x, int y, boolean dir) {
		super(x, y);

		laserHitbox = new Rectangle(0, 0, 0, 0);

		width = 25;
		height = 25;

		shootingDelay = new Timer(5000, this);
		shootingDelay.start();
	}

	void draw(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		g.fillRect(x + width / 4, y - 5, width / 2, height);

		g.setColor(Color.red);
		g.fillRect(laserHitbox.x, laserHitbox.y, laserHitbox.width, laserHitbox.height);

	}

	void shoot() {
		laserHitbox = new Rectangle(x + width / 4, y - 5, width/2, 200);
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
