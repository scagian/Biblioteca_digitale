
package Controller;

import Controller.CoreOperation.Gestione_utenza;
import java.util.HashMap;
import Model.EntityObject.*;
import Model.DAO.*;
import View.*;

/**
 *
 * @author Gianluca Scatena
 */
public class FCUtente implements FrontController {
    
    private final DBMS database;
    
    public FCUtente () {
        database = new DBMS();
    };
    
    public Object doOperation(HashMap<String, Object[]> param) {
        V_Opere view = null;
        for(HashMap.Entry<String, Object[]> entry: param.entrySet()) {
            Object [] parametri = entry.getValue();
            if (entry.getKey().equals("login")) {
                Utente utente = Gestione_utenza.login((String)parametri[0], (String)parametri[1], this.database);
                if (utente.getRuolo() != null){
                    if (!utente.getRuolo().equals("amministratore")) {
                        view = new V_Opere(utente, this.database);
                    } else {
                        view = new V_Opere(utente);
                    }
                }
            } else if(entry.getKey().equals("registrazione")) {
                if (Gestione_utenza.registrazione((HashMap<String, String>)parametri[0], this.database)) {
                    return "true";
                } else {
                    return "false";
                }
            }
        }
        return view;
    }
    
    public V_Opere sessOspite() {
        V_Opere view = new V_Opere(null, this.database);
        return view;
    }
}
