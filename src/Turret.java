import java.awt.Color;
import java.awt.Graphics;

public class Turret extends GameObject {

	Turret(int x, int y) {
		super(x, y);

		width = 25;
		height = 25;
		
	}
	
	void draw(Graphics g) {
		
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	
		g.setColor(Color.red);
		g.drawLine(x + width/2, y+height/2, Evolution.panel.player.x + Evolution.panel.player.width/2, Evolution.panel.player.y + Evolution.panel.player.height/2);
		
	}

}
