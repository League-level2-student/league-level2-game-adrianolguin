import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {

	boolean open = true;
	boolean close = false;

	Timer iFrames;

	Player p;

	ObjectManager(Player p) {

		this.p = p;

		iFrames = new Timer(1000, this);
	}

	void draw(Graphics g) {
		p.draw(g);
	}

	void update() {

		p.update();

		checkAllCollisions();

	}

	void checkAllCollisions() {
		checkWallCollisions();
		checkEnemyCollisions();
	}

	void checkEnemyCollisions() {

	}

	void checkWallCollisions() {

	}

	void checkWall(Wall w) {
		if (p.getCollisionBox().intersects(w.collisionBox)) {

			if (p.collisionLine1.intersects(w.door)) {
			} else if (p.collisionLine1.intersects(w.collisionBox)) {
				p.setX(p.getX() + p.getSpeed());
				p.setCBPos(p.getX(), p.getY());
			}
			if (p.collisionLine2.intersects(w.door)) {

			} else if (p.collisionLine2.intersects(w.collisionBox)) {
				p.setY(p.getY() + p.getSpeed());
				p.setCBPos(p.getX(), p.getY());
			}
			if (p.collisionLine3.intersects(w.door)) {
			} else if (p.collisionLine3.intersects(w.collisionBox)) {
				p.setX(p.getX() - p.getSpeed());
				p.setCBPos(p.getX(), p.getY());
			}
			if (p.collisionLine4.intersects(w.door)) {
			} else if (p.collisionLine4.intersects(w.collisionBox)) {
				p.setY(p.getY() - p.getSpeed());
				p.setCBPos(p.getX(), p.getY());
			}

		}
	}

	void checkEnemy(Enemy e) {
		if (p.invincible) {

		} else {
			if (p.getCollisionBox().intersects(e.getCollisionBox())) {
				p.health--;
				p.invincible = true;
				iFrames.start();
				System.out.println(p.health);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		p.invincible = false;
		iFrames.stop();
	}
}
