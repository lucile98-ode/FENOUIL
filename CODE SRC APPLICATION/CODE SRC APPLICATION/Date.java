public class Date {

    private int jour;
    private int mois;
    private int annee;

    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public Date(int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public String toStringDate() {
        String s = "";
        s += getJour() + " / " + getMois() + " / " + getAnnee();
        return s;
    }

    public String toStringDateCB() {
        String s = "";
        s += getMois() + " / " + getAnnee();
        return s;
    }
}
