package Model.EntityObject;

import java.util.*;

/**
 *
 * @author Gianluca Scatena
 */
public class Opera {
    private int ID_Opera;
    private String titolo;
    private String autore;
    private String lingua; 
    private String data_pubblicazione;
    private ArrayList<Pagina> pagine;
    
    public Opera(int id, String t) {
        this.ID_Opera = id;
        this.titolo = t;
    }
    
    public Opera(String t, String a, String l, String dp) {
        this.titolo = t;
        this.autore = a;
        this.lingua = l;
        this.data_pubblicazione = dp;
    }
    
    public Opera(int id, String t, String a, String l, String dp) {
        this.ID_Opera = id;
        this.titolo = t;
        this.autore = a;
        this.lingua = l;
        this.data_pubblicazione = dp;
    }
    
    public Opera(int id, String t, String a, String l, String dp, ArrayList<Pagina> p) {
        this.ID_Opera = id;
        this.titolo = t;
        this.autore = a;
        this.lingua = l;
        this.data_pubblicazione = dp;
        this.pagine = p;
    }
    
    public int getID_Opera() {
        return this.ID_Opera;
    }
    
    public String getTitolo() {
        return this.titolo;
    }
    
    public String getAutore() {
        return this.autore;
    }
    
    public String getLingua() {
        return this.lingua;
    }
    
    public String getData() {
        return this.data_pubblicazione;
    }
    
    public ArrayList<Pagina> getPagine() {
        return this.pagine;
    }
    
    public void setPagine(ArrayList<Pagina> pagine) {
        this.pagine = pagine;
    }
    
    public void setID_Op (int id) {
        this.ID_Opera = id;
    }
    
}
