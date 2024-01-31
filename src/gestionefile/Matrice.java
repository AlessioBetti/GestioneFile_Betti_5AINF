/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionefile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Alessio Betti
 * @version 31/01/2024
 */

public class Matrice {

    char mv[][];
    String verme;

    public Matrice(String verme) {
        this.mv = new char[26][26];
        this.verme = verme;
    }

    public void setElemento(int r, int c, int el) {
        this.mv[r][c] = (char) el;
    }

    public char getElemento(int r, int c) {
        return mv[r][c];
    }

    public void stampa() {
        int r = 0;
        int c = 0;

        for (r = 0; r < 26; r++) {
            for (c = 0; c < 26; c++) {
                
          System.out.print(this.getElemento(r, c));
            }
            System.out.print("\n");
        }
    }

    public String cifra(String messaggio){
        String cifrato;
        int k,j,col,row;
        cifrato="";  
        k = 0;
        for (j=0;j<messaggio.length();j++)
        {

            if (k==verme.length())
            {
                k=0;
            }
            col=(int)messaggio.charAt(j)-65;
            row=(int)verme.charAt(k)-65;
            if ((int)messaggio.charAt(j)==32) {
                cifrato = cifrato + " ";
            }
            else
            {
                cifrato=cifrato+mv[row][col];
            }
            k++;
        }   

        return(cifrato);
    }

public String deCifra(String cifrato){
        String messaggio="";

        int k,j,col,row;

        k=0;

        for (j=0;j<cifrato.length();j++){

            if (k==verme.length()){
                    k=0;
            }
            row=(int)verme.charAt(k)-65;
             for (col=0;col<26;col++){
                     if (mv[row][col]==cifrato.charAt(j)){
                             char car=(char)(col+65);
                             messaggio+=car;
                     }
                    }

            k++;
            }   

      return(messaggio);
    }
}

