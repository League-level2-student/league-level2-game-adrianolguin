import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameObject {

	int doorDistance;

	Rectangle door;

	int doorSize;

	boolean hasDoor;

	Rectangle jumpableArea;
	int jumpableAreaSize = 1;

	Wall(int x, int y, int width, int height, boolean hasDoor, int doorDistance, int doorSize) {
		super(x, y);

		this.doorSize = doorSize;
		this.width = width;
		this.height = height;
		this.doorDistance = doorDistance;
		this.hasDoor = hasDoor;

		if (hasDoor) {
			if (height > width) {

				door = new Rectangle(x, y + doorDistance, width, doorSize);

			} else {

				door = new Rectangle(x + doorDistance, y, doorSize, height);

			}
			door.setBounds(door);

		} else {
			door = new Rectangle(0, 0, 0, 0);
		}

		jumpableArea = new Rectangle(x - jumpableAreaSize, y + 15, width + jumpableAreaSize * 2, height - 15);

		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);

	}

	void draw(Graphics g) {

//		g.setColor(Color.CYAN);
//		g.fillRect(jumpableArea.x, jumpableArea.y, jumpableArea.width, jumpableArea.height);

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

				door = new Rectangle(x, y + doorDistance, width, doorSize);

			} else {

				door = new Rectangle(x + doorDistance, y, doorSize, height);

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
	
	void doorDistance(int distance) {
	doorDistance = distance;
	initializeDoor();
	}

	void closeDoor() {

		door = new Rectangle(0, 0, 0, 0);

	}

}
