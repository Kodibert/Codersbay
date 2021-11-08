/**
 * Java 3 Methoden, Aufgabe "Game of Life"
 * Conways Spiel des Lebens ist ein beliebter Algorithmus der Automatentheorie.
 * Dabei hat man ein beliebig großes Feld (e.g. 100 x 100 Zellen). Jede der Zelle
 * kann entweder lebendig oder tod sein. Eine Zelle hat immer acht Nachbarzellen (Moor)
 * Die Anfangspopulation wird zufällig gewählt, danach entwickelt sich der Algorithmus in
 * Generationen nach folgenden Regeln:
 * <p>
 * ist eine Zelle tot und hat genau 3 lebende Nachbarn, wird sie in der nächsten Generation geboren 👶
 * ist eine Zelle am Leben und hat weniger als 2 Nachbarn stirbt sie an Einsamkeit 😔
 * ist eine Zelle am Leben und hat 2 oder 3 Nachbarn, bleibt sie am Leben 🤝‍
 * ist eine Zelle am Leben und hat mehr als 3 Nachbarn, stirbt sie an Überbevölkerung 💀
 * Eine schöne Visualisierung des Algorithmus findet ihr auf https://bitstorm.org/gameoflife/.
 * <p>
 * Schreib einen Algorithmus der ein N X N Feld visualisiert (z.B. # für lebende Zellen und Leerzeichen/'.' für tote Zellen)
 * und Generationen durchlaufen lässt. Entweder X Generationen oder bis das Programm mit Strg+C abgebrochen wird.
 */
public class Board {
    int[][] b;

    /**
     * "Constructor" for "Objects" from the Class "Board" (Jede Klasse hat einen Standardkonstruktor, erstelt man in nicht selbst wird dieser vom Compiler automatisch erzeugt)
     * Instance with int[][] b; --> Initialise with Parameter....
     * @param rows   = Vertical Reihen (Rows sind "Major" = position 1)
     * @param column = Horizontal Spaltem
     */
    public Board(int rows, int column) {
        b = new int[rows][column];
    }
    /**
     * The "get" method returns the value stored at the specified
     * row,col location.
     *
     * @param rows   The row of the grid
     * @param column The column of the grid
     * @return the int value stored at that row,col
     */
    public int get(int rows, int column) {

        return b[rows][column];
    }

    /**
     * The set method sets the specified row,col location to
     * the specified value
     *
     * @param row   The row of the grid
     * @param column   The column of the grid
     * @param value The int value to be stored at row,col
     *              Keine Rückgabe --> daher void
     */
    public void set(int row, int column, int value) {

        b[row][column] = value;
    }
    /**
     * The getRows method returns the number of rows (the height)
     * of the grid
     *
     * @return the rows (height) of the grid
     */
    public int getRows() {
        return b.length;
    }

    /**
     * The getColumn method returns the number of columns (the width)
     * b[0] erste Position --> Breite.
     * of the grid
     *
     * @return the columns (width) of the grid
     */
    public int getColumn() {
        return b[0].length;
    }

    /**
     * The toString method returns a String that can be printed to
     * display the grid
     *
     * @return a String representing the grid
     * <p>
     * for loop r(ows) --> r
     * for loop c(olumn) --> c
     * "Result += b[r][c]" will be automatically changed to string (For example in Python you have to convert) to Convert this in Java manual wright "String.valueOf(b[r][c])"
     */
    public String toString()
    {
        String result = "";
        for (int r = 0; r < getRows(); r++)
        {
            for (int c = 0; c < getColumn(); c++)
            {
                result += b[r][c];
            }
            result += "\n";

        }
        return result;

    }

}



