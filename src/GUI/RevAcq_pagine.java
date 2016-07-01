
package GUI;

import Controller.FCPagina;
import Controller.FCUtente;
import Model.EntityObject.Pagina;
import View.V_Pagine;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gianluca Scatena
 */
public class RevAcq_pagine extends javax.swing.JFrame {
    private V_Pagine view;
    private FCPagina controllerP;
    private Pannello_revisoreAcq prev;
    private Mostra_Acquisizione showAcq;
    private ArrayList<Pagina> pag;

    /*
    
    In fase di inizializzazione viene fornita la lista di tutte le pagine presenti
    nel sistema riferite ad un'opera. Successivamente, viene utilizzata la funzione
    filterStato per generare una lista che contiene soltanto le pagine 
    in attesa di revisione.
    
    */
    
    public RevAcq_pagine(V_Pagine v, FCPagina cp, Pannello_revisoreAcq pr) {
        this.view = v;
        this.controllerP = cp;
        this.prev = pr;
        this.showAcq = null;
        this.pag = this.view.filterStato("attesa revisione acq");
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
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista pagine");
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Seleziona pagina da revisionare");

        jButton1.setText("Apri");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Indietro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        prev.setVisible(true);
        this._dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /*
    
    Bottone "Apri": apre il frame che contiene l'acquisizione relativa alla
    pagina selezionata. Prima di aprire la pagina, inoltre, viene aggiornato il suo stato
    per evitare che altri utenti procedano alla revisione.
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jList1.isSelectionEmpty()) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            int index_pag = jList1.getSelectedIndex();
            Pagina p = this.pag.get(index_pag);
            this.controllerP.ask(p);
            if (p.getAcquisizione().getTrascrizione() == null && 
                this.controllerP.updateStato(p, "in revisione acq")) {
                try {
                    this.showAcq = new Mostra_Acquisizione(p, this.controllerP, this.view.getUtente(), this);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    this.showAcq.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Lista_Pagine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void myInitComponents() {

        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return pag.size(); }
            public Object getElementAt(int i) { return pag.get(i).getNumero(); }
        });
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                if (showAcq != null) {
                    showAcq.dispose();
                }
                e.getWindow().dispose();
            }
        });
        
        setLocationRelativeTo(null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
