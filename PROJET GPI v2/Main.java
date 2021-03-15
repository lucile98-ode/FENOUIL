import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
    public static void main(String[] args) {
        BaseDeDonnees b = new BaseDeDonnees();
        InterfaceGraphique.Accueil(b);
        b.addCibleRoutages("Departement de residence", "Cible Essai 1", "ciseau", "pinceau", "ciment", "brique",
                "carrelage", "essai 1", "economique", "catalogue papier");
        b.addCibleRoutagesValide(
                new CibleRoutage("Age", "Cible Essai 2", "parpaing", "brique", "", "", "", "essai 2", "", "SMS"));
        b.addCibleRoutagesAEnvoyer(new CibleRoutage("Categorie socio-professionnelle", "Cible Essai 3", "brique",
                "ciment", "carrelage", "", "", "essai 3", "economique", "catalogue papier"));

        // CREATION DU XML (Hors de la classe CreerXML.java parce que probleme)
        // Creation du xml pour la cible de routage creer dans le Main.java pour un
        // essai
        /*
         * try {
         * 
         * // CibleRoutage cr = b.getCibleRoutageEnvoye(0);
         * 
         * DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         * DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
         * 
         * // élément de racine Document doc = docBuilder.newDocument(); Element racine
         * = doc.createElement("cibleRoutage"); doc.appendChild(racine);
         * 
         * // l'élément cible Element cible = doc.createElement("cible");
         * racine.appendChild(cible);
         * 
         * // le titre Element titre = doc.createElement("titre");
         * titre.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getTitre())
         * ); cible.appendChild(titre);
         * 
         * // la selection Element selection = doc.createElement("selection");
         * selection.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).
         * getSelection())); cible.appendChild(selection);
         * 
         * // la description Element description = doc.createElement("description");
         * description.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).
         * getDescription())); cible.appendChild(description);
         * 
         * // l'article 1 Element article1 = doc.createElement("article1");
         * article1.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).
         * getArticle1())); cible.appendChild(article1);
         * 
         * // l'article 2 Element article2 = doc.createElement("article2");
         * article2.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).
         * getArticle2())); cible.appendChild(article2);
         * 
         * // l'article 3 Element article3 = doc.createElement("article3");
         * article3.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).
         * getArticle3())); cible.appendChild(article3);
         * 
         * // l'article 4 Element article4 = doc.createElement("article4");
         * article4.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).
         * getArticle4())); cible.appendChild(article1);
         * 
         * // l'article 5 Element article5 = doc.createElement("article5");
         * article5.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).
         * getArticle5())); cible.appendChild(article5);
         * 
         * // le style Element style = doc.createElement("style");
         * style.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getStyle())
         * ); cible.appendChild(style);
         * 
         * // le type Element type = doc.createElement("type");
         * type.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getType()));
         * cible.appendChild(type);
         * 
         * // write the content into xml file TransformerFactory transformerFactory =
         * TransformerFactory.newInstance(); Transformer transformer =
         * transformerFactory.newTransformer(); DOMSource source = new DOMSource(doc);
         * String nomFichier = "cibleEnvoiEssai.xml"; StreamResult resultat = new
         * StreamResult(new File(nomFichier));
         * 
         * transformer.transform(source, resultat);
         * 
         * // System.out.println("Fichier sauvegardé avec succès!");
         * 
         * } catch (ParserConfigurationException pce) { pce.printStackTrace(); } catch
         * (TransformerException tfe) { tfe.printStackTrace(); }
         */
    }
}
