package anim;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Nominal extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage backgroundImage;
	private BufferedImage carImage;
	private int bgX = 0;
	private int bgY = 0;
	private int carX = 80;
	private int carY = 350;

	public Nominal() {
		try {
			backgroundImage = ImageIO
					.read(new File("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\anim\\background.jpg"));
			carImage = ImageIO
					.read(new File("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\anim\\car.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Timer timer = new Timer(30, e -> {
			bgX -= 5; // Faire défiler l'arrière-plan de 5 pixels vers la gauche à chaque fois
			if (bgX <= getWidth() - backgroundImage.getWidth()) {
				// Arrêter l'animation lorsque le bord droit de l'arrière-plan atteint le bord
				// droit de la fenêtre
				((Timer) e.getSource()).stop();
				Timer closingTimer = new Timer(1000, event -> {
					Window window = SwingUtilities.getWindowAncestor(this);
					window.dispose();
				});
				closingTimer.setRepeats(false); // S'assurer que le timer ne se répète pas
				closingTimer.start();
			}
			repaint(); // Redessiner la fenêtre avec la nouvelle position de l'arrière-plan
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Dessiner l'arrière-plan
		g.drawImage(backgroundImage, bgX, bgY, null);
		// Dessiner la voiture
		g.drawImage(carImage, carX, carY, null);
	}

}
