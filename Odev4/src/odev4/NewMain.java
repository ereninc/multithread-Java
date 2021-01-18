/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFileChooser;

/**
 *
 * @author sbuys
 */

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        int sayac = 0;
        String okunan[][] = null;
        String filePath = null;
        JFileChooser chooser = new JFileChooser();
        int fileint = chooser.showOpenDialog(null);
        
        File file = null;
        if(fileint == JFileChooser.APPROVE_OPTION)
        {
            file = chooser.getSelectedFile();
        }
        if(file != null)
        {
            filePath = file.getPath();
        }
        
        BufferedReader reader;
        try {

                reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();
                while(line != null)
                {
                    sayac++;
                    line = reader.readLine();
                }
                reader.close();
                reader = new BufferedReader(new FileReader(filePath));
                line = reader.readLine();
                okunan = new String [sayac][4];
                sayac=0;
                String okunann[] = new String[4];
                while(line != null)
                {
                    okunann = line.split("");
                    for(int i = 0; i<4;i++)
                    {
                       okunan[sayac][i] = okunann[i]; 
                    } 
                    sayac++;
                    line = reader.readLine();
                }
                 reader.close();
            } catch (IOException e) {
        }
        
        int value0 = 0;
        int value1 = 0 ;
        int value2 = 0 ;
        int value3 = 0 ;   
        
        serihesap r5 = new serihesap(okunan);
        binler r1 = new binler(okunan); 
        yuzler r2 = new yuzler(okunan); 
        onlar r3 = new onlar(okunan); 
        birler r4 = new birler(okunan); 
        Thread calis1 = new Thread(r1); //thread olustur
        Thread calis2 = new Thread(r2); //thread olustur
        Thread calis3 = new Thread(r3); //thread olustur
        Thread calis4 = new Thread(r4); //thread olustur
        Thread calis5 = new Thread(r5);
        
        
        ExecutorService pool = Executors.newFixedThreadPool(8);

        long baslangic = System.nanoTime(); //hesaplama başlıyor   
        pool.execute(calis1);
        pool.execute(calis2);
        pool.execute(calis3);
        pool.execute(calis4);
        pool.shutdown();
        while(!pool.isTerminated())
        {
        }
        
        long bitis = System.nanoTime();//hesaplama bitiyor
        double sure = (bitis-baslangic)/1000000.0;
        
        
        int value4 = 0;
        int value5 = 0 ;
        int value6 = 0 ;
        int value7 = 0 ;   
        
        
        long baslangic1 = System.nanoTime(); //hesaplama başlıyor
        calis5.start();
        while(calis5.isAlive())
        {
            
        }

        
        long bitis1 = System.nanoTime();//hesaplama bitiyor
        double sure1 = (bitis1-baslangic1)/1000000.0;
        
        
        
//        long baslangic2 = System.nanoTime(); //hesaplama başlıyor
//        for(int i = 0; i<okunan.length;i++)
//        {
//            value4+=Integer.parseInt(okunan[i][0]);
//            value5+=Integer.parseInt(okunan[i][1]);
//            value6+=Integer.parseInt(okunan[i][2]);
//            value7+=Integer.parseInt(okunan[i][3]);
//        }
//        
//        long bitis2 = System.nanoTime();//hesaplama bitiyor
//        double sure2 = (bitis1-baslangic1)/1000000.0;
        
        
        
        
        value0 = r1.getValue();
        value1 = r2.getValue();
        value2 = r3.getValue();
        value3 = r4.getValue();
        
        
        System.out.println("\nParalel Hesaplanma Süresi " + String.format("%.2f", sure) + " milisaniye.");
        System.out.println("\nSeri Hesaplanma Süresi " + String.format("%.2f", sure1) + " milisaniye.");
//        System.out.println("\nSeri2 Hesaplanma Süresi " + String.format("%.2f", sure2) + " milisaniye.");
        System.out.println(""+value0+""+value1+""+value2+""+value3);
        //21  17   13   9
    }


}

