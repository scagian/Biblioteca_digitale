
package GUI;

import Controller.FCPagina;
import Controller.FCUtente;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import View.V_Pagine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianluca Scatena
 */
public class Trascrittore_pagine extends javax.swing.JFrame {
    private V_Pagine view;
    private Opera opera;
    private final FCPagina controllerP;
    private ArrayList<Pagina> pag;
    private Pannello_trascrittore prev;


    public Trascrittore_pagine(V_Pagine v, FCPagina cp, Opera o, Pannello_trascrittore pr) {
        this.prev = pr;
        this.opera = o;
        this.view = v;
        this.controllerP = cp;
        this.pag = this.view.filterStato("acquisito");
        initComponents();
        myInitComponents();
    }
    
    public Trascrittore_pagine(V_Pagine v, FCPagina cp, Pannello_trascrittore pr) {
        this.prev = pr;
        this.view = v;
        this.controllerP = cp;
        this.pag = this.view.filterStato("acquisito");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
        setTitle("Lista pagine");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Pagine in attesa di trascrizione");

        jButton1.setText("Trascrivi");

        jButton3.setText("Indietro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.prev.setVisible(true);
        this._dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {  
        jButton1.setVisible(true);
    } 
        
    /*
    
    Bottone "Trascrivi": apre l'editor TEI per la trascrizione della pagina. 
    Prima, inoltre, viene aggiornato il suo stato per evitare che altri utenti procedano alla trascrizione.
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException { 
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        int index_pag = jList1.getSelectedIndex();
        Pagina p = pag.get(index_pag);
        this.controllerP.ask(p);
        if (p.getAcquisizione().getTrascrizione() == null && 
                this.controllerP.updateStato(p, "in trascrizione")){
            this.controllerP.assign(this.view.getUtente(), p);
            Editor edit = new Editor(p, this.controllerP, this.view.getUtente(), this, this.opera);
            edit.setVisible(true);
            this._dispose();
            prev.dispose();
        } else {
            JOptionPane.showMessageDialog(jFrame1, "La pagina è già in acquisizione!");            
        }
    }
    
    private void myInitComponents() {
        
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return pag.size(); }
            public Object getElementAt(int i) { return pag.get(i).getNumero(); }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            } 
        });
        
        jButton1.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Trascrittore_pagine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        setLocationRelativeTo(null);
    }
    
    public int sizeList() {
        return this.pag.size();
    }
    
    public void _dispose() {
        super.dispose();
    }
    
    @Override 
    public void dispose() {
        super.dispose();
        this.prev.dispose();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
