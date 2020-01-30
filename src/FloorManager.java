import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FloorManager {

	String modeKey;
	
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
			spawnFloorX = 1;
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

			floor[1][0].lasers.add(new Laser(310, 450, 30, 250, LEFT, true));
			floor[1][0].lasers.add(new Laser(210, 350, 30, 230, RIGHT, true));
			floor[1][0].lasers.add(new Laser(310, 250, 30, 250, LEFT, true));
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
			floor[2][0].lasers.add(new Laser(760, 110, 25, 700, LEFT, false));
			floor[2][0].lasers.get(0).shootBuffer.setDelay(500);
			floor[2][0].lasers.get(0).addEventBox(100, 100, 100, 100, true, false);
			floor[2][0].lasers.get(0).addEventBox(660, 150, 90, 45, false, true);

			floor[2][0].lasers.add(new Laser(45, 250, 25, 680, RIGHT, false));
			floor[2][0].lasers.get(1).shootBuffer.setDelay(1250);
			floor[2][0].lasers.get(1).addEventBox(660, 150, 90, 45, true, false);
			floor[2][0].lasers.get(1).addEventBox(60, 325, 115, 45, false, true);
			//
			floor[2][0].spikeStrips.add(new spikeStrip(500, 295, 110, 25, 5));
			floor[2][0].spikeStrips.add(new spikeStrip(290, 295, 110, 25, 5));
			//

		} else if (presetNum == 2) {

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

		} else if (presetNum == 4) {
			floorCols = 4;
			floorRows = 4;
			spawnX = 90;
			spawnY = 600;
			spawnFloorX = 0;
			spawnFloorY = 0;
			floor = new Room[floorCols][floorRows];

			miniMapRWidth = miniMapWidth / floorCols;
			miniMapRHeight = miniMapHeight / floorRows;

			floor[0][0] = new Room(50, 50, sWidth - 50, sHeight - 100, false, false, true, false);
			floor[0][0].setModeKey("zero-zero");
			floor[1][0] = new Room(50, 50, sWidth - 50, sHeight - 100, true, false, false, true);
			floor[1][0].setModeKey("one-zero");

			floor[1][0].walls[3].doorDistance(750);
			floor[1][0].walls[3].doorSize(140);

			floor[1][1] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, false, true);
			floor[1][1].setModeKey("one-one");
			floor[1][1].walls[1].doorDistance(750);
			floor[1][1].walls[1].doorSize(140);
			floor[1][1].walls[3].doorDistance(10);
			floor[1][1].walls[3].doorSize(90);

			floor[1][2] = new Room(50, 50, sWidth - 50, sHeight - 100, false, true, false, false);
			floor[1][2].walls[1].doorSize(90);
			floor[1][2].setModeKey("one-two");

			//
			floor[0][0].insideWalls.add(new Wall(50 + 100, 50 + 480 + 15, 50, 85, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(50 + 300, 50 + 480 + 15, 50, 85, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(50 + 400, 50 + 480 + 15 - 40, 100, 85 + 40, false, 0, 0));
			floor[0][0].insideWalls.add(new Wall(50 + 676, 50 + 480 + 15 - 40, 100, 85 + 40, false, 0, 0));

			floor[0][0].spikeStrips.add(new spikeStrip(50 + 400 + 100, 600 - 10, 175, 40, 6));
			//
			floor[1][0].insideWalls.add(new Wall(600, 50, 50, 500, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(125, 575, 50, 65, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(750, 180, 50, 450, false, 0, 0));
			floor[1][0].insideWalls.add(new Wall(800, 400, 75, 30, false, 0, 0));

			floor[1][0].lasers.add(new Laser(200, 620, 20, 560, UP, false));
			floor[1][0].lasers.add(new Laser(325, 620, 20, 560, UP, false));
			floor[1][0].lasers.get(1).shootBuffer.setDelay(900);
			floor[1][0].lasers.add(new Laser(325 + 40, 620, 20, 560, UP, false));
			floor[1][0].lasers.get(2).shootBuffer.setDelay(900);
			floor[1][0].lasers.add(new Laser(325 + 80, 620, 20, 560, UP, false));
			floor[1][0].lasers.get(3).shootBuffer.setDelay(900);
			floor[1][0].lasers.add(new Laser(325 + 120, 620, 20, 560, UP, false));
			floor[1][0].lasers.get(4).shootBuffer.setDelay(900);
			floor[1][0].lasers.add(new Laser(570, 620, 20, 560, UP, false));
			floor[1][0].lasers.add(new Laser(790, 250, 20, 130, RIGHT, false));
			floor[1][0].lasers.add(new Laser(790, 290, 20, 130, RIGHT, false));
			floor[1][0].lasers.add(new Laser(790, 330, 20, 130, RIGHT, false));
			floor[1][0].lasers.add(new Laser(930, 480, 20, 130, LEFT, false));
			floor[1][0].lasers.add(new Laser(930, 520, 20, 130, LEFT, false));
			floor[1][0].lasers.add(new Laser(930, 560, 20, 130, LEFT, false));

			floor[1][0].lasers.get(0).addEventBox(110, 580, 50, 50, true, false);
			floor[1][0].lasers.get(1).addEventBox(110, 580, 50, 50, true, false);
			floor[1][0].lasers.get(2).addEventBox(110, 580, 50, 50, true, false);
			floor[1][0].lasers.get(3).addEventBox(110, 580, 50, 50, true, false);
			floor[1][0].lasers.get(4).addEventBox(110, 580, 50, 50, true, false);
			floor[1][0].lasers.get(5).addEventBox(110, 580, 50, 50, true, false);

			floor[1][0].lasers.get(0).addEventBox(600, 580, 50, 50, false, false);
			floor[1][0].lasers.get(1).addEventBox(600, 580, 50, 50, false, false);
			floor[1][0].lasers.get(2).addEventBox(600, 580, 50, 50, false, false);
			floor[1][0].lasers.get(3).addEventBox(600, 580, 50, 50, false, false);
			floor[1][0].lasers.get(4).addEventBox(600, 580, 50, 50, false, false);
			floor[1][0].lasers.get(5).addEventBox(600, 580, 50, 50, false, false);

			floor[1][0].lasers.get(6).addEventBox(600, 580, 50, 50, true, false);
			floor[1][0].lasers.get(7).addEventBox(600, 580, 50, 50, true, false);
			floor[1][0].lasers.get(8).addEventBox(600, 580, 50, 50, true, false);
			floor[1][0].lasers.get(9).addEventBox(600, 580, 50, 50, true, false);
			floor[1][0].lasers.get(10).addEventBox(600, 580, 50, 50, true, false);
			floor[1][0].lasers.get(11).addEventBox(600, 580, 50, 50, true, false);

			floor[1][0].lasers.get(6).addEventBox(800, 600, 140, 30, false, false);
			floor[1][0].lasers.get(7).addEventBox(800, 600, 140, 30, false, false);
			floor[1][0].lasers.get(8).addEventBox(800, 600, 140, 30, false, false);
			floor[1][0].lasers.get(9).addEventBox(800, 600, 140, 30, false, false);
			floor[1][0].lasers.get(10).addEventBox(800, 600, 140, 30, false, false);
			floor[1][0].lasers.get(11).addEventBox(800, 600, 140, 30, false, false);
			//
			floor[1][1].insideWalls.add(new Wall(800, 50 + 150, 150, 435, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(550, 50 + 150, 100, 200, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(550, 50, 100, 75, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(550, 500, 100, 135, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(350, 125, 100, 280, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(150, 600, 300, 30, false, 0, 0));
			floor[1][1].insideWalls.add(new Wall(50, 50, 150, 400, false, 0, 0));

			floor[1][1].spikeStrips.add(new spikeStrip(450, 600, 100, 30, 5));
			floor[1][1].spikeStrips.add(new spikeStrip(650, 600, 150, 30, 6));
			//

			floor[1][2].insideWalls.add(new Wall(50, 200, 200, 35, false, 0, 0));
			floor[1][2].insideWalls.add(new Wall(740, 200, 200, 35, false, 0, 0));			
			floor[1][2].insideWalls.add(new Wall(250 + 100, 200, 200, 35, false, 0, 0));




		}

	}

	Room getRoom(int x, int y) {
		return floor[x][y];
	}

}
