import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {

	int healthBuffer1;
	int healthBuffer2;

	int sWidth = Evolution.width - 250;
	int sHeight = Evolution.height;

	boolean open = true;
	boolean close = false;

	boolean nDoor;
	boolean sDoor;
	boolean wDoor;
	boolean eDoor;

	Timer iFrames;

	Player player;

	Room currentRoom;

	Health healthBar;

	ObjectManager(Player player) {

		this.player = player;

		iFrames = new Timer(1000, this);

		healthBar = new Health(Evolution.width - 200, 200);
	}

	void draw(Graphics g) {

		healthBar.draw(g);

		if (currentRoom != null) {
			currentRoom.draw(g);
		}
		
		player.draw(g);
	}

	void update() {

		player.update();

//		currentRoom.updateContents();

	}

	void checkAllCollisions() {
		checkWallCollisions();
		checkHazardCollisions();

	}

	void checkHazardCollisions() {

		for (int i = 0; i < currentRoom.lasers.size(); i++) {
			if (player.collisionBox.intersects(currentRoom.lasers.get(i).laserHitbox)) {
				player.takeDamage();
			}
		}

	}

	void checkWallCollisions() {

		if (player.x < currentRoom.walls[3].door.x + currentRoom.walls[3].doorSize
				&& player.x + player.width > currentRoom.walls[3].door.x
				&& player.y + player.width > currentRoom.walls[3].y) {
			sDoor = true;
		}

		if (player.y + player.height > currentRoom.walls[3].y) {
			player.setY(currentRoom.walls[3].y - player.height);
			player.airborn = false;
			player.boostAble = true;
			player.yVelocity = 0;
		}
		// -------------------------------------------------------------------------------
		if (player.x < currentRoom.walls[1].door.x + currentRoom.walls[1].doorSize
				&& player.x + player.width > currentRoom.walls[1].door.x
				&& player.y < currentRoom.walls[1].y + currentRoom.wallWidth) {
			nDoor = true;

		} else if (player.y < currentRoom.walls[1].y + currentRoom.wallWidth) {
			player.setY(currentRoom.walls[1].y + currentRoom.wallWidth);
			player.yVelocity = 0;
		}
		// -------------------------------------------------------------------------------
		if (player.y > currentRoom.walls[2].door.y
				&& player.y < currentRoom.walls[2].door.y + currentRoom.walls[2].doorSize
				&& player.x + player.width > currentRoom.walls[2].x) {
			eDoor = true;
		} else if (player.x + player.width > currentRoom.walls[2].x) {
			player.x = currentRoom.walls[2].x - player.width;
		}
		// -------------------------------------------------------------------------------
		if (player.y < currentRoom.walls[0].door.y + currentRoom.walls[0].doorSize
				&& player.y + player.width > currentRoom.walls[0].door.y
				&& player.x < currentRoom.walls[0].y + currentRoom.wallWidth) {
			wDoor = true;
		} else if (player.x < currentRoom.walls[0].x + currentRoom.wallWidth) {
			player.x = currentRoom.walls[0].x + currentRoom.wallWidth;
		}

		for (int x = 0; x < currentRoom.insideWalls.size(); x++) {

			int insideWallY = currentRoom.insideWalls.get(x).y;
			int insideWallX = currentRoom.insideWalls.get(x).x;
			int insideWallWidth = currentRoom.insideWalls.get(x).width;
			int insideWallHeight = currentRoom.insideWalls.get(x).height;

			if (player.y < insideWallY + 20) {
				if (player.y + player.height > currentRoom.insideWalls.get(x).y && player.x + player.width > insideWallX
						&& player.x < insideWallX + insideWallWidth) {
					player.setY(insideWallY - player.height);
					player.airborn = false;
					player.boostAble = true;
					player.yVelocity = 0;
				}
			}
			if (player.x < insideWallX + 20) {
				if (player.x + player.width > insideWallX && player.y < insideWallY + insideWallHeight
						&& player.y + player.height > insideWallY) {
					player.setX(insideWallX - player.width);
					player.xVelocity = 0;
				}
			}

			if (player.y > insideWallY + insideWallHeight - 20) {
				if (player.y < insideWallY + insideWallHeight && player.x + player.width > insideWallX
						&& player.x < insideWallX + insideWallWidth) {
					player.setY(insideWallY + insideWallHeight);
					player.yVelocity = 0;
				}
			}

			if (player.x > insideWallX + insideWallWidth - 20) {
				if (player.x < insideWallX + insideWallWidth && player.y < insideWallY + insideWallHeight
						&& player.y + player.height > insideWallY) {
					player.setX(insideWallX + insideWallWidth);
				}
			}

		}

	}

	void checkWall(Wall w) {

	}

	void changeCurrentRoom(Room r) {
		currentRoom = r;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		player.invincible = false;
		iFrames.stop();
	}

}
