import java.util.Calendar;

public class ToStringIndividuCreation {

    private String nom, prenom, categorieSocioProfessionnelle, adresseRue, ville, numeroTel, caracteristiqueCommerciale,
            adresseMail;
    private int dateJour, dateMois, dateAnnee, adresseNumero, departement;

    public ToStringIndividuCreation() {
    }

    public ToStringIndividuCreation(String nom, String prenom, int dateJour, int dateMois, int dateAnnee,
            String categorieSocioProfessionnelle, int adresseNumero, String adresseRue, int departement, String ville,
            String numeroTel, String adresseMail, String caracteristiqueCommerciale) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateJour = dateJour;
        this.dateMois = dateMois;
        this.dateAnnee = dateAnnee;
        this.categorieSocioProfessionnelle = categorieSocioProfessionnelle;
        this.adresseNumero = adresseNumero;
        this.adresseRue = adresseRue;
        this.departement = departement;
        this.ville = ville;
        this.numeroTel = numeroTel;
        this.adresseMail = adresseMail;
        this.caracteristiqueCommerciale = caracteristiqueCommerciale;
    }

    public String toString() {
        String str = "";
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        // PB DANS LA GESTION DES EXCEPTION

        if (this.nom != "" || this.prenom != "" || this.adresseRue != "" || this.ville != "" || this.numeroTel != "") {
            if ((this.dateAnnee >= 0 && this.dateAnnee <= year) && (this.dateJour <= 31 && this.dateJour > 0)
                    && (this.dateMois <= 12 && this.dateMois > 0)) {
                str = "Creation de l'individu :\n\n";

                str += "Informations :\n";
                str += "Nom : " + this.nom + "\n";
                str += "Prenom : " + this.prenom + "\n";
                str += "Date de naissance : " + this.dateJour + "/" + this.dateMois + "/" + this.dateAnnee + "\n";
                str += "Telephone : " + this.numeroTel + "\n";
                str += "email : " + this.adresseMail + "\n\n";

                str += "Coordonnees :\n";
                str += "Adresse : " + this.adresseNumero + " " + this.adresseRue + " - " + this.departement + ", "
                        + this.ville + "\n\n";

                str += "Specificites :\n";
                str += "Categorie Socio-Porfessionnelle : " + this.categorieSocioProfessionnelle + "\n";
                str += "Caracteristique Commerciale : " + this.caracteristiqueCommerciale + "\n";

            }
        } else {
            str = "Aucune information !";
        }
        return str;

    }

}