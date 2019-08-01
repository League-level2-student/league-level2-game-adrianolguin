import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Health {

	int x;
	int y;

	int sWidth = Evolution.width - 250;
	int sHeight = Evolution.height;

	int maxHealth = 20;
	int currentHealth = 20;

	int currentRow = 0;

	ArrayList<BufferedImage> health;

	Health(int x, int y) {

		this.x = x;
		this.y = y;

		health = new ArrayList<BufferedImage>();

		for (int i = 0; i < 10; i++) {
			health.add(GamePanel.heartImg);
		}

	}

	void draw(Graphics g) {

		if (currentHealth > maxHealth) {

			if (currentHealth % 2 == 0) {
				maxHealth = currentHealth;
			} else {
				maxHealth = currentHealth + 1;
			}

		}

		for (int i = 0; i < maxHealth/2; i++) {

			if (i % 10 == 0) {
				currentRow++;
			}

			if (currentHealth == maxHealth) {
				g.drawImage(GamePanel.heartImg, x, (y) + i * 40, 64, 64, null);
			} else {

				if (currentHealth % 2 == 0) {

					if (i < currentHealth / 2) {

						g.drawImage(GamePanel.heartImg, x, (y) + i * 40, 64, 64, null);
					} else {

						g.drawImage(GamePanel.brokenHeartImg, x, (y) + i * 40, 64, 64, null);
					}

				} else {

					if (i < currentHealth / 2) {
						g.drawImage(GamePanel.heartImg, x, (y) + i * 40, 64, 64, null);
					} else if (i == currentHealth / 2) {

						g.drawImage(GamePanel.damagedHeartImg, x, (y) + i * 40, 64, 64, null);

					} else {
						g.drawImage(GamePanel.brokenHeartImg, x, (y) + i * 40, 64, 64, null);
					}

				}

			}

		}

	}
}
