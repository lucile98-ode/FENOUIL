public class Main {
        public static void main(String[] args) {
                BaseDeDonnees b = new BaseDeDonnees();
                InterfaceGraphique.Accueil(b);

                // TESTS CIBLES DE ROUTAGE (BASE DE DONNEES REMPLIS POUR DES TESTS)
                b.addCibleRoutages("Departement de residence", "Cible Essai 1", "ciseau", "pinceau", "ciment", "brique",
                                "carrelage", "essai 1", "economique", "catalogue papier");
                b.addCibleRoutagesValide(new CibleRoutage("Age", "Cible Essai 2", "parpaing", "brique", "", "", "",
                                "essai 2", "", "SMS"));
                b.addCibleRoutagesAEnvoyer(new CibleRoutage("Categorie socio-professionnelle", "Cible Essai 3",
                                "brique", "ciment", "carrelage", "", "", "essai 3", "economique", "catalogue papier"));

                // TESTS ADMINISTRATION DES DONNEES (BASE DE DONNEES REMPLIS POUR DES TESTS)
                b.addIndividu("DUJARDIN", "Jean", new DateNaissance(1, 1, 2000), "cadre",
                                new Adresse(1, "avenue de la Republique", 75000, "Paris"), "0123456789",
                                "individu@exemple.fr", "client");

                b.addArticle("012345", "pot de peinture", 30, 50);

        }
}
