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

public class CibleRoutageValidation extends JDialog {

    private ToStringValidationCibleRoutage infoToString = new ToStringValidationCibleRoutage();
    private boolean sendData;
    private JLabel cibleLabel;
    private JComboBox cible;

    BaseDeDonnees b;

    public CibleRoutageValidation(JFrame parent, String title, boolean modal, BaseDeDonnees bd) {
        super(parent, title, modal);
        this.setSize(900, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        b = bd;
        this.initComponent();
    }

    public ToStringValidationCibleRoutage showCibleRoutageValidation() {
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
        if (b.getListeCibleRoutages().length == 0 || b.getListeCibleRoutages() == null) {
            cible.addItem("Pas de cible à valider");
        } else {
            cible.addItem("");
            for (int i = 0; i < b.getListeCibleRoutages().length; i++) {
                if (b.getListeCibleRoutages()[i].getStyle() == "") {
                    cible.addItem("titre : " + b.getListeCibleRoutages()[i].getTitre() + " - type : "
                            + b.getListeCibleRoutages()[i].getType() + " - article(s) : "
                            + b.getListeCibleRoutages()[i].getArticle1() + " "
                            + b.getListeCibleRoutages()[i].getArticle2() + " "
                            + b.getListeCibleRoutages()[i].getArticle3() + " "
                            + b.getListeCibleRoutages()[i].getArticle4() + " "
                            + b.getListeCibleRoutages()[i].getArticle5() + " - description : "
                            + b.getListeCibleRoutages()[i].getDescription());
                } else {
                    cible.addItem("titre : " + b.getListeCibleRoutages()[i].getTitre() + " - type : "
                            + b.getListeCibleRoutages()[i].getType() + " - style : "
                            + b.getListeCibleRoutages()[i].getStyle() + " - article(s) : "
                            + b.getListeCibleRoutages()[i].getArticle1() + " "
                            + b.getListeCibleRoutages()[i].getArticle2() + " "
                            + b.getListeCibleRoutages()[i].getArticle3() + " "
                            + b.getListeCibleRoutages()[i].getArticle4() + " "
                            + b.getListeCibleRoutages()[i].getArticle5() + " - description : "
                            + b.getListeCibleRoutages()[i].getDescription());
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
                infoToString = new ToStringValidationCibleRoutage((String) cible.getSelectedItem());
                int cibleIndex = (int) cible.getSelectedIndex() - 1;
                if (cibleIndex != -1) {

                    b.addCibleRoutagesValide(b.getListeCibleRoutages()[cibleIndex]);
                    b.delCibleRoutage(b.getListeCibleRoutages()[cibleIndex]);
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