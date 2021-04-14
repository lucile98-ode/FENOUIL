public class Mdp {

    // Pour les connexions dans le cadre des cibles de routage :
    // departement prospection -> mdp = departement
    // directeur de la strategie -> mdp = directeur
    // responsable de routage -> mdp = responsable
    // administateur de donnee -> mdp = administateur
    // assistants de saisie -> mdp = assistant
    // geestionnaire administratif -> mdp = gestionnaire

    final String mdpDepartementProspection = "departement";
    final String mdpDirecteurStrategie = "directeur";
    final String mdpResponsableRoutage = "responsable";
    final String mdpAdministrateurDonnees = "administrateur";
    final String mdpAssistantSaisie = "assistant";
    final String mdpGestionnaireAdministratif = "gestionnaire";

    public String[] mdp = new String[] { mdpDepartementProspection, mdpDirecteurStrategie, mdpResponsableRoutage,
            mdpAdministrateurDonnees, mdpAssistantSaisie, mdpGestionnaireAdministratif };

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

    public String getMdpAssistantSaisie() {
        return mdpAssistantSaisie;
    }

    public String getMdpGestionnaireAdministratif() {
        return mdpGestionnaireAdministratif;
    }

}