import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class FloorManager {

	ArrayList<Room> floor = new ArrayList<Room>();

	Random random;

	Player p;

	FloorManager(Player p) {

		this.p = p;
		random = new Random();
	}

	void createFloor() {

		floor.add(new Room(100, 100, 200, 200, false, false, false, true));

	}

	void startChallenge(Room r) {

		int numEnemies = random.nextInt(5) + 1;

		Rectangle area = new Rectangle(r.x + r.wallWidth, r.y + r.wallWidth, r.width - r.wallWidth,
				r.height - r.wallWidth);

	}

	void draw(Graphics g) {

		for (int x = 0; x < floor.size(); x++) {
			floor.get(x).draw(g);
		}

	}

}
