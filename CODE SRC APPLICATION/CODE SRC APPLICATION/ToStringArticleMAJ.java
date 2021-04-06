public class ToStringArticleMAJ {

    private String designation, article, modification;
    private int quantite;
    // PB AVEC LES FLOATS
    private int prix;

    public ToStringArticleMAJ() {
    }

    public ToStringArticleMAJ(String string, String modification, String article) {
        this.modification = modification;
        if (this.modification == "designation") {
            this.designation = modification;
        }
        this.article = article;
    }

    public ToStringArticleMAJ(int entier, String modification, String article) {
        this.modification = modification;
        if (this.modification == "prix") {
            this.prix = entier;
        } else if (this.modification == "quantite") {
            this.quantite = entier;
        }
        this.article = article;
    }

    public String toString() {
        String str = "";

        // PB DANS LA GESTION DES EXCEPTION

        if (this.modification == "designation") {
            str = "Modification de l'article :\n";
            str += this.article + "\n\n";
            str += "Designation : " + this.designation + "\n";
        } else if (this.modification == "prix" && this.prix >= 0) {
            str = "Modification de l'article :\n";
            str += this.article + "\n\n";
            str += "Prix unitaire : " + this.prix + "\n";
        } else if (this.modification == "quantite" && this.quantite >= 0) {
            str = "Modification de l'article :\n";
            str += this.article + "\n\n";
            str += "Quantité en stock : " + this.quantite + "\n";
        }

        else {
            str = "Aucune information !";
        }
        return str;

    }

}
