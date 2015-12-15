/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaprekar;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lliurex-server
 */
public class Kaprekar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        int cantidadNum=leeEntrada();
        generaSalida(cantidadNum);
    }
    
       
        
    
    public static int leeEntrada(){

        try {
           InputStreamReader isr = new InputStreamReader(System.in);
           BufferedReader br = new BufferedReader (isr);
           String texto = br.readLine();
        //   System.out.println("Entrada leida "+texto);
           return Integer.parseInt(texto);
           
        }
        catch(IOException io) {
            System.out.println("No hay caracteres disponibles");
        }
        
        return 0;
    
    }
    
    public static void generaSalida(int cantidad){
        
        for (int i=0;i<cantidad;i++){
            System.out.println(obtieneKaprekar(leeEntrada()));
        }
    }
    
    public static int obtieneKaprekar(int num){
       // System.out.println(num);
        if (num%1111==0) return 8;
        if (num==6174) return 0;
        
        return 0;
    }
}

 
