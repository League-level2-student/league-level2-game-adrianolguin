import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Laser extends GameObject implements ActionListener {

	String UP = "up";
	String DOWN = "down";
	String RIGHT = "right";
	String LEFT = "left";

	int size, laserLength;
	String direction;
	Rectangle hurtBox;

	Timer shootBuffer;
	boolean shooting = true;

	Laser(int x, int y, int size, int laserLength, String direction) {
		super(x, y);

		shootBuffer = new Timer(1500, this);

		this.size = size;
		this.direction = direction;
		this.laserLength = laserLength;

		if (direction.equals(UP)) {
			hurtBox = new Rectangle(x, y - laserLength, size, laserLength);
		} else if (direction.equals(DOWN)) {
			hurtBox = new Rectangle(x, y + size, size, laserLength);
		} else if (direction.equals(RIGHT)) {
			hurtBox = new Rectangle(x + size, y, laserLength, size);
		} else if (direction.equals(LEFT)) {
			hurtBox = new Rectangle(x - laserLength, y, laserLength, size);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (shooting) {
			stop();
		} else {
			shoot();
		}

	}

	void timerStart() {
		shootBuffer.start();
	}

	void draw(Graphics g) {

		g.setColor(Color.GRAY);
		g.fillRect(x, y, size, size);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, size - 1, size - 1);

		g.setColor(Color.RED);
		g.fillRect(hurtBox.x, hurtBox.y, hurtBox.width, hurtBox.height);

	}

	void stop() {
		hurtBox = new Rectangle(0, 0, 0, 0);
		shooting = false;
	}

	void shoot() {
		if (direction.equals(UP)) {
			hurtBox = new Rectangle(x, y - laserLength, size, laserLength);
		} else if (direction.equals(DOWN)) {
			hurtBox = new Rectangle(x, y + size, size, laserLength);
		} else if (direction.equals(RIGHT)) {
			hurtBox = new Rectangle(x + size, y, laserLength, size);
		} else if (direction.equals(LEFT)) {
			hurtBox = new Rectangle(x - laserLength, y, laserLength, size);
		}
		shooting = true;
	}

}
