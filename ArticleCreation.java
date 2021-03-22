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

public class ArticleCreation extends JDialog {
    private ToStringCreationArticle infoToString = new ToStringCreationArticle();
    private boolean sendData;
    private JLabel numeroLabel, designationLabel, prixLabel, quantiteLabel;
    private JTextField numero, designation;
    private JSpinner prix, quantite;

    BaseDeDonnees b;

    public ArticleCreation(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringCreationArticle showArticleCreation() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // Numero de l'article
        JPanel panNumero = new JPanel();
        panNumero.setBackground(Color.white);
        panNumero.setPreferredSize(new Dimension(200, 80));
        panNumero.setBorder(BorderFactory.createTitledBorder("Reference"));
        numero = new JTextField();
        numero.setPreferredSize(new Dimension(80, 25));
        numeroLabel = new JLabel("Numero de reference :");
        panNumero.add(numeroLabel);
        panNumero.add(numero);

        // Designation de l'article
        JPanel panDesignation = new JPanel();
        panDesignation.setBackground(Color.white);
        panDesignation.setPreferredSize(new Dimension(200, 80));
        panDesignation.setBorder(BorderFactory.createTitledBorder("Designation"));
        designation = new JTextField();
        designation.setPreferredSize(new Dimension(150, 25));
        designationLabel = new JLabel("Nom :");
        panDesignation.add(designationLabel);
        panDesignation.add(designation);

        // Prix de l'article
        JPanel panPrix = new JPanel();
        panPrix.setBackground(Color.white);
        panPrix.setPreferredSize(new Dimension(200, 80));
        panPrix.setBorder(BorderFactory.createTitledBorder("Prix Unitaire"));
        prix = new JSpinner();
        prix.setValue(01);
        prix.setPreferredSize(new Dimension(50, 30));
        prixLabel = new JLabel("Prix : ");
        panPrix.add(prixLabel);
        panPrix.add(prix);

        // Quantite de l'article
        JPanel panQuantite = new JPanel();
        panQuantite.setBackground(Color.white);
        panQuantite.setPreferredSize(new Dimension(200, 80));
        panQuantite.setBorder(BorderFactory.createTitledBorder("Stock initial"));
        quantite = new JSpinner();
        quantite.setValue(01);
        quantite.setPreferredSize(new Dimension(50, 30));
        quantiteLabel = new JLabel("Quantite : ");
        panQuantite.add(quantiteLabel);
        panQuantite.add(quantite);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panNumero);
        content.add(panDesignation);
        content.add(panPrix);
        content.add(panQuantite);

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                infoToString = new ToStringCreationArticle((String) numero.getText(), (int) prix.getValue(),
                        (String) designation.getText(), (int) quantite.getValue());

                b.addArticle((String) numero.getText(), (String) designation.getText(), (int) prix.getValue(),
                        (int) quantite.getValue());

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