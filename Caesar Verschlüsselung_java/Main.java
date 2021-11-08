package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myReader = null;
        FileWriter myWriter = null;

        try {
            File testFile = new File("c:\\users\\nerdbert\\test.txt");
            if (testFile.exists()) {
                myReader = new Scanner(testFile);
                String text = "";
                while (myReader.hasNextLine()) {
                    text = myReader.nextLine();
                }

                int offset = 10;
// Offset (Verschiebung) wählen
                char[] meinArray = text.toCharArray();
// den Text in ein Char Array laden
                char[] verschluesseltArray = verschluesseln(offset, meinArray);
// mit der Methode (siehe unten) "verschluesseln" ein neues
// Char Array mit dem verschlüsselten Text erstellen
// verschlüsselten Text wieder ausgeben:
                System.out.println("\nSo sieht der Text verschlüsselt aus:");
                String verschluesselt = new String(verschluesseltArray);
                System.out.println(verschluesselt);
                System.out.println("\n");

//Verschlüsseltes Array in Datei schreiben
                myWriter = new FileWriter("c:\\users\\nerdbert\\testverschluesselt.txt");
                myWriter.write(verschluesselt);

                for (int x = 1; x < 128; x++) {
                    char[] entschluesseltArray = entschluesseln(x, verschluesseltArray);

                    String entschluesselt = new String(entschluesseltArray);
// entschlüsselten Text wieder ausgeben:
                    if (entschluesselt.equals(text)) {
                        System.out.println("\nUnd so wieder zurück entschlüsselt:");
                        System.out.println(entschluesselt);
                    }
                }
            } else {
                System.out.println("Die Datei exisitiert nicht.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            if (myReader != null) {
                myReader.close();
            }
            if (myWriter != null) {
                try {
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // hier die Methode zum verschlüsseln
    public static char[] verschluesseln(int offset, char[] charArray) {
        char[] cryptArray = new char[charArray.length];
// erstmal ein leeres Char Array erstellen
        for (int i = 0; i < charArray.length; i++) {
            int verschiebung = (charArray[i] + offset) % 128;
// ursprüngliches Zeichen plus Offset modulo 128

            cryptArray[i] = (char) (verschiebung);
        }
        return cryptArray;
    }

    // hier die Methode zum entschlüsseln
    public static char[] entschluesseln(int offset, char[] charArray) {
        char[] cryptArray = new char[charArray.length];
// erstmal ein leeres Char Array erstellen
        int verschiebung;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] - offset < 0) {
                verschiebung = charArray[i] - offset + 128;
            }
// nach Verschiebung kleiner 0? Wenn ja, dann
// 128 addieren
            else {
                verschiebung = (charArray[i] - offset) % 128;
            }
// wenn nein, einfach nur modulo 128
            cryptArray[i] = (char) (verschiebung);

        }
        return cryptArray;
    }
}