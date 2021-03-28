public class ToStringCibleRoutage {
    private String selection, titre, art1, art2, art3, art4, art5, description, style, type;

    public ToStringCibleRoutage() {
    }

    public ToStringCibleRoutage(String selection, String titre, String art1, String art2, String art3, String art4,
            String art5, String description, String style, String type) {
        this.selection = selection;
        this.titre = titre;
        this.art1 = art1;
        this.art2 = art2;
        this.art3 = art3;
        this.art4 = art4;
        this.art5 = art5;
        this.description = description;
        this.style = style;
        this.type = type;
    }

    public ToStringCibleRoutage(String selection, String titre, String art1, String art2, String art3, String art4,
            String art5, String description, String type) {
        this.selection = selection;
        this.titre = titre;
        this.art1 = art1;
        this.art2 = art2;
        this.art3 = art3;
        this.art4 = art4;
        this.art5 = art5;
        this.description = description;
        this.type = type;
    }

    public String toString() {
        String str;

        if (this.selection != null && this.titre != "" && this.art1 != null && this.type != null
                && this.art1 != "Aucun produit enregistre") {
            str = "Recapitulatif de la creation\n";
            str += "Selection : " + this.selection + "\n";
            str += "Titre : " + this.titre + "\n";
            str += "Article n°1 : " + this.art1 + "\n";
            if (this.art2 != "") {
                str += "Article n°2 : " + this.art2 + "\n";
            }
            if (this.art3 != "") {
                str += "Article n°3 : " + this.art3 + "\n";
            }
            if (this.art4 != "") {
                str += "Article n°4 : " + this.art4 + "\n";
            }
            if (this.art5 != "") {
                str += "Article n°5 : " + this.art5 + "\n";
            }
            if (this.description != "") {
                str += "Description : " + this.description + "\n";
            }
            str += "Type : " + this.type + "\n";
            if (this.style != null) {
                str += "Style : " + this.style + "\n";
            }
        } else {
            str = "Aucune information !";
        }

        return str;
    }
}
