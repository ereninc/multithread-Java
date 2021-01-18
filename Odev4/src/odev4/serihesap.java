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
public class serihesap implements Runnable{
     private int value0;
     private int value1;
     private int value2;
     private int value3;
     private final String[][] dosya;
     String donut;
     
     serihesap(String[][] DosyaDizisi)
     {
         this.dosya = DosyaDizisi;
         value0 = 0;
         value1 = 0;
         value2 = 0;
         value3 = 0;
     }
    @Override
    public void run()
    {
         for (int i = 0; i<dosya.length;i++) {
             value0 += Integer.parseInt(dosya[i][0]);
         }
         for(int i=0; i<dosya.length;i++)
         {
             value1 += Integer.parseInt(dosya[i][1]);
         }
         for(int i=0; i<dosya.length;i++)
         {
             value2 += Integer.parseInt(dosya[i][2]);
         }
         for(int i=0; i<dosya.length;i++)
         {
             value3 += Integer.parseInt(dosya[i][3]);
         }
    }
    
    public String getValue() {
         donut = ""+value0+""+value1+""+value2+""+value3;
         return donut;
     }
}
