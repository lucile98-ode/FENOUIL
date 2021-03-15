
// http://www.codeurjava.com/2015/07/dom-parser-comment-creer-un-fichier-xml.html
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

public class CreerXML {

    public static void main(String args[]) {

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

            // élément de racine
            Document doc = docBuilder.newDocument();
            Element racine = doc.createElement("cibleRoutage");
            doc.appendChild(racine);

            // l'élément cible
            Element cible = doc.createElement("cible");
            racine.appendChild(cible);

            // le nom
            Element nom = doc.createElement("nom");
            nom.appendChild(doc.createTextNode("codeur"));
            cible.appendChild(nom);

            // le prénom
            Element prenom = doc.createElement("prenom");
            prenom.appendChild(doc.createTextNode("java"));
            cible.appendChild(prenom);

            // le mobile
            Element mobile = doc.createElement("mobile");
            mobile.appendChild(doc.createTextNode("098745126"));
            cible.appendChild(mobile);

            // l'email
            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode("codeurjava8@gmail.com"));
            cible.appendChild(email);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult resultat = new StreamResult(new File("monFichier.xml"));

            transformer.transform(source, resultat);

            System.out.println("Fichier sauvegardé avec succès!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}