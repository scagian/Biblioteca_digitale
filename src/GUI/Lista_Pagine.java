package GUI;

import View.*;
import Controller.*;
import Model.EntityObject.Pagina;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Gianluca Scatena
 */
public class Lista_Pagine extends javax.swing.JFrame {
    private V_Pagine view;
    private final FCPagina controllerP;
    private ArrayList<Pagina> pag_pubb;
    private Lista_Opere prev;

    
    public Lista_Pagine(V_Pagine v, FCPagina cp, Lista_Opere pr) {
        this.prev = pr;
        this.view = v;
        this.controllerP = cp;
        this.pag_pubb = this.view.filterPubb();
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        jButton1.setText("Visualizza");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista pagine");

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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    
    Bottone "Visualizza": le pagine pubblicate possono contenere una semplice acquisizione
    oppure un'acquisizione corredata da trascrizione. L'handler di questa azione, quindi,
    prende la pagina dalla lista della View e chiede al controller di completarne la definizione, 
    aggiungendo relative acquisizione e trascrizione. Quando il controller 
    ha terminato il suo lavoro, l'handler verifica la presenza o meno della trascrizione 
    e quindi decide quale frame inizializzare.
    
    */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jList1.isSelectionEmpty()) {
            int index_pag = jList1.getSelectedIndex();
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            Pagina pag = this.pag_pubb.get(index_pag);
            this.controllerP.ask(pag);
            if (pag.getAcquisizione().getTrascrizione() == null) {
                Mostra_Acquisizione new_view;
                try {
                    new_view = new Mostra_Acquisizione(pag, this.controllerP, this.view.getUtente(), this);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    new_view.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Lista_Pagine.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Mostra_Trascrizione new_view;
                try {
                    new_view = new Mostra_Trascrizione(pag, this.controllerP, this.view.getUtente());
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    new_view.setVisible(true);
                } catch(IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /*
    
    Bottone "Torna indietro": permette di tornare alla visualizzazione
    delle opere pubblicate.
    
    */
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.prev.setVisible(true);
        this._dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void myInitComponents () {
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return pag_pubb.size(); }
            public Object getElementAt(int i) { return pag_pubb.get(i).getNumero(); }
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
