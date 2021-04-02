public class ToStringIndividuMAJ {

    private String nom, string, individu, modification, categorie, caracteristique, rue, ville, tel, email;
    private int num, departement;

    public ToStringIndividuMAJ() {
    }

    public ToStringIndividuMAJ(String string, String modification, String individu) {
        this.modification = modification;
        if (this.modification == "nom") {
            this.nom = string;
        } else if (modification == "categorie") {
            this.categorie = string;
        } else if (modification == "caracteristique") {
            this.caracteristique = string;
        }
        this.individu = individu;
    }

    public ToStringIndividuMAJ(int num, String rue, int departement, String ville, String modification,
            String individu) {
        this.modification = modification;
        this.num = num;
        this.departement = departement;
        this.ville = ville;
        this.rue = rue;
        this.individu = individu;
    }

    public ToStringIndividuMAJ(String tel, String email, String modification, String individu) {
        this.modification = modification;
        this.tel = tel;
        this.email = email;
    }

    public String toString() {
        String str = "";

        // PB DANS LA GESTION DES EXCEPTION

        if (this.modification == "nom") {
            str = "Modification de l'individu :\n";
            str += this.individu + "\n\n";
            str += "Nom : " + this.nom + "\n";
        } else if (this.modification == "categorie") {
            str = "Modification de l'individu :\n";
            str += this.individu + "\n\n";
            str += "Categorie Socio-professionnelle : " + this.categorie + "\n";
        } else if (this.modification == "adresse" && this.num > 0 && this.rue != "" && this.departement > 0
                && this.ville != "") {
            str = "Modification de l'individu :\n";
            str += this.individu + "\n\n";
            str += "Adresse: " + this.num + " " + this.rue + " - " + this.departement + ", " + this.ville;
        } else if (this.modification == "coordonees" && this.tel != "") {
            str = "Modification de l'individu :\n";
            str += this.individu + "\n\n";
            str += "Telephone: " + this.tel;
            str += "Email : " + this.email;
        }

        else {
            str = "Aucune information !";
        }
        return str;

    }

}