package gestionefile;
import java.io.*;

/**
 *
 * @author Alessio Betti
 * @version 26/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(input);
        
        //1)LETTURA
        Lettore lettore = new Lettore("output.csv");
        lettore.start();
        //2)ELABORAZIONE
        String nome = "";
        System.out.println("Inserisci il tuo nome:\n");
        try{
            nome = keyboard.readLine();
        }
        catch(Exception e){
            System.out.println("Errore");
        }
        
        String pwd = "";
        System.out.println("Inserisci la password:\n");
        try{
            pwd = keyboard.readLine();
        }
        catch(Exception e){
            System.out.println("Errore");
        }
        String testo = nome + ";" + pwd;
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", nome, pwd, testo);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
