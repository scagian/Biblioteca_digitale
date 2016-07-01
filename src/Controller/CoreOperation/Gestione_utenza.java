
package Controller.CoreOperation;

import Model.EntityObject.*;
import Model.DAO.*;
import java.util.HashMap;

/**
 *
 * @author Gianluca Scatena
 */
public class Gestione_utenza {
    
    public static Utente login(String username, String password, DBMS db) {
        Utente utente = new Utente(username, password);
        db.get(utente);
        return utente;
    }
    
    public static boolean registrazione(HashMap<String, String> param, DBMS db) {
        return db.registrazione(param.get("nome"), param.get("cognome"), param.get("username"),
                param.get("email"), param.get("password"), param.get("ruolo"));
    }
}
