import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.plaf.ColorUIResource;

public class Fenetre extends JFrame {

    JPanel panel = new JPanel();
    String nomFenetre;
    int rouge, vert, bleu, x, y;

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

    public Fenetre(String vFenetre, String cible, BaseDeDonnees b) {

        this.setTitle(vFenetre);
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        if (cible == "cibles Crees") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeCibleRoutages().length][10];

            // System.out.println(b.getListeCibleRoutages().length);

            for (int i = 0; i < b.getListeCibleRoutages().length; i++) {
                data[i][0] = b.getListeCibleRoutages()[i].getTitre();
                data[i][1] = b.getListeCibleRoutages()[i].getSelection();
                data[i][2] = b.getListeCibleRoutages()[i].getDescription();
                data[i][3] = b.getListeCibleRoutages()[i].getArticle1();
                data[i][4] = b.getListeCibleRoutages()[i].getArticle2();
                data[i][5] = b.getListeCibleRoutages()[i].getArticle3();
                data[i][6] = b.getListeCibleRoutages()[i].getArticle4();
                data[i][7] = b.getListeCibleRoutages()[i].getArticle5();
                data[i][8] = b.getListeCibleRoutages()[i].getStyle();
                data[i][9] = b.getListeCibleRoutages()[i].getType();
            }

            // Les titres des colonnes
            String title[] = { "Titre", "Selection par", "Description", "Article n°1", "Article n°2", "Article n°3",
                    "Article n°4", "Article n°5", "Style", "Type" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));
        }

        else if (cible == "cibles Validees") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeCibleRoutagesValide().length][10];

            for (int i = 0; i < b.getListeCibleRoutagesValide().length; i++) {
                data[i][0] = b.getListeCibleRoutagesValide()[i].getTitre();
                data[i][1] = b.getListeCibleRoutagesValide()[i].getSelection();
                data[i][2] = b.getListeCibleRoutagesValide()[i].getDescription();
                data[i][3] = b.getListeCibleRoutagesValide()[i].getArticle1();
                data[i][4] = b.getListeCibleRoutagesValide()[i].getArticle2();
                data[i][5] = b.getListeCibleRoutagesValide()[i].getArticle3();
                data[i][6] = b.getListeCibleRoutagesValide()[i].getArticle4();
                data[i][7] = b.getListeCibleRoutagesValide()[i].getArticle5();
                data[i][8] = b.getListeCibleRoutagesValide()[i].getStyle();
                data[i][9] = b.getListeCibleRoutagesValide()[i].getType();
            }

            // Les titres des colonnes
            String title[] = { "Titre", "Selection par", "Description", "Article n°1", "Article n°2", "Article n°3",
                    "Article n°4", "Article n°5", "Style", "Type" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));
        }

        else if (cible == "cibles Envoyees") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeCibleRoutagesEnvoyee().length][10];

            for (int i = 0; i < b.getListeCibleRoutagesEnvoyee().length; i++) {
                data[i][0] = b.getListeCibleRoutagesEnvoyee()[i].getTitre();
                data[i][1] = b.getListeCibleRoutagesEnvoyee()[i].getSelection();
                data[i][2] = b.getListeCibleRoutagesEnvoyee()[i].getDescription();
                data[i][3] = b.getListeCibleRoutagesEnvoyee()[i].getArticle1();
                data[i][4] = b.getListeCibleRoutagesEnvoyee()[i].getArticle2();
                data[i][5] = b.getListeCibleRoutagesEnvoyee()[i].getArticle3();
                data[i][6] = b.getListeCibleRoutagesEnvoyee()[i].getArticle4();
                data[i][7] = b.getListeCibleRoutagesEnvoyee()[i].getArticle5();
                data[i][8] = b.getListeCibleRoutagesEnvoyee()[i].getStyle();
                data[i][9] = b.getListeCibleRoutagesEnvoyee()[i].getType();
            }

            // Les titres des colonnes
            String title[] = { "Titre", "Selection par", "Description", "Article n°1", "Article n°2", "Article n°3",
                    "Article n°4", "Article n°5", "Style", "Type" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));

        } else if (cible == "liste individu") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeIndividus().length][9];

            for (int i = 0; i < b.getListeIndividus().length; i++) {
                data[i][0] = b.getListeIndividus()[i].getNom();
                data[i][1] = b.getListeIndividus()[i].getPrenom();
                data[i][2] = b.getListeIndividus()[i].getAge();
                data[i][3] = b.getListeIndividus()[i].getDateNaissance();
                data[i][4] = b.getListeIndividus()[i].getCategorieSocioProfessionnelle();
                data[i][5] = b.getListeIndividus()[i].getAdresse();
                data[i][6] = b.getListeIndividus()[i].getNumeroTelephone();
                data[i][7] = b.getListeIndividus()[i].getAdresseMail();
                data[i][8] = b.getListeIndividus()[i].getCaracteristiqueCommerciale();
            }

            // Les titres des colonnes
            String title[] = { "Nom", "Prenom", "Age", "Date de naissance", "Categorie Socio Professionnelle",
                    "Adresse", "Numero de telephone", "email", "Carateristique commerciale" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));
        }

        else if (cible == "liste article") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeArticles().length][4];

            for (int i = 0; i < b.getListeArticles().length; i++) {
                data[i][0] = b.getListeArticles()[i].getNumero();
                data[i][1] = b.getListeArticles()[i].getDesignation();
                data[i][2] = b.getListeArticles()[i].getPrix() + " euros";
                data[i][3] = b.getListeArticles()[i].getQuantite();

            }

            // Les titres des colonnes
            String title[] = { "Numero", "Designation", "Prix", "Quantite en stock" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));
        }

    }

    public void disposeFenetre(Fenetre fen) {
        fen.dispose();
    }
}
