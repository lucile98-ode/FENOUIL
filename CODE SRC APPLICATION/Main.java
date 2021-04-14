public class Main {
        public static void main(String[] args) {
                BaseDeDonnees b = new BaseDeDonnees();
                InterfaceGraphique.Accueil(b);

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////

                // TESTS ADMINISTRATION DES DONNEES INDIVIDUS (BASE DE DONNEES REMPLIS POUR DES
                // TESTS)
                Individu individu1 = new Individu("DUPUY", "Martin", new Date(18, 6, 1950), "retraites",
                                new Adresse(64, "avenue de la Republique", 75000, "Paris"), "0123456789",
                                "martin.dupuy@laposte.net", "client");

                Individu individu2 = new Individu("RIVIERE", "Evelyne", new Date(29, 12, 1965), "employes",
                                new Adresse(1, "rue de la St Cloud", 91000, "Evry"), "0738102736",
                                "evelyne.riviere@gmail.com", "prospect");

                Individu individu3 = new Individu("MOREL", "Simon", new Date(30, 5, 1980), "cadres",
                                new Adresse(27, "rue De La Chevrotiere", 92700, "Colombes"), "0654837285",
                                "simon.morel@laposte.net", "client");

                Individu individu4 = new Individu("PEREZ", "Sophie", new Date(17, 1, 1999), "etudiants",
                                new Adresse(78, "avenue des Pommiers", 69000, "Lyon"), "0624249856",
                                "sophie.perez@hotmail.fr", "prospect");

                Individu individu5 = new Individu("FABRE", "Luka", new Date(10, 11, 1988), "cadre",
                                new Adresse(10, "avenue de Versailles", 75000, "Paris"), "0628995372",
                                "luka.fabre@gmail.com", "client");

                Individu individu6 = new Individu("GUERIN", "Rose", new Date(5, 7, 1948), "retraites",
                                new Adresse(22, "place Gabriel Perie", 86000, "Poitiers"), "0773590208",
                                "rose.guerin@hotmail.fr", "prospect");

                Individu individu7 = new Individu("MULLER", "Victor", new Date(25, 2, 1969), "autres",
                                new Adresse(9, "boulevard du Midi", 59000, "Lille"), "0622983582",
                                "victor.muller@free.fr", "client");

                Individu individu8 = new Individu("GARCIA", "Alix", new Date(27, 4, 1985), "cadres",
                                new Adresse(287, "rue des Chailliers", 33063, "Bordeaux"), "0624159378",
                                "alix.garcia@gmail.com", "prospect");

                Individu individu9 = new Individu("LEBRUN", "Paul", new Date(20, 8, 1970), "agriculteurs",
                                new Adresse(19, "avenue de la Liberte", 75000, "Paris"), "0682938112",
                                "paul.lebrun@outlook.com", "client");

                Individu individu10 = new Individu("FERNANDES", "Celia", new Date(1, 3, 2000), "etudiants",
                                new Adresse(175, "boulevard du Levant", 75000, "Paris"), "0791630982",
                                "celia.fernandes@free.fr", "prospect");

                b.addIndividu(individu1);
                b.addIndividu(individu2);
                b.addIndividu(individu3);
                b.addIndividu(individu4);
                b.addIndividu(individu5);
                b.addIndividu(individu6);
                b.addIndividu(individu7);
                b.addIndividu(individu8);
                b.addIndividu(individu9);
                b.addIndividu(individu10);

                Individu[] listeIndividus = { individu1, individu2 };

                // TESTS CIBLES DE ROUTAGE (BASE DE DONNEES REMPLIS POUR DES TESTS)

                // b.addCibleRoutages("Departement de residence", "PUB - Bricolage",
                // "carrelage", "pinceau", "ciment",
                // "brique", "", "Nouveaux articles", "economique", "catalogue papier",
                // listeIndividus);

                // b.addCibleRoutagesValide(new CibleRoutage("Age", "Cible Essai 2", "parpaing",
                // "brique", "", "", "",
                // "essai 2", "", "SMS", listeIndividus));
                // b.addCibleRoutagesAEnvoyer(new CibleRoutage("Categorie
                // socio-professionnelle", "Cible Essai 3",
                // "brique", "ciment", "carrelage", "", "", "essai 3", "economique", "catalogue
                // papier",
                // listeIndividus));

                // TESTS ADMINISTRATION DES DONNEES ARTICLES (BASE DE DONNEES REMPLIS POUR DES
                // TESTS)
                b.addArticle("01234", "pot de peinture", 30, 50);
                b.addArticle("94248", "fauteil", 100, 50);
                b.addArticle("23439", "colle", 20, 50);
                b.addArticle("84774", "canape", 130, 50);
                b.addArticle("78323", "table", 80, 50);
                b.addArticle("36719", "chaise", 30, 50);
                b.addArticle("29503", "lavabo", 80, 50);
                b.addArticle("10928", "lampe", 20, 50);
                b.addArticle("72973", "tapis", 20, 50);
                b.addArticle("88023", "bureau", 30, 50);
                b.addArticle("82631", "porte", 40, 50);
                b.addArticle("85064", "armoire", 40, 50);
                b.addArticle("92722", "etagere", 40, 50);

                Article art1 = new Article("08264", "lit", 60, 10);
                Article art2 = new Article("02935", "marteau", 15, 10);
                Article art3 = new Article("92750", "pinceau", 5, 10);
                Article art4 = new Article("54782", "seau", 10, 10);

                b.addArticle(art1);
                b.addArticle(art2);
                b.addArticle(art3);
                b.addArticle(art4);

                Article[] listeArticle1 = { art3 };
                Article[] listeArticle2 = { art2, art4 };
                Article[] listeArticle = { art1, art2, art3, art4 };

                // TESTS ADMINISTRATION DES DONNEES CATEGORIE SOCIO PROFESSIONNELLE (BASE DE
                // DONNEES REMPLIS POUR DES TESTS)
                b.addCategorieSocioProfessionnelle("artisans");
                b.addCategorieSocioProfessionnelle("agriculteurs");
                b.addCategorieSocioProfessionnelle("cadres");
                b.addCategorieSocioProfessionnelle("ouvriers");
                b.addCategorieSocioProfessionnelle("retraites");
                b.addCategorieSocioProfessionnelle("employes");
                b.addCategorieSocioProfessionnelle("etudiants");
                b.addCategorieSocioProfessionnelle("autres");

                // TESTS COMMANDE (BASE DE DONNEES REMPLIS POUR DES TESTS)
                Commande cmd = new Commande();
                cmd.setIndividu(individu1);
                cmd.setListeArticle(listeArticle);
                cmd.setReglement(new Reglement("CB", "**** **** **** **** ***", new Date(12, 2031)));
                cmd.setMontant(900);
                cmd.setNumeroCommande("2021-04-12/12:16:27.624159510");
                // System.out.println(java.time.LocalDate.now() + "/" +
                // java.time.LocalTime.now());
                cmd.setAnomalie(false);
                cmd.addTypesAnomalie("");

                b.addCommandeEnregistre(cmd.getIndividu(), cmd.getListeArticle(), cmd.getReglement(), 50,
                                cmd.getNumeroCommande(), cmd.getAnomalie(), cmd.getTypesAnomalie());
                b.addCommande(cmd.getIndividu(), cmd.getListeArticle(), cmd.getReglement(), 50, cmd.getNumeroCommande(),
                                cmd.getAnomalie(), cmd.getTypesAnomalie());

                b.addCommandeEnregistre(individu5, listeArticle2,
                                new Reglement("CB", "**** **** **** **** ***", new Date(12, 2025)), 200,
                                "2021-04-13/09:12:23.787023504", false, cmd.getTypesAnomalie());
                b.addCommande(individu5, listeArticle2,
                                new Reglement("CB", "**** **** **** **** ***", new Date(12, 2025)), 200,
                                "2021-04-13/09:12:23.787023504", false, cmd.getTypesAnomalie());

                cmd.addTypesAnomalie("Erreur sur le moyen de paiment");

                b.addCommandeEnregistre(individu10, listeArticle1,
                                new Reglement("CB", "**** **** **** **** ***", new Date(12, 2020)), cmd.getMontant(),
                                java.time.LocalDate.now() + "/" + java.time.LocalTime.now(), true,
                                cmd.getTypesAnomalie());
                b.addCommande(individu10, listeArticle1,
                                new Reglement("CB", "**** **** **** **** ***", new Date(12, 2020)), cmd.getMontant(),
                                java.time.LocalDate.now() + "/" + java.time.LocalTime.now(), true,
                                cmd.getTypesAnomalie());

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