import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.plaf.ColorUIResource;

///////////////////////////////////////////////////////////////

public class Fenetre extends JFrame {

    JPanel panel = new JPanel();
    String nomFenetre;
    int rouge, vert, bleu, x, y;

    String t;

    /* _______________________________________________________ */

    public Fenetre(String vFenetre, int r, int v, int b) {

        nomFenetre = vFenetre;
        rouge = r;
        vert = v;
        bleu = b;

        panel.setLayout(null);
        Color couleur = new ColorUIResource(rouge, vert, bleu);
        panel.setBackground(couleur);
        this.setTitle(vFenetre);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        setContentPane(panel);
    }

    public Fenetre(String vFenetre, BaseDeDonnee b) {

        this.setTitle(vFenetre);
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // this.setVisible(true);
        this.setResizable(false);
        // panel.setSize(900, 600);
        // setContentPane(panel);

        // Les donnees du tableau
        Object data[][] = new Object[b.getTabCibleRoutages().length][10];

        for (int i = 0; i < b.getTabCibleRoutages().length; i++) {
            data[i][0] = b.getTabCibleRoutages()[i].getTitre();
            data[i][1] = b.getTabCibleRoutages()[i].getSelection();
            data[i][2] = b.getTabCibleRoutages()[i].getDescription();
            data[i][3] = b.getTabCibleRoutages()[i].getArticle1();
            data[i][4] = b.getTabCibleRoutages()[i].getArticle2();
            data[i][5] = b.getTabCibleRoutages()[i].getArticle3();
            data[i][6] = b.getTabCibleRoutages()[i].getArticle4();
            data[i][7] = b.getTabCibleRoutages()[i].getArticle5();
            data[i][8] = b.getTabCibleRoutages()[i].getStyle();
            data[i][9] = b.getTabCibleRoutages()[i].getType();
        }

        // Les titres des colonnes
        String title[] = { "Titre", "Slection par", "Description", "Article n°1", "Article n°2", "Article n°3",
                "Article n°4", "Article n°5", "Style", "Type" };
        JTable tableau = new JTable(data, title) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        this.getContentPane().add(new JScrollPane(tableau));

    }

}
