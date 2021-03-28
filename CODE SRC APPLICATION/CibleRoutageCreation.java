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

public class CibleRoutageCreation extends JDialog {
    private ToStringCibleRoutage infoToString = new ToStringCibleRoutage();
    private boolean sendData;
    private JLabel titreLabel, selectionLabel, articleLabel, styleLabel, descriptionLabel, typeLabel;
    private JComboBox selection, art1, art2, art3, art4, art5, style, type;
    private JTextField titre, description;

    String typePub;
    BaseDeDonnees b;
    static String vselection, vtitre, vart1, vart2, vart3, vart4, vart5, vdescription, vstyle, vtype;

    public CibleRoutageCreation(JFrame parent, String title, boolean modal, String TPub, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(700, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        typePub = TPub;
        b = bd;
        this.initComponent();
    }

    public ToStringCibleRoutage showCibleRoutage() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // Selection de l'individu
        JPanel panSelection = new JPanel();
        panSelection.setBackground(Color.white);
        panSelection.setPreferredSize(new Dimension(350, 60));
        panSelection.setBorder(BorderFactory.createTitledBorder("Selection des Individus"));
        selection = new JComboBox();
        selection.addItem("Categorie socio-professionnelle");
        selection.addItem("Age");
        selection.addItem("Departement de residence");
        selection.addItem("Selection d’individus deja clients ou non");
        selectionLabel = new JLabel("par : ");
        panSelection.add(selectionLabel);
        panSelection.add(selection);

        // Article
        JPanel panArticle = new JPanel();
        panArticle.setBackground(Color.white);
        panArticle.setPreferredSize(new Dimension(575, 90));
        panArticle.setBorder(BorderFactory.createTitledBorder("Selection des articles (5 max)"));
        art1 = new JComboBox();
        if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
            art1.addItem("Aucun produit enregistre");
        }
        for (int i = 0; i < b.getListeArticles().length; i++) {
            art1.addItem(b.getListeArticles()[i].getDesignation());
        }

        art2 = new JComboBox();
        if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
            art2.addItem("Aucun produit enregistre");
        }
        art2.addItem("");
        for (int i = 0; i < b.getListeArticles().length; i++) {
            art2.addItem(b.getListeArticles()[i].getDesignation());
        }

        art3 = new JComboBox();
        if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
            art3.addItem("Aucun produit enregistre");
        }
        art3.addItem("");
        for (int i = 0; i < b.getListeArticles().length; i++) {
            art3.addItem(b.getListeArticles()[i].getDesignation());
        }

        art4 = new JComboBox();
        if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
            art4.addItem("Aucun produit enregistre");
        }
        art4.addItem("");
        for (int i = 0; i < b.getListeArticles().length; i++) {
            art4.addItem(b.getListeArticles()[i].getDesignation());
        }

        art5 = new JComboBox();
        if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
            art5.addItem("Aucun produit enregistre");
        }
        art5.addItem("");
        for (int i = 0; i < b.getListeArticles().length; i++) {
            art5.addItem(b.getListeArticles()[i].getDesignation());
        }

        articleLabel = new JLabel("");
        panArticle.add(articleLabel);
        panArticle.add(art1);
        panArticle.add(art2);
        panArticle.add(art3);
        panArticle.add(art4);
        panArticle.add(art5);

        // Le titre
        JPanel panTitre = new JPanel();
        panTitre.setBackground(Color.white);
        panTitre.setPreferredSize(new Dimension(220, 60));
        titre = new JTextField();
        titre.setPreferredSize(new Dimension(100, 25));
        panTitre.setBorder(BorderFactory.createTitledBorder("Titre de la publicite "));
        titreLabel = new JLabel("Saisir un titre :");
        panTitre.add(titreLabel);
        panTitre.add(titre);

        // Le description
        JPanel panDescription = new JPanel();
        panDescription.setBackground(Color.white);
        panDescription.setPreferredSize(new Dimension(225, 60));
        description = new JTextField();
        description.setPreferredSize(new Dimension(100, 25));
        panDescription.setBorder(BorderFactory.createTitledBorder("Description de la publicite "));
        descriptionLabel = new JLabel("Saisir : ");
        panDescription.add(descriptionLabel);
        panDescription.add(description);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panSelection);
        content.add(panTitre);
        content.add(panArticle);
        content.add(panDescription);

        if (typePub == "Papier") {
            // Le Style
            JPanel panStyle = new JPanel();
            panStyle.setBackground(Color.white);
            panStyle.setPreferredSize(new Dimension(150, 60));
            style = new JComboBox();
            style.setPreferredSize(new Dimension(115, 25));
            style.addItem("standard");
            style.addItem("superieur");
            style.addItem("economique");
            panStyle.setBorder(BorderFactory.createTitledBorder("Style de la publicite "));
            styleLabel = new JLabel("");
            panStyle.add(styleLabel);
            panStyle.add(style);
            content.add(panStyle);

            // Le Type
            JPanel panType = new JPanel();
            panType.setBackground(Color.white);
            panType.setPreferredSize(new Dimension(190, 60));
            type = new JComboBox();
            type.setPreferredSize(new Dimension(145, 25));
            type.addItem("catalogue papier");
            panType.setBorder(BorderFactory.createTitledBorder("Type de la publicite "));
            typeLabel = new JLabel("");
            panType.add(typeLabel);
            panType.add(type);
            content.add(panType);

        } else if (typePub == "Internet") {
            // Le Type
            JPanel panType = new JPanel();
            panType.setBackground(Color.white);
            panType.setPreferredSize(new Dimension(300, 60));
            type = new JComboBox();
            type.setPreferredSize(new Dimension(250, 25));
            type.addItem("email envoye par internet");
            type.addItem("SMS");
            type.addItem("publicite dans un moteur de recherche");
            panType.setBorder(BorderFactory.createTitledBorder("Type de la publicite "));
            typeLabel = new JLabel("");
            panType.add(typeLabel);
            panType.add(type);
            content.add(panType);
        }

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if (typePub == "Papier") {
                    infoToString = new ToStringCibleRoutage((String) selection.getSelectedItem(), titre.getText(),
                            (String) art1.getSelectedItem(), (String) art2.getSelectedItem(),
                            (String) art3.getSelectedItem(), (String) art4.getSelectedItem(),
                            (String) art5.getSelectedItem(), description.getText(), (String) style.getSelectedItem(),
                            (String) type.getSelectedItem());

                    b.addCibleRoutages((String) selection.getSelectedItem(), titre.getText(),
                            (String) art1.getSelectedItem(), (String) art2.getSelectedItem(),
                            (String) art3.getSelectedItem(), (String) art4.getSelectedItem(),
                            (String) art5.getSelectedItem(), description.getText(), (String) style.getSelectedItem(),
                            (String) type.getSelectedItem(), b.getListeIndividus());
                    // System.out.println(b.toString());
                } else if (typePub == "Internet") {
                    infoToString = new ToStringCibleRoutage((String) selection.getSelectedItem(), titre.getText(),
                            (String) art1.getSelectedItem(), (String) art2.getSelectedItem(),
                            (String) art3.getSelectedItem(), (String) art4.getSelectedItem(),
                            (String) art5.getSelectedItem(), description.getText(), (String) type.getSelectedItem());

                    b.addCibleRoutages((String) selection.getSelectedItem(), titre.getText(),
                            (String) art1.getSelectedItem(), (String) art2.getSelectedItem(),
                            (String) art3.getSelectedItem(), (String) art4.getSelectedItem(),
                            (String) art5.getSelectedItem(), description.getText(), "", (String) type.getSelectedItem(),
                            b.getListeIndividus());
                }

                // vselection = (String) selection.getSelectedItem();
                // vtitre = titre.getText();
                // vart1 = (String) art1.getSelectedItem();
                // vart2 = (String) art2.getSelectedItem();
                // vart3 = (String) art3.getSelectedItem();
                // vart4 = (String) art4.getSelectedItem();
                // vart5 = (String) art5.getSelectedItem();
                // vdescription = description.getText();
                // if (typePub == "Papier") {
                // vstyle = (String) style.getSelectedItem();
                // } else {
                // vstyle = "";
                // }
                // vtype = (String) type.getSelectedItem();

                setVisible(false);
                // Selection s = new Selection(null, "Definir : " + (String)
                // selection.getSelectedItem(), true, b,
                // (String) selection.getSelectedItem(), infoToString);

                // ToStringCibleRoutage infoToString = s.showCibleRoutage();
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