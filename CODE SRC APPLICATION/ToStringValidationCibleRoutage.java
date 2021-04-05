public class ToStringValidationCibleRoutage {

    private String cible;

    public ToStringValidationCibleRoutage() {
    }

    public ToStringValidationCibleRoutage(String cible) {
        this.cible = cible;
    }

    public String toString() {
        String str;

        if (this.cible != null) {
            str = "Validation de la cible de routage : \n";
            str += this.cible + "\n";

        } else {
            str = "Aucune information !";
        }

        return str;
    }

}