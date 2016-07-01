
package View;

import Model.EntityObject.*;
import Model.DAO.*;
import java.util.ArrayList;

/**
 *
 * @author Gianluca Scatena
 */
public class V_Opere {
    private Utente utente;
    private ArrayList<Opera> lista;
    private DBMS database;
    
    public V_Opere(Utente u, DBMS db, String stato) {
        this.utente = u;
        this.database = db;
        this.lista = this.database.getOpere(stato);
    }
    
    public V_Opere(Utente u, DBMS db) {
        this.utente = u;
        this.database = db;
        this.lista = this.database.getOpere();
    }
    
    public V_Opere (Utente u) {
        this.utente = u;
        this.lista = null;
    }
    
    public ArrayList<Opera> getLista() {
        return this.lista;
    }
    
    public Utente getUtente() {
        return this.utente;
    }
    
    public DBMS getDB() {
        return this.database;
    }
   
}
