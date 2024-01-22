package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessio Betti
 * @version 17/01/24
 */

public class Scrittore implements Runnable{

    String nomeFile;
    String username;
    String pwd;
    String testoCopia;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    
    public Scrittore(String nomeFile, String username, String pwd, String testoCopia){
        this.nomeFile = nomeFile;
        this.username = username;
        this.pwd = pwd;
        this.testoCopia = testoCopia;
    }
    
    @Override
    public void run() {
        scriviUserPwd(username, pwd);
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile));
            //2) scrivo nel buffer
            br.write("File in output");
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
    
    public void scriviUserPwd(String username, String pwd){
        BufferedWriter br=null;
        BufferedWriter brCopia=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile));
            brCopia = new BufferedWriter(
                    new FileWriter("copia.csv"));
            //2) scrivo nel buffer
            br.write(username + ";" + pwd);
            br.write("\n\r");
            brCopia.write(username + ";" + pwd);
            brCopia.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();  
            brCopia.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null || brCopia != null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
                    brCopia.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}




