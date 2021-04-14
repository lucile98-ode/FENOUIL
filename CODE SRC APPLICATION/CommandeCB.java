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

public class CommandeCB extends JDialog {

    private ToStringCommandeCB infoToString = new ToStringCommandeCB();
    private boolean sendData;
    private JLabel cibleLabel;
    private JComboBox cible;

    BaseDeDonnees b;

    public CommandeCB(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(500, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringCommandeCB showCommandeCB() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // cible
        JPanel panCible = new JPanel();
        panCible.setBackground(Color.white);
        panCible.setPreferredSize(new Dimension(400, 60));
        panCible.setBorder(BorderFactory.createTitledBorder("Selection de la commande"));
        cible = new JComboBox();
        if (b.getListeCommandeAEnregistrer().length == 0 || b.getListeCommandeAEnregistrer() == null) {
            cible.addItem("Pas de commande CB");
        } else {
            cible.addItem("");
            for (int i = 0; i < b.getListeCommandeAEnregistrer().length; i++) {
                if (b.getListeCommandeAEnregistrer()[i].getReglement().getType() == "CB") {
                    cible.addItem("n° " + b.getListeCommandeAEnregistrer()[i].getNumeroCommande());
                } else {
                    cible.addItem("Pas de commande CB");
                }
            }
        }

        cibleLabel = new JLabel("");
        panCible.add(cibleLabel);
        panCible.add(cible);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panCible);

        JPanel control = new JPanel();

        JButton voirCible = new JButton("Enregistrer");
        voirCible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int cibleIndex = (int) cible.getSelectedIndex() - 1;
                Commande cmd = b.getListeCommandeAEnregistrer()[cibleIndex];
                if (cmd.getAnomalie()) {
                    b.addCommandeInvalide(cmd);
                } else {
                    b.addCommandeValide(cmd);
                }
                b.delCommandeEnregistre(cmd);
                setVisible(false);
                Fenetre recapCible = new Fenetre("Recapitulatif de la commande", cmd.getReglement().getType(), cmd);
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