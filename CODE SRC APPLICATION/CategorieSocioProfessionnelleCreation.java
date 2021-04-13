
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CategorieSocioProfessionnelleCreation extends JDialog {

    private ToStringCategorieSocioProfessionnelle infoToString = new ToStringCategorieSocioProfessionnelle();
    private boolean sendData;
    private JLabel categorieLabel;
    private JTextField categorie;

    BaseDeDonnees b;

    public CategorieSocioProfessionnelleCreation(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(330, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringCategorieSocioProfessionnelle showCategorieSocioProfessionnelleCreation() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        JPanel content = new JPanel();

        // categorie
        JPanel panCategorie = new JPanel();
        panCategorie.setBackground(Color.white);
        panCategorie.setPreferredSize(new Dimension(300, 65));
        panCategorie.setBorder(BorderFactory.createTitledBorder("Creer une categorie socio professionnelle"));
        categorie = new JTextField();
        categorie.setPreferredSize(new Dimension(180, 25));
        categorieLabel = new JLabel("Saisir :");
        panCategorie.add(categorieLabel);
        panCategorie.add(categorie);
        content.add(panCategorie);

        JPanel control = new JPanel();
        content.setBackground(Color.white);
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                infoToString = new ToStringCategorieSocioProfessionnelle((String) categorie.getText());
                b.addCategorieSocioProfessionnelle((String) categorie.getText());
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