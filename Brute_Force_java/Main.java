package com.company;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        char[] targetPW = new char[4];
        for(int i = 0; i < targetPW.length; i++){
            targetPW[i] = (char) (rand.nextInt(13) + 48); //funktion rand.nextInt(13) liefert zufällig wert zwischen 0 und 12

        }
        System.out.println("Randomisiertes Passwort: " + Arrays.toString(targetPW));
        System.out.println("Brute-Force generiertes Passwort: " + Arrays.toString(brute(targetPW)));
    }
    public static char[] brute(char[] targetPW) {
        char[] currentPW = new char[targetPW.length];    // Neues Array, mit dem verglichen wird

        for (int p = 48; p <= 59; p++) {
            currentPW[targetPW.length - 4] = (char) p;
            for (int o = 48; o <= 59; o++) {
                for (int k = 48; k <= 59; k++) {
                    currentPW[targetPW.length - 3] = (char) k;
                    for (int j = 48; j <= 59; j++) {
                        currentPW[targetPW.length - 2] = (char) j;
                        for (int i = 48; i <= 59; i++) {
                            currentPW[targetPW.length - 1] = (char) i;
                            if (Arrays.equals(targetPW, currentPW)) {    // Wenn das richtige Passwort gefunden wurde
                                return currentPW;                   // wird es als Array zurückgegeben 20736 Möglichkeiten
                            }
                        }
                    }
                }
            }
        }
        return currentPW;
    }

}
