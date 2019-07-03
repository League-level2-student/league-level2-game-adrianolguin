import java.awt.Color;
import java.awt.Graphics;

public class Room {

	Wall[] walls;

	int wallWidth = 10;

	int x;
	int y;
	int width;
	int height;

	boolean door1;
	boolean door2;
	boolean door3;
	boolean door4;
	
	Room(int x, int y, int width, int height, boolean door1, boolean door2, boolean door3, boolean door4) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		walls = new Wall[4];

		walls[0] = new Wall(x, y, wallWidth, height, door1);
		walls[1] = new Wall(x, y, width, wallWidth, door2);
		walls[2] = new Wall(x + width - wallWidth, y, wallWidth, height, door3);
		walls[3] = new Wall(x, y + height - wallWidth, width, wallWidth, door4);

	}

	void draw(Graphics g) {

		for (int x = 0; x < 4; x++) {
			walls[x].draw(g);
		}

	}

}
