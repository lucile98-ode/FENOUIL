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
import javax.swing.JSpinner;

public class SaisirCommande extends JDialog {
    private ToStringSaisirCommande infoToString = new ToStringSaisirCommande();
    private boolean sendData;
    private JLabel infoLabel, specificitesLabel, coordonneesLabel, articleLabel, quantiteLabel, anomalieLabel;
    private JComboBox categorieSocioProfessionnelle, article, anomalie;
    private JTextField nom, prenom, adresseRue, ville, numeroTel, email, numCarte, nomBanque, numCheque;
    private JSpinner dateJour, dateMois, dateAnnee, adresseNumero, departement, quantite, montant;

    BaseDeDonnees b;
    String etat, typeCommande;
    Commande cmd;
    Reglement reg;

    public SaisirCommande(JFrame parent, String title, boolean modal, String etat, String typeCommande, Commande cmd,
            Reglement reg, BaseDeDonnees b) {
        super(parent, title, modal);
        this.b = b;
        this.etat = etat;
        this.typeCommande = typeCommande;
        this.cmd = cmd;
        this.reg = reg;

        if (this.etat == "individu") {
            this.setSize(700, 320);
        } else if (this.etat == "commande") {
            this.setSize(700, 150);
        } else if (this.etat == "payer") {
            this.setSize(700, 300);
        } else if (this.etat == "confirmation") {
            this.setSize(350, 650);
        }

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    public ToStringSaisirCommande showSaisirCommande() {
        this.sendData = false;
        this.setVisible(true);
        return this.infoToString;
    }

    private void initComponent() {

        JPanel content = new JPanel();

        if (etat == "individu") {
            // Information de l'individu
            JPanel panInformation = new JPanel();
            panInformation.setBackground(Color.white);
            panInformation.setPreferredSize(new Dimension(625, 100));
            panInformation.setBorder(BorderFactory.createTitledBorder("Informations"));

            nom = new JTextField();
            nom.setPreferredSize(new Dimension(135, 25));
            infoLabel = new JLabel("Nom :");
            panInformation.add(infoLabel);
            panInformation.add(nom);

            prenom = new JTextField();
            prenom.setPreferredSize(new Dimension(135, 25));
            infoLabel = new JLabel("Prenom :");
            panInformation.add(infoLabel);
            panInformation.add(prenom);

            numeroTel = new JTextField();
            numeroTel.setPreferredSize(new Dimension(120, 25));
            infoLabel = new JLabel("Telephone :");
            panInformation.add(infoLabel);
            panInformation.add(numeroTel);

            dateJour = new JSpinner();
            dateJour.setValue(01);
            dateJour.setPreferredSize(new Dimension(50, 30));
            infoLabel = new JLabel("Jour : ");
            panInformation.add(infoLabel);
            panInformation.add(dateJour);

            dateMois = new JSpinner();
            dateMois.setValue(01);
            dateMois.setPreferredSize(new Dimension(50, 30));
            infoLabel = new JLabel("Mois : ");
            panInformation.add(infoLabel);
            panInformation.add(dateMois);

            dateAnnee = new JSpinner();
            dateAnnee.setValue(1990);
            dateAnnee.setPreferredSize(new Dimension(50, 30));
            infoLabel = new JLabel("Annee : ");
            panInformation.add(infoLabel);
            panInformation.add(dateAnnee);

            email = new JTextField();
            email.setPreferredSize(new Dimension(115, 25));
            infoLabel = new JLabel("Email (falcutatif):");
            panInformation.add(infoLabel);
            panInformation.add(email);

            // Coordonnees de l'individu
            JPanel panCoordonnees = new JPanel();
            panCoordonnees.setBackground(Color.white);
            panCoordonnees.setPreferredSize(new Dimension(625, 60));
            panCoordonnees.setBorder(BorderFactory.createTitledBorder("Coordonnees"));

            adresseNumero = new JSpinner();
            adresseNumero.setValue(1);
            adresseNumero.setPreferredSize(new Dimension(50, 30));
            coordonneesLabel = new JLabel("Numero : ");
            panCoordonnees.add(coordonneesLabel);
            panCoordonnees.add(adresseNumero);

            adresseRue = new JTextField();
            adresseRue.setPreferredSize(new Dimension(115, 25));
            coordonneesLabel = new JLabel("Adresse :");
            panCoordonnees.add(coordonneesLabel);
            panCoordonnees.add(adresseRue);

            departement = new JSpinner();
            departement.setValue(91000);
            departement.setPreferredSize(new Dimension(65, 30));
            coordonneesLabel = new JLabel("Code postal : ");
            panCoordonnees.add(coordonneesLabel);
            panCoordonnees.add(departement);

            ville = new JTextField();
            ville.setPreferredSize(new Dimension(100, 25));
            coordonneesLabel = new JLabel("Ville :");
            panCoordonnees.add(coordonneesLabel);
            panCoordonnees.add(ville);

            // Specifications
            JPanel panSpecifications = new JPanel();
            panSpecifications.setBackground(Color.white);
            panSpecifications.setPreferredSize(new Dimension(625, 60));
            panSpecifications.setBorder(BorderFactory.createTitledBorder("Specificites"));
            specificitesLabel = new JLabel("Categorie Socio-Professionnelle :");
            categorieSocioProfessionnelle = new JComboBox();
            if (b.getListeCategorieSocioProfessionnelles().length == 0
                    || b.getListeCategorieSocioProfessionnelles() == null) {
                categorieSocioProfessionnelle.addItem("Aucune categorie enregistree");
            }
            for (int i = 0; i < b.getListeCategorieSocioProfessionnelles().length; i++) {
                categorieSocioProfessionnelle
                        .addItem(b.getListeCategorieSocioProfessionnelles()[i].getCategorieSocioProfessionnelle());
            }

            panSpecifications.add(specificitesLabel);
            panSpecifications.add(categorieSocioProfessionnelle);

            // ENSEMBLE
            content.setBackground(Color.white);
            content.add(panInformation);
            content.add(panCoordonnees);
            content.add(panSpecifications);

        } else if (etat == "commande") {

            // Article
            JPanel panArticle = new JPanel();
            panArticle.setBackground(Color.white);
            panArticle.setPreferredSize(new Dimension(400, 60));
            panArticle.setBorder(BorderFactory.createTitledBorder("Ajouter un article a la commande"));
            articleLabel = new JLabel("Article :");
            article = new JComboBox();
            if (b.getListeArticles().length == 0 || b.getListeArticles() == null) {
                article.addItem("Aucun article enregistre");
            }
            for (int i = 0; i < b.getListeArticles().length; i++) {
                article.addItem(b.getListeArticles()[i].getDesignation() + " - "
                        + (b.getListeArticles()[i].getPrix() + "euro(s) l'unite"));
            }

            panArticle.add(articleLabel);
            panArticle.add(article);

            // Quantite
            JPanel panQuantite = new JPanel();
            panQuantite.setBackground(Color.white);
            panQuantite.setPreferredSize(new Dimension(150, 60));
            panQuantite.setBorder(BorderFactory.createTitledBorder("Saisir la quantite"));
            quantite = new JSpinner();
            quantite.setValue(1);
            quantite.setPreferredSize(new Dimension(65, 30));
            quantiteLabel = new JLabel("Quantite : ");
            panQuantite.add(quantiteLabel);
            panQuantite.add(quantite);

            // ENSEMBLE
            content.setBackground(Color.white);
            content.add(panArticle);
            content.add(panQuantite);

        } else if (etat == "payer") {
            if (typeCommande == "CB") {
                // Date Carte Bancaire
                JPanel panInformation = new JPanel();
                panInformation.setBackground(Color.white);
                panInformation.setPreferredSize(new Dimension(650, 60));
                panInformation.setBorder(BorderFactory.createTitledBorder("Date d'expiration de la carte bancaire"));

                dateJour = new JSpinner();
                dateJour.setValue(01);
                dateJour.setPreferredSize(new Dimension(50, 30));
                infoLabel = new JLabel("Jour : ");
                panInformation.add(infoLabel);
                panInformation.add(dateJour);

                dateMois = new JSpinner();
                dateMois.setValue(01);
                dateMois.setPreferredSize(new Dimension(50, 30));
                infoLabel = new JLabel("Mois : ");
                panInformation.add(infoLabel);
                panInformation.add(dateMois);

                dateAnnee = new JSpinner();
                dateAnnee.setValue(1990);
                dateAnnee.setPreferredSize(new Dimension(50, 30));
                infoLabel = new JLabel("Annee : ");
                panInformation.add(infoLabel);
                panInformation.add(dateAnnee);

                numCarte = new JTextField();
                numCarte.setPreferredSize(new Dimension(115, 25));
                infoLabel = new JLabel("Numero de la carte bancaire");
                panInformation.add(infoLabel);
                panInformation.add(numCarte);

                // ENSEMBLE
                content.setBackground(Color.white);
                content.add(panInformation);

            } else if (typeCommande == "CHEQUE") {
                // Cheque
                JPanel panInformation = new JPanel();
                panInformation.setBackground(Color.white);
                panInformation.setPreferredSize(new Dimension(650, 120));
                panInformation.setBorder(BorderFactory.createTitledBorder("Paiement par cheque"));

                numCheque = new JTextField();
                numCheque.setPreferredSize(new Dimension(115, 25));
                infoLabel = new JLabel("Numero de cheque");
                panInformation.add(infoLabel);
                panInformation.add(numCheque);

                nomBanque = new JTextField();
                nomBanque.setPreferredSize(new Dimension(115, 25));
                infoLabel = new JLabel("Nom de la banque");
                panInformation.add(infoLabel);
                panInformation.add(nomBanque);

                montant = new JSpinner();
                montant.setValue(0);
                montant.setPreferredSize(new Dimension(80, 30));
                infoLabel = new JLabel("          Montant du cheque : ");
                panInformation.add(infoLabel);
                panInformation.add(montant);

                // Specifications
                JPanel panAnomalie = new JPanel();
                panAnomalie.setBackground(Color.white);
                panAnomalie.setPreferredSize(new Dimension(200, 60));
                panAnomalie.setBorder(BorderFactory.createTitledBorder("Anomalie"));
                anomalieLabel = new JLabel("Cheque signe ?");
                anomalie = new JComboBox();
                anomalie.addItem("oui");
                anomalie.addItem("non");
                panAnomalie.add(anomalieLabel);
                panAnomalie.add(anomalie);

                // ENSEMBLE
                content.setBackground(Color.white);
                content.add(panInformation);
                content.add(panAnomalie);
            }

        } else if (etat == "confirmation") {
            // Recapitulatif
            JPanel panInformation = new JPanel();
            panInformation.setBackground(Color.white);
            panInformation.setPreferredSize(new Dimension(300, 300));
            panInformation.setBorder(BorderFactory.createTitledBorder("Resume de la commande"));

            // ENSEMBLE
            content.setBackground(Color.white);
            content.add(panInformation);
        }

        JPanel control = new JPanel();

        // IDENTIFICATION AVANT DE PASSER COMMANDE
        if (etat == "individu") {
            JButton okBouton = new JButton("OK");
            okBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    cmd.setIndividu(new Individu((String) nom.getText(), (String) prenom.getText(),
                            new Date((int) dateJour.getValue(), (int) dateMois.getValue(), (int) dateAnnee.getValue()),
                            (String) categorieSocioProfessionnelle.getSelectedItem(),
                            new Adresse((int) adresseNumero.getValue(), (String) adresseRue.getText(),
                                    (int) departement.getValue(), (String) ville.getText()),
                            (String) numeroTel.getText(), (String) email.getText(), "client"));

                    setVisible(false);
                    if (typeCommande == "CB") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "commande", "CB", cmd,
                                reg, b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    } else if (typeCommande == "CHEQUE") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "commande", "CHEQUE", cmd,
                                reg, b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    }
                }
            });

            JButton cancelBouton = new JButton("Annuler");
            cancelBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    setVisible(false);
                }
            });

            control.add(cancelBouton);
            control.add(okBouton);
        }

        // SAISIE DE LA COMMANDE
        if (etat == "commande") {
            JButton ajouterUnProduit = new JButton("Ajouter Un Produit");
            ajouterUnProduit.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent arg0) {
                    int indexArticle = (int) article.getSelectedIndex();
                    String numeroArticle = b.getListeArticles()[indexArticle].getNumero();
                    String designationArticle = b.getListeArticles()[indexArticle].getDesignation();
                    float prixArticle = b.getListeArticles()[indexArticle].getPrix();
                    int quantiteArticle = (int) quantite.getValue();

                    cmd.addArticle(new Article(numeroArticle, designationArticle, prixArticle, quantiteArticle));
                    cmd.setMontant(cmd.getMontant() + (prixArticle * quantiteArticle));

                    setVisible(false);
                    if (typeCommande == "CB") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "commande", "CB", cmd,
                                reg, b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    } else if (typeCommande == "CHEQUE") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "commande", "CHEQUE", cmd,
                                reg, b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    }
                }
            });

            JButton reglement = new JButton("Payer");
            reglement.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int indexArticle = (int) article.getSelectedIndex();
                    String numeroArticle = b.getListeArticles()[indexArticle].getNumero();
                    String designationArticle = b.getListeArticles()[indexArticle].getDesignation();
                    float prixArticle = b.getListeArticles()[indexArticle].getPrix();
                    int quantiteArticle = (int) quantite.getValue();

                    cmd.addArticle(new Article(numeroArticle, designationArticle, prixArticle, quantiteArticle));
                    cmd.setMontant(cmd.getMontant() + (prixArticle * quantiteArticle));

                    setVisible(false);

                    if (typeCommande == "CB") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "payer", "CB", cmd, reg,
                                b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    } else if (typeCommande == "CHEQUE") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "payer", "CHEQUE", cmd,
                                reg, b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    }

                }
            });

            JButton cancelBouton = new JButton("Annuler la commande en cours");
            cancelBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    setVisible(false);
                }
            });

            control.add(cancelBouton);
            control.add(ajouterUnProduit);
            control.add(reglement);

        }

        // REGLEMENT DE LA COMMANDE
        if (etat == "payer") {
            JButton confirmation = new JButton("Terminer la commande");
            confirmation.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (typeCommande == "CB") {
                        int jour = (int) dateJour.getValue();
                        int mois = (int) dateMois.getValue();
                        int annee = (int) dateAnnee.getValue();
                        String numDeLaCarte = (String) numCarte.getText();

                        reg.setNumeroCarteBanquaire(numDeLaCarte);
                        reg.setDateExpirationCB(new Date(jour, mois, annee));
                        reg.setType("Carte Banquaire");
                        cmd.setReglement(reg);
                        // Numero = date + heure
                        String numeroDeLaCommande = java.time.LocalDate.now() + "/" + java.time.LocalTime.now();
                        cmd.setNumeroCommande(numeroDeLaCommande);

                        b.addCommande(cmd.getIndividu(), cmd.getListeArticle(), cmd.getReglement(), cmd.getMontant(),
                                cmd.getNumeroCommande(), cmd.getAnomalie(), cmd.getTypesAnomalie());

                        setVisible(false);

                        Fenetre recapCommande = new Fenetre("Recapitulatif de la commande", "CB", cmd);
                        recapCommande.setVisible(true);

                    } else if (typeCommande == "CHEQUE") {

                        String numeroDuCheque = (String) numCheque.getText();
                        String nomDeLaBanque = (String) nomBanque.getText();
                        int montantPaye = (int) montant.getValue();

                        reg.setNumeroCheque(numeroDuCheque);
                        reg.setNomBanque(nomDeLaBanque);
                        reg.setType("Cheque");
                        cmd.setReglement(reg);
                        // Numero = date + heure
                        String numeroDeLaCommande = java.time.LocalDate.now() + "/" + java.time.LocalTime.now();
                        cmd.setNumeroCommande(numeroDeLaCommande);

                        if (montantPaye != cmd.getMontant()) {
                            cmd.setAnomalie(true);
                            cmd.addTypesAnomalie("Erreur sur le montant");
                        } else {
                            cmd.addTypesAnomalie("");
                        }

                        if (((String) anomalie.getSelectedItem()) == "non") {
                            cmd.setAnomalie(true);
                            cmd.addTypesAnomalie("Erreur sur le moyen de paiement");
                        } else {
                            cmd.addTypesAnomalie("");
                        }

                        b.addCommande(cmd.getIndividu(), cmd.getListeArticle(), cmd.getReglement(), cmd.getMontant(),
                                cmd.getNumeroCommande(), cmd.getAnomalie(), cmd.getTypesAnomalie());

                        setVisible(false);

                        Fenetre recapCommande = new Fenetre("Recapitulatif de la commande", "CHEQUE", cmd);
                        recapCommande.setVisible(true);
                    }

                }
            });

            JButton ajouterUnProduit = new JButton("Ajouter un produit");
            ajouterUnProduit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    setVisible(false);
                    if (typeCommande == "CB") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "commande", "CB", cmd,
                                reg, b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    } else if (typeCommande == "CHEQUE") {
                        SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true, "commande", "CHEQUE", cmd,
                                reg, b);
                        ToStringSaisirCommande infoToString = sc.showSaisirCommande();
                    }
                }
            });

            JButton cancelBouton = new JButton("Annuler la commande en cours");
            cancelBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    setVisible(false);
                }
            });

            control.add(cancelBouton);
            control.add(ajouterUnProduit);
            control.add(confirmation);
        }

        // // RECAPITULATIF DE LA COMMANDE
        // if (etat == "confirmation") {
        // JButton confirmation = new JButton("Confimer la commande");
        // confirmation.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent arg0) {

        // setVisible(false);

        // }
        // });

        // // JButton ajouterUnProduit = new JButton("Ajouter un produit");
        // // ajouterUnProduit.addActionListener(new ActionListener() {
        // // public void actionPerformed(ActionEvent arg0) {
        // // SaisirCommande sc = new SaisirCommande(null, "Saisir Commande", true,
        // // "commande", cmd, reg, b);
        // // ToStringSaisirCommande infoToString = sc.showSaisirCommande();

        // // setVisible(false);
        // // }
        // // });

        // JButton cancelBouton = new JButton("Annuler la commande en cours");
        // cancelBouton.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent arg0) {

        // setVisible(false);
        // }
        // });

        // control.add(confirmation);
        // // control.add(ajouterUnProduit);
        // control.add(cancelBouton);
        // }

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }
}