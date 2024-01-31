package gestionefile;
import java.io.*;

/**
 *
 * @author Alessio Betti
 * @version 31/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(input);
        
        Matrice m = new Matrice("TPSIT");
        Vigenere v1 = new Vigenere(0, 12, 0, 12, m);
        Vigenere v2 = new Vigenere(13, 25, 0, 12, m);
        Vigenere v3 = new Vigenere(0, 12, 13, 25, m);
        Vigenere v4 = new Vigenere(13, 25, 13, 25, m);
        Thread t1 = new Thread(v1);
        Thread t2 = new Thread(v2);
        Thread t3 = new Thread(v3);
        Thread t4 = new Thread(v4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("errore all'interno del metodo join");
        }
        
        
        //1)LETTURA
        Lettore lettore = new Lettore("output.csv");
        //2)ELABORAZIONE
        String nome = "";
        System.out.println("\nInserisci il tuo nome:\n");
        try{
            nome = keyboard.readLine();
        }
        catch(Exception e){
            System.out.println("Errore");
        }
        
        String pwd = "";
        String pwdCifrata = "";
        System.out.println("Inserisci la password:\n");
        try{
            pwd = keyboard.readLine();
        }
        catch(Exception e){
            System.out.println("Errore");
        }
        pwdCifrata = m.cifra(pwd);
        String testo = nome + ";" + pwdCifrata;
        
 
        
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("user.json"));
        DataOutputStream outputStream2 = new DataOutputStream(new FileOutputStream("user.csv"));
        DataInputStream inputStream = new DataInputStream(new FileInputStream("user.json"));
        
        outputStream.writeBytes("{\"Title\": \"Progetto GestioneFile\", \"Author\": \"Alessio Betti\", \"Classe\": \"5AINF\"}");
        
        int count = inputStream.available();
        byte[] b = new byte[count];
        inputStream.readFully(b);
        
        /*System.out.println("Contenuto del file \"user.json\"");
        for (byte i : b){
            System.out.print((char)i);
        }
        */
        outputStream2.writeBytes("Title;Author;Class\n");
        outputStream2.writeBytes("Progetto GestioneFile;Alessio Betti;5AINF\n");
       
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", nome, pwdCifrata, testo);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
