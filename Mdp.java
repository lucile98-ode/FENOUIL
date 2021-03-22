public class Mdp {

    // Pour les connexions dans le cadre des cibles de routage :
    // departement prospection -> mdp = departement
    // directeur de la strategie -> mdp = directeur
    // responsable de routage -> mdp = responsable
    // administateur de donee -> mdp = administateur
    final String mdpDepartementProspection = "departement";
    final String mdpDirecteurStrategie = "directeur";
    final String mdpResponsableRoutage = "responsable";
    final String mdpAdministrateurDonnees = "administrateur";

    public String[] mdp = new String[] { mdpDepartementProspection, mdpDirecteurStrategie, mdpResponsableRoutage };

    public Mdp() {
    }

    // GETTERS
    public String getMdpDepartementProspection() {
        return mdpDepartementProspection;
    }

    public String getMdpDirecteurStrategie() {
        return mdpDirecteurStrategie;
    }

    public String getMdpResponsableRoutage() {
        return mdpResponsableRoutage;
    }

    public String getMdpAdministrateurDonnees() {
        return mdpAdministrateurDonnees;
    }
}
