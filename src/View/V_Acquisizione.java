
package View;

import Model.EntityObject.Utente;
import java.io.InputStream;

/**
 *
 * @author Gianluca Scatena
 */
public class V_Acquisizione {
    
    private Utente utente;
    private InputStream img;
    
    public V_Acquisizione (Utente u, InputStream is) {
        this.utente = u;
        this.img = is;
    }
    
    public InputStream getInput() {
        return this.img;
    }
    
    public Utente getUtente() {
        return this.utente;
    }
    
}
