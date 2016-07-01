
package Controller.CoreOperation;

import Model.DAO.DBMS;
import Model.DAO.FileSystem;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import Model.EntityObject.Trascrizione;
import Model.EntityObject.Utente;
/**
 *
 * @author Gianluca Scatena
 */
public class Trascrittore {
    
    public static boolean trascrivi(String t, Pagina p, Utente u, Opera o, DBMS db) {
        boolean confirm = false;
        Trascrizione tras = new Trascrizione(p, o, u, t);
        if (db.set(tras)) {
            db.changeStato(p, "attesa revisione tras");
            db.setClosedRel(u, p);
            p.getAcquisizione().setTrascrizione(tras);
            p.setStato("attesa revisione tras");
            confirm = true;
        }
        return confirm;
    }
}
