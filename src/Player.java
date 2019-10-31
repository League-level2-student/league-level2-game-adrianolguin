import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Player extends GameObject implements ActionListener {

	int fRIGHT = 1;
	int fLEFT = -1;
	
	boolean disableRIGHT = false;
	boolean disableLEFT = false;
	
	int wallJumpXVel = 15;

	Timer boostBuffer;
	boolean Boosting;
	// make it so when boosting you cant control the player with left and right to
	// get rid of the weird boost while holding left and right

	boolean airborn;

	int dir;

	boolean wallJump = false;
	boolean grinding = false;
	boolean ableBoost = true;
	
	int yVelocity = 0;

	int xVelocity = 0;

	Player(int x, int y) {
		super(x, y);

		health = 6;

		speed = 5;

		width = 20;
		height = 20;

		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);

		boostBuffer = new Timer(100, this);

	}

	void update() {

		super.update();

		if(!grinding) {
		yVelocity += Evolution.panel.gravity;
		} else {
			if(!wallJump) {
			yVelocity = 5;
			}
		}
		
		y += yVelocity;

		if (xVelocity < 0) {
			xVelocity += Evolution.panel.friction;
		} else if (xVelocity > 0) {
			xVelocity -= Evolution.panel.friction;
		}

		x += xVelocity;

		collisionBox.x = x;
		collisionBox.y = y;

		
		if (LEFT && !Boosting) {

			if(!disableLEFT) {
			xVelocity = -speed;
		}
		
			dir = fLEFT;

		}
		if (RIGHT && !Boosting) {

			if (!disableRIGHT) {
				xVelocity = speed;
			}

			dir = fRIGHT;
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Boosting = false;
		boostBuffer.stop();

	}

	void draw(Graphics g) {

		// g.setColor(Color.YELLOW);
		// g.fillRect(getCBX(), getCBY(), width, height);

		if (invincible) {
			g.setColor(Color.pink);
			g.fillRect(getCBX(), getCBY(), width, height);
		} else {
			g.setColor(Color.blue);
			g.fillRect(x, y, width, height);
		}
	}

	void boost() {

		if(airborn) {
			ableBoost = false;
		}
		
		Boosting = true;

		boostBuffer.start();

		xVelocity = speed * 4 * dir;

		// yVelocity = 1;
		// Evolution.panel.gravity = 0;
		// Evolution.panel.friction = 0;
	}

	void jump() {
		if (!airborn) {
			yVelocity = -15;
			airborn = true;
		} else {
		}

	}

	void wallJump() {
		
		wallJump = true;

		yVelocity = -15;

		if (dir == fLEFT) {
			xVelocity = wallJumpXVel;
			dir = fRIGHT;
			disableLEFT = true;
		} else if (dir == fRIGHT) {
			xVelocity = -wallJumpXVel;
			dir = fLEFT;
			disableRIGHT = true;
		}

	}

	void setX(int newx) {
		x = newx;
	}

	void setY(int newy) {
		y = newy;
	}

	void setPos(int newx, int newy) {
		x = newx;
		y = newy;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	int getCBX() {
		return collisionBox.x;
	}

	int getCBY() {
		return collisionBox.y;
	}

	void setCBPos(int newx, int newy) {
		collisionBox.x = newx;
		collisionBox.y = newy;
	}

	void isIntersecting(boolean change) {
		intersecting = change;
	}

	void isAlive(boolean change) {
		alive = change;
	}

	Rectangle getCollisionBox() {
		return collisionBox;
	}

	void manageDir(int keyPressed, boolean change) {

		if (keyPressed == KeyEvent.VK_UP) {
			UP = change;
		}
		if (keyPressed == KeyEvent.VK_DOWN) {
			DOWN = change;
		}
		if (keyPressed == KeyEvent.VK_LEFT) {
			LEFT = change;
		}
		if (keyPressed == KeyEvent.VK_RIGHT) {
			RIGHT = change;
		}
	}

	void takeDamage() {
		if (!invincible) {
			invincible = true;
			Evolution.panel.oManager.iFrames.start();
			health--;
			Evolution.panel.oManager.healthBar.currentHealth = health;
		}
	}

	public int getSpeed() {
		return speed;
	}

}
