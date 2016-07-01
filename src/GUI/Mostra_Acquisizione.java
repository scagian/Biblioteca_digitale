package GUI;

import Controller.FCPagina;
import Model.EntityObject.Acquisizione;
import Model.EntityObject.Pagina;
import Model.EntityObject.Utente;
import View.V_Acquisizione;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Gianluca Scatena
 */
public class Mostra_Acquisizione extends javax.swing.JFrame {
    private Pagina pagina;
    private Acquisizione acquisizione;
    private V_Acquisizione view;
    private ImageIcon bg;
    private Utente utente;
    private Object prev;
    private final FCPagina controllerP;

    /*
    
    In fase di inizializzazione, viene chiesto al Controller di caricare
    la View relativa all'acquisizione ricavata dalla pagina ricevuta. 
    Questa contiene un InputStream con l'immagine presa dal server esterno, 
    mostrata poi come background del pannello che compone il frame.
    
    */
    
    public Mostra_Acquisizione(Pagina a, FCPagina cp, Utente ut, Object pr) throws IOException {
        this.utente = ut;
        this.pagina = a;
        this.acquisizione = a.getAcquisizione();
        this.prev = pr;
        this.controllerP = cp;
        this.view = cp.ask(ut, this.acquisizione);
        Image image = ImageIO.read(this.view.getInput()).getScaledInstance(425, 490,  java.awt.Image.SCALE_SMOOTH);
        this.bg = new ImageIcon(image);
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
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acquisizione");
        setResizable(false);

        jLabel1.setIcon(bg);
        jLabel1.setText("");
        jScrollPane1.setViewportView(jLabel1);

        jProgressBar1.setStringPainted(true);

        jMenu1.setText("Conferma");
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

        jMenu2.setText("Rigetta");
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

        jMenu3.setText("PUBBLICA");
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    
    Menu "Conferma": mostrato soltanto se l'utente loggato è un revisore di 
    acquisizioni. I parametri vengono organizzati in un HashMap che verrà 
    scandagliato dal controller, il quale restituirà una risposta di tipo String
    ("true" o "false", dal momento che non è possibile fare il casting di un Object
    in boolean). La pagina viene confermata, ma non pubblicata.
    
    */
    
    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        HashMap<String, Object[]> conf = new HashMap<String, Object[]>();
        Object [] param = {this.pagina};
        conf.put("conferma acq", param);
        MyThread progress = new MyThread(jProgressBar1);
        progress.start();
        if (this.controllerP.doOperation(conf).equals("true")) {
            JOptionPane.showMessageDialog(jFrame1, "Acquisizione confermata!");
        } else  {
            JOptionPane.showMessageDialog(jFrame1, "Acquisizione confermata in precedenza");            
        }
        this._dispose();
        RevAcq_pagine rap = (RevAcq_pagine)this.prev;
        rap.dispose();
        Pannello_revisoreAcq new_p= new Pannello_revisoreAcq(this.controllerP.askOpere(this.view.getUtente(), 
                    "attesa revisione acq"), this.controllerP);
        new_p.setVisible(true);
    }//GEN-LAST:event_jMenu1MenuSelected

    /*
    
    Menu "Rigetta": mostrato soltanto se l'utente loggato è un revisore di 
    acquisizioni. I parametri vengono organizzati in un HashMap che verrà 
    scandagliato dal controller, il quale restituirà una risposta di tipo String
    ("true" o "false", dal momento che non è possibile fare il casting di un Object
    in boolean). La pagina viene rigettata.
    
    */
    
    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        HashMap<String, Object[]> rig = new HashMap<String, Object[]>();
        Object [] param = {this.pagina};
        rig.put("rigetta acq", param);
        MyThread progress = new MyThread(jProgressBar1);
        progress.start();
        if (this.controllerP.doOperation(rig).equals("true")) {
            JOptionPane.showMessageDialog(jFrame1, "Acquisizione rigettata!");
        } else  {
            JOptionPane.showMessageDialog(jFrame1, "Acquisizione rigettata in precedenza");
        }
        this._dispose();
        RevAcq_pagine rap = (RevAcq_pagine)this.prev;
        rap.dispose();
        Pannello_revisoreAcq new_p= new Pannello_revisoreAcq(this.controllerP.askOpere(this.view.getUtente(),
            "attesa revisione acq"), this.controllerP);
        new_p.setVisible(true);
    }//GEN-LAST:event_jMenu2MenuSelected

    /*
    
    Menu "PUBBLICA": mostrato soltanto se l'utente loggato è un revisore di 
    acquisizioni. I parametri vengono organizzati in un HashMap che verrà 
    scandagliato dal controller, il quale restituirà una risposta di tipo String
    ("true" o "false", dal momento che non è possibile fare il casting di un Object
    in boolean). La pagina viene confermata e pubblicata.
    
    */
    
    private void jMenu3MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu3MenuSelected
        HashMap<String, Object[]> pubb = new HashMap<String, Object[]>();
        Object [] param = {this.pagina};
        pubb.put("pubblica acq", param);
        MyThread progress = new MyThread(jProgressBar1);
        progress.start();
        if (this.controllerP.doOperation(pubb).equals("true")) {
            JOptionPane.showMessageDialog(jFrame1, "Acquisizione pubblicata!");
        } else  {
            JOptionPane.showMessageDialog(jFrame1, "Acquisizione pubblicata in precedenza");
        }
        this._dispose();
        RevAcq_pagine rap = (RevAcq_pagine)this.prev;
        rap.dispose();
        Pannello_revisoreAcq new_p= new Pannello_revisoreAcq(this.controllerP.askOpere(this.view.getUtente(),
            "attesa revisione acq"), this.controllerP);
        new_p.setVisible(true);
    }//GEN-LAST:event_jMenu3MenuSelected


    private void myInitComponents() {
        if (!(this.utente.getRuolo().equals("revisore acq") ||
                this.utente.getRuolo().equals("amministratore")) ||
                this.prev instanceof Lista_Pagine) {
            jMenuBar1.setVisible(false);
            jProgressBar1.setVisible(false);
        }
        setLocationRelativeTo(null);
    } 
    
    @Override
    public void dispose() {
        if (this.view.getUtente().getRuolo().equals("revisore acq") || 
                this.utente.getRuolo().equals("amministratore")) {
            this.controllerP.updateStato(this.pagina, "attesa revisione acq");
        }
        super.dispose();
    }
    
    public void _dispose() {
        super.dispose();
    }
                                            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
