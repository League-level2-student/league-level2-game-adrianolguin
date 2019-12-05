import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Room {

	Wall[] walls;

	int wallWidth = 10;

	int doorSize = 40;

	int x;
	int y;
	int width;
	int height;

	boolean door1;
	boolean door2;
	boolean door3;
	boolean door4;

	int[] test;

	ArrayList<Wall> insideWalls;
	ArrayList<Laser> lasers;
	ArrayList<spikeStrip> spikeStrips;
	ArrayList<ActionBarrier> events;

	Room(int x, int y, int width, int height, boolean door1, boolean door2, boolean door3, boolean door4) {

		test = new int[3];

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		insideWalls = new ArrayList<Wall>();

		lasers = new ArrayList<Laser>();

		spikeStrips = new ArrayList<spikeStrip>();
		
		events = new ArrayList<ActionBarrier>();
		
		walls = new Wall[4];

		walls[0] = new Wall(x, y, wallWidth, height, door1, height - wallWidth - doorSize, doorSize);
		walls[1] = new Wall(x, y, width, wallWidth, door2, wallWidth, doorSize);
		walls[2] = new Wall(x + width - wallWidth, y, wallWidth, height, door3, height - wallWidth - doorSize,
				doorSize);
		walls[3] = new Wall(x, y + height - wallWidth, width, wallWidth, door4, 20, doorSize);

	}

	void draw(Graphics g) {
		for (int x = 0; x < insideWalls.size(); x++) {
			insideWalls.get(x).draw(g);
		}

		for (int x = 0; x < 4; x++) {
			walls[x].draw(g);
		}
		
		for (int x = 0; x < lasers.size(); x++) {
			lasers.get(x).draw(g);
		}
		
		for(int x = 0; x < spikeStrips.size(); x++) {
			spikeStrips.get(x).draw(g);
		}

	}

	void updateContents() {
		//
		// for (int x = 0; x < containing.size(); x++) {
		// containing.get(x).update();
		// }

	}

}
