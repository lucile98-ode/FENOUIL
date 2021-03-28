public class DepartementResidence {

    private String numero;
    private String nom;

    public DepartementResidence(String numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    public String ToStringDepartementResidence() {
        String s = numero + " - " + nom;
        return s;
    }

    public String getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }
}
