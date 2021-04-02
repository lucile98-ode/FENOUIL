public class Article {

    private String numero;
    private String designation;
    private float prix;
    private int quantite;

    public Article(String numero, String designation, float prix, int quantite) {
        this.numero = numero;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Article(String numero) {
        this.numero = numero;
    }

    // GETTERS
    public String getNumero() {
        return numero;
    }

    public String getDesignation() {
        return designation;
    }

    public float getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    // SETTERS
    public void setDesignation(String newDesignation) {
        this.designation = newDesignation;
    }

    public void setPrix(int newPrix) {
        this.prix = newPrix;
    }

    public void setQuantite(int newQuantite) {
        this.quantite = newQuantite;
    }

}