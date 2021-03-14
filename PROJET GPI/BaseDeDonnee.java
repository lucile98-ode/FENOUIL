public class BaseDeDonnee {

    private CibleRoutage[] listeCibleRoutage = new CibleRoutage[0];
    private CibleRoutage[] listeValide = new CibleRoutage[0];

    public BaseDeDonnee() {

    }

    // GETTERS
    public CibleRoutage[] getTabCibleRoutages() {
        return listeCibleRoutage;
    }

    // ADDERS
    public int addCibleRoutages(String selection, String titre, String article1, String article2, String article3,
            String article4, String article5, String description, String style, String type) {

        CibleRoutage c = new CibleRoutage(selection, titre, article1, article2, article3, article4, article5,
                description, style, type);

        CibleRoutage[] newList = new CibleRoutage[listeCibleRoutage.length + 1];
        for (int i = 0; i < listeCibleRoutage.length; i++) {
            newList[i] = listeCibleRoutage[i];
        }
        newList[newList.length - 1] = c;
        listeCibleRoutage = newList;
        return 0;
    }

    // TOSTRING PROVISOIRE
    public String toString() {
        String s = "nb de cible : " + listeCibleRoutage.length + "\n" + listeCibleRoutage[0].getTitre();
        return s;
    }

}
