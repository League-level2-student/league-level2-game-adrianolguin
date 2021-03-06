import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EventBox {
	int x, y, width, height;
	boolean state;
	boolean persistance;
	Rectangle boundingBox;

	EventBox(int x, int y, int width, int height, boolean state, boolean persistance) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.state = state;
		this.persistance = persistance;
		boundingBox = new Rectangle(x, y, width, height);
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);

	}

	void disappear() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;

	}

}
