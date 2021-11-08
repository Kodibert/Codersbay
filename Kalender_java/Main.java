package com.company;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welches Jahr: ");
        int year = input.nextInt();
        System.out.print("Welches Monat: ");
        int month = input.nextInt();
        System.out.print("Erster Tag des Monats(0-6):  ");
        int day = input.nextInt();
        String monthString = getMonthString(month); //Aufruf der Funktion getMonthString(month)."Umwandlung der int Eingabe in String Ausgabe"..
        int numOfDays = getNumberOfDaysInMonth(year, month); //Aufruf der Funktion getNumberOfDaysInMonth(year, month)

        System.out.println();
        System.out.println(monthString + year);
        System.out.println();
        System.out.println(" MO| DI| MI| DO| FR| SA| SO|");
        //Ausgabe der "Leertage" bis zum gewählten Starttag (0-6 wobei 0 für Montag steht)
        for (int i = 1; i <= day; i++) {
            System.out.print("   |");
        }
        for (int j = 1; j <= numOfDays; j++) {
            //Zeilenumbruch beim erreichen des Endes der Woche
            if (day % 7 == 0 && day != 0) {
                System.out.println();
            }
            System.out.printf(" %2d|", j);
            day += 1;
        }

        System.out.println();
    }

    // Ermitteln der String repräsentation des Monats
    static String getMonthString(int month) {
        String returnValue = "";
        switch (month) {
            case 1:
                returnValue = "Jänner ";
                break;
            case 2:
                returnValue = "Februar ";
                break;
            case 3:
                returnValue = "März ";
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
    //Anzahl der Tage von einem Monat
    static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }


        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }

        return 0; // Wenn die Monats-Eingabe keinen Sinn macht
    }
    // Ist es ein Schaltjahr
    static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

}