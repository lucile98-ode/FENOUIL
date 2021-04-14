public class ToStringConnexionSaisie {

    private String selection, mdp;
    Fenetre fen;
    Mdp motDePasse = new Mdp();
    BaseDeDonnees b;

    public ToStringConnexionSaisie() {
    }

    public ToStringConnexionSaisie(String selection, String mdp, Fenetre fen, BaseDeDonnees b) {
        this.selection = selection;
        this.mdp = mdp;
        this.fen = fen;
        this.b = b;
    }

    public String toString() {
        String str;

        if ((this.selection.equals("Assistants de saisie")) && (this.mdp.equals(motDePasse.getMdpAssistantSaisie()))) {
            str = "Connexion en temps qu'Assistants de saisie";
            this.fen.dispose();
            InterfaceGraphique.SaisirCommande(b);
        } else {
            str = "Erreur de connexion";
        }

        return str;

    }

}