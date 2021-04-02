public class CibleRoutage {

    private String selection;
    private String titre;
    private String article1, article2, article3, article4, article5;
    private String description;
    private String style;
    private String type;
    private Individu[] individusCibles;

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
}