/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev4;


/**
 *
 * @author sbuys
 */
public class binler implements Runnable{
     private int value;
     private final String[][] dosya;
     
     binler(String[][] DosyaDizisi)
     {
         this.dosya = DosyaDizisi;
         value = 0;
     }
    @Override
    public void run()
    {
         for (int i = 0; i<dosya.length;i++) {
             value += Integer.parseInt(dosya[i][0]);
         }
    }
    
    public int getValue() {
         return value;
     }
}
