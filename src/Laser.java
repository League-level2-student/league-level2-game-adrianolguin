import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Laser extends GameObject implements ActionListener {

	ArrayList<EventBox> eventBoxes;
	
	String UP = "up";
	String DOWN = "down";
	String RIGHT = "right";
	String LEFT = "left";

	boolean state = true;
	
	int size, laserLength;
	String direction;
	Rectangle hurtBox;

	Timer shootBuffer;
	boolean shooting = true;

	Laser(int x, int y, int size, int laserLength, String direction) {
		super(x, y);

		eventBoxes = new ArrayList<EventBox>();
		
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
	
	void timerStop() {
		shootBuffer.stop();

	}

	void draw(Graphics g) {

		for(int x = 0; x < eventBoxes.size(); x++) {
		g.setColor(Color.yellow);
		g.fillRect(eventBoxes.get(x).x, eventBoxes.get(x).y, eventBoxes.get(x).width, eventBoxes.get(x).height);
		}
		
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

	void addEventBox(int x, int y, int width, int height, boolean state) {
		EventBox eventBox = new EventBox(x, y, width, height, state);
		eventBoxes.add(eventBox);
	}
	
	
	
}
