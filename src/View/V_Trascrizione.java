
package View;

import Model.EntityObject.Trascrizione;
import java.util.HashMap;

/**
 *
 * @author Gianluca Scatena
 */
public class V_Trascrizione {
    private String titolo_opera;
    private String autore;
    private String lingua;
    private String testo;
    private String data_pubb;
    private String trascrittore;
    private String id_trascrittore;
    private String email_trascrittore;
    private String revisore;
    private String data_rev;
    private String note_rev;
    private String titolo_pag;
    
    public V_Trascrizione(HashMap<String, String> dati) {
        this.titolo_opera = dati.get("titolo opera");
        this.autore = dati.get("autore");
        this.lingua = dati.get("lingua");
        this.testo = dati.get("testo");
        this.data_pubb = dati.get("data pubblicazione");
        this.trascrittore = dati.get("publisher");
        this.id_trascrittore = dati.get("username");
        this.email_trascrittore = dati.get("email");
        this.revisore = dati.get("revisore");
        this.data_rev = dati.get("data revisione");
        this.note_rev = dati.get("note revisore");
        this.titolo_pag = dati.get("titolo pagina");
    }
    
    public String getTitolo() {
        return this.titolo_opera;
    }
    
    public String getLingua() {
        return this.lingua;
    }
    
    public String getTrascrittore() {
        return this.trascrittore;
    }
    
    public String getIDTrascrittore() {
        return this.id_trascrittore;
    }
    
    public String getEmailTrascrittore() {
        return this.email_trascrittore;
    }
    
    public String getTesto() {
        return this.testo;
    }
    
    public String getAutore() {
        return this.autore;
    }
    
    public String getDataPubb() {
        return this.data_pubb;
    }
    
    public String getRevisore() {
        return this.revisore;
    }
    
    public String getTitoloPag() {
        return this.titolo_pag;
    }
    
    public String getDataRev() {
        return this.data_rev;
    }
    
    public String getNoteRev() {
        return this.note_rev;
    }
}
