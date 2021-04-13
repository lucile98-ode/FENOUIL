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

        Bouton bouton1 = new Bouton("<html><center>Menu Cible de routage \nConnexion", 50, 450, 200, 60);
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

        Bouton bouton2 = new Bouton("<html><center>Connexion - Menu Saisie de commande", 275, 450, 200, 60);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(e -> {
            ConnexionSaisie crc = new ConnexionSaisie(null, "Connexion", true, fen, b);
            ToStringConnexionSaisie infoToString = crc.showConnexionSaisie();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, infoToString.toString(), "Connexion", JOptionPane.INFORMATION_MESSAGE);
        });

        Bouton bouton3 = new Bouton("<html><center>Connexion - Menu Anomalies", 525, 450, 200, 60);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            ConnexionAnomalie crc = new ConnexionAnomalie(null, "Connexion", true, fen, b);
            ToStringConnexionAnomalie infoToString = crc.showConnexionAnomalie();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, infoToString.toString(), "Connexion", JOptionPane.INFORMATION_MESSAGE);
        });

        Bouton bouton4 = new Bouton("<html><center>Connexion - Menu Administration du referentiel", 750, 450, 200, 60);
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

        Bouton bouton6 = new Bouton("<html><center>Interface Client - Faire une commande en ligne", 750, 300, 200, 60);
        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Commande cmd = new Commande();
                cmd.setMontant(0);
                Reglement reg = new Reglement();
                SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "individu", "CB", cmd, reg, b);
                ToStringSaisirCommande infoToString = sc.showSaisirCommande();

            }
        });
    }

    public static void CreationCibleDeRoutage(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Cible de routage", 150, 100, 100);
        Texte texte1 = new Texte("Creation d'une cible de routage", 150, 100, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 400, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Creer une cible de routage Papier", 50, 450, 200, 75);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutage cr = new CibleRoutage();
                CibleRoutageCreation crc = new CibleRoutageCreation(null, "Creation cible de routage - Papier", true,
                        "Papier", "initialisation", b, cr);
                ToStringCibleRoutage infoToString = crc.showCibleRoutage();
            }
        });

        Bouton bouton3 = new Bouton("<html><center>Creer une cible de routage Internet", 275, 450, 200, 75);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CibleRoutage cr = new CibleRoutage();
                CibleRoutageCreation crc = new CibleRoutageCreation(null, "Creation cible de routage - Internet", true,
                        "Internet", "initialisation", b, cr);
                ToStringCibleRoutage infoToString = crc.showCibleRoutage();
            }
        });

        Bouton bouton5 = new Bouton("<html><center>Consulter le details des cibles de routage", 750, 450, 200, 75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DetailsCibleRoutage dcr = new DetailsCibleRoutage(null,
                        "Selectionner la cible de routage pour consulter ses details", true, b);
                ToStringDetailsCibleRoutage infoToString = dcr.showDetailsCibleRoutage();
            }
        });

        Bouton bouton4 = new Bouton("<html><center>Liste des cibles de routage en attente de validation", 525, 450, 200,
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
            bouton5.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
        });

    }

    public static void ValidationCibleDeRoutage(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Cible de routage", 150, 100, 100);
        Texte texte1 = new Texte("Validation d'une cible de routage", 120, 100, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 400, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Valider une cible de routage", 100, 350, 200, 75);
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

        Bouton bouton5 = new Bouton("<html><center>Consulter le details des cibles de routage", 400, 350, 200, 75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DetailsCibleRoutage dcr = new DetailsCibleRoutage(null,
                        "Selectionner la cible de routage pour consulter ses details", true, b);
                ToStringDetailsCibleRoutage infoToString = dcr.showDetailsCibleRoutage();
            }
        });

        Bouton bouton6 = new Bouton("<html><center>Consulter le details des cibles de routage validees", 700, 350, 200,
                75);
        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DetailsCibleRoutageValidee dcr = new DetailsCibleRoutageValidee(null,
                        "Selectionner la cible de routage pour consulter ses details", true, b);
                ToStringDetailsCibleRoutageValidee infoToString = dcr.showDetailsCibleRoutageValidee();
            }
        });

        Bouton bouton3 = new Bouton("<html><center>Liste des cibles de routage en attente de validation", 250, 450, 200,
                75);

        Bouton bouton4 = new Bouton("<html><center>Liste des cibles de routage validees", 550, 450, 200, 75);

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
            bouton5.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton6.addActionListener(ev -> {
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
            bouton5.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton6.addActionListener(ev -> {
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

        Bouton bouton2 = new Bouton("<html><center>Envoi une cible de routage", 100, 350, 200, 75);
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

        Bouton bouton5 = new Bouton("<html><center>Consulter le details des cibles de routage validees", 400, 350, 200,
                75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DetailsCibleRoutageValidee dcr = new DetailsCibleRoutageValidee(null,
                        "Selectionner la cible de routage pour consulter ses details", true, b);
                ToStringDetailsCibleRoutageValidee infoToString = dcr.showDetailsCibleRoutageValidee();
            }
        });

        Bouton bouton6 = new Bouton("<html><center>Consulter le details des cibles de routage envoyees", 700, 350, 200,
                75);
        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DetailsCibleRoutageEnvoyee dcr = new DetailsCibleRoutageEnvoyee(null,
                        "Selectionner la cible de routage pour consulter ses details", true, b);
                ToStringDetailsCibleRoutageEnvoyee infoToString = dcr.showDetailsCibleRoutageEnvoyee();
            }
        });

        Bouton bouton3 = new Bouton("<html><center>Liste des cibles de routage validee en attente d'envoi", 250, 450,
                200, 75);
        Bouton bouton4 = new Bouton("<html><center>Liste des cibles de routage envoyees", 550, 450, 200, 75);

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
            bouton5.addActionListener(ev -> {
                fenCibleRoutageAValider.dispose();
            });
            bouton6.addActionListener(ev -> {
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
            bouton5.addActionListener(ev -> {
                fenCibleRoutageEnvoye.dispose();
            });
            bouton6.addActionListener(ev -> {
                fenCibleRoutageEnvoye.dispose();
            });
        });

    }

    public static void AdministrerDonnees(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Administration des donnees", 120, 150, 180);
        Texte texte1 = new Texte("Administrer les donnees", 210, 120, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 250, 600, 200, 30);
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
                ModificationsIndividu(b);
            }
        });

        Bouton bouton8 = new Bouton("<html><center>Ajouter une categorie socio professionnelle", 550, 600, 200, 30);
        fen.panel.add(bouton8);
        fen.setContentPane(fen.panel);
        bouton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CategorieSocioProfessionnelleCreation cspc = new CategorieSocioProfessionnelleCreation(null,
                        "Creer une categorie socio professionnelle", true, b);
                ToStringCategorieSocioProfessionnelle infoToString = cspc.showCategorieSocioProfessionnelleCreation();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Creer une categorie socio professionnelle",
                        JOptionPane.INFORMATION_MESSAGE);
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
                bouton8.addActionListener(ev -> {
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
                bouton8.addActionListener(ev -> {
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

        Bouton bouton3 = new Bouton("<html><center>Modifier la designation", 50, 350, 200, 75);
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

        Bouton bouton4 = new Bouton("<html><center>Modifier le prix", 275, 350, 200, 75);
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

        Bouton bouton5 = new Bouton("<html><center>Modifier le stock", 525, 350, 200, 75);
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

        Bouton bouton6 = new Bouton("<html><center>Liste des articles", 750, 350, 200, 75);
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

    public static void ModificationsIndividu(BaseDeDonnees b) {
        Fenetre fen = new Fenetre("Modification des individus", 150, 150, 180);
        Texte texte1 = new Texte("Modifier les individus", 260, 100, 1000, 100, 50, "Cambria");
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

        Bouton bouton3 = new Bouton("<html><center>Modifier le nom", 100, 300, 200, 75);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                IndividuMAJ imaj = new IndividuMAJ(null, "Mise a jour du nom de famille", true, "nom", b);
                ToStringIndividuMAJ infoToString = imaj.showIndividuMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Modification du nom",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        Bouton bouton4 = new Bouton("<html><center>Modifier les coordonnees", 400, 300, 200, 75);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                IndividuMAJ imaj = new IndividuMAJ(null, "Mise a jour des coordonnees", true, "coordonnees", b);
                ToStringIndividuMAJ infoToString = imaj.showIndividuMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Modification des coordonnees",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton5 = new Bouton("<html><center>Modifier l'adresse de residence", 700, 300, 200, 75);
        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                IndividuMAJ amaj = new IndividuMAJ(null, "Mise a jour de l'adresse de residence", true, "adresse", b);
                ToStringIndividuMAJ infoToString = amaj.showIndividuMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Modification de l'adressse de residence",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton6 = new Bouton("<html><center>Modifier la categorie socio-professionnelle", 100, 450, 200, 75);
        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                IndividuMAJ amaj = new IndividuMAJ(null, "Mise a jour de la categorie socio-professionnelle", true,
                        "categorie", b);
                ToStringIndividuMAJ infoToString = amaj.showIndividuMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(),
                        "Modification de la categorie socio-professionnelle", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton7 = new Bouton("<html><center>Modifier la caracteristique commerciale", 400, 450, 200, 75);
        fen.panel.add(bouton7);
        fen.setContentPane(fen.panel);
        bouton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                IndividuMAJ amaj = new IndividuMAJ(null, "Mise a jour de la caracteristique commerciale de l'individu",
                        true, "caracteristique", b);
                ToStringIndividuMAJ infoToString = amaj.showIndividuMAJ();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Modification de la caracteristique commerciale",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton8 = new Bouton("<html><center>Liste des individus", 700, 450, 200, 75);
        fen.panel.add(bouton8);
        fen.setContentPane(fen.panel);
        bouton8.addActionListener(new ActionListener() {
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
                bouton6.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
                bouton7.addActionListener(ev -> {
                    fenListedesIndividus.dispose();
                });
            }
        });

    }

    public static void SaisirCommande(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Saisie des commandes", 120, 150, 180);
        Texte texte1 = new Texte("Saisie des commandes", 210, 120, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 400, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Saisie des commandes (recues par courrier)", 250, 350, 200, 75);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Commande cmd = new Commande();
                cmd.setMontant(0);
                Reglement reg = new Reglement();
                SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "client", "CHEQUE", cmd, reg, b);
                ToStringSaisirCommande infoToString = sc.showSaisirCommande();
            }

        });

        Bouton bouton3 = new Bouton("<html><center>Consulter le details des commandes", 550, 350, 200, 75);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DetailsCommande dc = new DetailsCommande(null, "Selectionner la commande pour consulter ses details",
                        true, b);
                ToStringDetailsCommande infoToString = dc.showDetailsCommande();
            }
        });

        Bouton bouton4 = new Bouton("<html><center>Liste de toutes les commandes", 100, 450, 200, 75);
        Bouton bouton5 = new Bouton("<html><center>Liste des commandes valides", 400, 450, 200, 75);
        Bouton bouton6 = new Bouton("<html><center>Liste des commandes invalides", 700, 450, 200, 75);

        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesCommandes = new Fenetre("Liste des commandes", "liste commande", b);

                fenListedesCommandes.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesCommandes.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesCommandes.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesCommandes.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesCommandes.dispose();
                });
                bouton5.addActionListener(ev -> {
                    fenListedesCommandes.dispose();
                });
            }
        });

        fen.panel.add(bouton5);
        fen.setContentPane(fen.panel);
        bouton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesCommandesValides = new Fenetre("Liste des commandes valides",
                        "liste commande valide", b);

                fenListedesCommandesValides.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesCommandesValides.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesCommandesValides.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesCommandesValides.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesCommandesValides.dispose();
                });
                bouton6.addActionListener(ev -> {
                    fenListedesCommandesValides.dispose();
                });
            }
        });

        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesCommandesInvalides = new Fenetre("Liste des commandes en attentes",
                        "liste commande invalide", b);

                fenListedesCommandesInvalides.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesCommandesInvalides.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesCommandesInvalides.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesCommandesInvalides.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesCommandesInvalides.dispose();
                });
                bouton5.addActionListener(ev -> {
                    fenListedesCommandesInvalides.dispose();
                });
            }
        });

    }

    public static void Anomalie(BaseDeDonnees b) {

        Fenetre fen = new Fenetre("Gestion des anomalies", 120, 150, 180);
        Texte texte1 = new Texte("Gestion des anomalies", 225, 120, 1000, 100, 50, "Cambria");
        fen.add(texte1);

        Bouton bouton1 = new Bouton("Retour", 250, 600, 200, 30);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            Accueil(b);
        });

        Bouton bouton2 = new Bouton("<html><center>Recherche d'anomalie par individu", 100, 300, 200, 75);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Anomalie an = new Anomalie();
                System.out.println(b.getListeAnomalie().length);
                RechercheAnomalie ac = new RechercheAnomalie(null, "Recherche d'anomalie", true, b, "individu", an);
                ToStringRechercheAnomalie infoToString = ac.showRechercheAnomalie();
            }
        });

        Bouton bouton3 = new Bouton("<html><center>Recherche d'anomalie par numero de commande", 100, 450, 200, 75);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Anomalie an = new Anomalie();
                RechercheAnomalie ac = new RechercheAnomalie(null, "Recherche d'anomalie", true, b, "numero", an);
                ToStringRechercheAnomalie infoToString = ac.showRechercheAnomalie();
            }
        });

        Bouton bouton4 = new Bouton("<html><center>Recherche d'anomalie par date", 400, 300, 200, 75);
        fen.panel.add(bouton4);
        fen.setContentPane(fen.panel);
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Anomalie an = new Anomalie();
                RechercheAnomalie ac = new RechercheAnomalie(null, "Recherche d'anomalie", true, b, "date", an);
                ToStringRechercheAnomalie infoToString = ac.showRechercheAnomalie();
            }
        });

        Bouton bouton6 = new Bouton("<html><center>Liste des anomalies ", 700, 450, 200, 75);
        Bouton bouton7 = new Bouton("<html><center>Liste des anomalies en cours de traitement", 700, 300, 200, 75);

        fen.panel.add(bouton6);
        fen.setContentPane(fen.panel);
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesAnomalies = new Fenetre("Liste des anomalie", "liste anomalie", b);

                fenListedesAnomalies.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton7.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });

            }
        });

        fen.panel.add(bouton7);
        fen.setContentPane(fen.panel);
        bouton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Fenetre fenListedesAnomalies = new Fenetre("Liste des anomalie", "liste resolues", b);
                fenListedesAnomalies.setVisible(true);
                bouton1.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton2.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton3.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton4.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
                bouton6.addActionListener(ev -> {
                    fenListedesAnomalies.dispose();
                });
            }
        });

    }

}
