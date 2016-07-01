package Model.EntityObject;

import java.io.IOException;
import java.io.FileInputStream;

/**
 *
 * @author Gianluca Scatena
 */
public class Trascrizione {
    private Pagina pagina;
    private Opera opera;
    private Utente utente;
    private String testo;
    private String TEI;
    private String autore_rev;
    private String note;
    private String data_rev;
    private int ID_tras;
    
    public Trascrizione(Pagina p, Opera op, Utente ut, String t, String not) {
        this.pagina = p;
        this.opera = op;
        this.utente = ut;
        this.testo = t;
        this.note = not;
        setTrascrizione();
    }
    
    public Trascrizione(Pagina p, Opera op, Utente ut, String t) {
        this.pagina = p;
        this.opera = op;
        this.utente = ut;
        this.testo = t;
        this.note = null;
        setTrascrizione();
    }
    
    public Trascrizione(String tei, int id) {
        this.TEI = tei;
        this.ID_tras = id;
    }
    
    public String getTEI() {
        return this.TEI;
    }
    
    public int getID() {
        return this.ID_tras;
    }
    
    public Pagina getPagina() {
        return this.pagina;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public String getAutoRev() {
        return this.autore_rev;
    }
    
    public String getDataRev() {
        return this.data_rev;
    }
    
    public String getTesto() {
        return this.testo;
    }
    
    public void setTrascrizione() {
        this.TEI = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<!DOCTYPE TEI.2 PUBLIC \"-//TEI P4//DTD Main Document Type//EN\" \"http://infomotions.com/musings/xml-in-libraries/etexts/etc/dtd/tei2.dtd\" [\n" +
                    "<!ENTITY % TEI.XML     'INCLUDE' >\n" +
                    "<!ENTITY % TEI.prose   'INCLUDE' >\n" +
                    "<!ENTITY % TEI.linking 'INCLUDE' >\n" +
                    "<!ENTITY % TEI.figures 'INCLUDE' >\n" +
                    "<!ATTLIST xptr   url CDATA #IMPLIED >\n" +
                    "<!ATTLIST xref   url CDATA #IMPLIED >\n" +
                    "<!ATTLIST figure url CDATA #IMPLIED >\n" +
                    "]>\n" +
                    "<TEI.2>\n" +
                    "  <teiHeader>\n" +
                    "    <fileDesc>\n" +
                    "      <titleStmt>\n" +
                    "        <title>"+this.opera.getTitolo()+"</title>\n" +
                    "        <author>\n" +
                    "          <name>"+this.opera.getAutore()+"</name>\n" +
                    "        </author>\n" +
                    "      </titleStmt>\n" +
                    "      <publicationStmt>\n" +
                    "        <publisher>"+this.utente.getNome()+" "+this.utente.getCognome()+"</publisher>\n" +
                    "        <address>\n" +
                    "          <addrLine>"+this.utente.getEmail()+"</addrLine>\n" +
                    "        </address>\n" +
                    "        <idno>"+this.utente.getUsername()+"</idno>\n" +
                    "      </publicationStmt>\n" +
                    "    </fileDesc>\n" +
                    "    <profileDesc>\n" +
                    "      <creation>\n" +
                    "        <date>"+this.opera.getData()+"</date>\n" +
                    "      </creation>\n" +
                    "      <langUsage>\n" +
                    "        <language>"+this.opera.getLingua()+"</language>\n" +
                    "      </langUsage>\n" +
                    "    </profileDesc>\n" +
                    "    <revisionDesc>\n" +
                    "      <change>\n" +
                    "        <date></date>\n" +
                    "        <respStmt>\n" +
                    "          <name></name>\n" +
                    "        </respStmt>\n" +
                    "        <item></item>\n" +
                    "      </change>\n" +
                    "    </revisionDesc>\n" +
                    "  </teiHeader>\n" +
                    "  <text>\n" +
                    "    <front>\n" +
                    "      <titlePage>\n" +
                    "        <docTitle>\n" +
                    "          <titlePart>Pagina "+this.pagina.getNumero()+"</titlePart>\n" +
                    "        </docTitle>\n" +
                    "      </titlePage>\n" +
                    "    </front>\n" +
                    "    <body>\n" +
                    "      <div>"+this.testo+"</div>\n" +
                    "    </body>\n" +
                    "  </text>\n" +
                    "</TEI.2>";
    }
    
    public void setTrascrizione(String xml) {
        this.TEI = xml;
    }
   
    
    public void setNote(String n) {
        this.note = n;
    }
    
    public void setDataRev (String dr) {
        this.data_rev = dr;
    }
    
    public void setAutoRev (String ar) {
        this.autore_rev = ar;
    }
    
    public void setTesto(String t) {
        this.testo = t;
    }
}
