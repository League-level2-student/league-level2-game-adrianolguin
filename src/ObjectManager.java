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

		// currentRoom.updateContents();

	}

	void checkAllCollisions() {
		checkWallCollisions();

	}

	void checkEnemyCollisions() {

	}

	void checkWallCollisions() {

		if (player.x < currentRoom.walls[3].door.x + currentRoom.walls[3].doorSize
				&& player.x + player.width > currentRoom.walls[3].door.x
				&& player.y + player.width > currentRoom.walls[3].y) {
			sDoor = true;
		}

		if (player.y + player.height > currentRoom.walls[3].y) {
			player.setY(currentRoom.walls[3].y - player.height);
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
