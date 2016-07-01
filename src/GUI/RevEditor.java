
package GUI;

import Controller.FCPagina;
import Model.EntityObject.Acquisizione;
import Model.EntityObject.Opera;
import Model.EntityObject.Pagina;
import Model.EntityObject.Trascrizione;
import Model.EntityObject.Utente;
import View.V_Acquisizione;
import java.awt.Image;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Gianluca Scatena
 */
public class RevEditor extends javax.swing.JFrame {

    private Pagina pagina;
    private Acquisizione acquisizione;
    private Trascrizione trascrizione;
    private RevTras_pagine prev;
    private V_Acquisizione view;
    private ImageIcon bg;
    private Utente utente;
    private final FCPagina controllerP;

    
    public RevEditor(Pagina a, FCPagina cp, Utente ut, RevTras_pagine pr) throws IOException, ParserConfigurationException, SAXException {
        this.utente = ut;
        this.pagina = a;
        this.acquisizione = a.getAcquisizione();
        this.trascrizione = this.acquisizione.getTrascrizione();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

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
        setTitle("Editor");
        setResizable(false);

        jLabel1.setIcon(bg);
        jLabel1.setText("");
        jScrollPane1.setViewportView(jLabel1);

        jScrollPane2.setViewportView(jEditorPane1);

        jButton1.setText("Conferma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Rigetta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jEditorPane2);

        jLabel2.setText("Trascrizione");

        jLabel3.setText("Descrizione delle modifiche apportate");

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
    
    Bottone "Conferma"
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        HashMap<String, Object[]> conf = new HashMap<String, Object[]>();
        Object [] param = {this.pagina, jEditorPane1.getText(), jEditorPane2.getText(), 
            this.view.getUtente().getUsername()};
        conf.put("conferma tras", param);
        MyThread progress = new MyThread(jProgressBar1);
        progress.start();
        if (this.controllerP.doOperation(conf).equals("true")) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(jFrame1, "Trascrizione pubblicata!");
        } else  {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(jFrame1, "Trascrizione confermata in precedenza");            
        }
        this._dispose();
        RevTras_pagine rap = (RevTras_pagine)this.prev;
        rap.dispose();
        Pannello_revisoreTras new_p= new Pannello_revisoreTras(this.controllerP.askOpere(this.view.getUtente(), 
                    "attesa revisione tras"), this.controllerP);
        new_p.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
   
    /*
    
    Bottone "Rigetta"
    
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        HashMap<String, Object[]> rig = new HashMap<String, Object[]>();
        Object [] param = {this.pagina};
        rig.put("rigetta tras", param);
        MyThread progress = new MyThread(jProgressBar1);
        progress.start();
        if (this.controllerP.doOperation(rig).equals("true")) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(jFrame1, "Trascrizione rigettata!");
        } else  {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(jFrame1, "Trascrizione rigettata in precedenza");
        }
        this._dispose();
        RevTras_pagine rap = (RevTras_pagine)this.prev;
        rap.dispose();
        Pannello_revisoreTras new_p= new Pannello_revisoreTras(this.controllerP.askOpere(this.view.getUtente(),
            "attesa revisione tras"), this.controllerP);
        new_p.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void myInitComponents() throws ParserConfigurationException, SAXException, IOException {
        HashMap<String, String> parsed = this.controllerP.TEIparser(this.trascrizione.getTEI());
        String testo = "";
        for(HashMap.Entry<String, String> entry: parsed.entrySet()) {
            if (entry.getKey().equals("testo")) {
                testo = entry.getValue();
            }
        }
        jEditorPane1.setText(testo);
        setLocationRelativeTo(null);
    } 
    
    @Override
    public void dispose() {
        if(this.controllerP.updateStato(this.pagina, "attesa revisione tras")) {
            super.dispose();
        }
    }
    
    public void _dispose() {
        super.dispose();
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
