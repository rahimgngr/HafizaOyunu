/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hafızaoyunu;

import java.util.Scanner;

/**
 *
 * @author rahimgng
 */
public class HafızaOyunu {

     private static kart[][] kartlar = new kart[4][4];
     
    public static void main(String[] args) {
       
        
        kartlar[0][0] = new kart('E');
        kartlar[0][1] = new kart('A');
        kartlar[0][2] = new kart('B');
        kartlar[0][3] = new kart('F');
        kartlar[1][0] = new kart('G');
        kartlar[1][1] = new kart('A');
        kartlar[1][2] = new kart('D');
        kartlar[1][3] = new kart('H');
        kartlar[2][0] = new kart('F');
        kartlar[2][1] = new kart('C');
        kartlar[2][2] = new kart('D');
        kartlar[2][3] = new kart('H');
        kartlar[3][0] = new kart('E');
        kartlar[3][1] = new kart('G');
        kartlar[3][2] = new kart('B');
        kartlar[3][3] = new kart('C');

       // oyunTahtasi();
       while (oyunBittiMi() == false){
           
           oyunTahtasi();
           tahminEt();
       }
    }
    
    public static void tahminEt(){
        
        Scanner scanner = new Scanner (System.in);    
        
        System.out.println("Birinci tahmin : i ve j değerlerini bi boşluklu gir.. " );
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();
        
        kartlar[i1][j1].setTahmin(true);
        oyunTahtasi();
        
         System.out.println("İkinci tahmin : i ve j değerlerini bi boşluklu gir.. " );
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();
        
        if (kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()){
            kartlar[i2][j2].setTahmin(true);
        }
        else {
            kartlar[i1][j1].setTahmin(false);
        }
    }
    public static boolean oyunBittiMi(){
       
        for (int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j< 4 ; j++){
                if (kartlar[i][j].isTahmin()== false)
                    return false;
            }
        }
        return true;
    }
    
    public static void oyunTahtasi(){
        
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(kartlar[i][j].isTahmin() == true){
                    System.out.print(" | " + kartlar[i][j].getDeger() + " | ");
                }
                else {
                    System.out.print(" | | ");
                }
            }
            
            System.out.println(" ");
        }
     }
    
}
