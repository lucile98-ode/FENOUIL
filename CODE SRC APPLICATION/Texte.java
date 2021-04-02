import javax.swing.JLabel;
import java.awt.Font;

public class Texte extends JLabel {
    String texte;
    int position_x;
    int position_y;
    int largeur;
    int hauteur;
    int taille_texte;
    String police;

    public Texte(String t, int x, int y, int l, int h, int taille_t, String p) {

        texte = t;
        position_x = x;
        position_y = y;
        largeur = l;
        hauteur = h;
        taille_texte = taille_t;
        police = p;

        this.setText(texte);
        this.setBounds(x, y, l, h);
        Font font = new Font(police, Font.BOLD, taille_texte);
        this.setFont(font);
        this.setVisible(true);
    }

}