import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class ActionBarrier {
	int x, y, width, height;
	Rectangle barrier; 
	ActionBarrier(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		barrier = new Rectangle(x, y, width, height);
	}
	
	
}
