import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class InterfaceGraphique {

    public static void Accueil(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Ecran Accueil", 100, 100, 150);
        Texte texte1 = new Texte("Fenouil", 410, 75, 500, 100, 50, "Cambria");
        fen.add(texte1);
        Texte texte2 = new Texte(
                "Application developpee par : ROUX Amandine - FREYSSAC Lucile - BNIK Bouchra - MENGUELTI Hacene - GHAZOUANI Bilal",
                65, 550, 1000, 100, 15, "Cambria");
        fen.add(texte2);
        Texte texte3 = new Texte("<html><center>Groupe L2BHA - Universite Evry Val d'Essonne", 350, 580, 1000, 100, 15,
                "Cambria");
        fen.add(texte3);

        Bouton bouton1 = new Bouton("<html><center>Menu Cible de routage Connexion", 50, 450, 200, 60);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ConnexionCibleRoutage crc = new ConnexionCibleRoutage(null, "Connexion", true, fen, b);
                ToStringConnexionCibleRoutage infoToString = crc.showConnexionCibleRoutage();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Connexion", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton2 = new Bouton("Saisir une commande", 275, 450, 200, 60);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(e -> {
            fen.dispose();
        });

        Bouton bouton3 = new Bouton("Anomalie", 525, 450, 200, 60);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            fen.dispose();
        });

        Bouton bouton4 = new Bouton("Referentiel des individus", 750, 450, 200, 60);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ConnexionAdmin crc = new ConnexionAdmin(null, "Connexion", true, fen, b);
                ToStringConnexionAdmin infoToString = crc.showConnexionAdmin();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Connexion", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton5 = new Bouton("Quitter", 870, 30, 80, 30);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(e -> {
            fen.dispose();
        });
    }

    public static void CreationCibleDeRoutage(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Cible de routage", 150, 100, 100);
        Texte texte1 = new Texte("Creation d'une cible de routage", 200, 100, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 400, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Creer une cible de routage Papier", 150, 450, 200, 75);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutageCreation crc = new CibleRoutageCreation(null, "Creation cible de routage - Papier", true,
                        "Papier", b);
                ToStringCibleRoutage infoToString = crc.showCibleRoutage();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Création Cible de routage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton3 = new Bouton("<html><center>Creer une cible de routage Internet", 400, 450, 200, 75);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutageCreation crc = new CibleRoutageCreation(null, "Creation cible de routage - Internet", true,
                        "Internet", b);
                ToStringCibleRoutage infoToString = crc.showCibleRoutage();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Création Cible de routage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton4 = new Bouton("<html><center>Liste des cibles de routage en attente de validation", 650, 450, 200,
                75);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(e -> {
            Fenetre fenCibleRoutageAValider = new Fenetre("Liste des cibles de routages en attente de validation",
                    "cibles Crees", b);
            fenCibleRoutageAValider.setVisible(true);
            bouton1.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton2.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton3.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
        });

    }

    public static void ValidationCibleDeRoutage(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Cible de routage", 150, 100, 100);
        Texte texte1 = new Texte("Validation d'une cible de routage", 180, 100, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 400, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Valider une cible de routage", 150, 450, 200, 75);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutageValidation crv = new CibleRoutageValidation(null, "Valider une cible de routage", true, b);
                ToStringValidationCibleRoutage infoToString = crv.showCibleRoutageValidation();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Validation Cible de routage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton3 = new Bouton("<html><center>Liste des cibles de routage en attente de validation", 400, 450, 200,
                75);

        Bouton bouton4 = new Bouton("<html><center>Liste des cibles de routage validees", 650, 450, 200, 75);

        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            Fenetre fenCibleRoutageAValider = new Fenetre("Liste des cibles de routages en attente de validation",
                    "cibles Crees", b);
            fenCibleRoutageAValider.setVisible(true);
            bouton1.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton2.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton4.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
        });

        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(e -> {
            Fenetre fenCibleRoutageAValider = new Fenetre("Liste des cibles de routages validees", "cibles Validees",
                    b);
            fenCibleRoutageAValider.setVisible(true);
            bouton1.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton2.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton2.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
        });

    }

    public static void EnvoiCibleDeRoutage(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Envoi de routage", 150, 100, 100);
        Texte texte1 = new Texte("Envoi d'une cible de routage", 190, 100, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 400, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Envoi une cible de routage", 150, 450, 200, 75);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutageEnvoi crv = new CibleRoutageEnvoi(null, "Envoi une cible de routage", true, b);
                ToStringEnvoiCibleRoutage infoToString = crv.showCibleRoutageEnvoi();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Envoi Cible de routage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton3 = new Bouton("<html><center>Liste des cibles de routage validee en attente d'envoi", 400, 450,
                200, 75);
        Bouton bouton4 = new Bouton("<html><center>Liste des cibles de routage envoyees", 650, 450, 200, 75);

        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            Fenetre fenCibleRoutageAValider = new Fenetre("Liste des cibles de routage validee en attente d'envoi",
                    "cibles Validees", b);
            fenCibleRoutageAValider.setVisible(true);
            bouton1.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton2.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton4.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
        });

        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(e -> {
            Fenetre fenCibleRoutageEnvoye = new Fenetre("Liste des cibles de routage envoyees", "cibles Envoyees", b);
            fenCibleRoutageEnvoye.setVisible(true);
            bouton1.addActionListener(ev -> {
                fenCibleRoutageEnvoye.dispose();
            });
            bouton2.addActionListener(ev -> {
                fenCibleRoutageEnvoye.dispose();
            });
            bouton3.addActionListener(ev -> {
                fenCibleRoutageEnvoye.dispose();
            });
        });

    }

    public static void AdministrerDonnees(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Administration des donnees", 150, 150, 180);
        Texte texte1 = new Texte("Administrer les donnees", 210, 100, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 400, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Creer un article", 100, 300, 200, 75);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ArticleCreation ac = new ArticleCreation(null, "Creation d'un article", true, b);
                ToStringCreationArticle infoToString = ac.showArticleCreation();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Création d'un article",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        Bouton bouton3 = new Bouton("<html><center>Creer un individu", 100, 450, 200, 75);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                IndividuCreation ic = new IndividuCreation(null, "Creation d'un individu", true, b);
                ToStringIndividuCreation infoToString = ic.showIndividuCreation();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Création Cible de routage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton4 = new Bouton("<html><center>Mettre a jour un article", 400, 300, 200, 75);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fen.dispose();
                ModificationsArticle(b);
            }
        });

        Bouton bouton5 = new Bouton("<html><center>Mettre a jour un individu", 400, 450, 200, 75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fen.dispose();
            }
        });

        Bouton bouton6 = new Bouton("<html><center>Liste des individus", 700, 450, 200, 75);
        Bouton bouton7 = new Bouton("<html><center>Liste des articles", 700, 300, 200, 75);

        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesIndividus = new Fenetre("Liste des individus", "liste individu", b);
                fenListedesIndividus.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
                bouton5.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
                bouton7.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
            }
        });

        fen.panel.add(bouton7);
        fen.setContentPane(fen.panel);
        bouton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesArticles = new Fenetre("Liste des articles", "liste article", b);
                fenListedesArticles.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton5.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton6.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
            }
        });

    }

    public static void ModificationsArticle(BaseDeDonnees b) {
        Fenetre fen = new Fenetre("Modification des articles", 150, 150, 180);
        Texte texte1 = new Texte("Modifier les articles", 260, 100, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 200, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            AdministrerDonnees(b);
        });

        Bouton bouton2 = new Bouton("Accueil", 600, 600, 200, 30);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton3 = new Bouton("<html><center>Modifier la designation", 50, 450, 200, 75);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ArticleMAJ amaj = new ArticleMAJ(null, "Mise a jour de la designation", true, "designation", b);
                ToStringArticleMAJ infoToString = amaj.showArticleMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Modification du nom",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        Bouton bouton4 = new Bouton("<html><center>Modifier le prix", 275, 450, 200, 75);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ArticleMAJ amaj = new ArticleMAJ(null, "Mise a jour du prix", true, "prix", b);
                ToStringArticleMAJ infoToString = amaj.showArticleMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Modification du prix",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton5 = new Bouton("<html><center>Modifier le stock", 525, 450, 200, 75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ArticleMAJ amaj = new ArticleMAJ(null, "Mise a jour du prix", true, "quantite", b);
                ToStringArticleMAJ infoToString = amaj.showArticleMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Modification des stocks",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton6 = new Bouton("<html><center>Liste des articles", 750, 450, 200, 75);
        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesArticles = new Fenetre("Liste des articles", "liste article", b);
                fenListedesArticles.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
                bouton5.addActionListener(ev -> {
                    fenListedesArticles.dispose();
                });
            }
        });

    }
}