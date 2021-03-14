import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class InterfaceGraphique {

    public static void Accueil(BaseDeDonnee b) {

        Fenetre fen = new Fenetre("Ecran Accueil", 100, 100, 150);
        Texte texte1 = new Texte("Fenouil", 410, 75, 500, 100, 50, "Script MT Bold");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Cible de routage", 250, 350, 200, 60);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ConnexionIndividu crc = new ConnexionIndividu(null,
                        "Creation cible de routage - Gerer par le departement \"Prospection\"", true, fen, b);
                ToStringConnexion infoToString = crc.showConnexion();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Connexion", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton2 = new Bouton("Saisir une commande", 550, 350, 200, 60);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(e -> {
            fen.dispose();
        });

        Bouton bouton3 = new Bouton("Anomalie", 550, 450, 200, 60);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            fen.dispose();
        });

        Bouton bouton4 = new Bouton("Référentiel des individus", 250, 450, 200, 60);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(e -> {
            fen.dispose();
        });

        Bouton bouton5 = new Bouton("Quitter", 870, 30, 80, 30);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(e -> {
            fen.dispose();
        });
    }

    public static void CreationCibleDeRoutage(BaseDeDonnee b) {

        Fenetre fen = new Fenetre("Cible de routage", 150, 100, 100);
        Texte texte1 = new Texte("Creation d'une cible de routage", 200, 100, 1000, 100, 50, "Script MT Bold");
        fen.add(texte1);

        Bouton bouton3 = new Bouton("Accueil", 200, 600, 200, 30);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton4 = new Bouton("Retour", 600, 600, 200, 30);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton5 = new Bouton("<html><center>Creer une cible de routage Papier", 250, 450, 200, 75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutageCreation crc = new CibleRoutageCreation(null,
                        "Creation cible de routage - Gerer par le departement \"Prospection\"", true, "Papier", b);
                ToStringCibleRoutage infoToString = crc.showCibleRoutage();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Création Cible de routage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton6 = new Bouton("<html><center>Creer une cible de routage Internet", 550, 450, 200, 75);
        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutageCreation crc = new CibleRoutageCreation(null,
                        "Creation cible de routage - Gerer par le departement \"Prospection\"", true, "Internet", b);
                ToStringCibleRoutage infoToString = crc.showCibleRoutage();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Création Cible de routage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void ValidationCibleDeRoutage(BaseDeDonnee b) {

        Fenetre fen = new Fenetre("Cible de routage", 150, 100, 100);
        Texte texte1 = new Texte("Validation d'une cible de routage", 200, 100, 1000, 100, 50, "Script MT Bold");
        fen.add(texte1);

        Fenetre fen1 = new Fenetre("Liste des cibles de routages", b);

        Bouton bouton3 = new Bouton("Accueil", 200, 600, 200, 30);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            fen.dispose();
            fen1.setVisible(false);
            Accueil(b);
        });

        Bouton bouton4 = new Bouton("Retour", 600, 600, 200, 30);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(e -> {
            fen.dispose();
            fen1.setVisible(false);
            Accueil(b);
        });

        Bouton bouton5 = new Bouton("<html><center>Valider une cible de routage", 250, 450, 200, 75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(e -> {
            fen1.setVisible(false);
        });

        Bouton bouton6 = new Bouton("<html><center>Afficher la liste des cibles de routage", 550, 450, 200, 75);
        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(e -> {
            fen1.setVisible(true);
        });

    }

}