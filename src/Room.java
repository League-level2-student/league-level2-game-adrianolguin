import java.awt.Graphics;

public class Room {

	int Verticle = 0;
	int Horizontal = 1;

	int x;
	int y;
	int height;
	int wallWidth;

	Player player;

	Wall[] walls;

	Room(int x, int y, int wallWidth, int height) {

		this.x = x;
		this.y = y;
		this.wallWidth = wallWidth;
		this.height = height;

		walls = new Wall[4];

		walls[0] = new Wall(x, y, wallWidth, height);
		walls[1] = new Wall(x, y, height, wallWidth);
		walls[2] = new Wall(x + height - wallWidth, y, wallWidth, height);
		walls[3] = new Wall(x, y + height - wallWidth, height, wallWidth);
	}

	void draw(Graphics g) {
		for (int j = 0; j < 4; j++) {
			walls[j].draw(g);
		}
	}

}