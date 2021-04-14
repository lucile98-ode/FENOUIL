public class Commande {

    private Individu individu;
    private Article[] listeArticlesCommande = new Article[0];
    private Reglement reglement;
    private float montant;
    private String numeroCommande;
    private boolean anomalie;
    private String[] listeTypesAnomalie = new String[0];

    public Commande(Individu individu, Article[] listeArticlesCommande, Reglement reglement, float montant,
            String numeroCommande, boolean anomalie, String[] listeTypesAnomalie) {
        this.individu = individu;
        this.listeArticlesCommande = listeArticlesCommande;
        this.reglement = reglement;
        this.montant = montant;
        this.numeroCommande = numeroCommande;
        this.anomalie = anomalie;
        this.listeTypesAnomalie = listeTypesAnomalie;
    }

    public Commande() {
        this.anomalie = false;
    }

    // GETTERS
    public Individu getIndividu() {
        return individu;
    }

    public Article[] getListeArticle() {
        return listeArticlesCommande;
    }

    public Reglement getReglement() {
        return reglement;
    }

    public float getMontant() {
        return montant;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }

    public boolean getAnomalie() {
        return anomalie;
    }

    public String[] getTypesAnomalie() {
        return listeTypesAnomalie;
    }

    // SETTERS
    public void setIndividu(Individu individu) {
        this.individu = individu;
    }

    public void setListeArticle(Article[] listeArticlesCommande) {
        this.listeArticlesCommande = listeArticlesCommande;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public void setAnomalie(boolean aAnomalie) {
        this.anomalie = aAnomalie;
    }

    // ADDERS
    public int addArticle(Article article) {

        Article c = article;

        Article[] newList = new Article[listeArticlesCommande.length + 1];
        for (int i = 0; i < listeArticlesCommande.length; i++) {
            newList[i] = listeArticlesCommande[i];
        }
        newList[newList.length - 1] = c;
        listeArticlesCommande = newList;
        return 0;
    }

    public int addTypesAnomalie(String typeAnomalie) {

        String a = typeAnomalie;

        String[] newList = new String[listeTypesAnomalie.length + 1];
        for (int i = 0; i < listeTypesAnomalie.length; i++) {
            newList[i] = listeTypesAnomalie[i];
        }
        newList[newList.length - 1] = a;
        listeTypesAnomalie = newList;
        return 0;
    }

    // TOSTRING
    public String toStringCommandeCB() {
        String s = "";

        s += "Commande numero : " + getNumeroCommande() + "\n\n";

        s += "Individu : \n";
        s += "Nom : " + getIndividu().getNom() + "\n";
        s += "Prenom : " + getIndividu().getPrenom() + "\n";
        s += "Date de naissance : " + getIndividu().getDate() + "\n";
        s += "Age : " + getIndividu().getToStringAge() + "\n";
        s += "Adresse : " + getIndividu().getAdresse() + "\n";
        s += "Telephone : " + getIndividu().getNumeroTelephone() + "\n";
        s += "Email : " + getIndividu().getAdresseMail() + "\n";
        s += "Categorie Socio-Professionnelle : " + getIndividu().getCategorieSocioProfessionnelle() + "\n\n\n";

        s += "Liste de produit\n\n";
        for (int i = 0; i < listeArticlesCommande.length; i++) {
            s += "Produit " + (i + 1) + "\n";
            s += "Nom : " + getListeArticle()[i].getDesignation() + "\n";
            s += "Numero : " + getListeArticle()[i].getNumero() + "\n";
            s += "Prix total : " + (getListeArticle()[i].getPrix() * getListeArticle()[i].getQuantite()) + " euros \n";
            s += "Quantite : " + getListeArticle()[i].getQuantite() + "\n\n\n";
        }

        s += "Reglement\n\n";
        s += "Montant : " + getMontant() + " euros\n";
        s += "Numero de CB : " + getReglement().getNumeroCarteBanquaire() + "\n";
        s += "Date d'expiration de CB : " + getReglement().getDateExpiration().toStringDateCB() + "\n";
        s += "Anomalie ? : " + getAnomalie() + "\n";
        for (int i = 0; i < getTypesAnomalie().length - 1; i++) {
            s += getTypesAnomalie()[i] + " - ";
        }
        for (int i = getTypesAnomalie().length - 1; i == getTypesAnomalie().length - 1; i++) {
            s += getTypesAnomalie()[i];
        }

        return s;
    }

    public String toStringCommandeCheque() {
        String s = "";

        s += "Commande numero : " + getNumeroCommande() + "\n\n";

        s += "Individu : \n";
        s += "Nom : " + getIndividu().getNom() + "\n";
        s += "Prenom : " + getIndividu().getPrenom() + "\n";
        s += "Date de naissance : " + getIndividu().getDate() + "\n";
        s += "Age : " + getIndividu().getToStringAge() + "\n";
        s += "Adresse : " + getIndividu().getAdresse() + "\n";
        s += "Telephone : " + getIndividu().getNumeroTelephone() + "\n";
        s += "Email : " + getIndividu().getAdresseMail() + "\n";
        s += "Categorie Socio-Professionnelle : " + getIndividu().getCategorieSocioProfessionnelle() + "\n\n\n";

        s += "Liste de produit\n\n";
        for (int i = 0; i < listeArticlesCommande.length; i++) {
            s += "Produit " + (i + 1) + "\n";
            s += "Nom : " + getListeArticle()[i].getDesignation() + "\n";
            s += "Numero : " + getListeArticle()[i].getNumero() + "\n";
            s += "Prix total : " + (getListeArticle()[i].getPrix() * getListeArticle()[i].getQuantite()) + " euros \n";
            s += "Quantite : " + getListeArticle()[i].getQuantite() + "\n\n\n";
        }

        s += "Reglement\n\n";
        s += "Montant : " + getMontant() + " euros\n";
        s += "Numero de cheque : " + getReglement().getNumeroCheque() + "\n";
        s += "Banque : " + getReglement().getNomBanque() + "\n";
        s += "Anomalie ? : " + getAnomalie() + "\n";
        for (int i = 0; i < getTypesAnomalie().length - 1; i++) {
            s += getTypesAnomalie()[i] + " - ";
        }
        for (int i = getTypesAnomalie().length - 1; i == getTypesAnomalie().length - 1; i++) {
            s += getTypesAnomalie()[i];
        }

        return s;
    }

}