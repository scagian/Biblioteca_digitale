package GUI;

import Controller.FCPagina;
import Controller.FCUtente;
import Model.EntityObject.Opera;
import View.V_Opere;
import View.V_Pagine;
import java.util.ArrayList;

/**
 *
 * @author Gianluca Scatena
 */
public class Pannello_revisoreTras extends javax.swing.JFrame {

    private V_Opere view;
    private final FCPagina controllerP;

    
    public Pannello_revisoreTras(V_Opere v, FCPagina cp) {
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pannello");
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Seleziona un'opera con trascrizioni da revisionare");

        jButton1.setText("Procedi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
    
    Bottone "Procedi": apre il frame contenente le pagine dell'opera selezionata
    con trascrizione in attesa di revisione.
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jList1.isSelectionEmpty()) {
            int index_op = jList1.getSelectedIndex();
            Opera op = this.view.getLista().get(index_op);
            V_Pagine view = this.controllerP.askPagine(op, this.view.getUtente());
            RevTras_pagine new_view = new RevTras_pagine(view, this.controllerP, this);
            new_view.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /*
    
    Menu "Logout": torna alla schermata di login.
    
    */
    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        home new_view = new home();
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MenuSelected

    private void myInitComponents() {
        ArrayList<Opera> lista = this.view.getLista();
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return lista.size(); }
            public Object getElementAt(int i) { return lista.get(i).getTitolo(); }
        });
        
        setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
