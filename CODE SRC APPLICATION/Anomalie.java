public class Anomalie {
    String[] listeAnomalies = new String[0];
    Individu individu;
    Commande commande;
    Date date;

    public Anomalie(String[] listeAnomalies, Individu individu, Commande commande, Date date) {
        this.listeAnomalies = listeAnomalies;
        this.individu = individu;
        this.commande = commande;
        this.date = date;
    }

    public Anomalie() {

    }

    // GETTERS
    public Individu getIndividu() {
        return individu;
    }

    public Commande getCommande() {
        return commande;
    }

    public Date getDate() {
        return date;
    }

    public String[] getTabAnomalie() {
        return listeAnomalies;
    }

    // SETTERS
    public void setIndividu(Individu individu) {
        this.individu = individu;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // ADDERS
    public int addAnomalie(String newAnomalie) {

        String anomalie = newAnomalie;

        String[] newList = new String[listeAnomalies.length + 1];
        for (int i = 0; i < listeAnomalies.length; i++) {
            newList[i] = listeAnomalies[i];
        }
        newList[newList.length - 1] = anomalie;
        listeAnomalies = newList;
        return 0;
    }

    // TOSTRING
    public String toStringAnomalie() {
        String s = "";

        s += "Commande numero : " + getCommande().getNumeroCommande() + "\n";
        s += "Date de la commande : " + getDate().toStringDate() + "\n\n";

        s += "Individu : \n";
        s += "Nom : " + getIndividu().getNom() + "\n";
        s += "Prenom : " + getIndividu().getPrenom() + "\n";
        s += "Date de naissance : " + getIndividu().getDate() + "\n\n\n";

        s += "Reglement :\n\n";
        s += "Type de reglement " + getCommande().getReglement().getType() + "\n";
        s += "Montant : " + getCommande().getMontant() + " euros\n";

        s += "Anomalie(s) :\n";

        for (int i = 0; i < getTabAnomalie().length; i++) {
            s += getTabAnomalie()[i] + "\n";
        }

        return s;
    }
}
