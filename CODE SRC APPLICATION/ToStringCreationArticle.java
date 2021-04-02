public class ToStringCreationArticle {

    private String numero, designation;
    private int quantite;
    // PB AVEC LES FLOATS
    private int prix;

    public ToStringCreationArticle() {
    }

    public ToStringCreationArticle(String numero, int prix, String designation, int quantite) {
        this.numero = numero;
        this.prix = prix;
        this.designation = designation;
        this.quantite = quantite;
    }

    public String toString() {
        String str = "";

        // PB DANS LA GESTION DES EXCEPTION

        if (this.numero != "" || this.designation != "") {
            str = "Creation de l'article :\n\n";

            str += "Informations :\n";
            str += "Numero de reference : " + this.numero + "\n";
            str += "Designation : " + this.designation + "\n";
            str += "Prix unitaire : " + this.prix + "\n";
            str += "Quantité en stock initiale : " + this.quantite + "\n";

        } else {
            str = "Aucune information !";
        }
        return str;

    }

}