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

public class CibleRoutageEnvoi extends JDialog {
    private ToStringEnvoiCibleRoutage infoToString = new ToStringEnvoiCibleRoutage();
    private boolean sendData;
    private JLabel cibleLabel;
    private JComboBox cible;

    BaseDeDonnees b;

    public CibleRoutageEnvoi(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(900, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringEnvoiCibleRoutage showCibleRoutageEnvoi() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        // Cible routage
        JPanel panCible = new JPanel();
        panCible.setBackground(Color.white);
        panCible.setPreferredSize(new Dimension(800, 60));
        panCible.setBorder(BorderFactory.createTitledBorder("Selection d'une cible de routage"));
        cible = new JComboBox();
        if (b.getListeCibleRoutagesValide().length == 0 || b.getListeCibleRoutagesValide() == null) {
            cible.addItem("Pas de cible à valider");
        } else {
            cible.addItem("");
            for (int i = 0; i < b.getListeCibleRoutagesValide().length; i++) {
                if (b.getListeCibleRoutagesValide()[i].getStyle() == "") {
                    cible.addItem("titre : " + b.getListeCibleRoutagesValide()[i].getTitre() + " - type : "
                            + b.getListeCibleRoutagesValide()[i].getType() + " - article(s) : "
                            + b.getListeCibleRoutagesValide()[i].getArticle1() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle2() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle3() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle4() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle5() + " - description : "
                            + b.getListeCibleRoutagesValide()[i].getDescription());
                } else {
                    cible.addItem("titre : " + b.getListeCibleRoutagesValide()[i].getTitre() + " - type : "
                            + b.getListeCibleRoutagesValide()[i].getType() + " - style : "
                            + b.getListeCibleRoutagesValide()[i].getStyle() + " - article(s) : "
                            + b.getListeCibleRoutagesValide()[i].getArticle1() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle2() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle3() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle4() + " "
                            + b.getListeCibleRoutagesValide()[i].getArticle5() + " - description : "
                            + b.getListeCibleRoutagesValide()[i].getDescription());
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
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                infoToString = new ToStringEnvoiCibleRoutage((String) cible.getSelectedItem());
                int cibleIndex = (int) cible.getSelectedIndex() - 1;
                if (cibleIndex != -1) {

                    b.addCibleRoutagesAEnvoyer(b.getListeCibleRoutagesValide()[cibleIndex]);
                    b.delCibleRoutageValide(b.getListeCibleRoutagesValide()[cibleIndex]);
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