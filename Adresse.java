public class Adresse {

    private int numero;
    private String rue;
    private int codePostal;
    private String ville;

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    // GETTERS
    public int getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    // SETTERS
    public void setNumero(int newNumero) {
        this.numero = newNumero;
    }

    public void setRue(String newRue) {
        this.rue = newRue;
    }

    public void setCodePostal(int newCodePostal) {
        this.codePostal = newCodePostal;
    }

    public void setVille(String newVille) {
        this.ville = newVille;
    }

}
