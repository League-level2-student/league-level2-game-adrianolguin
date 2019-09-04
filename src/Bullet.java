import java.awt.Rectangle;

public class Bullet extends GameObject {

	boolean Horizontal = true;
	boolean Vertical = false;
	
	int xVelocity = 0;
	int yVelocity = 0;
	
	boolean dir;

	Bullet(int x, int y, int speed, boolean dir) {
		super(x, y);

		this.speed = speed;

		this.dir = dir;

	}

	void update() {

		y += yVelocity;
		x += xVelocity;
		
		if(dir == Vertical) {
			yVelocity = speed;
		} else if(dir == Horizontal){
			xVelocity = speed;
		}
		
	}
}
