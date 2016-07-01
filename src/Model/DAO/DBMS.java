/*

Lista di tutte le funzioni che implementano le query verso il database.

!!!******* Si assume l'esistenza di un database server con indirizzo ip e utente specificati ********!!!
!!!******* in fase di costruzione dell'oggetto.                                              ********!!!

*/
package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.EntityObject.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gianluca Scatena
 */
public class DBMS {
    
    private Connection connection;
    private Statement cmd;
    
    public DBMS() {
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
	}

        this.connection = null;

	try {
		this.connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/biblioteca_digitale","root", "****");
                this.cmd = connection.createStatement();
        } catch (SQLException e) {
		e.printStackTrace();
		return;
	}
    }
    
    public boolean isStato(Pagina p) {
        int ID = p.getID_Pagina();
        String stato = p.getStato();
        boolean confirm = false;
        try {
        String qry = "SELECT * FROM Stato_pag "
                + "WHERE Stato_pag.pagina =\""+ID+"\"";
        ResultSet res = this.cmd.executeQuery(qry);
        while (res.next()) {
            if (res.getString("stato").equals(stato)) {
                confirm = true;
            }
          }
        res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return confirm;
    }
    
    public void changeStato(Pagina p, String stato) {
        int ID = p.getID_Pagina();
        try {
        String qry = "UPDATE Stato_pag "
                + "SET Stato_pag.stato =\""+stato+"\""
                + "WHERE Stato_pag.pagina =\""+ID+"\"";
        this.cmd.executeUpdate(qry);
        p.setStato(stato);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void makePubb (Pagina p) {
        int ID = p.getID_Pagina();
        try {
        String qry = "UPDATE Pagina "
                + "SET Pagina.pubblicata =\"1\""
                + "WHERE Pagina.ID =\""+ID+"\"";
        this.cmd.executeUpdate(qry);
        p.setPubb(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }
    
    public void assignRel(Utente u, Pagina p) {
        String username = u.getUsername();
        int ID_Pagina = p.getID_Pagina();
        try {
            String qry_1 = "SELECT * From Utente_su_Pag "
                    + "WHERE Utente_su_Pag.utente=\""+username+"\" AND Utente_su_Pag.pagina=\""+ID_Pagina+"\"";
            ResultSet res = this.cmd.executeQuery(qry_1);
            String qry_2 = "";
            if (!res.next()) {
                qry_2 = "INSERT INTO Utente_su_Pag "
                    + "VALUES(\""+username+"\", \""+ID_Pagina+"\", \"0\")";
            } else {
                qry_2 = "UPDATE Utente_su_Pag "
                    + "SET Utente_su_Pag.closed=\"0\" WHERE "
                    + "Utente_su_Pag.utente=\""+username+"\" AND Utente_su_Pag.pagina=\""+ID_Pagina+"\"";
            }
            res.close();
            this.cmd.executeUpdate(qry_2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void disassignRel(Utente u, Pagina p) {
        String username = u.getUsername();
        int ID_Pagina = p.getID_Pagina();
        try {
            String qry = "DELETE FROM Utente_su_Pag "
                    + "WHERE utente=\""+username+"\" AND pagina=\""+ID_Pagina+"\"";
            this.cmd.executeUpdate(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setClosedRel(Utente u, Pagina p) {
        String username = u.getUsername();
        int ID_Pagina = p.getID_Pagina();
        try {
            String qry = "UPDATE Utente_su_Pag "
                    + "SET Utente_su_Pag.closed=\"1\" WHERE "
                    + "Utente_su_Pag.utente=\""+username+"\" AND Utente_su_Pag.pagina=\""+ID_Pagina+"\"";
            this.cmd.executeUpdate(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Opera> getOpere() {
        ArrayList<Opera> lista = new ArrayList<Opera>();
        String titolo, autore, lingua, data;
        int ID = 0;
        try {
        String qry = "SELECT * FROM Opera, Op_contiene, Pagina "
                + "WHERE Opera.ID = Op_contiene.opera AND Op_contiene.pagina=Pagina.ID "
                + "AND Pagina.pubblicata = 1";
        ResultSet res = this.cmd.executeQuery(qry);
        if (res.next()) {
            do {
                if (ID != res.getInt("ID")) {
                        ID = res.getInt("ID");
                        titolo = res.getString("titolo");
                        autore = res.getString("autore");
                        lingua = res.getString("lingua");
                        data = res.getString("data_pubb");
                        Opera opera = new Opera(ID, titolo, autore, lingua, data);
                        lista.add(opera);
                    } else {
                        continue;
                    }
                } while (res.next());
        }
        res.close();
        } catch (SQLException e) {
            e.printStackTrace();
      }
        return lista;
    }
    
    public ArrayList<Opera> getOpere(String stato) {
        ArrayList<Opera> lista = new ArrayList<Opera>();
        String titolo, autore, lingua, data;
        int ID = 0;
        try {
            String qry = "SELECT * FROM Opera, Op_contiene, Stato_pag "
                    + "WHERE Opera.ID=Op_contiene.opera AND Op_contiene.pagina=Stato_pag.pagina "
                    + "AND Stato_pag.stato=\""+stato+"\" ORDER BY Opera.ID ASC";
            ResultSet res = this.cmd.executeQuery(qry);
            if(res.next()) {
                do {
                    if (ID != res.getInt("ID")) {
                        ID = res.getInt("ID");
                        titolo = res.getString("titolo");
                        autore = res.getString("autore");
                        lingua = res.getString("lingua");
                        data = res.getString("data_pubb");
                        Opera opera = new Opera(ID, titolo, autore, lingua, data);
                        lista.add(opera);
                    } else {
                        continue;
                    }
                } while (res.next());
            }
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void getPagine(Opera op) {
        int id_op = op.getID_Opera();
        
        try {
            String qry = "SELECT Op_contiene.pagina, Pagina.numero, Pagina.pubblicata, Stato_pag.stato "
                    + "FROM Op_contiene, Pagina, Stato_pag "
                    + "WHERE Op_contiene.opera=\""+id_op+"\" "
                    + "AND Op_contiene.pagina=Pagina.ID AND Pagina.ID=Stato_pag.pagina";
            ResultSet res = this.cmd.executeQuery(qry);
            ArrayList<Pagina> lista = new ArrayList<Pagina>();
            while(res.next()) {
                int id_pag = res.getInt("pagina");
                int num_pag = res.getInt("numero");
                boolean pubb = res.getBoolean("pubblicata");
                String stato = res.getString("stato");
                Pagina pag = new Pagina(num_pag, id_pag, id_op, pubb, stato);
                lista.add(pag);
            }
            res.close();
            op.setPagine(lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public HashMap<Opera, ArrayList<Pagina>> getPersonale(Utente ut) {
        HashMap<Opera, ArrayList<Pagina>> lista = new HashMap<Opera, ArrayList<Pagina>>();
        ArrayList<Pagina> pagine = new ArrayList<Pagina>();
        int ID_op=0, ID_pag, numero;
        int closed;
        String titolo, stato, autore, lingua, data;
        try {
            String qry = "SELECT Opera.ID as \"ID_op\", Opera.titolo, Opera.autore, Opera.lingua, Opera.data_pubb, "
                    + "Pagina.ID as \"ID_pag\", Pagina.numero, Stato_pag.stato, Utente_su_Pag.closed "
                    + "FROM Opera, Op_contiene, Pagina, Stato_pag, Utente_su_Pag "
                    + "WHERE Utente_su_Pag.utente=\""+ut.getUsername()+"\" AND Utente_su_Pag.pagina=Pagina.ID "
                    + "AND Utente_su_Pag.pagina=Stato_pag.pagina AND Utente_su_Pag.pagina=Op_contiene.pagina AND Op_contiene.opera=Opera.ID "
                    + "ORDER BY Opera.ID ASC";
            ResultSet res = this.cmd.executeQuery(qry);
            boolean next = true;
            if(next = res.next()) {
                ID_op = res.getInt("ID_op");
                titolo = res.getString("titolo");
                autore = res.getString("autore");
                lingua = res.getString("lingua");
                data = res.getString("data_pubb");                
                do {
                    if (ID_op != res.getInt("ID_op")) {
                        Opera opera = new Opera(ID_op, titolo, autore, lingua, data);
                        lista.put(opera, pagine);
                        pagine = new ArrayList<Pagina>();
                        ID_op = res.getInt("ID_op");
                        titolo = res.getString("titolo");
                        autore = res.getString("autore");
                        lingua = res.getString("lingua");
                        data = res.getString("data_pubb");
                        stato = res.getString("stato");
                        ID_pag = res.getInt("ID_pag");                        
                        numero = res.getInt("numero");
                        closed = res.getInt("closed");                        
                        Pagina pagina = new Pagina(numero, ID_pag, ID_op, closed, stato);
                        pagine.add(pagina);
                        if(!(next = res.next())) {
                            Opera new_opera = new Opera(ID_op, titolo);
                            lista.put(new_opera, pagine);                            
                        }                    
                    } else {
                        stato = res.getString("stato");                        
                        ID_pag = res.getInt("ID_pag");                        
                        numero = res.getInt("numero");
                        closed = res.getInt("closed");
                        Pagina pagina = new Pagina(numero, ID_pag, ID_op, closed, stato);
                        pagine.add(pagina);
                        if(!(next = res.next())) {
                            Opera opera = new Opera(ID_op, titolo, autore, lingua, data);
                            lista.put(opera, pagine);                            
                        }
                    }
                } while (next);
            }
            res.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public void get(Pagina pag) {
        int id_pag = pag.getID_Pagina();
        int id_acq = -1;
        int id_tras = -1;
        String titolo = "";
        String TEI = "";
        try {
            String qry_1 = "SELECT * FROM Pag_contiene, Acquisizione "
                    + "WHERE Pag_contiene.pagina=\""+id_pag+"\" AND "
                    + "Pag_contiene.acquisizione=Acquisizione.ID";
            ResultSet res = this.cmd.executeQuery(qry_1);
            while(res.next()) {
                titolo = res.getString("titolo");
                id_acq = res.getInt("acquisizione");
            }
            res.close();
            Acquisizione acq = new Acquisizione(titolo, pag.getNumero(), pag.getID_Opera(), id_pag);
            pag.setAcquisizione(acq);
            
            String qry_2 = "SELECT * FROM Acq_contiene, Trascrizione "
                    + "WHERE Acq_contiene.acquisizione=\""+id_acq+"\" AND Acq_contiene.trascrizione=Trascrizione.ID";
            ResultSet _res = this.cmd.executeQuery(qry_2);
            while(_res.next()) {
                TEI = _res.getString("TEI");
                id_tras = _res.getInt("trascrizione");
            }
            _res.close();
            if (TEI.equals("") || TEI==null || id_tras==-1) {              
            } else {
                Trascrizione tras = new Trascrizione(TEI, id_tras);
                pag.getAcquisizione().setTrascrizione(tras);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void get(Utente utente) {
        String username = utente.getUsername();
        String password = utente.getPass();

	try {
                String qry = "SELECT * FROM Utente, Utente_possiede_ruolo "
                        + "WHERE Utente.username=\""+username+"\" "
                        + "AND Utente.username = Utente_possiede_ruolo.utente";
                ResultSet res = this.cmd.executeQuery(qry);
                while(res.next() && res.getString("password").equals(password)) {
                    utente.setNome(res.getString("nome"));
                    utente.setCognome(res.getString("cognome"));
                    utente.setEmail(res.getString("email"));
                    utente.setRuolo(res.getString("ruolo"));
                }
                res.close();
                
	} catch (SQLException e) {
		e.printStackTrace();
		return;
	}
    
    }
    
    public boolean set(Acquisizione acq) {
        int confirm = 0;
        int numero = acq.getNumero();
        String titolo = acq.getImg().getName();
        int ID_Pagina = acq.getID_Pagina();
        try {
                String qry_1 = "INSERT INTO Acquisizione "
                        + "VALUES(\""+numero+"\", \""+titolo+"\", null, DEFAULT)";
                PreparedStatement new_cmd = this.connection.prepareStatement(qry_1, Statement.RETURN_GENERATED_KEYS);
                confirm = new_cmd.executeUpdate();
                ResultSet keys = new_cmd.getGeneratedKeys();
                int next_id = 0;
                
                while(keys.next()) {
                    next_id = keys.getInt(1);
                }
                keys.close();
                new_cmd.close();
                
                String qry_2 = "INSERT INTO Pag_contiene "
                        + "VALUES (\""+ID_Pagina+"\", \""+next_id+"\")";
                if (confirm>0) {
                    confirm = this.cmd.executeUpdate(qry_2);
                } else {
                    return false;
                }
                
	} catch (SQLException e) {
		e.printStackTrace();
	}
        if (confirm > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean set(Trascrizione t) {
        int confirm = 0;
        String TEI = t.getTEI();
        try {
            PreparedStatement new_cmd = this.connection.prepareStatement("INSERT INTO Trascrizione "
                    + "VALUES(?, null, DEFAULT)", Statement.RETURN_GENERATED_KEYS);
            new_cmd.setString(1, TEI);
            confirm = new_cmd.executeUpdate();
            ResultSet keys = new_cmd.getGeneratedKeys();
            int next_id = 0;
                
            while(keys.next()) {
                next_id = keys.getInt(1);
            }
            keys.close();
            new_cmd.close();
            
            String qry_2 = "SELECT acquisizione FROM Pag_contiene "
                    + "WHERE Pag_contiene.pagina=\""+t.getPagina().getID_Pagina()+"\"";
            ResultSet res = this.cmd.executeQuery(qry_2);
            res.next();
            int ID_Acq = res.getInt("acquisizione");
            res.close();
                
            String qry_3 = "INSERT INTO Acq_contiene "
                    + "VALUES (\""+ID_Acq+"\", \""+next_id+"\")";
            if (confirm>0) {
                confirm = this.cmd.executeUpdate(qry_3);
            } else {
                return false;
            }        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        if (confirm > 0) {
            return true;
        } else {
            return false;
        }        
    }
    
    public boolean set (Opera op) {
        int confirm = 0;
        String titolo = op.getTitolo();
        String autore = op.getAutore();
        String lingua = op.getLingua();
        String data = op.getData();
        try {
            String qry = "INSERT INTO Opera "
                    + "VALUES(\""+titolo+"\", \""+autore+"\", \""+lingua+"\", \""+data+"\", DEFAULT)";
            PreparedStatement new_cmd = this.connection.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
            confirm = new_cmd.executeUpdate();
            ResultSet keys = new_cmd.getGeneratedKeys();
                
            while(keys.next()) {
                op.setID_Op(keys.getInt(1));
                Pagina p = new Pagina(1, keys.getInt(1));
                ArrayList<Pagina> l = new ArrayList<Pagina>();
                if (set(p)) {
                l.add(p);
                op.setPagine(l);
                } else {
                    confirm = 0;
                }
            }
            keys.close();
            new_cmd.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         if (confirm>0) {
             return true;
         } else {
             return false;
         }
    }
    
    public boolean set (Pagina pag) {
        int confirm = 0;
        int num = pag.getNumero();
        int id_op = pag.getID_Opera();
        String stato = pag.getStato();
        try {
            String qry_1 = "SELECT * FROM Op_contiene, Pagina "
                    + "WHERE Op_contiene.opera=\""+id_op+"\" AND Pagina.numero=\""+num+"\" "
                    + "AND Op_contiene.pagina=Pagina.ID";
            ResultSet res = this.cmd.executeQuery(qry_1);
            if (!res.next()) {
                String qry_2 = "INSERT INTO Pagina "
                        + "VALUES (\""+num+"\", 0, null, DEFAULT)";
                PreparedStatement new_cmd = this.connection.prepareStatement(qry_2, Statement.RETURN_GENERATED_KEYS);
                confirm = new_cmd.executeUpdate();
                ResultSet keys = new_cmd.getGeneratedKeys();
                
                while(keys.next()) {
                    pag.setID_Pag(keys.getInt(1));
                }
                keys.close();
                new_cmd.close();
                
                if (confirm > 0) {
                    String qry_3 = "INSERT INTO Op_contiene "
                            + "VALUES(\""+id_op+"\", \""+pag.getID_Pagina()+"\")";
                    this.cmd.executeUpdate(qry_3);
                    
                    String qry_4 = "INSERT INTO Stato_pag "
                            + "VALUES(\""+pag.getID_Pagina()+"\", \""+stato+"\")";
                    confirm = this.cmd.executeUpdate(qry_4);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (confirm>0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean  update(Trascrizione tras) {
        int id_tras = tras.getID();
        String TEI = tras.getTEI();
        int confirm = 0;
        try{
            PreparedStatement new_cmd = this.connection.prepareStatement("UPDATE Trascrizione SET Trascrizione.TEI= ?"
                    + "WHERE Trascrizione.ID = ?", Statement.RETURN_GENERATED_KEYS);
            new_cmd.setString(1, TEI);
            new_cmd.setInt(2, id_tras);
            confirm = new_cmd.executeUpdate();
            new_cmd.close();        
        } catch (SQLException e){
            e.printStackTrace();
        }
        if (confirm>0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void remove(Acquisizione acq) {
        int ID_pag = acq.getID_Pagina();
        int ID_acq = -1;
        int confirm = 0;
        try {
            String qry_1 = "SELECT * FROM Pag_contiene "
                    + "WHERE Pag_contiene.pagina=\""+ID_pag+"\"";
            ResultSet res = this.cmd.executeQuery(qry_1);
            res.next();
            ID_acq = res.getInt("acquisizione");
            res.close();
            if (ID_acq > -1) {
                String qry_2 = "DELETE FROM Pag_contiene "
                        + "WHERE Pag_contiene.pagina=\""+ID_pag+"\"";
                confirm = this.cmd.executeUpdate(qry_2);
                if (confirm > 0) {
                    String qry_3 = "DELETE FROM Acquisizione "
                            + "WHERE Acquisizione.ID=\""+ID_acq+"\"";
                    this.cmd.executeUpdate(qry_3);
                    String qry_4 = "UPDATE Utente_su_Pag SET closed =\"3\""
                            + "WHERE Utente_su_Pag.pagina=\""+ID_pag+"\"";
                    this.cmd.executeUpdate(qry_4);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remove(Pagina pag) {
        int ID_pag = pag.getID_Pagina();
        int ID_acq = -1;
        int ID_tras = -1;
        int confirm = 0;
        try {
            String qry_1 = "SELECT * FROM Pag_contiene "
                    + "WHERE Pag_contiene.pagina=\""+ID_pag+"\"";
            ResultSet res_1 = this.cmd.executeQuery(qry_1);
            res_1.next();
            ID_acq = res_1.getInt("acquisizione");
            res_1.close();
            if (ID_acq>-1) {
                String qry_2 = "SELECT * FROM Acq_contiene "
                        + "WHERE Acq_contiene.acquisizione=\""+ID_acq+"\"";
                ResultSet res_2 = this.cmd.executeQuery(qry_2);
                res_2.next();
                ID_tras = res_2.getInt("trascrizione");
                if (ID_tras>-1) {
                    String qry_3 = "DELETE FROM Acq_contiene "
                        + "WHERE Acq_contiene.acquisizione=\""+ID_acq+"\"";
                    confirm = this.cmd.executeUpdate(qry_3);
                    if (confirm>0) {
                        String qry_4 = "DELETE FROM Trascrizione "
                            + "WHERE Trascrizione.ID=\""+ID_tras+"\"";
                        confirm = this.cmd.executeUpdate(qry_4);
                        String qry_5 = "UPDATE Utente_su_Pag INNER JOIN Utente_possiede_ruolo "
                                + "ON  Utente_su_Pag.utente=Utente_possiede_ruolo.utente "
                                + "SET closed =\"3\" WHERE Utente_su_Pag.pagina=\""+ID_pag+"\" "
                                + "AND Utente_possiede_ruolo.ruolo=\"trascrittore\"";
                        this.cmd.executeUpdate(qry_5);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean registrazione(String nome, String cognome, String username, 
            String email, String password, String ruolo) {
        int confirm = 0;
        try {
            String qry = "SELECT * FROM Utente WHERE username=\""+username+"\"";
            ResultSet res = this.cmd.executeQuery(qry);
            if (!res.next()) {
                PreparedStatement new_cmd = this.connection.prepareStatement("INSERT INTO Utente VALUES (?, ?, ?, ?, ?)", 
                        Statement.RETURN_GENERATED_KEYS);
                new_cmd.setString(1, nome);
                new_cmd.setString(2, cognome);
                new_cmd.setString(3, username);
                new_cmd.setString(4, password);
                new_cmd.setString(5, email);
                confirm = new_cmd.executeUpdate();                
                new_cmd.close();
                if (confirm>0) {
                    PreparedStatement new_cmd_1 = this.connection.prepareStatement("INSERT INTO Utente_possiede_ruolo VALUES (?, ?)", 
                            Statement.RETURN_GENERATED_KEYS); 
                    new_cmd_1.setString(1,username);
                    new_cmd_1.setString(2,ruolo);
                    confirm = new_cmd_1.executeUpdate();
                    new_cmd_1.close();
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        if (confirm>0) {
            return true;
        } else {
            return false;
        }
    }
    
}
