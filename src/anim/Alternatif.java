package anim;

import java.awt.Graphics;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Alternatif extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage depanneuseImage;
	private BufferedImage carImage;
	private BufferedImage backgroundImage;
	private BufferedImage stationImage;
	private int bgX = 0;
	private int bgY = 0;
	private int carX = 0;
	private int carY = 350;
	private int dpX = 160;
	private int dpY = 1280;
	private int statX = 245;
	private int statY = 1800;

	public Alternatif() {
		try {
			backgroundImage = ImageIO
					.read(new File("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\anim\\background2.jpg"));
			depanneuseImage = ImageIO
					.read(new File("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\anim\\depanneuse.png"));
			carImage = ImageIO
					.read(new File("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\anim\\car.png"));
			stationImage = ImageIO
					.read(new File("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\anim\\station.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Timer tDep = new Timer(30, d -> {
			dpY -= 5;
			if (bgX <= getWidth() - backgroundImage.getWidth() / 2) {
				// Arrêter l'animation lorsque le bord droit de l'arrière-plan atteint le bord
				// droit de la fenêtre
				((Timer) d.getSource()).stop();
			}
		});
		tDep.start();

		Timer tStat = new Timer(30, s -> {
			statY -= 5;
			if (bgX <= getWidth() - backgroundImage.getWidth() / 2) {
				// Arrêter l'animation lorsque le bord droit de l'arrière-plan atteint le bord
				// droit de la fenêtre
				((Timer) s.getSource()).stop();
			}
		});

		tStat.start();

		Timer timer = new Timer(30, e -> {
			bgX -= 5; // Faire défiler l'arrière-plan de 5 pixels vers la gauche à chaque fois
			if (bgX <= getWidth() - backgroundImage.getWidth()) {
				// Arrêter l'animation lorsque le bord droit de l'arrière-plan atteint le bord
				// droit de la fenêtre
				((Timer) e.getSource()).stop();
				Timer closingTimer = new Timer(20000, event -> {
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
		g.drawImage(stationImage, statY, statX, null);
		// Dessiner la voiture
		g.drawImage(carImage, carX, carY, null);
		g.drawImage(depanneuseImage, dpY, dpX, null);
	}

}
