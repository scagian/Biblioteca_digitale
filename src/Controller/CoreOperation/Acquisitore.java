
package Controller.CoreOperation;

import Model.DAO.DBMS;
import Model.DAO.FileSystem;
import Model.EntityObject.Acquisizione;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import Model.EntityObject.Utente;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Gianluca Scatena
 */
public class Acquisitore {
    
    public static boolean acquisisci(File immagine, Pagina pag, Utente ut, DBMS db, FileSystem fs) throws FileNotFoundException {
        boolean confirm = false;
        Acquisizione acquisizione = new Acquisizione(pag.getNumero(), pag.getID_Opera(), pag.getID_Pagina(), immagine);
        if (db.set(acquisizione) && fs.set(acquisizione)) {
            db.changeStato(pag, "attesa revisione acq");
            db.setClosedRel(ut, pag);
            pag.setAcquisizione(acquisizione);
            pag.setStato("attesa revisione acq");
            confirm = true;
        }
        return confirm;
    }
    
    public static Opera inserisci_opera(String[] att, DBMS db) {
        Opera new_op_temp = new Opera(att[0], att[1], att[2], att[3]);
        Opera new_op = null;
        if(db.set(new_op_temp)) {
            new_op = new_op_temp;
        }
        return new_op;
    }
    
    public static Pagina inserisci_pagina(int n, int id, DBMS db) {
        Pagina new_pag_temp = new Pagina(n, id);
        Pagina new_pag = null;
        if (db.set(new_pag_temp)) {
            new_pag = new_pag_temp;
        }
        return new_pag;
    }
}
