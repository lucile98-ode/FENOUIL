import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class IndividuCreation extends JDialog {
    private ToStringIndividuCreation infoToString = new ToStringIndividuCreation();
    private boolean sendData;
    private JLabel infoLabel, specificitesLabel, coordonneesLabel;
    private JComboBox caracteristiqueCommercial, categorieSocioProfessionnelle;
    private JTextField nom, prenom, adresseRue, ville, numeroTel, email;
    private JSpinner dateJour, dateMois, dateAnnee, adresseNumero, departement;

    BaseDeDonnees b;

    public IndividuCreation(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(700, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringIndividuCreation showIndividuCreation() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // Information de l'individu
        JPanel panInformation = new JPanel();
        panInformation.setBackground(Color.white);
        panInformation.setPreferredSize(new Dimension(625, 100));
        panInformation.setBorder(BorderFactory.createTitledBorder("Informations"));

        nom = new JTextField();
        nom.setPreferredSize(new Dimension(135, 25));
        infoLabel = new JLabel("Nom :");
        panInformation.add(infoLabel);
        panInformation.add(nom);

        prenom = new JTextField();
        prenom.setPreferredSize(new Dimension(135, 25));
        infoLabel = new JLabel("Prenom :");
        panInformation.add(infoLabel);
        panInformation.add(prenom);

        numeroTel = new JTextField();
        numeroTel.setPreferredSize(new Dimension(120, 25));
        infoLabel = new JLabel("Telephone :");
        panInformation.add(infoLabel);
        panInformation.add(numeroTel);

        dateJour = new JSpinner();
        dateJour.setValue(01);
        dateJour.setPreferredSize(new Dimension(50, 30));
        infoLabel = new JLabel("Jour : ");
        panInformation.add(infoLabel);
        panInformation.add(dateJour);

        dateMois = new JSpinner();
        dateMois.setValue(01);
        dateMois.setPreferredSize(new Dimension(50, 30));
        infoLabel = new JLabel("Mois : ");
        panInformation.add(infoLabel);
        panInformation.add(dateMois);

        dateAnnee = new JSpinner();
        dateAnnee.setValue(1990);
        dateAnnee.setPreferredSize(new Dimension(50, 30));
        infoLabel = new JLabel("Annee : ");
        panInformation.add(infoLabel);
        panInformation.add(dateAnnee);

        email = new JTextField();
        email.setPreferredSize(new Dimension(115, 25));
        infoLabel = new JLabel("Email (falcutatif):");
        panInformation.add(infoLabel);
        panInformation.add(email);

        // Coordonnees de l'individu
        JPanel panCoordonnees = new JPanel();
        panCoordonnees.setBackground(Color.white);
        panCoordonnees.setPreferredSize(new Dimension(625, 60));
        panCoordonnees.setBorder(BorderFactory.createTitledBorder("Coordonnees"));

        adresseNumero = new JSpinner();
        adresseNumero.setValue(1);
        adresseNumero.setPreferredSize(new Dimension(50, 30));
        coordonneesLabel = new JLabel("Numero : ");
        panCoordonnees.add(coordonneesLabel);
        panCoordonnees.add(adresseNumero);

        adresseRue = new JTextField();
        adresseRue.setPreferredSize(new Dimension(115, 25));
        coordonneesLabel = new JLabel("Adresse :");
        panCoordonnees.add(coordonneesLabel);
        panCoordonnees.add(adresseRue);

        departement = new JSpinner();
        departement.setValue(91000);
        departement.setPreferredSize(new Dimension(65, 30));
        coordonneesLabel = new JLabel("Code postal : ");
        panCoordonnees.add(coordonneesLabel);
        panCoordonnees.add(departement);

        ville = new JTextField();
        ville.setPreferredSize(new Dimension(100, 25));
        coordonneesLabel = new JLabel("Ville :");
        panCoordonnees.add(coordonneesLabel);
        panCoordonnees.add(ville);

        // Specifications
        JPanel panSpecifications = new JPanel();
        panSpecifications.setBackground(Color.white);
        panSpecifications.setPreferredSize(new Dimension(625, 60));
        panSpecifications.setBorder(BorderFactory.createTitledBorder("Specificites"));
        specificitesLabel = new JLabel("Categorie Socio-Professionnelle :");
        categorieSocioProfessionnelle = new JComboBox();
        categorieSocioProfessionnelle.addItem("artisans");
        categorieSocioProfessionnelle.addItem("agriculteur");
        categorieSocioProfessionnelle.addItem("cadre");
        categorieSocioProfessionnelle.addItem("ouvriers");
        categorieSocioProfessionnelle.addItem("retraite");
        categorieSocioProfessionnelle.addItem("employe");
        categorieSocioProfessionnelle.addItem("autres");

        panSpecifications.add(specificitesLabel);
        panSpecifications.add(categorieSocioProfessionnelle);

        specificitesLabel = new JLabel("Caracteristique commerciale :");
        caracteristiqueCommercial = new JComboBox();
        caracteristiqueCommercial.addItem("client");
        caracteristiqueCommercial.addItem("client interdit");
        caracteristiqueCommercial.addItem("prospect");

        panSpecifications.add(specificitesLabel);
        panSpecifications.add(caracteristiqueCommercial);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panInformation);
        content.add(panCoordonnees);
        content.add(panSpecifications);

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                infoToString = new ToStringIndividuCreation((String) nom.getText(), (String) prenom.getText(),
                        (int) dateJour.getValue(), (int) dateMois.getValue(), (int) dateAnnee.getValue(),
                        (String) categorieSocioProfessionnelle.getSelectedItem(), (int) adresseNumero.getValue(),
                        (String) adresseRue.getText(), (int) departement.getValue(), (String) ville.getText(),
                        (String) numeroTel.getText(), (String) email.getText(),
                        (String) caracteristiqueCommercial.getSelectedItem());

                b.addIndividu((String) nom.getText(), (String) prenom.getText(),
                        new DateNaissance(
                                (int) dateJour.getValue(), (int) dateMois.getValue(), (int) dateAnnee.getValue()),
                        (String) categorieSocioProfessionnelle.getSelectedItem(),
                        new Adresse((int) adresseNumero.getValue(), (String) adresseRue.getText(),
                                (int) departement.getValue(), (String) ville.getText()),
                        (String) numeroTel.getText(), (String) email.getText(),
                        (String) caracteristiqueCommercial.getSelectedItem());

                setVisible(false);

            }
        });

        JButton cancelBouton = new JButton("Annuler");
        cancelBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });

        control.add(okBouton);
        control.add(cancelBouton);

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }
}