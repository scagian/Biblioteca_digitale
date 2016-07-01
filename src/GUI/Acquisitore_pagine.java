
package GUI;

import Controller.FCPagina;
import Controller.FCUtente;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import View.V_Pagine;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianluca Scatena
 */
public class Acquisitore_pagine extends javax.swing.JFrame {
    private V_Pagine view;
    private final FCPagina controllerP;
    private ArrayList<Pagina> pag;
    private Pannello_acquisitore prev;

    /*
    
    In fase di inizializzazione viene fornita la lista di tutte le pagine presenti
    nel sistema riferite ad un'opera. Successivamente, viene utilizzata la funzione
    filterStato per generare una lista che contiene soltanto le pagine 
    in attesa di acquisizione.
    
    */
    public Acquisitore_pagine(V_Pagine v, FCPagina cp, Pannello_acquisitore pr) {
        this.prev = pr;
        this.view = v;
        this.controllerP = cp;
        this.pag = this.view.filterStato("attesa acquisizione");
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
        jButton2 = new javax.swing.JButton();
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
        setTitle("Pagine");
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Pagine in attesa di acquisizione");

        jButton1.setText("Acquisisci");

        jButton2.setText("Aggiungi pagina");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2))
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    
    Bottone "Aggiungi pagina": apre il frame contenente i campi per 
    l'inserimento di una nuova pagina all'interno dell'opera precedentemente
    selezionata.
    
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Aggiungi_Pagina new_pag = new Aggiungi_Pagina(this.view, this.controllerP, this, prev);
        new_pag.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.prev.setVisible(true);
        this._dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {  
        jButton1.setVisible(true);
    } 
    
    /*
    
    Bottone "Acquisisci": apre il frame dell'upload. Prima, inoltre, viene aggiornato il suo stato
    per evitare che altri utenti procedano all'acquisizione.
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {       
        int index_pag = jList1.getSelectedIndex();
        Pagina p = pag.get(index_pag);
        if (this.controllerP.updateStato(p, "in acquisizione")){
            this.controllerP.assign(this.view.getUtente(), p);
            Acquisitore_upload upload = new Acquisitore_upload(p, this.view, this.controllerP, this);
            upload.setVisible(true);
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
                jButton1ActionPerformed(evt);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
