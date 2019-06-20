import java.awt.Rectangle;

public class ObjectInfo {

	int x;
	int y;
	int width;
	int height;
	int speed;
	String Object;
	Rectangle collisionBox;

	ObjectInfo(int x, int y, int width, int height, int speed, String Object, Rectangle collisionBox) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.Object = Object;
		this.collisionBox = collisionBox;
	}

}
