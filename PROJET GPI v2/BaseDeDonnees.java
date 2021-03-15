public class BaseDeDonnees {

    private CibleRoutage[] listeCibleRoutage = new CibleRoutage[0];
    private CibleRoutage[] listeValide = new CibleRoutage[0];
    CibleRoutage[] listeAEnvoyer = new CibleRoutage[0];

    public BaseDeDonnees() {

    }

    // GETTERS
    public CibleRoutage[] getListeCibleRoutages() {
        return listeCibleRoutage;
    }

    public CibleRoutage[] getListeCibleRoutagesValide() {
        return listeValide;
    }

    public CibleRoutage[] getListeCibleRoutagesEnvoyee() {
        return listeAEnvoyer;
    }

    public CibleRoutage getCibleRoutageEnvoye(int index) {
        return listeAEnvoyer[index];
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

    public int addCibleRoutagesValide(CibleRoutage c) {

        CibleRoutage[] newList = new CibleRoutage[listeValide.length + 1];
        for (int i = 0; i < listeValide.length; i++) {
            newList[i] = listeValide[i];
        }
        newList[newList.length - 1] = c;
        listeValide = newList;
        return 0;
    }

    public int addCibleRoutagesAEnvoyer(CibleRoutage c) {

        CibleRoutage[] newList = new CibleRoutage[listeAEnvoyer.length + 1];
        for (int i = 0; i < listeAEnvoyer.length; i++) {
            newList[i] = listeAEnvoyer[i];
        }
        newList[newList.length - 1] = c;
        listeAEnvoyer = newList;
        return 0;
    }

    // TOSTRING PROVISOIRE DANS LA CONSOLE
    public String toStringCible() {
        String s = "nb de cible : " + listeCibleRoutage.length + "\n";
        for (int i = 0; i <= listeCibleRoutage.length; i++) {
            s += "cible n°" + i + " : " + listeCibleRoutage[i].getTitre();
        }
        return s;
    }

    public String toStringCibleValide() {
        String s = "nb de cible : " + listeValide.length + "\n" + listeValide[0].getTitre();
        return s;
    }

    // DELETE
    public int delCibleRoutage(CibleRoutage c) {
        if (listeCibleRoutage.length != 0) {
            boolean isFind = false;
            for (int i = 0; i < listeCibleRoutage.length; i++) {
                if (c.equals(listeCibleRoutage[i])) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                CibleRoutage[] newlist = new CibleRoutage[(listeCibleRoutage.length - 1)];
                int j = 0;
                for (int i = 0; i < listeCibleRoutage.length; i++) {
                    if (c.equals(listeCibleRoutage[i])) {
                        continue;
                    }
                    newlist[j] = listeCibleRoutage[i];
                    j++;
                }
                listeCibleRoutage = newlist;
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int delCibleRoutageValide(CibleRoutage c) {
        if (listeValide.length != 0) {
            boolean isFind = false;
            for (int i = 0; i < listeValide.length; i++) {
                if (c.equals(listeValide[i])) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                CibleRoutage[] newlist = new CibleRoutage[(listeValide.length - 1)];
                int j = 0;
                for (int i = 0; i < listeValide.length; i++) {
                    if (c.equals(listeValide[i])) {
                        continue;
                    }
                    newlist[j] = listeValide[i];
                    j++;
                }
                listeValide = newlist;
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

}
