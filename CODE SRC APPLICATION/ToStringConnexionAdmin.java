public class ToStringConnexionAdmin {

    private String selection, mdp;
    Fenetre fen;
    Mdp motDePasse = new Mdp();
    BaseDeDonnees b;

    public ToStringConnexionAdmin() {
    }

    public ToStringConnexionAdmin(String selection, String mdp, Fenetre fen, BaseDeDonnees b) {
        this.selection = selection;
        this.mdp = mdp;
        this.fen = fen;
        this.b = b;
    }

    public String toString() {
        String str;

        if ((this.selection.equals("Administrateur de donnee"))
                && (this.mdp.equals(motDePasse.getMdpAdministrateurDonnees()))) {
            str = "Connexion en temps qu'Administrateur de donnee";
            this.fen.dispose();
            InterfaceGraphique.AdministrerDonnees(b);
        } else {
            str = "Erreur de connexion";
        }

        return str;

    }

}