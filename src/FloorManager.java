import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FloorManager {

	String UP = "up";
	String DOWN = "down";
	String RIGHT = "right";
	String LEFT = "left";

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

	Room CCCC = new Room(50, 50, sWidth - 50, sHeight - 100, false, false, false, false);
	Room CCOC = new Room(50, 50, sWidth - 50, sHeight - 100, false, false, true, false);
	Room OCCO = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, true);
	Room COCO = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, false, true);
	Room COOC = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);
	Room OCOC = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, true, false);
	Room OCCC = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);

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

			floorCols = 4;
			floorRows = 4;
			spawnX = 200;
			spawnY = 50;
			spawnFloorX = 2;
			spawnFloorY = 0;
			floor = new Room[floorCols][floorRows];

			miniMapRWidth = miniMapWidth / floorCols;
			miniMapRHeight = miniMapHeight / floorRows;

			floor[0][0] = CCOC;
			floor[1][0] = OCOC;
			floor[1][0].walls[2].doorDistance(50);
			floor[2][0] = OCCO;
			floor[2][0].walls[3].doorDistance(850);
			floor[2][0].walls[0].doorDistance(50);
			floor[2][1] = COCO;
			floor[2][2] = COCO;
			floor[2][3] = COOC;
			floor[3][3] = OCCC;

			///

			///
			floor[1][0].insideWalls.add(new Wall(200, 500, 50, 50, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(300, 400, 50, 50, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(200, 300, 50, 50, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(300, 200, 50, 50, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(450, 200, 50, 430, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(750, 200, 190, 50, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(890, 140, 50, 60, false, 0, 0));

			floor[1][0].lasers.add(new Laser(310, 450, 30, 250, LEFT));
			floor[1][0].lasers.add(new Laser(210, 350, 30, 230, RIGHT));
			floor[1][0].lasers.add(new Laser(310, 250, 30, 250, LEFT));
			///
			floor[2][0].insideWalls.add(new Wall(60, 170, 600, 20, false, 0, 0));
			floor[2][0].insideWalls.add(new Wall(60, 140, 50, 50, false, 0, 0));
			floor[2][0].insideWalls.add(new Wall(160, 140, 50, 50, false, 0, 0));
			floor[2][0].insideWalls.add(new Wall(260, 140, 150, 50, false, 0, 0));
			floor[2][0].insideWalls.add(new Wall(460, 140, 100, 50, false, 0, 0));
			floor[2][0].insideWalls.add(new Wall(610, 140, 50, 50, false, 0, 0));

			floor[2][0].insideWalls.add(new Wall(750, 60, 50, 400, false, 0, 0));
			floor[2][0].insideWalls.add(new Wall(175, 320, 625, 30, false, 0, 0));

			//
			floor[2][0].lasers.add(new Laser(760, 110, 25, 700, LEFT));
			floor[2][0].lasers.get(0).shootBuffer.setDelay(500);
			floor[2][0].lasers.get(0).addEventBox(660, 150, 90, 45, false);
			floor[2][0].lasers.add(new Laser(45, 250, 25, 680, RIGHT));
			floor[2][0].lasers.get(1).shootBuffer.setDelay(1250);
			floor[2][0].lasers.get(1).addEventBox(60, 325, 115, 45, false);
			//
			floor[2][0].spikeStrips.add(new spikeStrip(500, 295, 110, 25, 5));
			floor[2][0].spikeStrips.add(new spikeStrip(290, 295, 110, 25, 5));
			//
			

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
			floor[2][1].walls[1].doorDistance = 20;
			floor[2][1].walls[1].initializeDoor();

			floor[2][2] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, false, true);
			floor[2][3] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);
			floor[3][3] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);

		} else if (presetNum == 3) {
			floorCols = 2;
			floorRows = 2;
			floor = new Room[floorCols][floorRows];
			spawnFloorX = 1;
			spawnFloorY = 1;

			miniMapRWidth = miniMapWidth / floorCols;
			miniMapRHeight = miniMapHeight / floorRows;

			floor[0][0] = new Room(50, 50, sWidth - 50, sHeight - 100, false, false, true, true);
			floor[1][0] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);
			floor[1][1] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, false);
			floor[0][1] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, true, false);

			// spawnX = floor[spawnFloorX][spawnFloorY].walls[2].x - p.width - 20;
			spawnY = floor[spawnFloorX][spawnFloorY].walls[3].y - p.height;
			spawnX = 110;

			////////////////////////////////////////////////////////////////////////////////////////////////////////

			int room00x = floor[0][0].walls[2].x - p.width - 20;
			int room00y = floor[0][0].walls[3].y - p.height;

			int room10x = floor[0][0].walls[2].x - p.width - 20;
			int room10y = floor[0][0].walls[3].y - p.height;

			int room01x = floor[0][1].walls[1].door.x;
			int room01y = floor[0][1].walls[1].door.y + floor[0][1].walls[1].door.height + 10;

			int room11x = 60;
			int room11y = 60;

			floor[1][0].insideWalls.add(new Wall(room00x - 200, room00y + p.height - 100, 35, 75, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(room00x - 300, room00y + p.height - 200, 35, 175, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(room00x - 400, room00y + p.height - 300, 35, 300, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(125, room00y + p.height - 300, 375, 35, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(50, room00y + p.height - 200, 375, 35, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(125, room00y + p.height - 100, 375, 35, false, 0, 0));

			////////////////////////////////////////////////////////////////////////////////////////////////////////

			floor[0][0].insideWalls.add(new Wall(room10x - 200, room10y + p.height - 250, 35, 250, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(room10x - 175, room10y + p.height - 100, 85, 30, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(room10x - 45, room10y + p.height - 220, 85, 30, false, 0, 0));

			floor[0][0].insideWalls.add(new Wall(room10x - 450, room10y + p.height - 250, 35, 250, false, 0, 0));

			floor[0][0].insideWalls.add(new Wall(room10x - 555, room10y + p.height - 500, 35, 250, false, 0, 0));

			floor[0][0].insideWalls.add(new Wall(room10x - 660, room10y + p.height - 250, 35, 70, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(room10x - 660, room10y + p.height - 145, 35, 145, false, 0, 0));

			////////////////////////////////////////////////////////////////////////////////////////////////////////

			floor[0][1].insideWalls.add(new Wall(room01x + 500, room01y - 10, 35, 420, false, 0, 0));

			floor[0][1].insideWalls.add(new Wall(room01x, room01y + 175, 450, 35, false, 0, 0));
			floor[0][1].insideWalls.add(new Wall(room01x + 50, room01y + 375, 450, 35, false, 0, 0));
			floor[0][1].insideWalls.add(new Wall(room01x, room01y + 520, 800, 40, false, 0, 0));

			////////////////////////////////////////////////////////////////////////////////////////////////////////

			floor[1][1].insideWalls.add(new Wall(room11x + 250, room11y + 120, 40, 450, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(room11x + 100, room11y, 40, 450, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(room11x + 400, room11y + 120, 50, 40, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(room11x + 550, room11y + 120, 50, 40, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(room11x + 700, room11y + 120, 50, 40, false, 0, 0));

			////////////////////////////////////////////////////////////////////////////////////////////////////////

		}

	}

	Room getRoom(int x, int y) {
		return floor[x][y];
	}
	
	void spikeStrip(Rectangle r, int spikeAmount) {
	int amount = r.width/spikeAmount;
	for(int x = 0; x < amount; x++) {
		
	}
	}

}
