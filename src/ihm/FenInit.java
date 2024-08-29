package ihm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import anim.Alternatif;
import anim.Nominal;
import om.Voiture;

public class FenInit extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel immatLabel;
	private JTextField immatField;
	private JLabel powLabel;
	private JTextField powField;
	private JLabel kmLabel;
	private JTextField kmField;
	private JLabel vitLabel;
	private JTextField vitField;
	private JButton validBouton;
	private JFrame frame;
	private JLabel imageLabel;
	private ImageIcon pub;

	private double coutVal;
	private Connection cx;
	private Statement etat;
	private int rowAffected;

	public FenInit() {

		frame = new JFrame("Infos trajet");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel contenu = new JPanel(new GridLayout(5, 2));

		immatLabel = new JLabel("Entrez votre immatriculation :");
		immatField = new JTextField();

		powLabel = new JLabel("Indiquez la puissance de la voiture :");
		powField = new JTextField();

		kmLabel = new JLabel("Indiquez la distance en km :");
		kmField = new JTextField();

		vitLabel = new JLabel("Vitesse souhaitée :");
		vitField = new JTextField();

		imageLabel = new JLabel();
		pub = new ImageIcon("C:\\Users\\Cedric\\eclipse-workspace\\ProjetVoiture\\src\\ihm\\pub1.png");
		imageLabel.setIcon(pub);

		contenu.add(immatLabel);
		contenu.add(immatField);
		contenu.add(powLabel);
		contenu.add(powField);
		contenu.add(kmLabel);
		contenu.add(kmField);
		contenu.add(vitLabel);
		contenu.add(vitField);

		validBouton = new JButton("Démarrer trajet");
		validBouton.addActionListener(this);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(validBouton);

		frame.add(contenu, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.add(imageLabel, BorderLayout.SOUTH);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String immat = immatField.getText();
		String pow = powField.getText();
		int puissance = Integer.parseInt(pow);
		String km = kmField.getText();
		double distance = Double.parseDouble(km);
		String vit = vitField.getText();
		double vitesse = Double.parseDouble(vit);

		frame.dispose();

		Voiture maVoiture = new Voiture();

		maVoiture.initVoiture(puissance, immat);

		maVoiture.rouler(distance, vitesse);

		coutVal = maVoiture.getCout();

		JFrame anim = new JFrame("Background Animation");
		anim.setSize(800, 600);
		anim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		anim.setLocationRelativeTo(null);

		anim.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				FenBilan bilan = new FenBilan();
				bilan.setCoutVal(Double.toString(coutVal));
				bilan.setImmatVal(immat);
				bilan.setPuissVal(pow);
				bilan.setVitVal(vit);
				bilan.setKmVal(km);
				bilan.setVisible(true);
			}
		});

		if (!maVoiture.getScenario(distance)) {

			anim.add(new Alternatif());

		} else {

			anim.add(new Nominal());

		}

		anim.setVisible(true);

		String requeteSQL = "INSERT INTO trajets (immat, distance, puissance, vitesse, cout, date, id_pub1, id_pub2) VALUES ('"
				+ immat + "', " + distance + ", " + puissance + ", " + vitesse + ", " + coutVal + ", now(), 1, 1);";
		System.out.println(requeteSQL);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Problème au chargement" + ex.toString());
		}

		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/simultrajet?user=root&password=");
			etat = cx.createStatement();
			rowAffected = etat.executeUpdate(requeteSQL);
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex);
		}

	}

}
