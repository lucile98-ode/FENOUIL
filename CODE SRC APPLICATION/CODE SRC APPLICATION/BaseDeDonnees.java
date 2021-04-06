public class BaseDeDonnees {

    private CibleRoutage[] listeCibleRoutage = new CibleRoutage[0];
    private CibleRoutage[] listeValide = new CibleRoutage[0];
    private CibleRoutage[] listeEnvoye = new CibleRoutage[0];

    private Individu[] listeIndividu = new Individu[0];
    private Article[] listeArticle = new Article[0];

    private CategorieSocioProfessionnelle[] listeCategorieSocioProfessionnelles = new CategorieSocioProfessionnelle[0];
    private DepartementResidence[] listeDepartementResidence = new DepartementResidence[0];

    private Commande[] listeCommandes = new Commande[0];
    private Commande[] listeCommandesValidees = new Commande[0];
    private Commande[] listeCommandesInvalides = new Commande[0];

    public BaseDeDonnees() {

    }

    // GETTERS
    public CibleRoutage[] getListeCibleRoutages() {
        return listeCibleRoutage;
    }

    public CibleRoutage[] getListeCibleRoutagesValide() {
        return listeValide;
    }

    public CibleRoutage[] getListeCibleRoutagesEnvoyee() {
        return listeEnvoye;
    }

    public Individu[] getListeIndividus() {
        return listeIndividu;
    }

    public Article[] getListeArticles() {
        return listeArticle;
    }

    public CategorieSocioProfessionnelle[] getListeCategorieSocioProfessionnelles() {
        return listeCategorieSocioProfessionnelles;
    }

    public DepartementResidence[] getListeDepartementResidence() {
        return listeDepartementResidence;
    }

    public Commande[] getListeCommande() {
        return listeCommandes;
    }

    public Commande[] getListeCommandeValidees() {
        return listeCommandesValidees;
    }

    public Commande[] getListeCommandeInvalides() {
        return listeCommandesInvalides;
    }

    // POUR UN DEBUG
    public CibleRoutage getCibleRoutageEnvoye(int index) {
        return listeEnvoye[index];
    }
    //

    // ADDERS
    public int addCibleRoutages(String selection, String titre, String article1, String article2, String article3,
            String article4, String article5, String description, String style, String type, Individu[] individuCible) {

        CibleRoutage c = new CibleRoutage(selection, titre, article1, article2, article3, article4, article5,
                description, style, type, individuCible);

        CibleRoutage[] newList = new CibleRoutage[listeCibleRoutage.length + 1];
        for (int i = 0; i < listeCibleRoutage.length; i++) {
            newList[i] = listeCibleRoutage[i];
        }
        newList[newList.length - 1] = c;
        listeCibleRoutage = newList;
        return 0;
    }

    public int addCibleRoutages(CibleRoutage cr) {

        CibleRoutage c = cr;

        CibleRoutage[] newList = new CibleRoutage[listeCibleRoutage.length + 1];
        for (int i = 0; i < listeCibleRoutage.length; i++) {
            newList[i] = listeCibleRoutage[i];
        }
        newList[newList.length - 1] = c;
        listeCibleRoutage = newList;
        return 0;
    }

    public int addCibleRoutagesValide(CibleRoutage c) {

        CibleRoutage[] newList = new CibleRoutage[listeValide.length + 1];
        for (int i = 0; i < listeValide.length; i++) {
            newList[i] = listeValide[i];
        }
        newList[newList.length - 1] = c;
        listeValide = newList;
        return 0;
    }

    public int addCibleRoutagesAEnvoyer(CibleRoutage c) {

        CibleRoutage[] newList = new CibleRoutage[listeEnvoye.length + 1];
        for (int i = 0; i < listeEnvoye.length; i++) {
            newList[i] = listeEnvoye[i];
        }
        newList[newList.length - 1] = c;
        listeEnvoye = newList;
        return 0;
    }

    public int addIndividu(String nom, String prenom, Date date, String categorieSocioProfessionnelle, Adresse adresse,
            String numeroTelephone, String adresseMail, String caracteristiqueCommerciale) {

        Individu individu = new Individu(nom, prenom, new Date(date.getJour(), date.getMois(), date.getAnnee()),
                categorieSocioProfessionnelle,
                new Adresse(adresse.getNumero(), adresse.getRue(), adresse.getCodePostal(), adresse.getVille()),
                numeroTelephone, adresseMail, caracteristiqueCommerciale);

        Individu[] newList = new Individu[listeIndividu.length + 1];
        for (int i = 0; i < listeIndividu.length; i++) {
            newList[i] = listeIndividu[i];
        }
        newList[newList.length - 1] = individu;
        listeIndividu = newList;
        return 0;
    }

    public int addIndividu(Individu personne) {
        Individu individu = personne;
        Individu[] newList = new Individu[listeIndividu.length + 1];
        for (int i = 0; i < listeIndividu.length; i++) {
            newList[i] = listeIndividu[i];
        }
        newList[newList.length - 1] = individu;
        listeIndividu = newList;
        return 0;
    }

    public int addArticle(String numero, String designation, float prix, int quantite) {
        Article a = new Article(numero, designation, prix, quantite);
        Article[] newList = new Article[listeArticle.length + 1];
        for (int i = 0; i < listeArticle.length; i++) {
            newList[i] = listeArticle[i];
        }
        newList[newList.length - 1] = a;
        listeArticle = newList;
        return 0;
    }

    public int addArticle(Article art) {
        Article article = art;
        Article[] newList = new Article[listeArticle.length + 1];
        for (int i = 0; i < listeArticle.length; i++) {
            newList[i] = listeArticle[i];
        }
        newList[newList.length - 1] = article;
        listeArticle = newList;
        return 0;
    }

    public int addCategorieSocioProfessionnelle(String Categorie) {
        CategorieSocioProfessionnelle c = new CategorieSocioProfessionnelle(Categorie);
        CategorieSocioProfessionnelle[] newList = new CategorieSocioProfessionnelle[listeCategorieSocioProfessionnelles.length
                + 1];
        for (int i = 0; i < listeCategorieSocioProfessionnelles.length; i++) {
            newList[i] = listeCategorieSocioProfessionnelles[i];
        }
        newList[newList.length - 1] = c;
        listeCategorieSocioProfessionnelles = newList;
        return 0;
    }

    public int addDepartementResidence(String numero, String nom) {
        DepartementResidence d = new DepartementResidence(numero, nom);
        DepartementResidence[] newList = new DepartementResidence[listeDepartementResidence.length + 1];
        for (int i = 0; i < listeDepartementResidence.length; i++) {
            newList[i] = listeDepartementResidence[i];
        }
        newList[newList.length - 1] = d;
        listeDepartementResidence = newList;
        return 0;
    }

    public int addCommande(Individu individu, Article[] listeArticlesCommande, Reglement reglement, float montant,
            String numeroCommande, boolean anomalie, String[] listeAnomalies) {

        Commande commande = new Commande(individu, listeArticlesCommande, reglement, montant, numeroCommande, anomalie,
                listeAnomalies);

        Commande[] newList = new Commande[listeCommandes.length + 1];
        for (int i = 0; i < listeCommandes.length; i++) {
            newList[i] = listeCommandes[i];
        }
        newList[newList.length - 1] = commande;
        listeCommandes = newList;
        return 0;
    }

    public int addCommandeValide(Commande c) {

        Commande[] newList = new Commande[listeCommandesValidees.length + 1];
        for (int i = 0; i < listeCommandesValidees.length; i++) {
            newList[i] = listeCommandesValidees[i];
        }
        newList[newList.length - 1] = c;
        listeCommandesValidees = newList;
        return 0;
    }

    public int addCommandeInvalide(Commande c) {

        Commande[] newList = new Commande[listeCommandesInvalides.length + 1];
        for (int i = 0; i < listeCommandesInvalides.length; i++) {
            newList[i] = listeCommandesInvalides[i];
        }
        newList[newList.length - 1] = c;
        listeCommandesInvalides = newList;
        return 0;
    }

    // TOSTRING PROVISOIRE DANS LA CONSOLE
    public String toStringCible() {
        String s = "nb de cible : " + listeCibleRoutage.length + "\n";
        for (int i = 0; i <= listeCibleRoutage.length; i++) {
            s += "cible n°" + i + " : " + listeCibleRoutage[i].getTitre();
        }
        return s;
    }

    public String toStringCibleValide() {
        String s = "nb de cible : " + listeValide.length + "\n" + listeValide[0].getTitre();
        return s;
    }

    // DELETES
    public int delCibleRoutage(CibleRoutage c) {
        if (listeCibleRoutage.length != 0) {
            boolean isFind = false;
            for (int i = 0; i < listeCibleRoutage.length; i++) {
                if (c.equals(listeCibleRoutage[i])) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                CibleRoutage[] newlist = new CibleRoutage[(listeCibleRoutage.length - 1)];
                int j = 0;
                for (int i = 0; i < listeCibleRoutage.length; i++) {
                    if (c.equals(listeCibleRoutage[i])) {
                        continue;
                    }
                    newlist[j] = listeCibleRoutage[i];
                    j++;
                }
                listeCibleRoutage = newlist;
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int delCibleRoutageValide(CibleRoutage c) {
        if (listeValide.length != 0) {
            boolean isFind = false;
            for (int i = 0; i < listeValide.length; i++) {
                if (c.equals(listeValide[i])) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                CibleRoutage[] newlist = new CibleRoutage[(listeValide.length - 1)];
                int j = 0;
                for (int i = 0; i < listeValide.length; i++) {
                    if (c.equals(listeValide[i])) {
                        continue;
                    }
                    newlist[j] = listeValide[i];
                    j++;
                }
                listeValide = newlist;
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int delIndividu(Individu individu) {
        if (listeIndividu.length != 0) {
            boolean isFind = false;
            for (int i = 0; i < listeIndividu.length; i++) {
                if (individu.equals(listeIndividu[i])) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                Individu[] newlist = new Individu[(listeIndividu.length - 1)];
                int j = 0;
                for (int i = 0; i < listeIndividu.length; i++) {
                    if (individu.equals(listeIndividu[i])) {
                        continue;
                    }
                    newlist[j] = listeIndividu[i];
                    j++;
                }
                listeIndividu = newlist;
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int delCommande(Commande c) {
        if (listeCommandes.length != 0) {
            boolean isFind = false;
            for (int i = 0; i < listeCommandes.length; i++) {
                if (c.equals(listeCommandes[i])) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                Commande[] newlist = new Commande[(listeCommandes.length - 1)];
                int j = 0;
                for (int i = 0; i < listeCommandes.length; i++) {
                    if (c.equals(listeCommandes[i])) {
                        continue;
                    }
                    newlist[j] = listeCommandes[i];
                    j++;
                }
                listeCommandes = newlist;
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int delCommandeInvalide(Commande c) {
        if (listeCommandesInvalides.length != 0) {
            boolean isFind = false;
            for (int i = 0; i < listeCommandesInvalides.length; i++) {
                if (c.equals(listeCommandesInvalides[i])) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                Commande[] newlist = new Commande[(listeCommandesInvalides.length - 1)];
                int j = 0;
                for (int i = 0; i < listeCommandesInvalides.length; i++) {
                    if (c.equals(listeCommandesInvalides[i])) {
                        continue;
                    }
                    newlist[j] = listeCommandesInvalides[i];
                    j++;
                }
                listeCommandesInvalides = newlist;
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

}