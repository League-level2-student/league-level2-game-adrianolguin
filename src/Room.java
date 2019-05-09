import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Room {

	int x;
	int y;

	int height = 200;
	int width = 5;

	Rectangle collisionBox1;
	
	Room(int x, int y) {
		this.x = x;
		this.y = y;
		this.collisionBox1 = new Rectangle(x,y,height,height);
		  collisionBox1.setBounds(x, y, height, height);
	}

	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, height, height);
		g.setColor(Color.BLACK);
		g.fillRect(x+width, y+width, height-width*2, height-width*2);
	}
	
}
