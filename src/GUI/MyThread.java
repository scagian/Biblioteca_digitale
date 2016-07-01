/*

Classe utilizzata per la gestione delle progression bars, che devono svilupparsi 
contemporaneamente all'esecuzione delle operazioni principali fornite dal sistema.

*/

package GUI;

import javax.swing.JProgressBar;

/**
 *
 * @author Gianluca Scatena
 */
public class MyThread extends Thread {
    private JProgressBar progress;
    
    public MyThread (JProgressBar jpb) {
        this.progress = jpb;
    }
    
    public void run(){
        for (int i=0; i<=100; i++) {
            this.progress.setValue(i);
        }
    }
}
