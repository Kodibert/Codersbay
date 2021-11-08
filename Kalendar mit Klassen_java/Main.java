package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	System.out.print("Monat: ");
	int month = input.nextInt();
	System.out.print("Starttag des Monats(0-6): ");
	int day = input.nextInt();
	System.out.print("Jahr: ");
	int year = input.nextInt();

	String monthString = getMonthString(month); // Aufruf der Funktion getMonthString(month)

    int numberOfDays = getNumberOfDays(year, month);
    System.out.println();
    System.out.println(monthString + year);
    System.out.println();
    System.out.println(" MO| DI| MI| DO| FR| SA| SO|");
    for (int i = 1; i <= day; i++) { //Ausgabe der Leerfelder bei null (Montag) wird die Schleife übersprungen...
        System.out.print("   |");
    }
    for (int j = 1; j <= numberOfDays; j++) {
        if (day % 7 == 0 && day != 0) { //Zeilenumbruch (&& day != 0 absicherung bei eingabe 0 Zeilenumbruch)
            System.out.println();
        }
        System.out.printf(" %2d|", j); //Printf = formatiertes Ausgeben (%2d als Platzhalter für j. 2 steht für 2 dezimalstellen ab dem wert 10..)
        day += 1;
    }
    System.out.println();
    }
    //Funktionen
    static String getMonthString(int month) {
        String returnValue = ""; //Static Void hat keine Rückgabe (return). Static String wird hier ein Wert mit returnValue zurück gegeben ""; => Platzhalter
        switch (month) {
            case 1:
                returnValue = "Jänner ";
                break;
            case 2:
                returnValue = "Februar ";
                break;
            case 3:
                returnValue = "März ";
                break;
            case 4:
                returnValue = "April ";
                break;
            case 5:
                returnValue = "Mai ";
                break;
            case 6:
                returnValue = "Juni ";
                break;
            case 7:
                returnValue = "Juli ";
                break;
            case 8:
                returnValue = "August ";
                break;
            case 9:
                returnValue = "September ";
                break;
            case 10:
                returnValue = "Oktober ";
                break;
            case 11:
                returnValue = "November ";
                break;
            case 12:
                returnValue = "Dezember ";
                break;
        }
        return returnValue;


    }
    static int getNumberOfDays(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 30;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 31;
        }
        if (month == 2) {
            return schaltjahr(year) ? 29 : 28;
        }
        return 0; //wenn die monatgseingabe keinen sinn macht
    }
    static boolean schaltjahr(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 !=0);
    }

}
