import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class FloorManager {


	FloorManager() {

	}

	void createFloor(boolean[][] info) {

		Room[][] floor = new Room[info.length][info[0].length];
		
		for (int i = 0; i < floor.length; i++) {
			for (int j = 0; j < floor[0].length; j++) {

				if (info[i][j]) {
					floor[i][j] = new Room(i * 10, j * 10, 100, 100, false, false, false, false);
				} else {

				}

			}
		}

	}

}
