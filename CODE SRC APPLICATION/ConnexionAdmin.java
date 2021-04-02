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

public class ConnexionAdmin extends JDialog {
    private ToStringConnexionAdmin infoToString = new ToStringConnexionAdmin();
    private boolean sendData;
    private JLabel selectionLabel, mdpLabel;
    private JComboBox selection;
    private JTextField mdp;
    Fenetre fen;
    BaseDeDonnees b;

    public ConnexionAdmin(JFrame parent, String title, boolean modal, Fenetre f, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(700, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        fen = f;
        b = bd;
        this.initComponent();
    }

    public ToStringConnexionAdmin showConnexionAdmin() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // Selection de l'individu
        JPanel panSelection = new JPanel();
        panSelection.setBackground(Color.white);
        panSelection.setPreferredSize(new Dimension(350, 60));
        panSelection.setBorder(BorderFactory.createTitledBorder("Identifiant "));
        selection = new JComboBox();
        selection.addItem("");
        selection.addItem("Administrateur de donnee");
        selectionLabel = new JLabel("Vous etes : ");
        panSelection.add(selectionLabel);
        panSelection.add(selection);

        // Le mdp
        JPanel panMdp = new JPanel();
        panMdp.setBackground(Color.white);
        panMdp.setPreferredSize(new Dimension(220, 60));
        mdp = new JTextField();
        mdp.setPreferredSize(new Dimension(100, 25));
        panMdp.setBorder(BorderFactory.createTitledBorder("Mot de passe "));
        mdpLabel = new JLabel("Saisir le mdp :");
        panMdp.add(mdpLabel);
        panMdp.add(mdp);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panSelection);
        content.add(panMdp);

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                infoToString = new ToStringConnexionAdmin((String) selection.getSelectedItem(), mdp.getText(), fen, b);
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