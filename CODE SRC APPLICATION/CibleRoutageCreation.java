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
import javax.swing.JTextField;

public class CibleRoutageCreation extends JDialog {

    private ToStringCibleRoutage infoToString = new ToStringCibleRoutage();
    private boolean sendData;
    private JLabel titreLabel, selectionLabel, articleLabel, styleLabel, descriptionLabel, typeLabel, categorieLabel,
            ageLabel, departementLabel, clientLabel;
    private JComboBox selection, art1, art2, art3, art4, art5, style, type, categorie, age, departement, client;
    private JTextField titre, description;

    String typePub, etat;
    BaseDeDonnees b;
    static String vselection, vtitre, vart1, vart2, vart3, vart4, vart5, vdescription, vstyle, vtype;
    CibleRoutage cr;

    public CibleRoutageCreation(JFrame parent, String title, boolean modal, String typePub, String etat,
            BaseDeDonnees b, CibleRoutage cr) {
        super(parent, title, modal);
        if (etat == "initialisation") {
            this.setSize(700, 360);
        } else {
            this.setSize(500, 160);
        }

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        this.cr = cr;
        this.typePub = typePub;
        this.b = b;
        this.etat = etat;

        this.initComponent();
    }

    public ToStringCibleRoutage showCibleRoutage() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {
        JPanel content = new JPanel();
        content.setBackground(Color.white);

        if (etat == "initialisation") {
            // Selection de l'individu
            JPanel panSelection = new JPanel();
            panSelection.setBackground(Color.white);
            panSelection.setPreferredSize(new Dimension(350, 60));
            panSelection.setBorder(BorderFactory.createTitledBorder("Selection des Individus"));
            selection = new JComboBox();
            selection.addItem("Categorie socio-professionnelle");
            selection.addItem("Age");
            selection.addItem("Departement de residence");
            selection.addItem("Selection d’individus deja clients ou non");
            selectionLabel = new JLabel("par : ");
            panSelection.add(selectionLabel);
            panSelection.add(selection);

            // Article
            JPanel panArticle = new JPanel();
            panArticle.setBackground(Color.white);
            panArticle.setPreferredSize(new Dimension(575, 120));
            panArticle.setBorder(BorderFactory.createTitledBorder("Selection des articles (5 max)"));
            art1 = new JComboBox();
            if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
                art1.addItem("Aucun produit enregistre");
            }
            for (int i = 0; i < b.getListeArticles().length; i++) {
                art1.addItem(b.getListeArticles()[i].getDesignation() + " (" + b.getListeArticles()[i].getNumero()
                        + ") : " + b.getListeArticles()[i].getPrix() + " euros");
            }

            art2 = new JComboBox();
            if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
                art2.addItem("Aucun produit enregistre");
            }
            art2.addItem("");
            for (int i = 0; i < b.getListeArticles().length; i++) {
                art2.addItem(b.getListeArticles()[i].getDesignation() + " (" + b.getListeArticles()[i].getNumero()
                        + ") : " + b.getListeArticles()[i].getPrix() + " euros");
            }

            art3 = new JComboBox();
            if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
                art3.addItem("Aucun produit enregistre");
            }
            art3.addItem("");
            for (int i = 0; i < b.getListeArticles().length; i++) {
                art3.addItem(b.getListeArticles()[i].getDesignation() + " (" + b.getListeArticles()[i].getNumero()
                        + ") : " + b.getListeArticles()[i].getPrix() + " euros");
            }

            art4 = new JComboBox();
            if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
                art4.addItem("Aucun produit enregistre");
            }
            art4.addItem("");
            for (int i = 0; i < b.getListeArticles().length; i++) {
                art4.addItem(b.getListeArticles()[i].getDesignation() + " (" + b.getListeArticles()[i].getNumero()
                        + ") : " + b.getListeArticles()[i].getPrix() + " euros");
            }

            art5 = new JComboBox();
            if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
                art5.addItem("Aucun produit enregistre");
            }
            art5.addItem("");
            for (int i = 0; i < b.getListeArticles().length; i++) {
                art5.addItem(b.getListeArticles()[i].getDesignation() + " (" + b.getListeArticles()[i].getNumero()
                        + ") : " + b.getListeArticles()[i].getPrix() + " euros");
            }

            articleLabel = new JLabel("");
            panArticle.add(articleLabel);
            panArticle.add(art1);
            panArticle.add(art2);
            panArticle.add(art3);
            panArticle.add(art4);
            panArticle.add(art5);

            // Le titre
            JPanel panTitre = new JPanel();
            panTitre.setBackground(Color.white);
            panTitre.setPreferredSize(new Dimension(220, 60));
            titre = new JTextField();
            titre.setPreferredSize(new Dimension(100, 25));
            panTitre.setBorder(BorderFactory.createTitledBorder("Titre de la publicite "));
            titreLabel = new JLabel("Saisir un titre :");
            panTitre.add(titreLabel);
            panTitre.add(titre);

            // Le description
            JPanel panDescription = new JPanel();
            panDescription.setBackground(Color.white);
            panDescription.setPreferredSize(new Dimension(225, 60));
            description = new JTextField();
            description.setPreferredSize(new Dimension(100, 25));
            panDescription.setBorder(BorderFactory.createTitledBorder("Description de la publicite "));
            descriptionLabel = new JLabel("Saisir : ");
            panDescription.add(descriptionLabel);
            panDescription.add(description);

            content.add(panSelection);
            content.add(panTitre);
            content.add(panArticle);
            content.add(panDescription);

            if (typePub == "Papier") {
                // Le Style
                JPanel panStyle = new JPanel();
                panStyle.setBackground(Color.white);
                panStyle.setPreferredSize(new Dimension(150, 60));
                style = new JComboBox();
                style.setPreferredSize(new Dimension(115, 25));
                style.addItem("standard");
                style.addItem("superieur");
                style.addItem("economique");
                panStyle.setBorder(BorderFactory.createTitledBorder("Style de la publicite "));
                styleLabel = new JLabel("");
                panStyle.add(styleLabel);
                panStyle.add(style);
                content.add(panStyle);

                // Le Type
                JPanel panType = new JPanel();
                panType.setBackground(Color.white);
                panType.setPreferredSize(new Dimension(190, 60));
                type = new JComboBox();
                type.setPreferredSize(new Dimension(145, 25));
                type.addItem("catalogue papier");
                panType.setBorder(BorderFactory.createTitledBorder("Type de la publicite "));
                typeLabel = new JLabel("");
                panType.add(typeLabel);
                panType.add(type);
                content.add(panType);

            } else if (typePub == "Internet") {
                // Le Type
                JPanel panType = new JPanel();
                panType.setBackground(Color.white);
                panType.setPreferredSize(new Dimension(300, 60));
                type = new JComboBox();
                type.setPreferredSize(new Dimension(250, 25));
                type.addItem("email envoye par internet");
                type.addItem("SMS");
                type.addItem("publicite dans un moteur de recherche");
                panType.setBorder(BorderFactory.createTitledBorder("Type de la publicite "));
                typeLabel = new JLabel("");
                panType.add(typeLabel);
                panType.add(type);
                content.add(panType);
            }

        } else if (etat == "categorie") {

            // Categorie
            JPanel panCategorie = new JPanel();
            panCategorie.setBackground(Color.white);
            panCategorie.setPreferredSize(new Dimension(350, 60));
            panCategorie.setBorder(BorderFactory.createTitledBorder("Categorie Socio Professionnelle "));
            categorie = new JComboBox();
            if (b.getListeCategorieSocioProfessionnelles().length == 0
                    || b.getListeCategorieSocioProfessionnelles() == null) {
                categorie.addItem("Entrer la liste des categories");
            }
            for (int i = 0; i < b.getListeCategorieSocioProfessionnelles().length; i++) {
                categorie.addItem(b.getListeCategorieSocioProfessionnelles()[i].getCategorieSocioProfessionnelle());
            }
            categorieLabel = new JLabel("Categorie : ");
            panCategorie.add(categorieLabel);
            panCategorie.add(categorie);
            content.add(panCategorie);

        } else if (etat == "age") {

            // Age
            JPanel panAge = new JPanel();
            panAge.setBackground(Color.white);
            panAge.setPreferredSize(new Dimension(350, 60));
            panAge.setBorder(BorderFactory.createTitledBorder("Age de selection "));
            age = new JComboBox();
            age.addItem("< 25 ans");
            age.addItem("25 - 39 ans");
            age.addItem("40 - 54 ans");
            age.addItem("55 - 69 ans");
            age.addItem("> 70 ans");
            ageLabel = new JLabel("Categorie d'age : ");
            panAge.add(ageLabel);
            panAge.add(age);
            content.add(panAge);

        } else if (etat == "departement") {

            // Departement
            JPanel panDepartement = new JPanel();
            panDepartement.setBackground(Color.white);
            panDepartement.setPreferredSize(new Dimension(350, 60));
            panDepartement.setBorder(BorderFactory.createTitledBorder("Departement de residence"));
            departement = new JComboBox();

            if (b.getListeDepartementResidence().length == 0 || b.getListeDepartementResidence() == null) {
                departement.addItem("Entrer la liste des departements");
            }
            for (int i = 0; i < b.getListeDepartementResidence().length; i++) {
                departement.addItem(b.getListeDepartementResidence()[i].ToStringDepartementResidence());
            }
            departementLabel = new JLabel("Selectionner : ");
            panDepartement.add(departementLabel);
            panDepartement.add(departement);
            content.add(panDepartement);

        } else if (etat == "client") {

            // Client
            JPanel panClient = new JPanel();
            panClient.setBackground(Color.white);
            panClient.setPreferredSize(new Dimension(350, 60));
            panClient.setBorder(BorderFactory.createTitledBorder("Client ou non ? "));
            client = new JComboBox();
            client.addItem("les clients");
            client.addItem("les non clients");
            client.addItem("tout le monde sauf les clients interdits");
            clientLabel = new JLabel("Cibler : ");
            panClient.add(clientLabel);
            panClient.add(client);
            content.add(panClient);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JPanel control = new JPanel();

        // INITIALISATION
        if (etat == "initialisation") {
            JButton okBouton = new JButton("OK");
            okBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    CibleRoutage cr = new CibleRoutage();
                    if (typePub == "Papier") {

                        cr.setSelection((String) selection.getSelectedItem());
                        cr.setTitre(titre.getText());
                        cr.setArticle1((String) art1.getSelectedItem());
                        cr.setArticle2((String) art2.getSelectedItem());
                        cr.setArticle3((String) art3.getSelectedItem());
                        cr.setArticle4((String) art4.getSelectedItem());
                        cr.setArticle5((String) art5.getSelectedItem());
                        cr.setDescription(description.getText());
                        cr.setStyle((String) style.getSelectedItem());
                        cr.setType((String) type.getSelectedItem());

                        if (((String) selection.getSelectedItem()) == "Categorie socio-professionnelle") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null,
                                    "Selection des individu par categorie socio-professionnelle", true, "Papier",
                                    "categorie", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        } else if (((String) selection.getSelectedItem()) == "Age") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null, "Selection des individu par age",
                                    true, "Papier", "age", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        } else if (((String) selection.getSelectedItem()) == "Departement de residence") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null,
                                    "Selection des individu par departement de residence", true, "Papier",
                                    "departement", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        } else if (((String) selection
                                .getSelectedItem()) == "Selection d’individus deja clients ou non") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null,
                                    "Selection des individu deja clients ou non", true, "Papier", "client", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        }

                    } else if (typePub == "Internet") {

                        cr.setSelection((String) selection.getSelectedItem());
                        cr.setTitre(titre.getText());
                        cr.setArticle1((String) art1.getSelectedItem());
                        cr.setArticle2((String) art2.getSelectedItem());
                        cr.setArticle3((String) art3.getSelectedItem());
                        cr.setArticle4((String) art4.getSelectedItem());
                        cr.setArticle5((String) art5.getSelectedItem());
                        cr.setDescription(description.getText());
                        cr.setType((String) type.getSelectedItem());

                        if (((String) selection.getSelectedItem()) == "Categorie socio-professionnelle") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null,
                                    "Selection des individu par categorie socio-professionnelle", true, "Internet",
                                    "categorie", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        } else if (((String) selection.getSelectedItem()) == "Age") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null, "Selection des individu par age",
                                    true, "Internet", "age", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        } else if (((String) selection.getSelectedItem()) == "Departement de residence") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null,
                                    "Selection des individu par departement de residence", true, "Internet",
                                    "departement", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        } else if (((String) selection
                                .getSelectedItem()) == "Selection d’individus deja clients ou non") {
                            setVisible(false);
                            CibleRoutageCreation crc = new CibleRoutageCreation(null,
                                    "Selection des individu deja clients ou non", true, "Internet", "client", b, cr);
                            ToStringCibleRoutage infoToString = crc.showCibleRoutage();

                        }

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

        }

        // CATEGORIE
        if (etat == "categorie") {

            JButton okBouton = new JButton("Valider");
            okBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    String select = (String) categorie.getSelectedItem();

                    for (int i = 0; i < b.getListeIndividus().length; i++) {
                        if (b.getListeIndividus()[i].getCategorieSocioProfessionnelle() == select) {
                            cr.addIndividu(b.getListeIndividus()[i]);
                            // cr.addIndividu(b.getListeIndividus()[i].getNom(),
                            // b.getListeIndividus()[i].getPrenom(),
                            // b.getListeIndividus()[i].getDateDate(),
                            // b.getListeIndividus()[i].getCategorieSocioProfessionnelle(),
                            // b.getListeIndividus()[i].getAdresseAdresse(),
                            // b.getListeIndividus()[i].getNumeroTelephone(),
                            // b.getListeIndividus()[i].getAdresseMail(),
                            // b.getListeIndividus()[i].getCaracteristiqueCommerciale());
                        }
                    }

                    if (typePub == "Papier") {

                        cr.setSelection(cr.getSelection() + " : " + select);
                        b.addCibleRoutages(cr);

                    } else if (typePub == "Internet") {

                        cr.setSelection(cr.getSelection() + " : " + select);
                        b.addCibleRoutages(cr);

                    }

                    setVisible(false);

                    if (typePub == "Papier") {
                        Fenetre recapCible = new Fenetre("Resume de la cible de routage", "Papier", cr);
                        recapCible.setVisible(true);
                    } else if (typePub == "Internet") {
                        Fenetre recapCible = new Fenetre("Resume de la commande", "Internet", cr);
                        recapCible.setVisible(true);
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
        }

        // AGE
        if (etat == "age") {

            JButton okBouton = new JButton("Valider");
            okBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    int select = (int) age.getSelectedIndex();
                    String selectString = (String) age.getSelectedItem();

                    for (int i = 0; i < b.getListeIndividus().length; i++) {
                        if (select == 0) {
                            if (b.getListeIndividus()[i].getAge() < 25) {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        } else if (select == 1) {
                            if (b.getListeIndividus()[i].getAge() >= 25 && b.getListeIndividus()[i].getAge() <= 39) {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        } else if (select == 2) {
                            if (b.getListeIndividus()[i].getAge() >= 40 && b.getListeIndividus()[i].getAge() <= 54) {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        } else if (select == 3) {
                            if (b.getListeIndividus()[i].getAge() >= 55 && b.getListeIndividus()[i].getAge() <= 69) {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        } else if (select == 4) {
                            if (b.getListeIndividus()[i].getAge() > 69) {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        }
                    }

                    if (typePub == "Papier") {

                        cr.setSelection("Age : " + selectString);
                        b.addCibleRoutages(cr);

                    } else if (typePub == "Internet") {

                        cr.setSelection("Age : " + selectString);
                        b.addCibleRoutages(cr);

                    }

                    setVisible(false);
                    if (typePub == "Papier") {
                        Fenetre recapCible = new Fenetre("Resume de la cible de routage", "Papier", cr);
                        recapCible.setVisible(true);
                    } else if (typePub == "Internet") {
                        Fenetre recapCible = new Fenetre("Resume de la commande", "Internet", cr);
                        recapCible.setVisible(true);
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
        }

        // DEPARTEMENT
        if (etat == "departement") {

            JButton okBouton = new JButton("Valider");
            okBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    String select = (String) departement.getSelectedItem();

                    String cp = "";
                    cp += select.charAt(0);
                    cp += select.charAt(1);
                    cp += select.charAt(2);

                    // System.out.println(cp);

                    for (int i = 0; i < b.getListeIndividus().length; i++) {
                        if ((b.getListeIndividus()[i].getAdresseCodePostal().charAt(0) == select.charAt(0))) {
                            System.out.println(cp);
                            if ((b.getListeIndividus()[i].getAdresseCodePostal().charAt(1) == select.charAt(1))) {
                                System.out.println(cp);

                                if ((b.getListeIndividus()[i].getAdresseCodePostal().charAt(0)
                                        + (b.getListeIndividus()[i].getAdresseCodePostal().charAt(1)) == cp.charAt(0)
                                                + cp.charAt(1))) {
                                    if (b.getListeIndividus()[i].getAdresseCodePostal().charAt(2) == select.charAt(2)) {
                                        cr.addIndividu(b.getListeIndividus()[i]);
                                    }
                                }
                                if (select.charAt(1) + "" != '7' + "") {
                                    cr.addIndividu(b.getListeIndividus()[i]);
                                }
                            }
                        }
                    }

                    if (typePub == "Papier") {

                        cr.setSelection(cr.getSelection() + " : " + select);
                        b.addCibleRoutages(cr);

                    } else if (typePub == "Internet") {

                        cr.setSelection(cr.getSelection() + " : " + select);
                        b.addCibleRoutages(cr);
                    }

                    setVisible(false);
                    if (typePub == "Papier") {
                        Fenetre recapCible = new Fenetre("Resume de la cible de routage", "Papier", cr);
                        recapCible.setVisible(true);
                    } else if (typePub == "Internet") {
                        Fenetre recapCible = new Fenetre("Resume de la commande", "Internet", cr);
                        recapCible.setVisible(true);
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
        }

        // CLIENT OU PAS
        if (etat == "client") {

            JButton okBouton = new JButton("Valider");
            okBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    int select = (int) client.getSelectedIndex();

                    for (int i = 0; i < b.getListeIndividus().length; i++) {
                        if (select == 0) {
                            if (b.getListeIndividus()[i].getCaracteristiqueCommerciale() == "client") {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        } else if (select == 1) {
                            if (b.getListeIndividus()[i].getCaracteristiqueCommerciale() == "prospect") {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        } else if (select == 2) {
                            if (b.getListeIndividus()[i].getCaracteristiqueCommerciale() != "client interdit") {
                                cr.addIndividu(b.getListeIndividus()[i]);
                            }
                        }
                    }

                    if (typePub == "Papier") {

                        cr.setSelection(cr.getSelection() + " : " + select);
                        b.addCibleRoutages(cr);

                    } else if (typePub == "Internet") {

                        cr.setSelection(cr.getSelection() + " : " + select);
                        b.addCibleRoutages(cr);

                    }

                    setVisible(false);
                    if (typePub == "Papier") {
                        Fenetre recapCible = new Fenetre("Resume de la cible de routage", "Papier", cr);
                        recapCible.setVisible(true);
                    } else if (typePub == "Internet") {
                        Fenetre recapCible = new Fenetre("Resume de la commande", "Internet", cr);
                        recapCible.setVisible(true);
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
        }

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }
}