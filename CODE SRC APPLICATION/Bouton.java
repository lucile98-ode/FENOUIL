import javax.swing.JButton;

public class Bouton extends JButton {

    String texteBouton;
    int position_x;
    int position_y;
    int largeur;
    int hauteur;

    public Bouton(String texte_bouton, int x, int y, int l, int h) {

        texteBouton = texte_bouton;
        position_x = x;
        position_y = y;
        largeur = l;
        hauteur = h;

        this.setText(texteBouton);
        this.setBounds(position_x, position_y, largeur, hauteur);
        this.setVisible(true);
    }
}