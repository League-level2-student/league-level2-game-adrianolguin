import java.awt.Color;
import java.awt.Graphics;

public class FloorManager {

	int spawnFloorX;
	int spawnFloorY;
	int spawnX;
	int spawnY;

	int sWidth = Evolution.width - 250;
	int sHeight = Evolution.height;

	int impassable = 40;

	Room[][] floor;
	int floorCols;
	int floorRows;

	int miniMapWidth = 150;
	int miniMapHeight = 150;
	int miniMapRWidth;
	int miniMapRHeight;
	int miniMapX = sWidth + 70;
	int miniMapY = 25;
	int miniMapOffset = 5;

	int pX;
	int pY;

	Room CCOC = new Room(50, 50, sWidth - 50, sHeight - 100, false, false, true, false);
	Room OCCO = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, true);
	Room COCO = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, false, true);
	Room COOC = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);

	Player p;

	FloorManager(int preset, Player p) {

		this.p = p;

		loadPreset(preset);

	}

	void drawMiniMap(Graphics g) {

		for (int i = 0; i < floorCols; i++) {
			for (int j = 0; j < floorRows; j++) {
				if (floor[i][j] != null) {
					g.setColor(Color.white);
					g.fillRect(miniMapX + i * miniMapRWidth, miniMapY + j * miniMapRHeight, miniMapRWidth,
							miniMapRHeight);
					g.setColor(Color.black);
					g.fillRect(miniMapX + miniMapOffset + i * miniMapRWidth,
							miniMapY + miniMapOffset + j * miniMapRHeight, miniMapRWidth - miniMapOffset * 2,
							miniMapRHeight - miniMapOffset * 2);

				}
			}
		}

		g.setColor(Color.red);
		g.fillRect(miniMapX + pX * miniMapRWidth + (miniMapRWidth / 8 * 3),
				miniMapY + pY * miniMapRHeight + (miniMapRHeight / 8 * 3), miniMapRWidth / 4, miniMapRHeight / 4);

	}

	void loadPreset(int presetNum) {

		if (presetNum == 1) {

			floorCols = 3;
			floorRows = 3;
			spawnX = 0;
			spawnY = 0;
			floor = new Room[floorCols][floorRows];

			miniMapRWidth = miniMapWidth / floorCols;
			miniMapRHeight = miniMapHeight / floorRows;

			floor[0][0] = CCOC;
			floor[1][0] = OCCO;
			floor[1][1] = COCO;
			floor[1][2] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);
			floor[2][2] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);

		} else if (presetNum == 2) {

			floorCols = 4;
			floorRows = 4;
			spawnX = 500;
			spawnY = 500;
			floor = new Room[floorCols][floorRows];

			miniMapRWidth = miniMapWidth / floorCols;
			miniMapRHeight = miniMapHeight / floorRows;

			floor[0][0] = new Room(50, 50, sWidth - 50, sHeight - 100, false, false, false, true);
			floor[0][1] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);
			floor[1][1] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, true, false);
			floor[2][1] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, true);
			floor[2][2] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, false, true);
			floor[2][3] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);
			floor[3][3] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);

			floor[0][0].lasers.add(new Laser(200, 200, false, 400));

		} else if (presetNum == 3) {
			floorCols = 2;
			floorRows = 2;
			floor = new Room[floorCols][floorRows];
			spawnFloorX = 0;
			spawnFloorY = 0;

			miniMapRWidth = miniMapWidth / floorCols;
			miniMapRHeight = miniMapHeight / floorRows;

			floor[0][0] = new Room(50, 50, sWidth - 50, sHeight - 100, false, false, true, true);
			floor[1][0] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);
			floor[1][1] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);
			floor[0][1] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);

			spawnX = floor[spawnFloorX][spawnFloorY].walls[2].x - p.width - 20;
			spawnY = floor[spawnFloorX][spawnFloorY].walls[3].y - p.height;
			////////////////////////////////////////////////////////////////////////////////////////////////////////

			floor[1][0].insideWalls.add(new Wall(spawnX - 200, spawnY + p.height - 100, 35, 75, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(spawnX - 300, spawnY + p.height - 200, 35, 175, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(spawnX - 400, spawnY + p.height - 300, 35, 300, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(125, spawnY + p.height - 300, 375, 35, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(50, spawnY + p.height - 200, 375, 35, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(125, spawnY + p.height - 100, 375, 35, false, 0, 0));

			////////////////////////////////////////////////////////////////////////////////////////////////////////

			floor[0][0].insideWalls.add(new Wall(spawnX - 200, spawnY + p.height - 250, 35, 250, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(spawnX - 175, spawnY + p.height - 100, 85, 30, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(spawnX - 45, spawnY + p.height - 220, 85, 30, false, 0, 0));

			floor[0][0].insideWalls.add(new Wall(spawnX - 430, spawnY + p.height - 250, 35, 250, false, 0, 0));

			floor[0][0].insideWalls.add(new Wall(spawnX - 545, spawnY + p.height - 500, 35, 250, false, 0, 0));

			floor[0][0].insideWalls.add(new Wall(spawnX - 660, spawnY + p.height - 250, 35, 250, false, 0, 0));

			////////////////////////////////////////////////////////////////////////////////////////////////////////

			////////////////////////////////////////////////////////////////////////////////////////////////////////

			////////////////////////////////////////////////////////////////////////////////////////////////////////

		}

	}

	Room getRoom(int x, int y) {
		return floor[x][y];
	}

}
