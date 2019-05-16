import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Room {

	int x;
	int y;
	int height;
	int width;

	Rectangle collisionBox1;
	Rectangle collisionBox2;
	Rectangle collisionBox3;
	Rectangle collisionBox4;

	Room(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collisionBox1 = new Rectangle(x + width, y + width, width, height - width * 2);
		this.collisionBox2 = new Rectangle(x + width, y + width, height - width * 2, width);
		this.collisionBox3 = new Rectangle(x + height - width * 2, y + width, width, height - width * 2);
		this.collisionBox4 = new Rectangle(x + width, y + height - width * 2, height - width * 2, width);
	}

	void initialize() {
		collisionBox1.setBounds(x + width, y + width, width, height - width * 2);
		collisionBox2.setBounds(x + width, y + width, height - width * 2, width);
		collisionBox3.setBounds(x + height - width * 2, y + width, width, height - width * 2);
		collisionBox4.setBounds(x + width, y + height - width * 2, height - width * 2, width);
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, height, height);

		g.setColor(Color.BLACK);
		g.fillRect(x + width, y + width, height - width * 2, height - width * 2);

	}

}
