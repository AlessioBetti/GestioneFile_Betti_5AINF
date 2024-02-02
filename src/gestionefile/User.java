/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionefile;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class User{
    String nomeFile;
    String username;
    String password;
    
    public User (String nomeFile, String username, String password){
        this.nomeFile = nomeFile;
        this.username = username;
        this.password = password;
    }
    
    /**
     * @param username
     * @param password
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    public void scrivi(String username, String password)throws FileNotFoundException, IOException{
     
        FileOutputStream fos = new FileOutputStream("listaUser.csv");
        FileInputStream fis = new FileInputStream("listaUser.csv");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        DataInputStream dis = new DataInputStream(fis);
       
        /**
         * L'obiettivo sarebbe quello di leggere prima il contenuto dle file 'listaUser.csv', copiarne
         * il contenuto all'interno di un array, per poi riscriverlo aggiungendo però anche i dati dei nuovi user,
         * così da poter evitare che ad ogni esecuzione del programma i dati vengano sovrascritti.
         */
        
        int count = dis.available();
        byte[] b = new byte[count];
        dis.readFully(b);
        
        char[] content = new char[count];
        for (byte i : b){
           oos.writeByte((char)i);
        }
        
        for (byte i : b){
           System.out.println(content[i]);
        }
        
        
        System.out.println(username + password);
        oos.writeBytes(username + ";" + password);
        
    }
}
