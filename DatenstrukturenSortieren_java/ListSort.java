import java.util.ArrayList;
import java.util.Scanner;


public class ListSort {
    /**Java
     * Datenstrukturen
     * Aufgabe - Liste sortieren
     * Wähle einen der bereits mit Arrays implementierten Sortieralgorithmus und ändere die Implementation derart, dass statt
     * Arrays Listen verwendet werden. Wichtig: Es soll NICHT die eingebaute Sortierfunktion des Listen Interface, sondern
     * euer eigener Algorithmus verwendet werden.
     **/


    private ArrayList<String> cars;

    //Constructor = Methode die denselben Namen wie die Klasse hat, wird automatisch generiert sollte man diese nicht selbst definieren.
    public ListSort(ArrayList<String> input){
        cars = input;
    }
    public void sort(){
        cars = mergeSort(cars);
    }

    public ArrayList<String> mergeSort(ArrayList<String> wholeArray) {
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        int middle;
        if (wholeArray.size() == 1) {
            return wholeArray;
        }else {
            middle = wholeArray.size()/2;
            // Kopiere die linke Hälfte von wholeArray in left
            for(int i = 0; i < middle; i++) {
                left.add(wholeArray.get(i));
            }
                // Kopiere von der Mitte ausgehend alle Elemente in right
            for (int i = middle; i <wholeArray.size(); i++) {
                right.add(wholeArray.get(i));
            }
            // Ruft sich selbst wieder auf "mergeSort(left)"
            left = mergeSort(left);
            right = mergeSort(right);

            merge(left,right,wholeArray);

        }
        return wholeArray;
    }

    private void merge(ArrayList<String> left, ArrayList<String> right, ArrayList<String> wholeArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeArrayIndex = 0;
/**
* Solange weder die rechte oder die linke Arraylist aufgebraucht ist,
*  nimm den kleineren von "left.get(leftIndex) oder "rigth.get(rightIndex)"
*  und füge es in die gesamte Liste ein
**/
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                wholeArray.set(wholeArrayIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                wholeArray.set(wholeArrayIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeArrayIndex++;
        }
        ArrayList<String> rest;
        int restIndex;
        if (leftIndex >= left.size()) {  //Das linke Array ist aufgebraucht
            rest = right;
            restIndex = rightIndex;
        } else {                        //Das rechte Array ist aufgebraucht
            rest = left;
            restIndex = leftIndex;
        }                                 //Kopiere den Rest (Links oder Rechts) dorthin wo noch Platz ist
        for (int i = restIndex; i < rest.size(); i++) {
            wholeArray.set(wholeArrayIndex, rest.get(i));
            wholeArrayIndex++;
        }
    }
    public void show() {
        System.out.println("Alphabetisch sortiert:");
        for (int i=0; i< cars.size();i++) {
            System.out.println(cars.get(i));
        }
    }

    public static void main (String[] args){
        ArrayList<String> input = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib verschiedene Automarken an. Gib 'quit' an um die Eingabe zu beenden");
        String inputCars = scanner.nextLine();
        while(!inputCars.equals("quit")) {
            input.add(inputCars);
            inputCars = scanner.nextLine();
        }
        System.out.println("################################");
            ListSort test = new ListSort(input);
            test.sort();
            test.show();
        }

    }

