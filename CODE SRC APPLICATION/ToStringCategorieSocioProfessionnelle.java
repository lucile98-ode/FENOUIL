public class ToStringCategorieSocioProfessionnelle {

    private String categorie;

    public ToStringCategorieSocioProfessionnelle() {
    }

    public ToStringCategorieSocioProfessionnelle(String categorie) {
        this.categorie = categorie;
    }

    public String toString() {
        String str = "";

        if (this.categorie != "") {
            str = "Nouvelle categorie socio professionnelle :\n";
            str += this.categorie;
        }

        else {
            str = "Aucune information !";
        }
        return str;

    }
}
