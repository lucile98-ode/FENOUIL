public class Main {
        public static void main(String[] args) {
                BaseDeDonnees b = new BaseDeDonnees();
                InterfaceGraphique.Accueil(b);

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////

                // TESTS ADMINISTRATION DES DONNEES INDIVIDUS (BASE DE DONNEES REMPLIS POUR DES
                // TESTS)
                Individu individu1 = new Individu("Nom1", "Prenom1", new Date(1, 1, 2000), "cadre",
                                new Adresse(1, "avenue de la Republique", 75000, "Paris"), "0123456789",
                                "individu@exemple.fr", "client");

                Individu individu2 = new Individu("Nom2", "Prenom2", new Date(1, 1, 1998), "cadre",
                                new Adresse(56, "rue de la St Cloud", 91000, "Evry"), "0738102736",
                                "individu2@exemple.fr", "prospect");

                b.addIndividu(individu1);
                b.addIndividu(individu2);

                Individu[] listeIndividus = { individu1, individu2 };

                // TESTS CIBLES DE ROUTAGE (BASE DE DONNEES REMPLIS POUR DES TESTS)
                b.addCibleRoutages("Departement de residence", "Cible Essai 1", "ciseau", "pinceau", "ciment", "brique",
                                "carrelage", "essai 1", "economique", "catalogue papier", listeIndividus);
                b.addCibleRoutagesValide(new CibleRoutage("Age", "Cible Essai 2", "parpaing", "brique", "", "", "",
                                "essai 2", "", "SMS", listeIndividus));
                b.addCibleRoutagesAEnvoyer(new CibleRoutage("Categorie socio-professionnelle", "Cible Essai 3",
                                "brique", "ciment", "carrelage", "", "", "essai 3", "economique", "catalogue papier",
                                listeIndividus));

                // TESTS ADMINISTRATION DES DONNEES ARTICLES (BASE DE DONNEES REMPLIS POUR DES
                // TESTS)
                b.addArticle("01234", "pot de peinture", 30, 50);
                b.addArticle("94248", "carrelage", 100, 50);
                b.addArticle("23439", "colle", 20, 50);
                b.addArticle("84774", "ciment", 40, 50);

                Article art1 = new Article("08264", "parpaing", 60, 10);
                Article art2 = new Article("02935", "marteau", 15, 10);
                Article art3 = new Article("92750", "pinceau", 5, 10);
                Article art4 = new Article("54782", "seau", 10, 10);

                b.addArticle(art1);
                b.addArticle(art2);
                b.addArticle(art3);
                b.addArticle(art4);

                Article[] listeArticle = { art1, art2, art3, art4 };

                // TESTS ADMINISTRATION DES DONNEES CATEGORIE SOCIO PROFESSIONNELLE (BASE DE
                // DONNEES REMPLIS POUR DES TESTS)
                b.addCategorieSocioProfessionnelle("artisans");
                b.addCategorieSocioProfessionnelle("agriculteur");
                b.addCategorieSocioProfessionnelle("cadre");
                b.addCategorieSocioProfessionnelle("ouvriers");
                b.addCategorieSocioProfessionnelle("retraite");
                b.addCategorieSocioProfessionnelle("employe");
                b.addCategorieSocioProfessionnelle("autres");

                // TESTS COMMANDE (BASE DE DONNEES REMPLIS POUR DES TESTS)
                Commande cmd = new Commande();
                cmd.setIndividu(individu1);
                cmd.setListeArticle(listeArticle);
                cmd.setReglement(new Reglement("CB", "0192746", new Date(12, 2031)));
                cmd.setMontant(900);
                cmd.setNumeroCommande(java.time.LocalDate.now() + "/" + java.time.LocalTime.now());
                cmd.setAnomalie(false);
                cmd.addTypesAnomalie("");

                b.addCommande(cmd.getIndividu(), cmd.getListeArticle(), cmd.getReglement(), cmd.getMontant(),
                                cmd.getNumeroCommande(), cmd.getAnomalie(), cmd.getTypesAnomalie());

                // BASE DE DONNEES DES DEPARTEMENTS
                // (https://www.regions-et-departements.fr/departements-francais)
                b.addDepartementResidence("01", "Ain");
                b.addDepartementResidence("02", "Aisne");
                b.addDepartementResidence("03", "Allier");
                b.addDepartementResidence("04", "Alpes-de-Haute-Provence");
                b.addDepartementResidence("05", "Hautes-Alpes");
                b.addDepartementResidence("06", "Alpes-Maritimes");
                b.addDepartementResidence("07", "Ardeche");
                b.addDepartementResidence("08", "Ardennes");
                b.addDepartementResidence("09", "Ariege");
                b.addDepartementResidence("10", "Aube");
                b.addDepartementResidence("11", "Aude");
                b.addDepartementResidence("12", "Aveyron");
                b.addDepartementResidence("13", "Bouches-du-Rhone");
                b.addDepartementResidence("14", "Calvados");
                b.addDepartementResidence("15", "Cantal");
                b.addDepartementResidence("16", "Charente");
                b.addDepartementResidence("17", "Charente-Maritime");
                b.addDepartementResidence("18", "Cher");
                b.addDepartementResidence("19", "Correze");
                b.addDepartementResidence("2A", "Corse-du-Sud");
                b.addDepartementResidence("2B", "Haute-Corse");
                b.addDepartementResidence("21", "Cote-d\'Or");
                b.addDepartementResidence("22", "Cotes d\'Armor");
                b.addDepartementResidence("23", "Creuse");
                b.addDepartementResidence("24", "Dordogne");
                b.addDepartementResidence("25", "Doubs");
                b.addDepartementResidence("26", "Drome");
                b.addDepartementResidence("27", "Eure");
                b.addDepartementResidence("28", "Eure-et-Loir");
                b.addDepartementResidence("29", "Finistere");
                b.addDepartementResidence("30", "Gard");
                b.addDepartementResidence("31", "Haute-Garonne");
                b.addDepartementResidence("32", "Gers");
                b.addDepartementResidence("33", "Gironde");
                b.addDepartementResidence("34", "Herault");
                b.addDepartementResidence("35", "Ille-et-Vilaine");
                b.addDepartementResidence("36", "Indre");
                b.addDepartementResidence("37", "Indre-et-Loire");
                b.addDepartementResidence("38", "Isere");
                b.addDepartementResidence("39", "Jura");
                b.addDepartementResidence("40", "Landes");
                b.addDepartementResidence("41", "Loir-et-Cher");
                b.addDepartementResidence("42", "Loire");
                b.addDepartementResidence("43", "Haute-Loire");
                b.addDepartementResidence("44", "Loire-Atlantique");
                b.addDepartementResidence("45", "Loiret");
                b.addDepartementResidence("46", "Lot");
                b.addDepartementResidence("47", "Lot-et-Garonne");
                b.addDepartementResidence("48", "Lozere");
                b.addDepartementResidence("49", "Maine-et-Loire");
                b.addDepartementResidence("50", "Manche");
                b.addDepartementResidence("51", "Marne");
                b.addDepartementResidence("52", "Haute-Marne");
                b.addDepartementResidence("53", "Mayenne");
                b.addDepartementResidence("54", "Meurthe-et-Moselle");
                b.addDepartementResidence("55", "Meuse");
                b.addDepartementResidence("56", "Morbihan");
                b.addDepartementResidence("57", "Moselle");
                b.addDepartementResidence("58", "Nievre");
                b.addDepartementResidence("59", "Nord");
                b.addDepartementResidence("60", "Oise");
                b.addDepartementResidence("61", "Orne");
                b.addDepartementResidence("62", "Pas-de-Calais");
                b.addDepartementResidence("63", "Puy-de-Dome");
                b.addDepartementResidence("64", "Pyrenees-Atlantiques");
                b.addDepartementResidence("65", "Hautes-Pyrenees");
                b.addDepartementResidence("66", "Pyrenees-Orientales");
                b.addDepartementResidence("67", "Bas-Rhin");
                b.addDepartementResidence("68", "Haut-Rhin");
                b.addDepartementResidence("69", "Rhone");
                b.addDepartementResidence("70", "Haute-Saone");
                b.addDepartementResidence("71", "Saone-et-Loire");
                b.addDepartementResidence("72", "Sarthe");
                b.addDepartementResidence("73", "Savoie");
                b.addDepartementResidence("74", "Haute-Savoie");
                b.addDepartementResidence("75", "Paris");
                b.addDepartementResidence("76", "Seine-Maritime");
                b.addDepartementResidence("77", "Seine-et-Marne");
                b.addDepartementResidence("78", "Yvelines");
                b.addDepartementResidence("79", "Deux-Sevres");
                b.addDepartementResidence("80", "Somme");
                b.addDepartementResidence("81", "Tarn");
                b.addDepartementResidence("82", "Tarn-et-Garonne");
                b.addDepartementResidence("83", "Var");
                b.addDepartementResidence("84", "Vaucluse");
                b.addDepartementResidence("85", "Vandee");
                b.addDepartementResidence("86", "Vienne");
                b.addDepartementResidence("87", "Haute-Vienne");
                b.addDepartementResidence("88", "Vosges");
                b.addDepartementResidence("89", "Yonne");
                b.addDepartementResidence("90", "Territoire de Belfort");
                b.addDepartementResidence("91", "Essonne");
                b.addDepartementResidence("92", "Hauts-de-Seine");
                b.addDepartementResidence("93", "Seine-St-Denis");
                b.addDepartementResidence("94", "Val-de-Marne");
                b.addDepartementResidence("95", "Val-D\'Oise");
                b.addDepartementResidence("971", "Guadeloupe");
                b.addDepartementResidence("972", "Martinique");
                b.addDepartementResidence("973", "Guyane");
                b.addDepartementResidence("974", "La Reunion");
                b.addDepartementResidence("976", "Mayotte");

        }
}