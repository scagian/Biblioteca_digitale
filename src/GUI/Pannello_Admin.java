package GUI;

import Controller.FCPagina;
import Model.EntityObject.Utente;
import View.V_Opere;

/**
 *
 * @author Gianluca Scatena
 */
public class Pannello_Admin extends javax.swing.JFrame {

    private V_Opere view;
    private final FCPagina controllerP;
    
    public Pannello_Admin(V_Opere view, FCPagina cp) {
        this.view = view;
        this.controllerP = cp;
        initComponents();
        myInitComponents();
    }
    
    public Pannello_Admin(Utente ut, FCPagina cp) {
        this.controllerP = cp;
        this.view = this.controllerP.askOpere(ut);
        initComponents();
        myInitComponents();
    }

    /*
    
    Definisco lo stile del frame.
    
    */    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pannello admin");
        setResizable(false);

        jButton1.setText("Acquisizioni");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Revisione acquisizioni");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Trascrizioni");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Revisione trascrizioni");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Opere pubblicate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(153, 153, 153));
        jMenu1.setText("Logout");
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jButton2)
                .addGap(43, 43, 43)
                .addComponent(jButton3)
                .addGap(45, 45, 45)
                .addComponent(jButton4)
                .addGap(45, 45, 45)
                .addComponent(jButton5)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    /*
    
    Bottone "Acquisizioni": apre il pannello dell'acquisitore.
    
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Pannello_acquisitore new_view = 
                new Pannello_acquisitore(this.controllerP.askOpere(this.view.getUtente(), 
                        "attesa acquisizione"), this.controllerP);
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /*
    
    Bottone "Revisore acquisizioni": apre il pannello del revisore delle acquisizioni.
    
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Pannello_revisoreAcq new_view= new Pannello_revisoreAcq(this.controllerP.askOpere(this.view.getUtente(), 
                "attesa revisione acq"), this.controllerP);
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /*
    
    Bottone "Trascrizioni": apre il pannello del trascrittore.
    
    */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Pannello_trascrittore new_view= new Pannello_trascrittore(this.controllerP.askOpere(this.view.getUtente(), 
                "acquisito"), this.controllerP);
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /*
    
    Bottone "Revisore trascrizioni": apre il pannello del revisore delle trascrizioni.
    
    */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Pannello_revisoreTras new_view = new Pannello_revisoreTras(this.controllerP.askOpere(this.view.getUtente(), 
                "attesa revisione tras"), this.controllerP);
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    /*
    
    Bottone "Opere pubblicate": apre il frame con la lista delle opere pubblicate.
    
    */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Lista_Opere new_view = new Lista_Opere(this.controllerP.askOpere(this.view.getUtente()), this.controllerP);
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /*
    
    Bottone "Logout": torna alla schermata di login.
    
    */
    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        home new_view = new home();
        new_view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MenuSelected

    private void myInitComponents() {
        setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
