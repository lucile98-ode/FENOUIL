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

public class Selection extends JDialog {

    private ToStringCibleRoutage infoToString;
    private boolean sendData;
    private JLabel categorieLabel, ageLabel, departementLabel, clientLabel;
    private JComboBox categorie, age, departement, client;
    Fenetre fen;
    BaseDeDonnees b;
    String selection, type;

    public Selection(JFrame parent, String title, boolean modal, BaseDeDonnees bd, String selection,
            ToStringCibleRoutage infoToString) {
        super(parent, title, modal);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.selection = selection;
        this.infoToString = infoToString;
        this.type = type;

        this.initComponent();
    }

    public ToStringCibleRoutage showCibleRoutage() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        JPanel content = new JPanel();
        content.setBackground(Color.white);

        if (selection == "Categorie socio-professionnelle") {
            // Categorie
            JPanel panCategorie = new JPanel();
            panCategorie.setBackground(Color.white);
            panCategorie.setPreferredSize(new Dimension(350, 60));
            panCategorie.setBorder(BorderFactory.createTitledBorder("Categorie Socio Professionnelle "));
            categorie = new JComboBox();
            if (b.getListeCategorieSocioProfessionnelles().length == 0
                    || b.getListeCategorieSocioProfessionnelles() == null) {
                categorie.addItem("Entrer la liste des categories");
            }
            for (int i = 0; i < b.getListeCategorieSocioProfessionnelles().length; i++) {
                categorie.addItem(b.getListeCategorieSocioProfessionnelles()[i].getCategorieSocioProfessionnelle());
            }
            categorieLabel = new JLabel("Categorie : ");
            panCategorie.add(categorieLabel);
            panCategorie.add(categorie);
            content.add(panCategorie);

        } else if (selection == "Age") {
            // Age
            JPanel panAge = new JPanel();
            panAge.setBackground(Color.white);
            panAge.setPreferredSize(new Dimension(350, 60));
            panAge.setBorder(BorderFactory.createTitledBorder("Age de selection "));
            age = new JComboBox();
            age.addItem("< 25 ans");
            age.addItem("25 - 39 ans");
            age.addItem("40 - 54 ans");
            age.addItem("55 - 69 ans");
            age.addItem("> 70 ans");
            ageLabel = new JLabel("Categorie d'age : ");
            panAge.add(ageLabel);
            panAge.add(age);
            content.add(panAge);

        } else if (selection == "Departement de residence") {
            // Departement
            JPanel panDepartement = new JPanel();
            panDepartement.setBackground(Color.white);
            panDepartement.setPreferredSize(new Dimension(350, 60));
            panDepartement.setBorder(BorderFactory.createTitledBorder("Departement de residence"));
            departement = new JComboBox();

            if (b.getListeDepartementResidence().length == 0 || b.getListeDepartementResidence() == null) {
                departement.addItem("Entrer la liste des departements");
            }
            for (int i = 0; i < b.getListeDepartementResidence().length; i++) {
                departement.addItem(b.getListeDepartementResidence()[i].ToStringDepartementResidence());
            }
            departementLabel = new JLabel("Selectionner : ");
            panDepartement.add(departementLabel);
            panDepartement.add(departement);
            content.add(panDepartement);

        } else if (selection == "Selection d’individus deja clients ou non") {
            // Client
            JPanel panClient = new JPanel();
            panClient.setBackground(Color.white);
            panClient.setPreferredSize(new Dimension(350, 60));
            panClient.setBorder(BorderFactory.createTitledBorder("Client ou non ? "));
            client = new JComboBox();
            client.addItem("les clients");
            client.addItem("les non clients");
            client.addItem("tout le monde");
            clientLabel = new JLabel("Cibler : ");
            panClient.add(clientLabel);
            panClient.add(client);
            content.add(panClient);
        }

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                setVisible(false);
                Individu[] listeIndividusCibles = new Individu[0];

                // if (selection == "Categorie socio-professionnelle") {
                // for (int i = 0; i <= b.getListeIndividus().length; i++) {
                // if (b.getListeIndividus()[i].getCategorieSocioProfessionnelle()
                // .equals((String) categorie.getSelectedItem())) {
                // Individu[] listeIndividus = new Individu[listeIndividusCibles.length + 1];
                // listeIndividus = listeIndividusCibles;
                // listeIndividus[listeIndividus.length] = b.getListeIndividus()[i];
                // listeIndividusCibles = listeIndividus;
                // }
                // }

                // } else if (selection == "Age") {
                // int ageIndex = age.getSelectedIndex();
                // int ageMin = 0;
                // int ageMax = 0;

                // if (ageIndex == 0) {
                // ageMin = 0;
                // ageMax = 24;
                // } else if (ageIndex == 1) {
                // ageMin = 25;
                // ageMax = 39;
                // } else if (ageIndex == 2) {
                // ageMin = 40;
                // ageMax = 54;
                // } else if (ageIndex == 3) {
                // ageMin = 55;
                // ageMax = 69;
                // } else if (ageIndex == 4) {
                // ageMin = 70;
                // ageMax = 150; // pas de limite d'age
                // }

                // for (int i = 0; i <= b.getListeIndividus().length; i++) {
                // if (b.getListeIndividus()[i].getAge() >= ageMin
                // && b.getListeIndividus()[i].getAge() <= ageMax) {
                // Individu[] listeIndividus = new Individu[listeIndividusCibles.length + 1];
                // listeIndividus = listeIndividusCibles;
                // listeIndividus[listeIndividus.length] = b.getListeIndividus()[i];
                // listeIndividusCibles = listeIndividus;
                // }
                // }

                // } else if (selection == "Departement de residence") {

                // String codePostalItem = (String) departement.getSelectedItem();
                // char caractere1 = codePostalItem.charAt(0);
                // char caractere2 = codePostalItem.charAt(1);
                // char caractere3 = codePostalItem.charAt(2);
                // String codePostal = caractere1 + caractere2 + caractere3 + "";

                // for (int i = 0; i <= b.getListeIndividus().length; i++) {

                // if ((codePostal.charAt(0) + codePostal.charAt(1) + "").equals("97")) {
                // if ((codePostal.charAt(2) + "")
                // .equals(b.getListeIndividus()[i].getAdresseCodePostal().charAt(2) + "")) {
                // Individu[] listeIndividus = new Individu[listeIndividusCibles.length + 1];
                // listeIndividus = listeIndividusCibles;
                // listeIndividus[listeIndividus.length] = b.getListeIndividus()[i];
                // listeIndividusCibles = listeIndividus;
                // }
                // } else if ((b.getListeIndividus()[i].getAdresseCodePostal().charAt(0)
                // + b.getListeIndividus()[i].getAdresseCodePostal().charAt(1) + "")
                // .equals((codePostal.charAt(0) + codePostal.charAt(1) + ""))) {
                // Individu[] listeIndividus = new Individu[listeIndividusCibles.length + 1];
                // listeIndividus = listeIndividusCibles;
                // listeIndividus[listeIndividus.length] = b.getListeIndividus()[i];
                // listeIndividusCibles = listeIndividus;
                // }

                // }

                // } else if (selection == "Selection d’individus deja clients ou non") {

                // for (int i = 0; i <= b.getListeIndividus().length; i++) {
                // if ((String) client.getSelectedItem() == "les clients") {
                // if
                // (b.getListeIndividus()[i].getCaracteristiqueCommerciale().equals("client")) {
                // Individu[] listeIndividus = new Individu[listeIndividusCibles.length + 1];
                // listeIndividus = listeIndividusCibles;
                // listeIndividus[listeIndividus.length] = b.getListeIndividus()[i];
                // listeIndividusCibles = listeIndividus;
                // }

                // } else if ((String) client.getSelectedItem() == "les non clients") {
                // if
                // (b.getListeIndividus()[i].getCaracteristiqueCommerciale().equals("prospect"))
                // {
                // Individu[] listeIndividus = new Individu[listeIndividusCibles.length + 1];
                // listeIndividus = listeIndividusCibles;
                // listeIndividus[listeIndividus.length] = b.getListeIndividus()[i];
                // listeIndividusCibles = listeIndividus;
                // }

                // } else if ((String) client.getSelectedItem() == "tout le monde") {
                // if (b.getListeIndividus()[i].getCaracteristiqueCommerciale() != "client
                // interdit") {
                // Individu[] listeIndividus = new Individu[listeIndividusCibles.length + 1];
                // listeIndividus = listeIndividusCibles;
                // listeIndividus[listeIndividus.length] = b.getListeIndividus()[i];
                // listeIndividusCibles = listeIndividus;
                // }
                // }

                // }

                // }

                // if (type == "Papier") {
                // infoToString = new ToStringCibleRoutage(CibleRoutageCreation.vselection,
                // CibleRoutageCreation.vtitre, CibleRoutageCreation.vart1,
                // CibleRoutageCreation.vart2,
                // CibleRoutageCreation.vart3, CibleRoutageCreation.vart4,
                // CibleRoutageCreation.vart5,
                // CibleRoutageCreation.vdescription, CibleRoutageCreation.vstyle,
                // CibleRoutageCreation.vtype);

                // b.addCibleRoutages(CibleRoutageCreation.vselection,
                // CibleRoutageCreation.vtitre,
                // CibleRoutageCreation.vart1, CibleRoutageCreation.vart2,
                // CibleRoutageCreation.vart3,
                // CibleRoutageCreation.vart4, CibleRoutageCreation.vart5,
                // CibleRoutageCreation.vdescription,
                // CibleRoutageCreation.vstyle, CibleRoutageCreation.vtype,
                // b.getListeIndividus() /* listeIndividusCibles */);

                // } else if (type == "Internet") {
                // infoToString = new ToStringCibleRoutage(CibleRoutageCreation.vselection,
                // CibleRoutageCreation.vtitre, CibleRoutageCreation.vart1,
                // CibleRoutageCreation.vart2,
                // CibleRoutageCreation.vart3, CibleRoutageCreation.vart4,
                // CibleRoutageCreation.vart5,
                // CibleRoutageCreation.vdescription, CibleRoutageCreation.vtype);

                // b.addCibleRoutages(CibleRoutageCreation.vselection,
                // CibleRoutageCreation.vtitre,
                // CibleRoutageCreation.vart1, CibleRoutageCreation.vart2,
                // CibleRoutageCreation.vart3,
                // CibleRoutageCreation.vart4, CibleRoutageCreation.vart5,
                // CibleRoutageCreation.vdescription,
                // "", CibleRoutageCreation.vtype, b.getListeIndividus() /* listeIndividusCibles
                // */);
                // }

            }
        });

        // JButton cancelBouton = new JButton("Annuler");
        // cancelBouton.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent arg0) {
        // setVisible(false);
        // }
        // });

        control.add(okBouton);
        // control.add(cancelBouton);

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }

}