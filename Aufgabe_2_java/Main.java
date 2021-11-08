

package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {




        double[] arraypreis;
        arraypreis = new double[4];
        arraypreis[0] = 4.20;
        arraypreis[1] = 2.30;
        arraypreis[2] = 2.11;
        arraypreis[3] = 12.00;

        String[] arrayartikel;
        arrayartikel = new String[4];
        arrayartikel[0] = "Wurst";
        arrayartikel[1] = "Käse";
        arrayartikel[2] = "Brot";
        arrayartikel[3] = "DVD";

        int[] arraymenge;
        arraymenge = new int[4];
        arraymenge[0] = 1;
        arraymenge[1] = 2;
        arraymenge[2] = 3;
        arraymenge[3] = 4;

        int brieftasche = 46;
        double zwischensumme = arraypreis[0] * arraymenge[3];
        double gesamt = ((arraypreis[0] * arraymenge[3]) + (arraypreis[1]) + (arraymenge[0]) * arraypreis[2] + arraymenge[1] * arraypreis[3]);

        System.out.println(arrayartikel[0] + "  " + arraymenge[2] + "  x  " + arraypreis[0] + "  EUR");
        System.out.println("                      " + zwischensumme + "  EUR");
        System.out.println(arrayartikel[1] + "   " + arraymenge[0] + "  x  " + arraypreis[1] + "  EUR");
        System.out.println("                      " + zwischensumme + "  EUR");
        System.out.println(arrayartikel[2] + "   " + arraymenge[1] + "  x  " + arraypreis[2] + "  EUR");
        System.out.println("                      " + zwischensumme + "  EUR");
        System.out.println(arrayartikel[3] + "   " + arraymenge[1] + "  x  " + arraypreis[3] + "  EUR");
        System.out.println("                      " + zwischensumme + "  EUR");
        System.out.println("-------------------------------");
        System.out.println("Gesamt                " + gesamt);
        System.out.println("Gegeben               " + brieftasche);
        System.out.println("Zurueck                " + (brieftasche - gesamt));


        if (brieftasche < gesamt) {
            System.out.println("Das ist zu wenig du Honk!!!");
        } else {
            System.out.print("Danke, hier ist dein Restgeld");
        }

    }
}
