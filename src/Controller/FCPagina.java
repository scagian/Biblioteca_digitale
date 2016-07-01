
package Controller;

import Controller.CoreOperation.Trascrittore;
import Controller.CoreOperation.TrasRevisore;
import Controller.CoreOperation.Revisore;
import Controller.CoreOperation.Acquisitore;
import java.util.HashMap;
import Model.EntityObject.*;
import Model.DAO.*;
import View.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Gianluca Scatena
 */
public class FCPagina implements FrontController {
    
    private final DBMS database;
    private final FileSystem fs;
    
    public FCPagina() {
        this.database = new DBMS();
        this.fs = new FileSystem();
    };
    
    public Object doOperation(HashMap<String, Object[]> param) {
        for(HashMap.Entry<String, Object[]> entry: param.entrySet()) {
            Object [] parametri = entry.getValue();
            if (entry.getKey().equals("acquisisci")) {
                try {
                    if (Acquisitore.acquisisci((File)parametri[0], (Pagina)parametri[1], 
                            (Utente)parametri[2], this.database, this.fs)) {
                        return "true";
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FCPagina.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } else if (entry.getKey().equals("inserisci_opera")) {
                Opera new_op = Acquisitore.inserisci_opera((String[])parametri[0], this.database);
                if (new_op != null) {
                    V_Opere new_view = (V_Opere)parametri[1];
                    new_view.getLista().add(new_op);
                    return new_view;
                } else {
                    return "false";
                }
            } else if (entry.getKey().equals("inserisci_pagina")){
                V_Pagine new_view = (V_Pagine)parametri[1];
                Pagina new_pag = Acquisitore.inserisci_pagina((int)parametri[0], 
                        new_view.getOpera().getID_Opera(), this.database);
                if (new_pag != null) {
                    new_view.getOpera().getPagine().add(new_pag);
                    return new_view;
                } else {
                return "false";
                }
            } else if (entry.getKey().equals("conferma acq")) {
                Pagina pagina = (Pagina)parametri[0];
                if (Revisore.conferma(pagina, this.database)) {
                    return "true";
                } else {
                    return "false";
                }
            } else if (entry.getKey().equals("rigetta acq")) {
                Pagina pagina = (Pagina)parametri[0];
                if (Revisore.rigetta(pagina, this.database, this.fs)){
                    return "true";
                } else {
                    return "false";
                }
            } else if (entry.getKey().equals("pubblica acq")) {
                Pagina pagina = (Pagina)parametri[0];
                if (Revisore.pubblica(pagina, this.database)){
                    return "true";
                } else {
                    return "false";
                } 
            } else if (entry.getKey().equals("trascrivi"))  {
                String testo = (String)parametri[0];
                Pagina p = (Pagina)parametri[1];
                Utente ut = (Utente)parametri[2];
                Opera op = (Opera)parametri[3];
                if(Trascrittore.trascrivi(testo, p, ut, op, this.database)) {
                    return "true";
                } else {
                    return "false";
                }
            } else if (entry.getKey().equals("rigetta tras")) {
                Pagina pag = (Pagina)parametri[0];
                if (TrasRevisore.rigetta(pag, this.database)) {
                    return "true";
                } else {
                    return "false";
                }
                
            } else if (entry.getKey().equals("conferma tras")) {
                Pagina pag = (Pagina)parametri[0];
                Trascrizione tras = pag.getAcquisizione().getTrascrizione();
                tras.setTesto((String)parametri[1]);
                tras.setNote((String)parametri[2]);
                tras.setAutoRev((String)parametri[3]);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                tras.setDataRev(dateFormat.format(date));
                if(TrasRevisore.conferma(pag, this.database)) {
                    return "true";
                } else {
                    return "false";
                }
            }
        }
        return null;
    }
    
    public V_Pagine askPagine(Opera op, Utente u) {
        return new V_Pagine(u, op, this.database);
    }
    
    public V_Opere askOpere(Utente ut, String stato) {
        return new V_Opere(ut, this.database, stato);
    }
    
    public V_Opere askOpere(Utente ut) {
        return new V_Opere(ut, this.database);
    }
    
    public V_Personale askVPersonale(Utente ut) {
        return new V_Personale(ut, this.database);
    }
    
    public void ask (Pagina pag) {
        this.database.get(pag);
    }
    
    public V_Acquisizione ask (Utente ut, Acquisizione acq) {
        V_Acquisizione view = new V_Acquisizione(ut, this.fs.get(acq));
        return view;
    }
    
    public V_Trascrizione ask(Trascrizione tras) throws ParserConfigurationException, SAXException, IOException {
        HashMap<String, String> dati = this.TEIparser(tras.getTEI());
        return new V_Trascrizione(dati);
    }
    
    public boolean updateStato(Pagina pag, String stato) {
        boolean confirm = false;
        if (this.database.isStato(pag)) {
            this.database.changeStato(pag, stato);
            confirm = true;
        }
        return confirm;
    }
    
    public void assign (Utente u, Pagina p) {
        this.database.assignRel(u, p);
    }
    
    public void disassign (Utente u, Pagina p) {
        this.database.disassignRel(u, p);
    }
    
    public void setClosed (Utente u, Pagina p) {
        
    }
    
    public HashMap<String, String> TEIparser(String xml) throws ParserConfigurationException, SAXException, IOException {
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
        HashMap<String, String> parsed = new HashMap<String, String>();

	DefaultHandler handler = new DefaultHandler() {

            boolean titolo=false, autore_1=false, autore_2=false, autore_rev=false,
                    lingua=false, data_1=false, data_2=false, publisher=false, 
                    email=false, username=false, data_rev=false, revisore=false, 
                    rev_note=false, titolo_pag=false, testo=false;

            public void startElement(String uri, String localName,String qName, 
                    Attributes attributes) throws SAXException {

                    System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("title")) {
                            titolo = true;
                    }

                    if (qName.equalsIgnoreCase("name") && !autore_rev) {
                            autore_1 = true;
                            autore_rev = true;
                    }

                    if (qName.equalsIgnoreCase("publisher")) {
                            publisher = true;
                    }

                    if (qName.equalsIgnoreCase("addrLine")) {
                            email = true;
                    }
                    
                    if (qName.equalsIgnoreCase("idno")) {
                            username = true;
                    }       
                    
                    if (qName.equalsIgnoreCase("idno")) {
                            username = true;
                    }     
                    
                    if (qName.equalsIgnoreCase("date") && !data_rev) {
                            data_1 = true;
                            data_rev = true;
                    }         
                    
                    if (qName.equalsIgnoreCase("language")) {
                            lingua = true;
                    }                
                    
                    if (qName.equalsIgnoreCase("date") && data_rev) {
                            data_2 = true;
                    }        
                                        
                    if (qName.equalsIgnoreCase("respStmt") && autore_rev) {
                            autore_2 = true;
                    }  
                                        
                    if (qName.equalsIgnoreCase("item")) {
                            rev_note = true;
                    } 
                                        
                    if (qName.equalsIgnoreCase("titlePart")) {
                            titolo_pag = true;
                    } 
                    
                    if (qName.equalsIgnoreCase("div")) {
                            testo = true;
                    } 

            }
            
            public void characters(char ch[], int start, int length) throws SAXException {

		if (titolo) {
			parsed.put("titolo opera", new String(ch, start, length));
			titolo = false;
		}

		if (autore_1) {
                    parsed.put("autore", new String(ch, start, length));
                    autore_1 = false;
		}

		if (publisher) {
                    parsed.put("publisher", new String(ch, start, length));
                    publisher = false;
		}

		if (email) {
                    parsed.put("email", new String(ch, start, length));
                    email = false;
		}
                
                if (username) {
                    parsed.put("username", new String(ch, start, length));
                    username = false;                    
                }
                
                if (data_1) {
                    parsed.put("data pubblicazione", new String(ch, start, length));
                    data_1 = false;                    
                }    
                
                if (lingua) {
                    parsed.put("lingua", new String(ch, start, length));
                    lingua = false;                    
                }      
                
                if (data_2) {
                    parsed.put("data revisione", new String(ch, start, length));
                    data_2 = false;                    
                } 
                
                if (autore_2) {
                    parsed.put("revisore", new String(ch, start, length));
                    autore_2 = false;                    
                } 
                                
                if (rev_note) {
                    parsed.put("note revisore", new String(ch, start, length));
                    rev_note = false;                    
                } 
                                
                if (titolo_pag) {
                    parsed.put("titolo pagina", new String(ch, start, length));
                    titolo_pag = false;                    
                } 
                                
                if (testo) {
                    parsed.put("testo", new String(ch, start, length));
                    testo = false;                    
                } 

            }
        };
        saxParser.parse(new InputSource(new StringReader(xml)), handler);
        
        return parsed;
    }
}
