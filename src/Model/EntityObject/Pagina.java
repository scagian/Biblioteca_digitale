package Model.EntityObject;

/**
 *
 * @author Gianluca Scatena
 */
public class Pagina {
    private int numero;
    private int ID_Opera;
    private int ID_Pagina;
    private String stato;
    private boolean pubb;
    private int closed;
    private Acquisizione acquisizione;
    private String note;
    
    public Pagina (int n, int Oid) {
        this.numero = n;
        this.ID_Opera = Oid;
        this.pubb = false;
        this.stato = "attesa acquisizione";
    }
    
    public Pagina (int n, int Pid, int Oid, int cl, String st) {
        this.numero = n;
        this.ID_Pagina = Pid;
        this.ID_Opera = Oid;
        this.closed = cl;
        this.stato = st;
    }
    
    public Pagina (int n, int Pid, int Oid, boolean pub, String st) {
        this.numero = n;
        this.ID_Pagina = Pid;
        this.ID_Opera = Oid;
        this.pubb = pub;
        this.stato = st;
        this.note = "";
        this.acquisizione = null;        
    }
    
    public Pagina(int n, int Pid, int Oid, boolean pub, String st, String not, Acquisizione acq) {
        this.numero = n;
        this.ID_Pagina = Pid;
        this.ID_Opera = Oid;
        this.pubb = pub;
        this.stato = st;
        this.note = not;
        this.acquisizione = acq;
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
    
    public boolean isPubb() {
        return this.pubb;
    }
    
    public String getStato() {
        return this.stato;
    }
    
    public Acquisizione getAcquisizione() {
        return this.acquisizione;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public String getClosed() {
        if (this.closed==1) {
            return "OK";
        } else if (this.closed==0) {
            return " ";
        } else {
            return "RIGETTATA";
        }
    }
    
    public void setAcquisizione(Acquisizione a) {
        this.acquisizione = a;
    }
    
    public void setNote(String n) {
        this.note = n;
    }
    
    public void setStato(String s) {
        this.stato = s;
    }
    
    public void setID_Pag(int id) {
        this.ID_Pagina = id;
    }
    
    public void setPubb(boolean pubb) {
        this.pubb = pubb;
    }
    
    
}
