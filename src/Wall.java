import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameObject {

	Rectangle door;

	int doorSize = 20;

	boolean hasDoor;

	Wall(int x, int y, int width, int height, boolean hasDoor) {
		super(x, y);

		this.width = width;
		this.height = height;

		this.hasDoor = hasDoor;

		if (hasDoor) {
			if (height > width) {
				if (height % 2 == 0) {
					door = new Rectangle(x, y + (height / 2 - doorSize / 2), width, doorSize);
				} else {
					door = new Rectangle(x, y + (height + 1) / 2 - ((doorSize / 2) + 1), width, doorSize + 1);
				}
			} else {
				if (width % 2 == 0) {
					door = new Rectangle(x + (width / 2 - doorSize / 2), y, doorSize, height);
				} else {
					door = new Rectangle(x + (width + 1) / 2 - ((doorSize / 2) + 1), y, doorSize, height);
				}
			}
			door.setBounds(door);

		} else {
			door = new Rectangle(0, 0, 0, 0);
		}

		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);

	}

	void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);

		g.setColor(Color.green);
		g.fillRect(door.x, door.y, door.width, door.height);

		
	}

	void doorSize(int num) {

		doorSize = num;

		initializeDoor();

	}

	void initializeDoor() {

		if (hasDoor) {

			if (height > width) {
				if (height % 2 == 0) {
					door = new Rectangle(x, y + (height / 2 - doorSize / 2), width, doorSize);
				} else {
					door = new Rectangle(x, y + (height + 1) / 2 - ((doorSize / 2) + 1), width, doorSize + 1);
				}
			} else {
				if (width % 2 == 0) {
					door = new Rectangle(x + (width / 2 - doorSize / 2), y, doorSize, height);
				} else {
					door = new Rectangle(x + (width + 1) / 2 - ((doorSize / 2) + 1), y, doorSize + 1, height);
				}
			}
			door.setBounds(door);
		} else {
			door = new Rectangle(0, 0, 0, 0);
		}

	}

	void openDoor() {

		if (height > width) {
			if (height % 2 == 0) {
				door = new Rectangle(x, y + (height / 2 - doorSize / 2), width, doorSize);
			} else {
				door = new Rectangle(x, y + (height + 1) / 2 - ((doorSize / 2) + 1), width, doorSize + 1);
			}
		} else {
			if (width % 2 == 0) {
				door = new Rectangle(x + (width / 2 - doorSize / 2), y, doorSize, height);
			} else {
				door = new Rectangle(x + (width + 1) / 2 - ((doorSize / 2) + 1), y, doorSize + 1, height);
			}
		}
		door.setBounds(door);

	}

	void closeDoor() {

		door = new Rectangle(0, 0, 0, 0);

	}

}
