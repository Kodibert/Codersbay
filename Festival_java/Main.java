package com.company;

public class Main {

    public static void main(String[] args) {

        /* >=18  / boolean enter festival=true

           >=16 und <18 gelbes band
           >=4 und <=15 green

            */


        int age = 18;
        boolean vip = true;
        boolean companion = false;



        if (age >= 18) {
            System.out.println("You will get a green bracelet");
        } else if (age >= 16 && age < 18) {
            System.out.println("You will get a yellow bracelet");
        } else if (age >= 4 && age <= 15 && companion) {
            System.out.println("you will get a red bracelet");
        } else {
            System.out.println("You are not allowed to enter the festival");
        }

        if (vip){
            System.out.println("you will get a golden bracelet");
        }
    }
}
