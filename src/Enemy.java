import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject {

	Enemy(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.speed = speed;
		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(collisionBox);
	}

	void update() {
		x += speed;
		collisionBox.x = x;
		collisionBox.y = y;
		collisionBox.setBounds(collisionBox);

	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
