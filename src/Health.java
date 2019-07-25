import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Health {

	int sWidth = Evolution.width - 720;
	int sHeight = Evolution.height;

	int maxHealth = 20;
	int currentHealth = 20;

	int currentRow = 0;

	ArrayList<BufferedImage> health;

	Health() {

		health = new ArrayList<BufferedImage>();

		for (int i = 0; i < 10; i++) {
			health.add(GamePanel.heartImg);
		}

	}

	void draw(Graphics g) {

		for (int i = 0; i < health.size(); i++) {

			if(i % 10 == 0) {
				currentRow++;
			}
			
			if (currentHealth == maxHealth) {
				g.drawImage(GamePanel.heartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
			} else {

				if (currentHealth % 2 == 0) {

					if (i < currentHealth / 2) {

						g.drawImage(GamePanel.heartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
					} else {

						g.drawImage(GamePanel.brokenHeartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
					}

				} else {

					if (i < currentHealth / 2) {
						g.drawImage(GamePanel.heartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
					} else if (i == currentHealth / 2) {

						g.drawImage(GamePanel.damagedHeartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);

					} else {
						g.drawImage(GamePanel.brokenHeartImg, (sWidth + 40) + i * 40, 200, 64, 64, null);
					}

				}

			}

		}

	}
}
