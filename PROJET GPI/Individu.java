import java.util.Calendar;

public class Individu {

    private String nom;
    private String prenom;
    private int age;
    private DateNaissance date;
    private String categorieSocioProfessionnelle;
    private Adresse adresse;
    private String numeroTelephone;
    private String adresseMail;
    private String caracteristiqueCommerciale;

    public Individu(String nom, String prenom, DateNaissance date, String categorieSocioProfessionnelle,
            Adresse adresse, String numeroTelephone, String adresseMail, String caracteristiqueCommerciale) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.categorieSocioProfessionnelle = categorieSocioProfessionnelle;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.adresseMail = adresseMail;
        this.caracteristiqueCommerciale = caracteristiqueCommerciale;

    }

    // GETTERS
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // System.out.println("year=" + year);
        age = year - date.getAnnee();
        return age;
    }

    public String getDateNaissance() {
        return date.getJour() + "/" + date.getMois() + "/" + date.getAnnee();
    }

    public String getCategorieSocioProfessionnelle() {
        return categorieSocioProfessionnelle;
    }

    public String getAdresse() {
        return adresse.getNumero() + " " + adresse.getRue() + " - " + adresse.getCodePostal() + ", "
                + adresse.getVille();
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public String getCaracteristiqueCommerciale() {
        return caracteristiqueCommerciale;
    }

}
