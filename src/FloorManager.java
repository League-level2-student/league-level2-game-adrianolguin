
public class FloorManager {

	int floorX;
	int floorY;
	
	Room[][] floor;

	FloorManager(int cols, int rows) {

		floor = new Room[cols][rows];

	}

	void setRoom(int x, int y, Room r) {

		floor[x][y] = r;

	}

	Room getRoom(int x, int y) {

		return floor[x][y];
	}

	void setX(int x) {
		floorX = x;
	}
	
	void setY(int y) {
		floorY = y;
	}
	
	void setPos(int x, int y) {
		floorX = x;
		floorY = y;
	}
	
}
