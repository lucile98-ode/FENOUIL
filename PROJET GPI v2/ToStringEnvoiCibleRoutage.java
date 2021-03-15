public class ToStringEnvoiCibleRoutage {
    private String cible;

    public ToStringEnvoiCibleRoutage() {
    }

    public ToStringEnvoiCibleRoutage(String cible) {
        this.cible = cible;
    }

    public String toString() {
        String str;

        if (this.cible != null) {
            str = "Envoi de la cible de routage : \n";
            str += this.cible + "\n";

        } else {
            str = "Aucune information !";
        }

        return str;
    }
}
