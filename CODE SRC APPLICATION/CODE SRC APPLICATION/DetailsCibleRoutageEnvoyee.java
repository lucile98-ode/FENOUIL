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

public class DetailsCibleRoutageEnvoyee extends JDialog {

    private ToStringDetailsCibleRoutageEnvoyee infoToString = new ToStringDetailsCibleRoutageEnvoyee();
    private boolean sendData;
    private JLabel cibleLabel;
    private JComboBox cible;

    BaseDeDonnees b;

    public DetailsCibleRoutageEnvoyee(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(900, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringDetailsCibleRoutageEnvoyee showDetailsCibleRoutageEnvoyee() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // cible
        JPanel panCible = new JPanel();
        panCible.setBackground(Color.white);
        panCible.setPreferredSize(new Dimension(800, 60));
        panCible.setBorder(BorderFactory.createTitledBorder("Selection d'une cible de routage"));
        cible = new JComboBox();
        if (b.getListeCibleRoutagesEnvoyee().length == 0 || b.getListeCibleRoutagesEnvoyee() == null) {
            cible.addItem("Pas de cible de routage");
        } else {
            cible.addItem("");
            for (int i = 0; i < b.getListeCibleRoutagesEnvoyee().length; i++) {
                cible.addItem("Type : " + b.getListeCibleRoutagesEnvoyee()[i].getType() + " - Titre : "
                        + b.getListeCibleRoutagesEnvoyee()[i].getTitre() + " - articles : "
                        + b.getListeCibleRoutagesEnvoyee()[i].getArticle1() + " "
                        + b.getListeCibleRoutagesEnvoyee()[i].getArticle2() + " "
                        + b.getListeCibleRoutagesEnvoyee()[i].getArticle3() + " "
                        + b.getListeCibleRoutagesEnvoyee()[i].getArticle4() + " "
                        + b.getListeCibleRoutagesEnvoyee()[i].getArticle5() + " - "
                        + b.getListeCibleRoutagesEnvoyee()[i].getSelection());
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
                CibleRoutage cr = b.getListeCibleRoutagesEnvoyee()[cibleIndex];
                String typeCr = b.getListeCibleRoutagesEnvoyee()[cibleIndex].getType();
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