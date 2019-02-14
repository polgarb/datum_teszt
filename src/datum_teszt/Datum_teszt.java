/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datum_teszt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author t16
 */
public class Datum_teszt {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        
        Scanner bill = new Scanner(System.in);
        System.out.println("Első dátum:");
        String a = bill.nextLine();
        LocalDate elso = LocalDate.parse(a, DateTimeFormatter.ISO_DATE);
        System.out.println("Másik dátum:");
        String b = bill.nextLine();
        LocalDate masodik = LocalDate.parse(b, DateTimeFormatter.ISO_DATE);
        // az első korábbi e mint a második
        if (masodik.isBefore(elso)) {
         System.out.println("hibás");
        } else {
            System.out.println("ok");
        } 
        // hanyadik nap az évben
        int kezdonap = elso.getDayOfYear();
        int vegenap = masodik.getDayOfYear();
        //a szabadság hossza
        int szabihossza = vegenap-kezdonap+1;
        System.out.println(szabihossza);
        
        int szabistart = elso.getDayOfWeek().getValue();
        // van e benne hétvége
        if ((szabistart+szabihossza) > 5) {
            System.out.println("hétvége is van benne");
        } else {
            System.out.println("nincs benne hétvége");
        }
        // milyen napok vanna a szabiba
        int x = 0;
        int hetveginapok = 0;
        for (int i = 0; i < szabihossza; i++) {
            x = elso.getDayOfWeek().getValue()+i;
            if (x > 7) {
                x -= 7;
            }
            if (x == 6 || x == 7) {
                hetveginapok++;
            }
        }
        System.out.println("Hétvégi napok száma = " + hetveginapok);            

    } 
}


