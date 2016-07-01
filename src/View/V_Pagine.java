
package View;

import Model.DAO.DBMS;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import Model.EntityObject.Utente;
import java.util.ArrayList;

/**
 *
 * @author Gianluca Scatena
 */
public class V_Pagine {
    private Utente utente;
    private Opera opera;
    private DBMS database;
    
    public V_Pagine(Utente u, Opera o, DBMS db) {
        this.utente = u;
        this.opera = o;
        this.database = db;
        this.database.getPagine(this.opera);
    }
    
    public Opera getOpera() {
        return this.opera;
    }
    
    public Utente getUtente() {
        return this.utente;
    }
    
    public DBMS getDB() {
        return this.database;
    }
    
    public ArrayList<Pagina> filterPubb() {
        ArrayList<Pagina> pag_pubb = new ArrayList<Pagina>();
        for(Pagina pagina : this.opera.getPagine()) {
                if (pagina.isPubb()) {
                    pag_pubb.add(pagina);
                }
            }
        return pag_pubb;
    }
    
    public ArrayList<Pagina> filterStato(String stato) {
        ArrayList<Pagina> pag_acq = new ArrayList<Pagina>();
        for(Pagina pagina : this.opera.getPagine()) {
                if (pagina.getStato().equals(stato)) {
                    pag_acq.add(pagina);
                }
            }
        return pag_acq;
    }
}
