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

public class DetailsCibleRoutage extends JDialog {

    private ToStringDetailsCibleRoutage infoToString = new ToStringDetailsCibleRoutage();
    private boolean sendData;
    private JLabel cibleLabel;
    private JComboBox cible;

    BaseDeDonnees b;

    public DetailsCibleRoutage(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(500, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringDetailsCibleRoutage showDetailsCibleRoutage() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // cible
        JPanel panCible = new JPanel();
        panCible.setBackground(Color.white);
        panCible.setPreferredSize(new Dimension(400, 60));
        panCible.setBorder(BorderFactory.createTitledBorder("Selection d'une cible de routage"));
        cible = new JComboBox();
        if (b.getListeCibleRoutages().length == 0 || b.getListeCibleRoutages() == null) {
            cible.addItem("Pas de cible de routage");
        } else {
            cible.addItem("");
            for (int i = 0; i < b.getListeCibleRoutages().length; i++) {
                cible.addItem("Titre : " + b.getListeCibleRoutages()[i].getTitre());
            }
        }

        cibleLabel = new JLabel("");
        panCible.add(cibleLabel);
        panCible.add(cible);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panCible);

        JPanel control = new JPanel();

        JButton voirCible = new JButton("Voir le detail");
        voirCible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int cibleIndex = (int) cible.getSelectedIndex() - 1;
                CibleRoutage cr = b.getListeCibleRoutages()[cibleIndex];
                String typeCr = b.getListeCibleRoutages()[cibleIndex].getType();
                setVisible(false);
                Fenetre recapCible = new Fenetre("Recapitulatif de la cible de routage", typeCr, cr);
                recapCible.setVisible(true);
            }
        });

        JButton cancelBouton = new JButton("Annuler");
        cancelBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });

        control.add(voirCible);
        control.add(cancelBouton);

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }

}