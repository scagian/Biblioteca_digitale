package GUI;

import View.*;
import java.util.*;
import Model.EntityObject.*;
import Controller.*;

/**
 *
 * @author Gianluca Scatena
 */
public class Lista_Opere extends javax.swing.JFrame {
    private V_Opere view;
    private final FCPagina controllerP;

    public Lista_Opere(V_Opere v, FCPagina cp) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista Opere");
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.setBackground(java.awt.SystemColor.window);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gentium Book Basic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("--");

        jLabel2.setFont(new java.awt.Font("Gentium Book Basic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("--");

        jLabel3.setFont(new java.awt.Font("Gentium Book Basic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("--");

        jLabel4.setText("Autore");

        jLabel5.setText("Lingua");

        jLabel6.setText("Data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton1.setText("Visualizza pagine");

        jLabel7.setText("Lista opere pubblicate");

        jMenu1.setText("Vai al tuo pannello");
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

        jMenu3.setText("Torna indietro");
        jMenu3.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu3MenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu2.setText("Aggiorna");
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

        jMenu4.setForeground(new java.awt.Color(153, 153, 153));
        jMenu4.setText("Logout");
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    
    Menu "Vai al tuo pannello": mostrato soltanto se l'utente loggato ha un ruolo
    significativo per la modifica di opere e pagine. 
    Reindirizza l'utente nel pannello di competenza. In base al suo ruolo, di fatto, 
    viene istanziato un frame specifico che permette di eseguire determinate operazioni. 
    Ogni pannello riceve una View contenente una lista di opere filtrate 
    facendo riferimento allo stato delle pagine.
    
    
    */
    
    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        this.dispose();
        if (this.view.getUtente().getRuolo().equals("acquisitore")) {
            Pannello_acquisitore new_view = 
                    new Pannello_acquisitore(this.controllerP.askOpere(this.view.getUtente(), 
                            "attesa acquisizione"), this.controllerP);
            new_view.setVisible(true);
            this.dispose();
        } else if (this.view.getUtente().getRuolo().equals("revisore acq")) {
            Pannello_revisoreAcq new_view= new Pannello_revisoreAcq(this.controllerP.askOpere(this.view.getUtente(), 
                    "attesa revisione acq"), this.controllerP);
            new_view.setVisible(true);
            this.dispose();
        } else if (this.view.getUtente().getRuolo().equals("trascrittore")) {
            Pannello_trascrittore new_view= new Pannello_trascrittore(this.controllerP.askOpere(this.view.getUtente(), 
                    "acquisito"), this.controllerP);
            new_view.setVisible(true);
            this.dispose();
        } else if (this.view.getUtente().getRuolo().equals("revisore tras")) {
            Pannello_revisoreTras new_view = new Pannello_revisoreTras(this.controllerP.askOpere(this.view.getUtente(), 
                    "attesa revisione tras"), this.controllerP);
            new_view.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenu1MenuSelected

    /*
    
    Menu "Aggiorna": viene nuovamente inizializzato il frame corrente, in modo da
    effettuare un aggiornamento della lista delle opere.
    
    */
    
    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        this.view = this.controllerP.askOpere(this.view.getUtente());
        Lista_Opere refresh_op = new Lista_Opere(this.view, this.controllerP);
        refresh_op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MenuSelected

    /*
    
    Menu "Torna indietro": viene mostrato soltanto se l'utente loggato è un admin.
    Permette di tornare al pannello di amministrazione fornito successivamente 
    all'operazione di login.
    
    */
    
    private void jMenu3MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu3MenuSelected
        Pannello_Admin new_view = new Pannello_Admin(this.view.getUtente(), this.controllerP);
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu3MenuSelected

    /*
    
    Menu "Logout": mostrato sempre. Permette di tornare alla schermata iniziale
    di login.
    
    */
    
    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
        home new_view = new home();
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu4MenuSelected

    /*
    
    Quando viene selezionata un'opera dalla lista messa a disposizione a sinistra, 
    nel pannello a destra vengono mostrate le informazioni principali.
    
    */
    
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {  
        int index_op = jList1.getSelectedIndex();
        Opera op = this.view.getLista().get(index_op);
        jLabel1.setText(op.getAutore());
        jLabel2.setText(op.getLingua());
        jLabel3.setText(op.getData());
        if (this.view.getUtente() != null) {
            jButton1.setVisible(true);
        }
    } 
    
    /*
    
    Bottone "Visualizza pagine": mostrato soltanto se un'opera è stata selezionata.
    Apre un nuovo frame al quale viene passata questa volta una View con una lista di pagine
    pubblicate.
    
    */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {       
        int index_op = jList1.getSelectedIndex();
        Opera op = this.view.getLista().get(index_op);
        V_Pagine view = this.controllerP.askPagine(op, this.view.getUtente());
        Lista_Pagine new_view = new Lista_Pagine(view, this.controllerP, this);
        new_view.setVisible(true);
        this.setVisible(false);
    }
    
    
    private void myInitComponents() {
        jMenu3.setVisible(false);
        
        if (this.view.getUtente() != null) {
            if (!this.view.getUtente().getRuolo().equals("utente")) {
                jMenu4.setVisible(false);
            }

            if (this.view.getUtente().getRuolo().equals("amministratore")) {
                jMenu3.setVisible(true);
            }
        }
        
        if(this.view.getUtente() == null || this.view.getUtente().getRuolo().equals("utente") || 
                this.view.getUtente().getRuolo().equals("amministratore")) {
            jMenu1.setVisible(false);
        }
        
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

        jButton1.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });        

        setLocationRelativeTo(null);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
