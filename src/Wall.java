import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Wall extends GameObject {

	int doorScale = 3;

	Wall(int x, int y, int width, int height) {
		super(x, y, width, height);

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		collisionBox = new Rectangle(x,y,width,height);
		
		collisionBox.setBounds(collisionBox);
	}

	void draw(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);

	}

}
