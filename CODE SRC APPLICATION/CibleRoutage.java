public class CibleRoutage {

    private String selection;
    private String titre;
    private String article1, article2, article3, article4, article5;
    private String description;
    private String style;
    private String type;
    private Individu[] individusCibles = new Individu[0];

    public CibleRoutage(String selection, String titre, String article1, String article2, String article3,
            String article4, String article5, String description, String style, String type,
            Individu[] individusCibles) {
        this.selection = selection;
        this.titre = titre;
        this.article1 = article1;
        this.article2 = article2;
        this.article3 = article3;
        this.article4 = article4;
        this.article5 = article5;
        this.description = description;
        this.style = style;
        this.type = type;
        // this.individusCibles = individusCibles;
    }

    public CibleRoutage() {

    }

    // GETTERS
    public String getSelection() {
        return selection;
    }

    public String getTitre() {
        return titre;
    }

    public String getArticle1() {
        return article1;
    }

    public String getArticle2() {
        return article2;
    }

    public String getArticle3() {
        return article3;
    }

    public String getArticle4() {
        return article4;
    }

    public String getArticle5() {
        return article5;
    }

    public String getDescription() {
        return description;
    }

    public String getStyle() {
        return style;
    }

    public String getType() {
        return type;
    }

    public Individu[] getIndividusCibles() {
        return individusCibles;
    }

    // SETTERS
    public void setSelection(String newSelection) {
        this.selection = newSelection;
    }

    public void setTitre(String newTitre) {
        this.titre = newTitre;
    }

    public void setArticle1(String art1) {
        this.article1 = art1;
    }

    public void setArticle2(String art2) {
        this.article2 = art2;
    }

    public void setArticle3(String art3) {
        this.article3 = art3;
    }

    public void setArticle4(String art4) {
        this.article4 = art4;
    }

    public void setArticle5(String art5) {
        this.article5 = art5;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setStyle(String newStyle) {
        this.style = newStyle;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    // ADDERS
    public int addIndividu(String nom, String prenom, Date date, String categorieSocioProfessionnelle, Adresse adresse,
            String numeroTelephone, String adresseMail, String caracteristiqueCommerciale) {

        Individu individu = new Individu(nom, prenom, new Date(date.getJour(), date.getMois(), date.getAnnee()),
                categorieSocioProfessionnelle,
                new Adresse(adresse.getNumero(), adresse.getRue(), adresse.getCodePostal(), adresse.getVille()),
                numeroTelephone, adresseMail, caracteristiqueCommerciale);

        Individu[] newList = new Individu[individusCibles.length + 1];
        for (int i = 0; i < individusCibles.length; i++) {
            newList[i] = individusCibles[i];
        }
        newList[newList.length - 1] = individu;
        individusCibles = newList;
        return 0;
    }

    public int addIndividu(Individu personne) {

        Individu individu = personne;

        Individu[] newList = new Individu[individusCibles.length + 1];
        for (int i = 0; i < individusCibles.length; i++) {
            newList[i] = individusCibles[i];
        }
        newList[newList.length - 1] = individu;
        individusCibles = newList;
        return 0;
    }

    // TOSTRING
    public String toStringCibleRoutagePapier() {
        String s = "";

        s += "Titre : " + getTitre() + "\n\n";

        // s += "Selection par : \n";
        s += "Selection par : " + getSelection() + "\n";
        s += "Article 1 : " + getArticle1() + "\n";
        s += "Article 2 : " + getArticle2() + "\n";
        s += "Article 3 : " + getArticle3() + "\n";
        s += "Article 4 : " + getArticle4() + "\n";
        s += "Article 5 : " + getArticle5() + "\n";
        s += "Description : " + getDescription() + "\n";
        s += "Style : " + getStyle() + "\n";
        s += "Type : " + getType() + "\n\n\n";

        s += "Liste des individus cibles\n\n";
        for (int i = 0; i < individusCibles.length; i++) {
            s += "Nom : " + getIndividusCibles()[i].getNom() + "\n";
            s += "Prenom : " + getIndividusCibles()[i].getPrenom() + "\n";
            s += "Age : " + getIndividusCibles()[i].getToStringAge() + "\n";
            s += "Categorie socio-professionnelle : " + getIndividusCibles()[i].getCategorieSocioProfessionnelle()
                    + "\n";
            s += "Adresse : " + getIndividusCibles()[i].getAdresse() + "\n";
            s += "Caracteristique Commerciale : " + getIndividusCibles()[i].getCaracteristiqueCommerciale() + "\n\n\n";
        }

        return s;
    }

    public String toStringCibleRoutageInternet() {
        String s = "";

        s += "Titre : " + getTitre() + "\n\n";

        // s += "Selection par : \n";
        s += "Selection par : " + getSelection() + "\n";
        s += "Article 1 : " + getArticle1() + "\n";
        s += "Article 2 : " + getArticle2() + "\n";
        s += "Article 3 : " + getArticle3() + "\n";
        s += "Article 4 : " + getArticle4() + "\n";
        s += "Article 5 : " + getArticle5() + "\n";
        s += "Description : " + getDescription() + "\n";
        s += "Type : " + getType() + "\n\n\n";

        s += "Liste des individus cibles\n\n";
        for (int i = 0; i < individusCibles.length; i++) {
            s += "Nom : " + getIndividusCibles()[i].getNom() + "\n";
            s += "Prenom : " + getIndividusCibles()[i].getPrenom() + "\n";
            s += "Age : " + getIndividusCibles()[i].getToStringAge() + "\n";
            s += "Categorie socio-professionnelle : " + getIndividusCibles()[i].getCategorieSocioProfessionnelle()
                    + "\n";
            s += "Adresse : " + getIndividusCibles()[i].getAdresse() + "\n";
            s += "Caracteristique Commerciale : " + getIndividusCibles()[i].getCaracteristiqueCommerciale() + "\n\n\n";
        }

        return s;
    }
}