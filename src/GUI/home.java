package GUI;

import Controller.*;
import View.*;
import static java.lang.String.valueOf;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Gianluca Scatena
 */
public class home extends javax.swing.JFrame {
    private final FCPagina controllerP;
    private final FCUtente controllerU;

    /* 
    
    Essendo home la prima finestra dell'intera GUI, inizializzo gli oggetti 
    che si riferiscono alle classi che implementano l'interfaccia 
    FrontController (e dunque fanno da listener del Controller).
    Queste istanze verranno passate tra un frame e l'altro.
    
    */
    public home() {
        controllerP = new FCPagina();
        controllerU = new FCUtente();
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
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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
        setTitle("Login");
        setResizable(false);

        jButton1.setText("Accedi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jButton2.setText("Sessione ospite");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Registrazione");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gentium Basic", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("BIBLIOTECA DIGITALE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myInitComponents() {
        setLocationRelativeTo(null);
    }
    
    /* 
    
    Bottone "Accedi": organizzo l'input dell'utente in modo tale da passarlo
    correttamente al Controller, che in base a questo chiamerà l'azione 
    corrispondente. I due oggetti che fanno da listener prendono una struttura dati
    HashMap, in cui la chiave specifica l'azione, mentre il valore è dato da un array 
    di oggetti in cui sono contenuti tutti i parametri successivamente scandagliati
    dal controller. Quest'ultimo restituirà una nuova View relativa alla lista di
    tutte le opere pubblicate (di cui un nuovo frame farà uso), nel caso in cui 
    l'operazione di login abbia restituito una lista non nulla. Altrimenti, chi ha 
    effettuato l'accesso è un amministratore, il quale verrà reindirizzato al 
    pannello di amministrazione.
    
    */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = jTextField1.getText();
        String password = valueOf(jPasswordField1.getPassword());
        Object[] param = new Object[]{username, password};
        HashMap<String, Object[]> login = new HashMap<String, Object[]>();
        login.put("login", param);
        V_Opere view = (V_Opere)this.controllerU.doOperation(login);
        if (view != null) {
            this.dispose();
            if (view.getLista() != null) {
                Lista_Opere new_view = new Lista_Opere(view, this.controllerP);
                new_view.setVisible(true);
            } else {
                Pannello_Admin new_view = new Pannello_Admin (view, this.controllerP);
                new_view.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(jFrame1, "Credenziali errate!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /* 
    
    Bottone "Sessione ospite": il controller restituisce una view in cui l'utente
    è nullo. Questo servirà al nuovo frame per "capire" che l'autore del
    login non è un utente registrato.
    
    */
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        V_Opere view = (V_Opere)this.controllerU.sessOspite();
        if (view != null) {
            this.dispose();
            Lista_Opere new_view = new Lista_Opere(view, this.controllerP);
            new_view.setVisible(true);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    /* 
    
    Bottone "Registrazione": si apre un nuovo frame contenente i campi
    per effettuare una nuova registrazione.
    
    */
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Registrazione new_view = new Registrazione(this.controllerU);
        new_view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
