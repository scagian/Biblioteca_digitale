
package GUI;

import Model.EntityObject.Pagina;
import java.io.File;
import Controller.*;
import Model.EntityObject.Utente;
import View.V_Pagine;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Gianluca Scatena
 */
public class Acquisitore_upload extends javax.swing.JFrame {
    private Pagina pagina;
    private Utente utente;
    private V_Pagine view;
    private FCPagina controllerP;
    private Acquisitore_pagine prev;
    private Pannello_acquisitore _prev;

    
    public Acquisitore_upload(Pagina p, Utente ut, FCPagina cp, Pannello_acquisitore pr) {
        this._prev = pr;
        this.prev = null;
        this.controllerP = cp;
        this.utente = ut;
        this.pagina = p;
        UIManager.put("FileChooser.cancelButtonText", "Più tardi");
        initComponents();
        myInitComponents();
    }
        
    public Acquisitore_upload(Pagina p, V_Pagine vp, FCPagina cp, Acquisitore_pagine pr) {
        this.prev = pr;
        this._prev = null;
        this.controllerP = cp;
        this.utente = vp.getUtente();
        this.view = vp;
        this.pagina = p;
        UIManager.put("FileChooser.cancelButtonText", "Più tardi");
        initComponents();
        myInitComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        setTitle("Upload");
        setResizable(false);

        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jFileChooser1.setControlButtonsAreShown(false);
        jFileChooser1.setFileFilter(new MyCustomFilter());
        jFileChooser1.setFocusable(false);

        jButton1.setText("Procedi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Più tardi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    
    Bottone "Procedi": richiede l'upload del file, aprendo successivamente il frame
    da cui è iniziata la fase di acquisizione (lista pagine, se non vuota, o pannello personale).
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jFileChooser1.getSelectedFile() != null) {
            Object[] param = {jFileChooser1.getSelectedFile(), this.pagina, this.utente};
            HashMap<String, Object[]> acq = new HashMap<String, Object[]>();
            acq.put("acquisisci", param);
            MyThread progress = new MyThread(jProgressBar1);
            progress.start();
            if (this.controllerP.doOperation(acq).equals("true")) {
                JOptionPane.showMessageDialog(jFrame1, "Acquisizione avvenuta correttamente!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(jFrame1, "Errore durante l'acquisizione");                
            }
            Pannello_acquisitore new_p = new Pannello_acquisitore
            (this.controllerP.askOpere(this.utente, "attesa acquisizione"),
            this.controllerP);
            if (prev != null) {
               Acquisitore_pagine new_ap = new Acquisitore_pagine(this.controllerP.askPagine(this.view.getOpera(), this.utente), 
               this.controllerP, new_p);
               if (new_ap.sizeList()>0) {
                    new_ap.setVisible(true);  
               } else {
                    new_p.setVisible(true);
               }
               prev.dispose();
            } else {
               new_p.setTable(1);
               new_p.setVisible(true);
               _prev.dispose();
            }        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /*
    
    Bottone "Più tardi": rimanda l'acquisizione della pagina, che nel frattempo
    viene salvata nella tabella personale, così che l'utente possa tornarci 
    successivamente. In seguito, viene aperto il frame iniziale (lista pagine, se 
    non vuota, o pannello personale).
    
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        Pannello_acquisitore new_p = new Pannello_acquisitore
        (this.controllerP.askOpere(this.utente, "attesa acquisizione"),
        this.controllerP);
        if (prev != null) {
            Acquisitore_pagine new_ap = new Acquisitore_pagine(this.controllerP.askPagine(this.view.getOpera(), this.utente), 
            this.controllerP, new_p);
               if (new_ap.sizeList()>0) {
                    new_ap.setVisible(true);  
               } else {
                    new_p.setVisible(true);
               }
               prev.dispose();
        } else {
           new_p.setTable(1);
           new_p.setVisible(true);
           _prev.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void myInitComponents() {
        setLocationRelativeTo(null);
        
        if (this.utente.getRuolo().equals("amministratore")) {
            jButton2.setVisible(false);
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent e)
                {
                    controllerP.updateStato(pagina, "attesa acquisizione");
                    controllerP.disassign(utente, pagina);
                    e.getWindow().dispose();
                }
            });
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
