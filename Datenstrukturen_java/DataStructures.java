import java.util.*;

public class DataStructures {
    /**
     * Java
     * Datenstrukturen
     * Aufgabe - Mengenlehre
     * Gegeben sind drei Zahlenmengen A, B, C - realisiert als Arrays vom Typ Integer:
     * A = { 49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34 }
     * B = { 39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49 }
     * C = { 41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10 }
     * Berechne möglichst effizient die Vereinigungsmenge von A ∪ B ∪ C sowie alle möglichen Schnittmengen und Differenzmengen der drei Zahlenmengen.
     **/


    public static void main(String[] args) {



        List<Integer> A = new ArrayList<Integer>(Arrays.asList(49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34));
        List<Integer> B = new ArrayList<Integer>(Arrays.asList(39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49));
        List<Integer> C = new ArrayList<Integer>(Arrays.asList(41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10));

        System.out.println(new DataStructures().intersection(A, B, C));
        System.out.println(new DataStructures().union(A, B, C));
        System.out.println(new DataStructures().difference(A, B, C));

    }

/** METHOD INTERSECTION
     *
     * @param A are defined in the "main method" as an ArrayList from the type <Integer>
     * @param B are defined in the "main method" as an ArrayList from the type <Integer>
     * @param C are defined in the "main method" as an ArrayList from the type <Integer>
     * @param <T> is called as a "Generic Type" which can be any class in which it will be defined. In this case T is an ArrayList type.
     * @return listIntersect returns the new created array within this method
     */
    public <T> List<T> intersection(List<T> A, List<T> B, List<T> C) {
        List<T> listIntersect = new ArrayList<T>();

        for (T t : A) {
            if (B.contains(t) && C.contains(t)) {
                listIntersect.add(t);
            }
        }
        return listIntersect;
    }

/** METHOD DIFFERENCE AMOUNT
     *
     * @param A are defined in the "main method" as an ArrayList from the type <Integer>
     * @param B are defined in the "main method" as an ArrayList from the type <Integer>
     * @param C are defined in the "main method" as an ArrayList from the type <Integer>
     * @param <T> is called as a "Generic Type" which can be any class in which it will be defined. In this case T is an ArrayList type.
     * @return listDiff returns the new created array within this method
     */
    public <T> List<T> difference(List<T> A, List<T> B, List<T> C) {
        List<T> listDiff = new ArrayList<T>();

        for (T t : A) {
            if (!B.contains(t) && !C.contains(t)) {
                listDiff.add(t);
            }
        }
        return listDiff;
    }

    /** METHOD UNION
     *
     * @param A are defined in the "main method" as an ArrayList from the type <Integer>
     * @param B are defined in the "main method" as an ArrayList from the type <Integer>
     * @param C are defined in the "main method" as an ArrayList from the type <Integer>
     * @param <T> is called as a "Generic Type" which can be any class in which it will be defined. In this case T is an ArrayList type.
     * @return
     */
    public <T> List<T> union(List<T> A, List<T> B, List<T> C) {
        Set<T> set = new HashSet<T>();

        set.addAll(A);
        set.addAll(B);
        set.addAll(C);

        return new ArrayList<T>(set);
    }

}










