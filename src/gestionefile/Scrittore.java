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
    
    /**
     * 
     * @param nomeFile
     * 
     */
    
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
  
        try ( BufferedWriter br = new BufferedWriter(
                    new FileWriter(nomeFile));){
            //1) apro il file
            
            //2) scrivo nel buffer
            br.write("File in output");
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scriviUserPwd(String username, String pwd){
        
        try (BufferedWriter br = new BufferedWriter(new FileWriter("output.csv"));BufferedWriter brCopia = new BufferedWriter(new FileWriter("copia.csv"))){
            //1) apro il file
    
            //2) scrivo nel buffer
            br.write(username + ";" + pwd);
            br.write("\n\r");
            brCopia.write(username + ";" + pwd);
            brCopia.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();  
            br.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




