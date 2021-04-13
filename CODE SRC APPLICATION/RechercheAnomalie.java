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

public class RechercheAnomalie extends JDialog {

    private ToStringRechercheAnomalie infoToString = new ToStringRechercheAnomalie();
    private boolean sendData;
    private JLabel individuLabel, numeroLabel, dateLabel;
    private JComboBox individu, numero, date;

    BaseDeDonnees b;
    String etat;
    Anomalie an;

    public RechercheAnomalie(JFrame parent, String title, boolean modal, BaseDeDonnees b, String etat, Anomalie an) {
        super(parent, title, modal);
        this.setSize(500, 160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.b = b;
        this.etat = etat;
        this.an = an;
        this.initComponent();
    }

    public ToStringRechercheAnomalie showRechercheAnomalie() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        JPanel content = new JPanel();
        content.setBackground(Color.white);

        if (etat == "individu") {
            // Individu
            JPanel panIndividu = new JPanel();
            panIndividu.setBackground(Color.white);
            panIndividu.setPreferredSize(new Dimension(450, 60));
            panIndividu.setBorder(BorderFactory.createTitledBorder("Selection d'une anomalie par individu"));
            individu = new JComboBox();
            if (b.getListeAnomalie().length == 0 || b.getListeAnomalie() == null) {
                individu.addItem("pas d'anomalie");
            } else {
                individu.addItem("");
                for (int i = 0; i < b.getListeAnomalie().length; i++) {
                    individu.addItem(b.getListeAnomalie()[i].getIndividu().getNom() + " "
                            + b.getListeAnomalie()[i].getIndividu().getPrenom() + " né(e) le "
                            + b.getListeAnomalie()[i].getIndividu().getDate());
                }
            }

            individuLabel = new JLabel("");
            panIndividu.add(individuLabel);
            panIndividu.add(individu);
            content.add(panIndividu);

        } else if (etat == "numero") {
            // Numero
            JPanel panNumero = new JPanel();
            panNumero.setBackground(Color.white);
            panNumero.setPreferredSize(new Dimension(450, 60));
            panNumero.setBorder(BorderFactory.createTitledBorder("Selection d'une anomalie par numero de commande"));
            numero = new JComboBox();
            if (b.getListeAnomalie().length == 0 || b.getListeAnomalie() == null) {
                numero.addItem("pas d'anomalie");
            } else {
                numero.addItem("");
                for (int i = 0; i < b.getListeAnomalie().length; i++) {
                    numero.addItem(b.getListeAnomalie()[i].getCommande().getNumeroCommande());
                }
            }

            numeroLabel = new JLabel("");
            panNumero.add(numeroLabel);
            panNumero.add(numero);
            content.add(panNumero);

        } else if (etat == "date") {
            // Numero
            JPanel panDate = new JPanel();
            panDate.setBackground(Color.white);
            panDate.setPreferredSize(new Dimension(450, 60));
            panDate.setBorder(BorderFactory.createTitledBorder("Selection d'une anomalie par date de commande"));
            date = new JComboBox();
            if (b.getListeAnomalie().length == 0 || b.getListeAnomalie() == null) {
                date.addItem("pas d'anomalie");
            } else {
                date.addItem("");
                for (int i = 0; i < b.getListeAnomalie().length; i++) {
                    date.addItem(b.getListeAnomalie()[i].getDate().toStringDate());
                }
            }

            dateLabel = new JLabel("");
            panDate.add(dateLabel);
            panDate.add(date);
            content.add(panDate);

        }

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                if (etat == "individu") {
                    int individuIndex = (int) individu.getSelectedIndex() - 1;
                    if (individuIndex != -1) {
                        an = b.getListeAnomalie()[individuIndex];
                        b.addAnomalieResolues(b.getListeAnomalie()[individuIndex]);
                        b.delAnomalie(b.getListeAnomalie()[individuIndex]);
                    }
                    Fenetre recapAnomalie = new Fenetre("Edition courrier", "individu", an);
                    recapAnomalie.setVisible(true);

                } else if (etat == "numero") {
                    int numeroIndex = (int) numero.getSelectedIndex() - 1;
                    if (numeroIndex != -1) {
                        an = b.getListeAnomalie()[numeroIndex];
                        b.addAnomalieResolues(b.getListeAnomalie()[numeroIndex]);
                        b.delAnomalie(b.getListeAnomalie()[numeroIndex]);
                    }
                    Fenetre recapAnomalie = new Fenetre("Edition courrier", "numero", an);
                    recapAnomalie.setVisible(true);

                } else if (etat == "date") {
                    int dateIndex = (int) date.getSelectedIndex() - 1;
                    if (dateIndex != -1) {
                        an = b.getListeAnomalie()[dateIndex];
                        b.addAnomalieResolues(b.getListeAnomalie()[dateIndex]);
                        b.delAnomalie(b.getListeAnomalie()[dateIndex]);
                    }
                    Fenetre recapAnomalie = new Fenetre("Edition courrier", "date", an);
                    recapAnomalie.setVisible(true);
                }

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