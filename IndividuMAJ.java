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

public class IndividuMAJ extends JDialog {
    private ToStringIndividuMAJ infoToString = new ToStringIndividuMAJ();
    private boolean sendData;
    private JLabel nomLabel, categorieLabel, adresseLabel, telephoneLabel, emailLabel, caracteristiqueLabel,
            individuLabel;
    private JComboBox categorieSocioPro, caracteristiqueCom, individu;
    private JTextField nom, rue, ville, tel, email;
    private JSpinner numeroRue, departement;

    BaseDeDonnees b;
    String modification;

    public IndividuMAJ(JFrame parent, String title, boolean modal, String modif, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(800, 220);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        modification = modif;
        this.initComponent();
    }

    public ToStringIndividuMAJ showIndividuMAJ() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        JPanel content = new JPanel();

        // individu
        JPanel panIndividu = new JPanel();
        panIndividu.setBackground(Color.white);
        panIndividu.setPreferredSize(new Dimension(700, 60));
        panIndividu.setBorder(BorderFactory.createTitledBorder("Selection de l'individu a modifier"));
        individu = new JComboBox();
        if (b.getListeIndividus().length == 0 || b.getListeIndividus() == null) {
            individu.addItem("Pas d'individu a modifier");
        } else {
            individu.addItem("");
            for (int i = 0; i < b.getListeIndividus().length; i++) {
                individu.addItem(
                        "individu : " + b.getListeIndividus()[i].getNom() + " " + b.getListeIndividus()[i].getPrenom()
                                + " ne(e) le " + b.getListeIndividus()[i].getDateNaissance());
            }
        }

        individuLabel = new JLabel("");
        panIndividu.add(individuLabel);
        panIndividu.add(individu);
        content.setBackground(Color.white);
        content.add(panIndividu);

        if (modification == "nom") {
            // nom individu
            JPanel panNom = new JPanel();
            panNom.setBackground(Color.white);
            panNom.setPreferredSize(new Dimension(700, 65));
            panNom.setBorder(BorderFactory.createTitledBorder("Modifier le nom de famille"));
            nom = new JTextField();
            nom.setPreferredSize(new Dimension(150, 25));
            nomLabel = new JLabel("Nom :");
            panNom.add(nomLabel);
            panNom.add(nom);
            content.add(panNom);

        } else if (modification == "categorie") {
            // Categorie
            JPanel panCategorie = new JPanel();
            panCategorie.setBackground(Color.white);
            panCategorie.setPreferredSize(new Dimension(700, 60));
            panCategorie.setBorder(BorderFactory.createTitledBorder("Selection de l'article a modifier"));
            categorieSocioPro = new JComboBox();
            categorieSocioPro.addItem("FAIRE UN TABLEAU DE CATEGORIE");
            categorieSocioPro.addItem("FAIRE UN TABLEAU");
            categorieLabel = new JLabel("");
            panCategorie.add(categorieLabel);
            panCategorie.add(categorieSocioPro);
            content.add(panCategorie);

        } else if (modification == "adresse") {
            // adresse
            JPanel panAdresse = new JPanel();
            panAdresse.setBackground(Color.white);
            panAdresse.setPreferredSize(new Dimension(700, 65));
            panAdresse.setBorder(BorderFactory.createTitledBorder("Nouvelle adresse"));

            numeroRue = new JSpinner();
            numeroRue.setValue(1);
            numeroRue.setPreferredSize(new Dimension(50, 30));
            adresseLabel = new JLabel("Numero : ");
            panAdresse.add(adresseLabel);
            panAdresse.add(numeroRue);

            rue = new JTextField();
            rue.setPreferredSize(new Dimension(145, 25));
            adresseLabel = new JLabel("Adresse :");
            panAdresse.add(adresseLabel);
            panAdresse.add(rue);

            departement = new JSpinner();
            departement.setValue(91000);
            departement.setPreferredSize(new Dimension(65, 30));
            adresseLabel = new JLabel("Code postal : ");
            panAdresse.add(adresseLabel);
            panAdresse.add(departement);

            ville = new JTextField();
            ville.setPreferredSize(new Dimension(100, 25));
            adresseLabel = new JLabel("Ville :");
            panAdresse.add(adresseLabel);
            panAdresse.add(ville);

            content.add(panAdresse);

        } else if (modification == "coordonnees") {
            // coordonnees
            JPanel panCoordonnees = new JPanel();
            panCoordonnees.setBackground(Color.white);
            panCoordonnees.setPreferredSize(new Dimension(700, 65));
            panCoordonnees.setBorder(BorderFactory.createTitledBorder("Nouvelle adresse"));

            tel = new JTextField();
            tel.setPreferredSize(new Dimension(80, 25));
            telephoneLabel = new JLabel("Telephone :");
            panCoordonnees.add(telephoneLabel);
            panCoordonnees.add(tel);

            email = new JTextField();
            email.setPreferredSize(new Dimension(120, 25));
            emailLabel = new JLabel("Email (facultatif) :");
            panCoordonnees.add(emailLabel);
            panCoordonnees.add(email);

            content.add(panCoordonnees);

        } else if (modification == "caracteristique") {
            // caracteristique
            JPanel panCaracteristique = new JPanel();
            panCaracteristique.setBackground(Color.white);
            panCaracteristique.setPreferredSize(new Dimension(700, 60));
            panCaracteristique.setBorder(BorderFactory.createTitledBorder("Selection de l'article a modifier"));
            caracteristiqueCom = new JComboBox();
            caracteristiqueCom.addItem("DE caracteristique");
            caracteristiqueCom.addItem("FAIRE UN TABLEAU");
            caracteristiqueLabel = new JLabel("");
            panCaracteristique.add(caracteristiqueLabel);
            panCaracteristique.add(caracteristiqueCom);
            content.add(panCaracteristique);

        }

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String individuSelect = (String) individu.getSelectedItem();
                int individuIndex = (int) individu.getSelectedIndex() - 1;

                if (modification == "nom") {
                    infoToString = new ToStringIndividuMAJ((String) nom.getText(), modification, individuSelect);
                    if (individuIndex != -1) {
                        b.getListeIndividus()[individuIndex].setNom((String) nom.getText());
                    }

                } else if (modification == "categorie") {
                    infoToString = new ToStringIndividuMAJ((String) categorieSocioPro.getSelectedItem(), modification,
                            individuSelect);
                    if (individuIndex != -1) {
                        b.getListeIndividus()[individuIndex].setCategorie((String) categorieSocioPro.getSelectedItem());
                    }

                } else if (modification == "adresse") {
                    infoToString = new ToStringIndividuMAJ((int) numeroRue.getValue(), (String) rue.getText(),
                            (int) departement.getValue(), (String) ville.getText(), modification, individuSelect);
                    if (individuIndex != -1) {
                        b.getListeIndividus()[individuIndex].setNumeroAdresse((int) numeroRue.getValue());
                        b.getListeIndividus()[individuIndex].setRueAdresse((String) rue.getText());
                        b.getListeIndividus()[individuIndex].setDepartementAdresse((int) departement.getValue());
                        b.getListeIndividus()[individuIndex].setVilleAdresse((String) ville.getText());
                    }

                } else if (modification == "coordonnees") {
                    infoToString = new ToStringIndividuMAJ((String) tel.getText(), (String) email.getText(),
                            modification, individuSelect);
                    if (individuIndex != -1) {
                        b.getListeIndividus()[individuIndex].setTelephone((String) tel.getText());
                        b.getListeIndividus()[individuIndex].setEmail((String) email.getText());
                    }

                } else if (modification == "caracteristique") {
                    infoToString = new ToStringIndividuMAJ((String) caracteristiqueCom.getSelectedItem(), modification,
                            individuSelect);
                    if (individuIndex != -1) {
                        b.getListeIndividus()[individuIndex]
                                .setCaracteristique((String) caracteristiqueCom.getSelectedItem());
                    }
                }
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