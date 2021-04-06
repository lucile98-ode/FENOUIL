
// https://waytolearnx.com/2020/03/deplacer-le-fichier-vers-un-autre-repertoire-en-java.html
// https://waytolearnx.com/2020/03/recuperer-le-repertoire-courant-en-java.html

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

public class XMLChangeRepertoire {

    public static void XMLChangeRepertoire(BaseDeDonnees b, CibleRoutage cr) {

        try {
            String repertoireCourtant = System.getProperty("user.dir");
            // System.out.println("Le répertoire courant est : " + repertoireCourtant);

            String src = (repertoireCourtant + "\\" + cr.getTitre() + ".xml");
            String dest = (repertoireCourtant + "\\FichiersXML\\" + cr.getTitre() + ".xml");
            Path tmp = Files.move(Paths.get(src), Paths.get(dest));

            if (tmp != null) {
                System.out.println("Fichier déplacé avec succès");
            } else {
                System.out.println("Impossible de déplacer le fichier");
            }
        } catch (IOException ioException) {

        }
    }

}