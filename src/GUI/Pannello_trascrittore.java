/*

Il pannello del trascrittore si suddivide sostanzialmente in due parti principali, 
definite dalla presenza di un JTabbedPane, in cui la prima "scheda" si 
riferisce alla lista di tutte le opere contenenti pagine in attesa di trascrizione 
che non sono state prese in consegna da altri utenti; la seconda, invece, è 
strettamente personale e implementa una traccia di tutte le pagine già trattate 
dall'utente loggato. In questa lista sono presenti le pagine su cui il proprio lavoro
è già stato effettuato e quelle che invece sono poste in attesa (e che ragionevolmente
non possono essere trascritte da altri utenti nello stesso momento). 
Infine, grazie alla stessa tabella, è possibile verificare se alcune delle pagine già
trascritte dall'utente sono state rigettate da un revisore. Le pagine etichettate 
con un "RIGETTATA" possono essere eliminate dalla propria lista se si vuole lasciare
il compito ad altri trascrittori.

*/
package GUI;

import Controller.FCPagina;
import Controller.FCUtente;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import View.V_Opere;
import View.V_Pagine;
import View.V_Personale;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author gianluca
 */
public class Pannello_trascrittore extends javax.swing.JFrame {
    private V_Opere view;
    private V_Personale viewp;
    private final FCPagina controllerP;
    
    public Pannello_trascrittore(V_Opere v, FCPagina cp) {
        this.view = v;
        this.controllerP = cp;
        initComponents();
        myInitComponents();
    }

    /*
    
    Definisco lo stile del frame.
    
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pannello");
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Aggiorna lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Visualizza pagine");

        jLabel1.setText("Lista opere");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(122, 122, 122)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Pannello trascrizione", jPanel2);

        jButton4.setText("Aggiorna");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jButton5.setText("Trascrivi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cestina");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mio storico", jPanel1);

        jMenu1.setText("Torna indietro");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(153, 153, 153));
        jMenu2.setText("Logout");
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    /*
    
    Bottone "Aggiorna lista": inizializza nuovamente il frame corrente per aggiornare 
    la lista delle opere che contengono pagine in attesa di trascrizione.
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Pannello_trascrittore refresh =
        new Pannello_trascrittore(this.controllerP.askOpere(this.view.getUtente(), "acquisito"),
            this.controllerP);
        refresh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /*
    
    Bottone "Aggiorna" in "Mio storico": aggiorna la tabella personale.
    
    */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row=-1;
        if ((row = jTable1.getSelectedRow()) > -1) {
            if (((String)jTable1.getValueAt(row, 2)).equals("RIGETTATA")) {
                jButton6.setVisible(true);
            } else {
                jButton6.setVisible(false);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
    /*
    
    Bottone "Trascrivi" in "Mio storico": permette di aprire l'editor TEI di
    una trascrizione per una pagina presa precedentemente in consegna, ma posta in attesa.
    Una volta che la pagina è stata selezionata, il suo stato viene aggiornato dal
    Controller per evitare che altri utenti possano eseguire ulteriori trascrizioni,
    ovviamente con un occhio di riguardo verso la consistenza dei dati.
    
    */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row=-1;
        if ((row = jTable1.getSelectedRow()) > -1) {
            if (!(((String)jTable1.getValueAt(row, 2)).equals("OK"))) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                String titolo = (String)jTable1.getValueAt(row, 0);
                Pagina p;
                int num_pag = Integer.parseInt((String)jTable1.getValueAt(row, 1));
                for(HashMap.Entry<Opera, ArrayList<Pagina>> entry: this.viewp.getLista().entrySet()) {
                    if(entry.getKey().getTitolo().equals(titolo)) {
                        for (int i=0; i<entry.getValue().size(); i++) {
                            if (entry.getValue().get(i).getNumero() == num_pag) {
                                p = entry.getValue().get(i);
                                this.controllerP.ask(p);
                                if (this.controllerP.updateStato(p, "in trascrizione")){
                                    this.controllerP.assign(this.view.getUtente(), p);
                                    Editor editor;
                                    try {
                                        editor = new Editor(p, this.controllerP, this.view.getUtente(), this, entry.getKey());
                                        editor.setVisible(true);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Pannello_trascrittore.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    this.dispose();
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(jFrame1, "La pagina è già in trascrizione!");
                                    this.controllerP.disassign(this.view.getUtente(), p);
                                    setTable();                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    /*
    
    Bottone "Cestina" in "Mio storico": mostrato soltanto se una pagina rigettata è 
    stata selezionata dalla traccia personale.
    Elimina dalla propria tabella una pagina già rigettata che non si vuole più 
    prendere in consegna.
    
    */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int row = jTable1.getSelectedRow();
        String titolo = (String)jTable1.getValueAt(row, 0);
        Pagina p;
        int num_pag = Integer.parseInt((String)jTable1.getValueAt(row, 1));
        for(HashMap.Entry<Opera, ArrayList<Pagina>> entry: this.viewp.getLista().entrySet()) {
            if(entry.getKey().getTitolo().equals(titolo)) {
                for (int i=0; i<entry.getValue().size(); i++) {
                    if (entry.getValue().get(i).getNumero() == num_pag) {
                        p = entry.getValue().get(i);
                        this.controllerP.disassign(this.viewp.getUtente(), p);
                        setTable();
                        jButton6.setVisible(false);
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    
    /*
    
    Menu "Torna indietro": permette di tornare alla vista precedente, che può essere
    relativa alla lista delle opere pubblicate o al pannello di amministrazione.
    Questo è determinato dal ruolo dell'utente.
    
    */
    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        if (this.view.getUtente().getRuolo().equals("amministratore")) {
            Pannello_Admin view_admin = new Pannello_Admin(this.view, this.controllerP);
            view_admin.setVisible(true);           
        } else {        
        Lista_Opere prev = new Lista_Opere(this.controllerP.askOpere(this.view.getUtente()),
            this.controllerP);
        prev.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jMenu1MenuSelected
   
    /*
    
    Menu "Logout": torna alla schermata di login.
    
    */
    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        home new_view = new home();
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MenuSelected

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {  
        jButton3.setVisible(true);
    } 
        
    /*
    
    Bottone "Visualizza pagine": mostrato soltanto quando un'opera è selezionata.
    Permette di visualizzare la lista delle pagine che sono in attesa di trascrizione.
    
    */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {       
        int index_op = jList1.getSelectedIndex();
        Opera op = this.view.getLista().get(index_op);
        V_Pagine view = this.controllerP.askPagine(op, this.view.getUtente());
        Trascrittore_pagine new_view = new Trascrittore_pagine(view, this.controllerP, op, this);
        new_view.setVisible(true);
        this.setVisible(false);
    }
    
    private void myInitComponents() {
        if (this.view.getUtente().getRuolo().equals("amministratore")) {
            jTabbedPane1.remove(1);
        }
        jButton6.setVisible(false);
        
        ArrayList<Opera> lista = this.view.getLista();
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return lista.size(); }
            public Object getElementAt(int i) { return lista.get(i).getTitolo(); }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            } 
        });
        
        jButton3.setVisible(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        setTable();
        
        setLocationRelativeTo(null);
    }
    
    public void setTable() {
        this.viewp = this.controllerP.askVPersonale(this.view.getUtente());
        int size = 0;
        for(HashMap.Entry<Opera, ArrayList<Pagina>> entry: this.viewp.getLista().entrySet()) {
            size += entry.getValue().size();
        }
        Object rowData[][] = new Object[size][];
        int i = 0;
        size = 0;
        for(HashMap.Entry<Opera, ArrayList<Pagina>> entry: this.viewp.getLista().entrySet()) {
                for (int j=0; j<entry.getValue().size(); j++) {
                    String [] riga = {entry.getKey().getTitolo(), ""+entry.getValue().get(j).getNumero()+"", entry.getValue().get(j).getClosed()};
                    rowData[i] = riga;
                    i++;
                }
        }
        Object columnNames[] = {"Opera", "Pagina", "Stato"};
        TableModel model = new DefaultTableModel(rowData, columnNames);
        jTable1.setModel(model);
    }
    
    public void setTable(int index) {
        jTabbedPane1.setSelectedIndex(index);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
