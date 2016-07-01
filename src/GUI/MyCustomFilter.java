/*

Classe utilizzata in fase di upload delle acquisizioni per definire il formato
dei files che possono essere caricati nel sistema (nel mio caso .jpg).

*/

package GUI;

import java.io.File;

/**
 *
 * @author Gianluca Scatena
 */
    class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".jpg");
        }
        @Override
        public String getDescription() {
            return "JPG Images (*.jpg)";
        }
    } 
