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

public class DetailsCommande extends JDialog {

    private ToStringDetailsCommande infoToString = new ToStringDetailsCommande();
    private boolean sendData;
    private JLabel commandeLabel;
    private JComboBox commande;

    BaseDeDonnees b;

    public DetailsCommande(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(900, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringDetailsCommande showDetailsCommande() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // Commande
        JPanel panCommande = new JPanel();
        panCommande.setBackground(Color.white);
        panCommande.setPreferredSize(new Dimension(800, 60));
        panCommande.setBorder(BorderFactory.createTitledBorder("Selection d'une commande"));
        commande = new JComboBox();
        if (b.getListeCommande().length == 0 || b.getListeCommande() == null) {
            commande.addItem("Pas de commande");
        } else {
            commande.addItem("");
            for (int i = 0; i < b.getListeCommande().length; i++) {
                commande.addItem("n° " + b.getListeCommande()[i].getNumeroCommande() + " - Montant total : "
                        + b.getListeCommande()[i].getMontant() + " euros - Client : "
                        + b.getListeCommande()[i].getIndividu().getNom() + " "
                        + b.getListeCommande()[i].getIndividu().getPrenom());
            }
        }

        commandeLabel = new JLabel("");
        panCommande.add(commandeLabel);
        panCommande.add(commande);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panCommande);

        JPanel control = new JPanel();

        JButton voirCommande = new JButton("Voir le detail");
        voirCommande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int commandeIndex = (int) commande.getSelectedIndex() - 1;
                Commande cmd = b.getListeCommande()[commandeIndex];
                String typeCmd = b.getListeCommande()[commandeIndex].getReglement().getType();
                setVisible(false);
                Fenetre recapCommande = new Fenetre("Recapitulatif de la commande", typeCmd, cmd);
                recapCommande.setVisible(true);
            }
        });

        JButton cancelBouton = new JButton("Annuler");
        cancelBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });

        // control.add(okBouton);
        control.add(voirCommande);
        control.add(cancelBouton);

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }

}