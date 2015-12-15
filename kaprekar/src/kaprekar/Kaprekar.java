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
import java.util.ArrayList;

/**
 *
 * @author lliurex-server
 */
public class Kaprekar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        ArrayList resultado=leeEntrada();
        generaSalida(resultado);
    }
    
       
        
    
    public static ArrayList leeEntrada(){

        try {
           InputStreamReader isr = new InputStreamReader(System.in);
           BufferedReader br = new BufferedReader (isr);
           String texto = br.readLine();
        //   System.out.println("Entrada leida "+texto);
           int cantidad=Integer.parseInt(texto);
           ArrayList<String> lista=new ArrayList<>();
           for (int i=0;i<cantidad;i++){
               lista.add(br.readLine());    
               
            }
           return lista;
           }
           
        
        catch(IOException io) {
            System.out.println("No hay caracteres disponibles");
        }
        
        return null;
    
    }
    
    public static void generaSalida(ArrayList res){
        
        for (int i=0;i<res.size();i++){
            
            System.out.println(obtieneKaprekar((String)res.get(i)));
        }
    }
    
    public static int obtieneKaprekar(String num){
       
        
        if (Integer.parseInt(num)%1111==0) return 8;
        if (Integer.parseInt(num)==6174) return 0;
        
        int ascendente,descendente;
        
        
        return 0;
    }
    
    private int[] obtieneAscDesc(String num){
        int res[]=new int[2];
        switch (num.length()) {
            case 1:  res[0]=Integer.parseInt(num);
                     res[1]=res[0]*1000;
                     return res;
            case 2:  int aux[]=ordenaDos(num);
                     res[0]=aux[0]*1000+aux[1]*100;
                     res[1]=aux[0]+aux[1]*10;
                     return res;
            case 3:  int temp[]=ordenaTres(num);
                     res[0]=temp[0]*1000+temp[1]*100+temp[2]*10;
                     res[1]=temp[0]+temp[1]*10+temp[2]*100;
                     return res;
            case 4:  int var[]=ordenaCuatro(num);
                     res[0]=var[0]*1000+var[1]*100+var[2]*10+var[3];
                     res[1]=var[0]+var[1]*10+var[2]*100+var[3]*1000;
                     return res;
        }
        
         
    }
    private int[] ordenaDos(String num){
        
    }
    private int[] ordenaTres(String num){
        
    }
    
    private int[] ordenaCuatro(String num){
        
    }
    }
}

 
