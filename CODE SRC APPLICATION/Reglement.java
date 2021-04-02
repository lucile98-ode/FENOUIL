public class Reglement {

    private String type;
    private String numeroCheque;
    private String nomBanque;
    private String numeroCarteBanquaire;
    private Date dateExpirationCarteBanquaire;

    public Reglement(String type, String numeroCheque, String nomBanque) {
        this.type = type;
        this.numeroCheque = numeroCheque;
        this.nomBanque = nomBanque;
    }

    public Reglement(String type, String numeroCarteBanquaire, Date dateExpirationCarteBanquaire) {
        this.type = type;
        this.numeroCarteBanquaire = numeroCarteBanquaire;
        this.dateExpirationCarteBanquaire = dateExpirationCarteBanquaire;
    }

    public Reglement() {

    }

    // GETTERS
    public String getType() {
        return type;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public String getNumeroCarteBanquaire() {
        return numeroCarteBanquaire;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public Date getDateExpiration() {
        return dateExpirationCarteBanquaire;
    }

    // SETTERS
    public void setType(String type) {
        this.type = type;
    }

    public void setNumeroCarteBanquaire(String numeroCarteBanquaire) {
        this.numeroCarteBanquaire = numeroCarteBanquaire;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public void setDateExpirationCB(Date dateExpirationCarteBanquaire) {
        this.dateExpirationCarteBanquaire = dateExpirationCarteBanquaire;
    }
}
