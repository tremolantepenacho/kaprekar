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
        int ascDesc[];
        int diferencia=Integer.parseInt(num);
        //int diferencia;
        int i=0;
        do{
            ascDesc=obtieneAscDesc(Integer.toString(diferencia));
            diferencia=ascDesc[0]-ascDesc[1];
            i++;
        }
        while (diferencia!=0);
        
        
        return i;
    }
    
    private static int[] obtieneAscDesc(String num){
        int res[]=new int[4];
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
        return res;
         
    }
    private static int[] ordenaDos(String num){
        
        int res[]=new int[2];
        int a=num.charAt(0)-48;
        int b=num.charAt(1)-48;
        if (a>b){
            res[0]=a;
            res[1]=b;
        }
        else{
            res[0]=b;
            res[1]=a;
        }
        
        return res;
    }
    private static int[] ordenaTres(String num){
        
        int res[]=new int[3];
        int a=num.charAt(0)-48;
        int b=num.charAt(1)-48;
        int c=num.charAt(2)-48;
        
        if(a==b && b==c) {
            res[0]=a;
            res[1]=b;
            res[2]=c;
        }
        if (a>b && a>c){
            res[0]=a;
            if (b>c){
                res[1]=b;
                res[2]=c;
            }
            else{
                res[1]=c;
                res[2]=b;
            }
            return res;
        }
        
        if (b>a && b>c){
            res[0]=b;
            if (a>c){
                res[1]=a;
                res[2]=c;
            }
            else{
                res[1]=c;
                res[2]=a;
            }
            return res;
        }
        
        if (c>a && c>b){
            res[0]=c;
            if (a>b){
                res[1]=a;
                res[2]=b;
            }
            else{
                res[1]=b;
                res[2]=a;
            }
            return res;
        }
        
        return res;
    }
    
    private static int[] ordenaCuatro(String num){
              
        int res[]=new int[4];
        int a=num.charAt(0)-48;
        int b=num.charAt(1)-48;
        int c=num.charAt(2)-48;
        int d=num.charAt(3)-48;
        
        if(a==b && b==c && c==d) {
            res[0]=a;
            res[1]=b;
            res[2]=c;
            res[3]=d;
        }
        
        if (a>b && a>c && a>d){
            res[0]=a;
            if(b>c && b>d){
                res[1]=b;
                if(c>d){
                    res[2]=c;
                    res[3]=d;
                    return res;
                }
                else {
                    res[2]=d;
                    res[3]=c;
                    return res;
                }
            }
            if (c>b && c>d){
                res[1]=c;
                if(b>d){
                    res[2]=b;
                    res[3]=d;
                    return res;
                }
                else {
                    res[2]=d;
                    res[3]=b;
                    return res;
                }
            }
            if (d>b && d>c){
                res[1]=d;
                if(b>c){
                    res[2]=b;
                    res[3]=c;
                    return res;
                }
                else {
                    res[2]=c;
                    res[3]=b;
                    return res;
                }
            }
        }
        
        if (b>a && b>c && b>d){
            res[0]=b;
            if(a>c && a>d){
                res[1]=a;
                if(c>d){
                    res[2]=c;
                    res[3]=d;
                    return res;
                }
                else {
                    res[2]=d;
                    res[3]=c;
                    return res;
                }
            }
            if (c>a && c>d){
                res[1]=c;
                if(a>d){
                    res[2]=a;
                    res[3]=d;
                    return res;
                }
                else {
                    res[2]=d;
                    res[3]=a;
                    return res;
                }
            }
            if (d>a && d>c){
                res[1]=d;
                if(a>c){
                    res[2]=a;
                    res[3]=c;
                    return res;
                }
                else {
                    res[2]=c;
                    res[3]=a;
                    return res;
                }
            }
        }
        
        if (c>b && c>a && c>d){
            res[0]=c;
            if(b>a && b>d){
                res[1]=b;
                if(a>d){
                    res[2]=a;
                    res[3]=d;
                    return res;
                }
                else {
                    res[2]=d;
                    res[3]=a;
                    return res;
                }
            }
            if (a>b && a>d){
                res[1]=a;
                if(b>d){
                    res[2]=b;
                    res[3]=d;
                    return res;
                }
                else {
                    res[2]=d;
                    res[3]=b;
                    return res;
                }
            }
            if (d>b && d>a){
                res[1]=d;
                if(b>a){
                    res[2]=b;
                    res[3]=a;
                    return res;
                }
                else {
                    res[2]=a;
                    res[3]=b;
                    return res;
                }
            }
        }
        
        if (d>b && d>c && d>a){
            res[0]=d;
            if(b>c && b>a){
                res[1]=b;
                if(c>a){
                    res[2]=c;
                    res[3]=a;
                    return res;
                }
                else {
                    res[2]=a;
                    res[3]=c;
                    return res;
                }
            }
            if (c>b && c>a){
                res[1]=c;
                if(b>a){
                    res[2]=b;
                    res[3]=a;
                    return res;
                }
                else {
                    res[2]=a;
                    res[3]=b;
                    return res;
                }
            }
            if (a>b && a>c){
                res[1]=a;
                if(b>c){
                    res[2]=b;
                    res[3]=c;
                    return res;
                }
                else {
                    res[2]=c;
                    res[3]=b;
                    return res;
                }
            }
        }
        return res;
    }
}

 
