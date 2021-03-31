
public class ToStringConnexionAnomalie {

    private String selection, mdp;
    Fenetre fen;
    Mdp motDePasse = new Mdp();
    BaseDeDonnees b;

    public ToStringConnexionAnomalie() {
    }

    public ToStringConnexionAnomalie(String selection, String mdp, Fenetre fen, BaseDeDonnees b) {
        this.selection = selection;
        this.mdp = mdp;
        this.fen = fen;
        this.b = b;
    }

    public String toString() {
        String str;

        if ((this.selection.equals("Gestionnaire administratif"))
                && (this.mdp.equals(motDePasse.getMdpGestionnaireAdmin()))) {
            str = "Connexion en temps que Gestionnaire administratif";
            this.fen.dispose();
            InterfaceGraphique.test(b);
        } else {
            str = "Erreur de connexion";
        }

        return str;

    }
}
