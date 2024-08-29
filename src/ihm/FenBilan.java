package ihm;

import java.awt.*;

import javax.swing.*;

public class FenBilan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel coutLabel;
	private JLabel coutVal;
	private JLabel rappelParam;
	private JLabel immatLabel;
	private JLabel immatVal;
	private JLabel puissLabel;
	private JLabel puissVal;
	private JLabel vitLabel;
	private JLabel vitVal;
	private JLabel kmLabel;
	private JLabel kmVal;
	private JLabel sautLigne;

	private JFrame frame;
	private JLabel imageLabel;
	private ImageIcon pub;

	public FenBilan() {

		frame = new JFrame("Bilan trajet");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel north = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.CENTER;

		coutLabel = new JLabel("Coût estimé du trajet :");
		coutVal = new JLabel();
		sautLigne = new JLabel(" ");
		rappelParam = new JLabel("Rappel des paramètres de votre trajet :");

		immatLabel = new JLabel("Plaque d'immatriculation :");
		immatVal = new JLabel();
		puissLabel = new JLabel("Puissance :");
		puissVal = new JLabel();
		vitLabel = new JLabel("Vitesse souhaitée :");
		vitVal = new JLabel();
		kmLabel = new JLabel("Nombre de km parcourus :");
		kmVal = new JLabel();

		imageLabel = new JLabel();
		pub = new ImageIcon("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\ihm\\pub2.png");
		imageLabel.setIcon(pub);

		north.add(coutLabel, gbc);
		north.add(coutVal, gbc);
		north.add(sautLigne, gbc);
		north.add(rappelParam, gbc);

		JPanel center = new JPanel(new GridLayout(4, 2));

		center.add(immatLabel);
		center.add(immatVal);
		center.add(puissLabel);
		center.add(puissVal);
		center.add(vitLabel);
		center.add(vitVal);
		center.add(kmLabel);
		center.add(kmVal);

		frame.add(north, BorderLayout.NORTH);

		frame.add(center, BorderLayout.CENTER);

		frame.add(imageLabel, BorderLayout.SOUTH);

		frame.setVisible(true);

	}

	public void setCoutVal(String string) {
		coutVal.setText(string + "€");
	}

	public void setImmatVal(String value) {
		immatVal.setText(value);
	}

	public void setPuissVal(String value) {
		puissVal.setText(value);
	}

	public void setVitVal(String value) {
		vitVal.setText(value + " km/h");
	}

	public void setKmVal(String value) {
		kmVal.setText(value + " km");
	}
}