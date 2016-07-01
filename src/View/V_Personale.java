
package View;

import Model.DAO.DBMS;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import Model.EntityObject.Utente;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gianluca Scatena
 */
public class V_Personale {
    private Utente utente;
    private DBMS database;
    private HashMap<Opera, ArrayList<Pagina>> lista;
    
    public V_Personale (Utente ut, DBMS db) {
        this.utente = ut;
        this.database = db;
        lista = this.database.getPersonale(ut);
    }
    
    public HashMap<Opera, ArrayList<Pagina>> getLista() {
        return this.lista;
    }
    
    public Utente getUtente() {
        return this.utente;
    }
}
