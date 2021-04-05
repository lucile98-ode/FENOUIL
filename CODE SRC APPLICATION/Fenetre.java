import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JTextArea;

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
                data[i][3] = b.getListeIndividus()[i].getDate();
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

        } else if (cible == "liste article") {
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

        } else if (cible == "liste commande valide") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeCommandeValidees().length][5];

            for (int i = 0; i < b.getListeCommandeValidees().length; i++) {
                data[i][0] = b.getListeCommandeValidees()[i].getNumeroCommande();
                data[i][1] = b.getListeCommandeValidees()[i].getIndividu().getNom() + " "
                        + b.getListeCommandeValidees()[i].getIndividu().getPrenom();
                data[i][2] = b.getListeCommandeValidees()[i].getMontant() + " euro(s)";
                String s = "";
                for (int j = 0; j < b.getListeCommandeValidees()[i].getListeArticle().length; j++) {
                    s += b.getListeCommandeValidees()[i].getListeArticle()[j].getDesignation() + " ("
                            + b.getListeCommandeValidees()[i].getListeArticle()[j].getQuantite() + ") ";
                }
                data[i][3] = s;
                data[i][4] = b.getListeCommandeValidees()[i].getReglement().getType();
            }

            // Les titres des colonnes
            String title[] = { "Numero", "Client", "Montant paye", "Article(s) commande(s)", "Paiement par" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));

        } else if (cible == "liste commande") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeCommande().length][7];

            for (int i = 0; i < b.getListeCommande().length; i++) {
                data[i][0] = b.getListeCommande()[i].getNumeroCommande();
                data[i][1] = b.getListeCommande()[i].getIndividu().getNom() + " "
                        + b.getListeCommande()[i].getIndividu().getPrenom();
                data[i][2] = b.getListeCommande()[i].getMontant() + " euro(s)";
                String s = "";
                for (int j = 0; j < b.getListeCommande()[i].getListeArticle().length; j++) {
                    s += b.getListeCommande()[i].getListeArticle()[j].getDesignation() + " ("
                            + b.getListeCommande()[i].getListeArticle()[j].getQuantite() + ") ";
                }
                data[i][3] = s;
                data[i][4] = b.getListeCommande()[i].getReglement().getType();
                data[i][5] = b.getListeCommande()[i].getAnomalie();
                String ss = "";
                for (int j = 0; j < b.getListeCommande()[i].getTypesAnomalie().length; j++) {
                    ss += b.getListeCommande()[i].getTypesAnomalie()[j] + " ";
                }
                data[i][6] = ss;
            }

            // Les titres des colonnes
            String title[] = { "Numero", "Client", "Montant paye", "Article(s) commande(s)", "Paiement par",
                    "Anomalie ?", "Type(s) d'anomalie" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));

        } else if (cible == "liste commande invalide") {
            // Les donnees du tableau
            Object data[][] = new Object[b.getListeCommandeInvalides().length][7];

            for (int i = 0; i < b.getListeCommandeInvalides().length; i++) {
                data[i][0] = b.getListeCommandeInvalides()[i].getNumeroCommande();
                data[i][1] = b.getListeCommandeInvalides()[i].getIndividu().getNom() + " "
                        + b.getListeCommandeInvalides()[i].getIndividu().getPrenom();
                data[i][2] = b.getListeCommandeInvalides()[i].getMontant() + " euro(s)";
                String s = "";
                for (int j = 0; j < b.getListeCommandeInvalides()[i].getListeArticle().length; j++) {
                    s += b.getListeCommandeInvalides()[i].getListeArticle()[j].getDesignation() + " ("
                            + b.getListeCommandeInvalides()[i].getListeArticle()[j].getQuantite() + ") ";
                }
                data[i][3] = s;
                data[i][4] = b.getListeCommandeInvalides()[i].getReglement().getType();
                data[i][5] = b.getListeCommandeInvalides()[i].getAnomalie();
                String ss = "";
                for (int j = 0; j < b.getListeCommandeInvalides()[i].getTypesAnomalie().length; j++) {
                    ss += b.getListeCommandeInvalides()[i].getTypesAnomalie()[j] + " ";
                }
                data[i][6] = ss;
            }

            // Les titres des colonnes
            String title[] = { "Numero", "Client", "Montant paye", "Article(s) commande(s)", "Paiement par",
                    "Anomalie ?", "Type(s) d'anomalie" };
            JTable tableau = new JTable(data, title) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };
            this.getContentPane().add(new JScrollPane(tableau));

        }

    }

    public Fenetre(String vFenetre, String type, Commande cmd) {

        this.setTitle(vFenetre);
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Color couleur = new ColorUIResource(0, 0, 0);
        panel.setBackground(couleur);

        JPanel panel = new JPanel();
        if (type == "CB") {
            JTextArea labelArea = new JTextArea(cmd.toStringCommandeCB());
            panel.add(labelArea);
            labelArea.setForeground(Color.BLACK);
            labelArea.setEnabled(false);
            panel.add(labelArea);
        } else if (type == "CHEQUE") {
            JTextArea labelArea = new JTextArea(cmd.toStringCommandeCheque());
            panel.add(labelArea);
            labelArea.setForeground(Color.BLACK);
            labelArea.setEnabled(false);
            panel.add(labelArea);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 350, 400);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(350, 400));
        contentPane.add(scrollPane);
        this.setContentPane(contentPane);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void disposeFenetre(Fenetre fen) {
        fen.dispose();
    }
}