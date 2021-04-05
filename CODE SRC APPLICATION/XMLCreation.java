
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreation {

        public static void CreerXML(BaseDeDonnees b) {

                try {
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

                        // élément de racine
                        Document doc = docBuilder.newDocument();
                        Element racine = doc.createElement("cibleRoutage");
                        doc.appendChild(racine);

                        // CIBLE
                        Element cible = doc.createElement("cible");
                        racine.appendChild(cible);

                        // le titre
                        Element titre = doc.createElement("titre");
                        titre.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getTitre()));
                        cible.appendChild(titre);

                        // la selection
                        Element selection = doc.createElement("selection");
                        selection.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getSelection()));
                        cible.appendChild(selection);

                        // la description
                        Element description = doc.createElement("description");
                        description.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getDescription()));
                        cible.appendChild(description);

                        // l'article 1
                        Element article1 = doc.createElement("article1");
                        article1.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getArticle1()));
                        cible.appendChild(article1);

                        // l'article 2
                        Element article2 = doc.createElement("article2");
                        article2.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getArticle2()));
                        cible.appendChild(article2);

                        // l'article 3
                        Element article3 = doc.createElement("article3");
                        article3.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getArticle3()));
                        cible.appendChild(article3);

                        // l'article 4
                        Element article4 = doc.createElement("article4");
                        article4.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getArticle4()));
                        cible.appendChild(article4);

                        // l'article 5
                        Element article5 = doc.createElement("article5");
                        article5.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getArticle5()));
                        cible.appendChild(article5);

                        // le style
                        Element style = doc.createElement("style");
                        style.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getStyle()));
                        cible.appendChild(style);

                        // le type
                        Element type = doc.createElement("type");
                        type.appendChild(doc.createTextNode((b.getCibleRoutageEnvoye(0)).getType()));
                        cible.appendChild(type);

                        // INDIVIDU
                        Element individusCibles = doc.createElement("individusCible");
                        racine.appendChild(individusCibles);

                        // for (int i = 0; i <= b.getCibleRoutageEnvoye(0).getIndividusCibles().length;
                        // i++) {

                        Element listeIndividu = doc.createElement("individus");
                        individusCibles.appendChild(listeIndividu);

                        Element nom = doc.createElement("nom");
                        nom.appendChild(doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                        .getListeIndividus()[0].getNom())));
                        listeIndividu.appendChild(nom);

                        Element prenom = doc.createElement("prenom");
                        prenom.appendChild(
                                        doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                                        .getListeIndividus()[0].getPrenom())));
                        listeIndividu.appendChild(prenom);

                        Element age = doc.createElement("age");
                        age.appendChild(doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                        .getListeIndividus()[0].getToStringAge())));
                        listeIndividu.appendChild(age);

                        Element Date = doc.createElement("Date");
                        Date.appendChild(doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                        .getListeIndividus()[0].getDate())));
                        listeIndividu.appendChild(Date);

                        Element categorieSocioProfessionnelle = doc.createElement("categorieSocioProfessionnelle");
                        categorieSocioProfessionnelle.appendChild(
                                        doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                                        .getListeIndividus()[0].getCategorieSocioProfessionnelle())));
                        listeIndividu.appendChild(categorieSocioProfessionnelle);

                        Element adresse = doc.createElement("adresse");
                        adresse.appendChild(
                                        doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                                        .getListeIndividus()[0].getAdresse())));
                        listeIndividu.appendChild(adresse);

                        Element telephone = doc.createElement("telephone");
                        telephone.appendChild(
                                        doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                                        .getListeIndividus()[0].getNumeroTelephone())));
                        listeIndividu.appendChild(telephone);

                        Element email = doc.createElement("email");
                        email.appendChild(doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                        .getListeIndividus()[0].getAdresseMail())));
                        listeIndividu.appendChild(email);

                        Element caracteristiqueCommerciale = doc.createElement("caracteristiqueCommerciale");
                        caracteristiqueCommerciale.appendChild(
                                        doc.createTextNode((/* b.getCibleRoutageEnvoye(0)).getIndividusCibles()[0] */b
                                                        .getListeIndividus()[0].getCaracteristiqueCommerciale())));
                        listeIndividu.appendChild(caracteristiqueCommerciale);

                        // }

                        // write the content into xml file
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        String nomFichier = "cibleEnvoiEssai.xml";
                        // String nomCible = b.getListeCibleRoutagesEnvoyee()[0].getTitre();
                        // String nomFichier = nomCible + ".xml";
                        StreamResult resultat = new StreamResult(new File(nomFichier));

                        transformer.transform(source, resultat);
                        System.out.println("Fichier sauvegardé avec succès!");

                } catch (ParserConfigurationException pce) {
                        pce.printStackTrace();
                } catch (TransformerException tfe) {
                        tfe.printStackTrace();
                }
        }

}