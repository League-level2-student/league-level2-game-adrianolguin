import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {

	Enemy(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		information.Object.equals("Enemy");
		this.speed = speed;
	}

	void update() {
		x += speed;
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
