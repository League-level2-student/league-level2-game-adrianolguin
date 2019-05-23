import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall {
	int x;
	int y;
	int height;
	int width;

	Rectangle collisionBox1;
	Rectangle collisionBox2;
	Rectangle collisionBox3;
	Rectangle collisionBox4;

	Wall(int x, int y, int width, int height, int dir, boolean door) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		collisionBox1 = new Rectangle(x - width, y, width, height);
		collisionBox2 = new Rectangle(x, y - width, width, width);
		collisionBox3 = new Rectangle(x + width, y, width, height);
		collisionBox4 = new Rectangle(x,y+height,width,width);
	
		collisionBox1.setBounds(collisionBox1);
		collisionBox2.setBounds(collisionBox2);
		collisionBox3.setBounds(collisionBox3);
		collisionBox4.setBounds(collisionBox4);
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

		g.setColor(Color.BLUE);
		g.fillRect(x,y+height,width,width);
	}

}
