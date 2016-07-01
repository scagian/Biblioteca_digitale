
package Model.EntityObject;

import java.io.File;

/**
 *
 * @author Gianluca Scatena
 */
public class Acquisizione {
    private String titolo;
    private int numero;
    private int ID_Opera;
    private int ID_Pagina;
    private Trascrizione trascrizione;
    private String note;
    private File immagine;
    
    public Acquisizione (String t, int n, int Oid, int Pid) {
        this.titolo = t;
        this.numero = n;
        this.ID_Opera = Oid;
        this.ID_Pagina = Pid;
    }
    
    public Acquisizione (int n, int Oid, int Pid, File img) {
        this.numero = n;
        this.ID_Opera = Oid;
        this.ID_Pagina = Pid;
        this.trascrizione = null;
        this.immagine = img;
    }
    
    public Acquisizione (int n, int Oid, int Pid, Trascrizione tras, String not, File img) {
        this.numero = n;
        this.ID_Opera = Oid;
        this.ID_Pagina = Pid;
        this.trascrizione = tras;
        this.note = not;
        this.immagine = img;
    }
    
    public String getTitolo() {
        return this.titolo;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public int getID_Opera() {
        return this.ID_Opera;
    }
    
    public int getID_Pagina() {
        return this.ID_Pagina;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public Trascrizione getTrascrizione() {
        return this.trascrizione;
    }
    
    public File getImg() {
        return this.immagine;
    }
    
    public void setImg(File img) {
        this.immagine = img;
    }
    
    public void setTrascrizione(Trascrizione t) {
        this.trascrizione = t;
    }
    
    public void setNote(String n) {
        this.note = n;
    }
}
