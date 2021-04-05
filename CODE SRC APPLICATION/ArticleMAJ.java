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

public class ArticleMAJ extends JDialog {

    private ToStringArticleMAJ infoToString = new ToStringArticleMAJ();
    private boolean sendData;
    private JLabel designationLabel, prixLabel, quantiteLabel, articleLabel;
    private JComboBox article;
    private JTextField designation;
    private JSpinner prix, quantite;

    BaseDeDonnees b;
    String modification;

    public ArticleMAJ(JFrame parent, String title, boolean modal, String modif, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(530, 215);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        modification = modif;
        this.initComponent();
    }

    public ToStringArticleMAJ showArticleMAJ() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        JPanel content = new JPanel();

        // Article
        JPanel panArticle = new JPanel();
        panArticle.setBackground(Color.white);
        panArticle.setPreferredSize(new Dimension(480, 60));
        panArticle.setBorder(BorderFactory.createTitledBorder("Selection de l'article a modifier"));
        article = new JComboBox();
        if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
            article.addItem("Pas d'article a modifier");
        } else {
            article.addItem("");
            for (int i = 0; i < b.getListeArticles().length; i++) {
                article.addItem("reference : " + b.getListeArticles()[i].getNumero() + " - "
                        + b.getListeArticles()[i].getDesignation() + " - " + b.getListeArticles()[i].getPrix()
                        + " euro(s) " + b.getListeArticles()[i].getQuantite() + " en stock");
            }
        }

        articleLabel = new JLabel("");
        panArticle.add(articleLabel);
        panArticle.add(article);
        content.setBackground(Color.white);
        content.add(panArticle);

        if (modification == "designation") {
            // Designation de l'article
            JPanel panDesignation = new JPanel();
            panDesignation.setBackground(Color.white);
            panDesignation.setPreferredSize(new Dimension(280, 65));
            panDesignation.setBorder(BorderFactory.createTitledBorder("Designation"));
            designation = new JTextField();
            designation.setPreferredSize(new Dimension(150, 25));
            designationLabel = new JLabel("Nom :");
            panDesignation.add(designationLabel);
            panDesignation.add(designation);
            content.add(panDesignation);

        } else if (modification == "prix") {
            // Prix de l'article
            JPanel panPrix = new JPanel();
            panPrix.setBackground(Color.white);
            panPrix.setPreferredSize(new Dimension(200, 65));
            panPrix.setBorder(BorderFactory.createTitledBorder("Prix Unitaire"));
            prix = new JSpinner();
            prix.setValue(01);
            prix.setPreferredSize(new Dimension(50, 30));
            prixLabel = new JLabel("Prix : ");
            panPrix.add(prixLabel);
            panPrix.add(prix);
            content.add(panPrix);

        } else if (modification == "quantite") {
            // Quantite de l'article
            JPanel panQuantite = new JPanel();
            panQuantite.setBackground(Color.white);
            panQuantite.setPreferredSize(new Dimension(200, 65));
            panQuantite.setBorder(BorderFactory.createTitledBorder("Stock initial"));
            quantite = new JSpinner();
            quantite.setValue(01);
            quantite.setPreferredSize(new Dimension(50, 30));
            quantiteLabel = new JLabel("Quantite : ");
            panQuantite.add(quantiteLabel);
            panQuantite.add(quantite);
            content.add(panQuantite);
        }

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String articleSelect = (String) article.getSelectedItem();
                int articleIndex = (int) article.getSelectedIndex() - 1;

                if (modification == "designation") {
                    infoToString = new ToStringArticleMAJ((String) designation.getText(), modification, articleSelect);
                    if (articleIndex != -1) {
                        b.getListeArticles()[articleIndex].setDesignation((String) designation.getText());
                    }

                } else if (modification == "prix") {
                    infoToString = new ToStringArticleMAJ((int) prix.getValue(), modification, articleSelect);
                    if (articleIndex != -1) {
                        b.getListeArticles()[articleIndex].setPrix((int) prix.getValue());
                    }

                } else if (modification == "quantite") {
                    infoToString = new ToStringArticleMAJ((int) quantite.getValue(), modification, articleSelect);
                    if (articleIndex != -1) {
                        b.getListeArticles()[articleIndex].setQuantite((int) quantite.getValue());
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