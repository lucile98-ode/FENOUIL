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

    // SETTERS
    public void setNom(String newNom) {
        this.nom = newNom;
    }

    public void setCategorie(String newCategorie) {
        this.categorieSocioProfessionnelle = newCategorie;
    }

    public void setTelephone(String newTelephone) {
        this.numeroTelephone = newTelephone;
    }

    public void setEmail(String newEmail) {
        this.adresseMail = newEmail;
    }

    public void setCaracteristique(String newCaracteristique) {
        this.caracteristiqueCommerciale = newCaracteristique;
    }

    public void setNumeroAdresse(int newNumero) {
        this.adresse.setNumero(newNumero);
    }

    public void setRueAdresse(String newRue) {
        this.adresse.setRue(newRue);
    }

    public void setDepartementAdresse(int newDepartement) {
        this.adresse.setCodePostal(newDepartement);
    }

    public void setVilleAdresse(String newVille) {
        this.adresse.setVille(newVille);
    }
}
