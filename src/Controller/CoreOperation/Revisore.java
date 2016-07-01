
package Controller.CoreOperation;

import Model.DAO.DBMS;
import Model.DAO.FileSystem;
import Model.EntityObject.Pagina;

/**
 *
 * @author Gianluca Scatena
 */
public class Revisore {
    
    public static boolean conferma (Pagina pag, DBMS db) {
        boolean confirm = false;
        if (db.isStato(pag)) {
            db.changeStato(pag, "acquisito");
            confirm = true;
        }
        return confirm;
    }
    
    public static boolean rigetta (Pagina pag, DBMS db, FileSystem fs) {
        boolean confirm = false;
        if (db.isStato(pag)) {
            db.changeStato(pag, "attesa acquisizione");
            db.remove(pag.getAcquisizione());
            fs.remove(pag.getAcquisizione());
            confirm = true;
        }
        return confirm;
    }
    
    public static boolean pubblica (Pagina pag, DBMS db) {
        boolean confirm = false;
        if (db.isStato(pag)) {
            conferma(pag, db);
            db.makePubb(pag);
            confirm = true;
        }
        return confirm;        
    }
}
