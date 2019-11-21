import java.awt.Color;
import java.awt.Graphics;

public class Spike {

	int[] pointXs = new int[3];
	int[] pointYs = new int[3];

	Spike(int x, int y, int width, int height){
		
		pointXs[0] = x + width/2;
		pointYs[0] = y;
		
		pointXs[1] = x;
		pointYs[1] = y + height;
		
		pointXs[2] = x + width;
		pointYs[2] = y + height;
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillPolygon(pointXs, pointYs, 3);
	}
	
}
