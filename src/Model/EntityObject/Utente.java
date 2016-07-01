package Model.EntityObject;

/**
 *
 * @author Gianluca Scatena
 */
public class Utente {
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String email;
    private String ruolo;
    
    public Utente (String u, String ps) {
        this.username = u;
        this.password = ps;
    }
    
    public Utente(String n, String c, String u, String ps, String em, String r) {
        this.nome = n;
        this.cognome = c;
        this.username = u;
        this.password = ps;
        this.email = em;
        this.ruolo = r;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getCognome() {
        return this.cognome;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPass() {
        return this.password;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getRuolo() {
        return this.ruolo;
    }
    
    public void setNome(String n) {
        this.nome = n;
    }
    
    public void setCognome(String c) {
        this.cognome = c;
    }
    
    public void setEmail(String e) {
        this.email = e;
    }
    
    public void setRuolo(String r) {
        this.ruolo = r;
    }
    
    
    
    
}
