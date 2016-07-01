/*

Lista delle funzionalità che accedono alle risorse del server via FTP.

!!!******* Si assume l'esistenza di un server con indirizzo ip e utente specificati ********!!!
!!!******* in fase di costruzione dell'oggetto.                                     ********!!!

*/
package Model.DAO;

import Model.EntityObject.Acquisizione;
import com.mysql.jdbc.log.Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Object;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.commons.net.SocketClient;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Gianluca Scatena
 */
public class FileSystem {
    
    FTPClient client;
    FileInputStream fis;
    
    public FileSystem () {
        this.client = new FTPClient();
        this.fis = null;
    
    }
    
    public boolean set(Acquisizione acq) throws FileNotFoundException {
        boolean status = false;
        try {
            try {
                String ip = "localhost";
                String userName = "ray-ftp";
                String pass = "ciao";

                this.client.connect(InetAddress.getByName(ip));
                this.client.login(userName, pass);
                this.client.setFileType(FTP.BINARY_FILE_TYPE);                
                int reply = this.client.getReplyCode();
                if (FTPReply.isPositiveCompletion(reply)) {

                    FileInputStream stream = new FileInputStream(acq.getImg());
                    if (this.client.storeFile(acq.getImg().getName(), stream)) {
                        status = true;
                    }
                    stream.close(); 
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        }
        return status;
    }
    
    public InputStream get(Acquisizione acq) {
        InputStream stream = null;
        try {
            try {
                String ip = "localhost";
                String userName = "ray-ftp";
                String pass = "ciao";

                this.client.connect(InetAddress.getByName(ip));
                this.client.login(userName, pass);
                this.client.setFileType(FTP.BINARY_FILE_TYPE);            
                int reply = this.client.getReplyCode();
                if (FTPReply.isPositiveCompletion(reply)) {
                    stream = this.client.retrieveFileStream(acq.getTitolo());
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        } 
        return stream;
    }
    
    public void remove(Acquisizione acq) {
        try {
            try {
                String ip = "localhost";
                String userName = "ray-ftp";
                String pass = "ciao";

                this.client.connect(InetAddress.getByName(ip));
                this.client.login(userName, pass);
                this.client.setFileType(FTP.BINARY_FILE_TYPE);                
                int reply = this.client.getReplyCode();
                if (FTPReply.isPositiveCompletion(reply)) {
                    this.client.deleteFile(acq.getTitolo());
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        } 
    }
 }
   
