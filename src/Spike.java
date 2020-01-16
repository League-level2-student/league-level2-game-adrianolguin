import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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

class spikeStrip {
	int x, y, width, height;
	int amount;
	int triangleSize;
	int[] pointXs;
	int[] pointYs;
	Rectangle hurtBox;
	int triangleWidth;
	int triangleHeight;
	spikeStrip(int x, int y, int width, int height, int amount){
		pointXs = new int[3];
		pointYs = new int[3];
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.amount = amount;
		hurtBox = new Rectangle(x,y,width,height);
		triangleWidth = width / amount;
		triangleHeight = height;
		
	}
	
	void draw(Graphics g) {
//		g.setColor(Color.red);
//		g.drawRect(x, y, width, height);
		for(int i = 0; i < amount; i++) {
			pointXs[0] = (x + triangleWidth/2) + (triangleWidth * i);
			pointYs[0] = y;
			
			pointXs[1] = x + triangleWidth * i;
			pointYs[1] = y + triangleHeight;
			
			pointXs[2] = (x + triangleWidth) + triangleWidth * i;
			pointYs[2] = y + triangleHeight;
			g.setColor(Color.WHITE);
			g.fillPolygon(pointXs, pointYs, 3);
		}
	}
}
