
package Controller.CoreOperation;

import Controller.CoreOperation.Revisore;
import Model.DAO.DBMS;
import Model.DAO.FileSystem;
import Model.EntityObject.Pagina;
import Model.EntityObject.Trascrizione;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Gianluca Scatena
 */
public class TrasRevisore extends Revisore {
    
    public static boolean rigetta (Pagina pag, DBMS db) {
        boolean confirm = false;
        if (db.isStato(pag)) {
            db.changeStato(pag, "acquisito");
            db.remove(pag);
            confirm = true;
        }
        return confirm;
    }
    
    /*
    
    Prima della pubblicazione di una trascrizione, viene salvato nel database il testo
    in formato TEI modificato rispetto alla prima trascrizione. Di fatto, vengono aggiunte 
    informazioni aggiuntive riguardo la revisione e viene eseguito l'aggiornamento
    del testo iniziale. Tutto questo viene effettuato caricando dapprima il TEI dal database,
    sul quale si esegue un'azione di parsing per ricavare le parti che devono essere
    modificate.
    
    */
    
    public static boolean conferma (Pagina pag, DBMS db) {
        boolean confirm = false;
        Trascrizione tras = pag.getAcquisizione().getTrascrizione();
        String xml = tras.getTEI();
        try {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = (Document) docBuilder.parse(new InputSource(new StringReader(xml)));
                Node div = doc.getElementsByTagName("div").item(0);
                Node revisionDesc = doc.getElementsByTagName("change").item(0);
                NodeList change = revisionDesc.getChildNodes();
                Node date = change.item(1);
                Node autore = change.item(3);
                Node note = change.item(5);
                div.setTextContent(tras.getTesto());
                date.setTextContent(tras.getDataRev());
                autore.setTextContent(tras.getAutoRev()); 
                note.setTextContent(tras.getNote());
                xml = toString(doc);
                tras.setTrascrizione(xml);
                confirm = db.update(tras);
                if (confirm) {
                    db.makePubb(pag);
                    if (db.isStato(pag)) {
                        db.changeStato(pag, "trascritto");
                        confirm = true;
                    }
                }
            } catch (SAXException sae) {
                sae.printStackTrace();
            } catch (IOException ioe) {
		ioe.printStackTrace();
	   }
        }   catch (ParserConfigurationException pce) {
		pce.printStackTrace();
        }
    return confirm;
    }
    

    public static String toString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

}
