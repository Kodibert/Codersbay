package com.company;

public class Main {

    public static void main(String[] args) {


        int zahlenswitch = 5;
        switch (zahlenswitch) {
            case 10:
                System.out.println("Jackpot");
                break;
            case 9:
            case 8:
            case 7:
            case 6:
                System.out.println("Die zahl liegt zwischen 6 und 9");
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
                System.out.println("Die zahl liegt zwischen 1 und 5");
                break;
            default:
                System.out.println("Die Zahl ist zu groß oder klein");
                break;

        }


    }
}
