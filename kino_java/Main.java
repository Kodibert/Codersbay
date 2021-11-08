package com.company;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        String[] movies = new String[5];
        movies[0] = "1. The Gentlemen";
        movies[1] = "2. Eine Frau mit berauschenden Talenten";
        movies[2] = "3. Vergiftete Wahrheit";
        movies[3] = "4. Das perfekte Geheimnis";
        movies[4] = "5. Unhinged - Ausser Kontrolle";

        String[] food = new String[3];
        food[0] = "1. Pizza";
        food[1] = "2. Kebab";
        food[2] = "3. Bratl";

        int[] foodPrice = new int[3];
        foodPrice[0] = 11;
        foodPrice[1] = 6;
        foodPrice[2] = 14;


        LocalTime[] time = new LocalTime[5];
        time[0] = (LocalTime.of(20, 15));
        time[1] = (LocalTime.of(20, 30));
        time[2] = (LocalTime.of(20, 45));
        time[3] = (LocalTime.of(21, 00));
        time[4] = (LocalTime.of(21, 15));


        boolean[] three_D = new boolean[5];
        three_D[0] = true;
        three_D[1] = false;
        three_D[2] = false;
        three_D[3] = true;
        three_D[4] = false;

        char[] three_D_char = new char[5];
        for (int i = 0; i < three_D_char.length; i++) {
            three_D_char[i] = three_D[i] ? '*' : ' ';
        }
        boolean[] booked = new boolean[5];
        booked[0] = false;
        booked[1] = false;
        booked[2] = false;
        booked[3] = true;
        booked[4] = false;

        char[] booked_char = new char[5];
        for (int i = 0; i < booked_char.length; i++) {
            booked_char[i] = booked[i] ? 'J' : 'N';
        }

        System.out.printf("%15s %50s %20s %20s %20s ", "Filme", "Uhrzeit", "Saal", "3D", "Ausgbucht");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < movies.length; i++) {
            String format = String.format("%-59s %s %19s %22s %16s", movies[i], time[i], 1 + i, three_D_char[i], booked_char[i]);
            System.out.println(format);

        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        LocalTime currentTime = LocalTime.of(20, 10);
        boolean exit = false;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Wählen Sie einen Film aus (1-5) oder null (0) um das Programm zu beenden (Achten Sie bitte auf die Buchung):");
            int choice = input.nextInt();

            if (choice > 0 && choice <= movies.length && !booked[choice - 1]) {
                System.out.println("Ihre Wahl: " + movies[choice - 1] + " um " + time[choice - 1] + " wird gespeichert!");

                String store = movies[choice - 1] + "  " + time[choice - 1];
                FileWriter f1;

                try {
                    f1 = new FileWriter("c:\\users\\nerdbert\\kino.txt");
                    f1.write(store);
                    f1.close();
                } catch (IOException e) {
                    System.out.println("Fehler beim Erstellen der Datei");
                }

                if (currentTime.isBefore(time[choice - 1].minusMinutes(10))) { // ich habe noch mehr als 10 Minuten
                    System.out.println("\nIch habe noch Zeit mir Essen zu holen...\n");
                    System.out.printf("%6s %47s ", "Speisen", "Preis");
                    System.out.println();
                    System.out.println("-------------------------------------------------------");
                    for (int i = 0; i < food.length; i++) {
                        String format = String.format("%-50s %s %s", food[i], foodPrice[i], " €");
                        System.out.println(format);
                    }
                    System.out.println("-------------------------------------------------------\n");
                    System.out.println("!!!Gewinnspiel!!!\nSpielen Sie? (Eingabe 'j' oder 'n')");

                    char yesOrNo = input.next().charAt(0);

                    int randomNumber = getRandomNumber();

                    int wallet = 12;

                    switch (yesOrNo) {
                        case 106 -> {
                            System.out.println("Ihre Nummer ist: " + randomNumber);
                            if (isPrime(randomNumber) || isRoundNumber(randomNumber)) {
                                System.out.print("Sie haben gewonnen!!! Ihr Bestellung ist kostenlos.");
                            }
                        }
                        case 110 -> {
                            System.out.println("Was möchten Sie essen?");
                            for (int i = 0; i < foodPrice.length; i++) {
                                if (foodPrice[i] <= wallet) {
                                    System.out.println("Ich kann mir " + food[i] + " leisten!");
                                } else {
                                    System.out.println(food[i] + " ist zu teuer!");
                                }
                            }

                        }
                    }

                } else {
                    System.out.println("Ich gehe noch kurz aufs Klo");
                }
                System.out.println();
                System.out.println("Auf ins Kino!!!!!");
                exit = true;
            } else if (choice == 0) {
                exit = true;
            }
        } while (!exit);

    }

    public static boolean isPrime(int randomNumber) {
        int sqrt = (int) Math.sqrt(randomNumber) + 1;
        for (int i = 2; i < randomNumber; i++) {
            if (randomNumber % i == 0) {

                return false;
            }
        }
        return true;
    }

    public static boolean isRoundNumber(int randomNumber) {
        return randomNumber % 10 == 0;
    }

    private static int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(1001);
    }

}





