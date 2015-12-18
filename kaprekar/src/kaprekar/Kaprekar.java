/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaprekar;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
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
        
         try {
           InputStreamReader isr = new InputStreamReader(System.in);
           BufferedReader br = new BufferedReader (isr);
           String texto = br.readLine();
           int cantidad=Integer.parseInt(texto);
          
           for (int i=0;i<cantidad;i++){
               System.out.println(obtieneKaprekar(Integer.parseInt(br.readLine())));
               
            }
           }
           
        
        catch(IOException io) {
            System.out.println("No hay caracteres disponibles");
        }
    }  
        
    
       
    public static int obtieneKaprekar(int num){
       
        
        if (num%1111==0) return 8;
        if (num==6174) return 0;
        int ascDesc[];
        int diferencia=num;
        //int diferencia;
        int i=0;
        do{
            ascDesc=obtieneAscDesc(diferencia);
            diferencia=ascDesc[0]-ascDesc[1];
            i++;
        }
        while (diferencia!=6174);
        
        
        return i;
    }
    
    private static int[] obtieneAscDesc(int num){
        int res[]=new int[4];
        int aux[];
      
        if (num<10){
            res[0]=num*1000;
            res[1]=num;
            return res;
            
        }
        
        if (num<100){
            aux=ordenaDos(num);
            res[0]=aux[0]*1000+aux[1]*100;
            res[1]=aux[0]+aux[1]*10;
            return res;
        }
        
        if (num<1000){
            aux=ordenaTres(num);
            res[0]=aux[0]*1000+aux[1]*100+aux[2]*10;
            res[1]=aux[0]+aux[1]*10+aux[2]*100;
            return res;
        }
        else {
            aux=ordenaCuatro(num);
            res[0]=aux[0]*1000+aux[1]*100+aux[2]*10+aux[3];
            res[1]=aux[0]+aux[1]*10+aux[2]*100+aux[3]*1000;
            return res;
        }
    }
    private static int[] ordenaDos(int num){
        
        int res[]=new int[2];
        int b=num%10;
        int a=(num-b)/10;
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
    private static int[] ordenaTres(int num){
        
        int res[]=new int[3];
        int c=num%10;
        num=(num-c)/10;
        int b=num%10;
        num=(num-b)/10;
        int a=num%10;
        
        if(a==b && b==c) {
            res[0]=a;
            res[1]=b;
            res[2]=c;
            return res;
        }
        if (a>=b && a>=c){
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
        
        if (b>=a && b>=c){
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
        
        if (c>=a && c>=b){
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
    
    private static int[] ordenaCuatro(int num){
              
        int res[]=new int[4];
        int d=num%10;
        num=(num-d)/10;
        int c=num%10;
        num=(num-c)/10;
        int b=num%10;
        num=(num-b)/10;
        int a=num%10;
                
        if(a==b && b==c && c==d) {
            res[0]=a;
            res[1]=b;
            res[2]=c;
            res[3]=d;
        }
        
        if (a>=b && a>=c && a>=d){
            res[0]=a;
            if(b>=c && b>=d){
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
            if (c>=b && c>=d){
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
            if (d>=b && d>=c){
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
        
        if (b>=a && b>=c && b>=d){
            res[0]=b;
            if(a>=c && a>=d){
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
            if (c>=a && c>=d){
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
            if (d>=a && d>=c){
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
        
        if (c>=b && c>=a && c>=d){
            res[0]=c;
            if(b>=a && b>=d){
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
            if (a>=b && a>=d){
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
            if (d>=b && d>=a){
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
        
        if (d>=b && d>=c && d>=a){
            res[0]=d;
            if(b>=c && b>=a){
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
            if (c>=b && c>=a){
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
            if (a>=b && a>=c){
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

 
