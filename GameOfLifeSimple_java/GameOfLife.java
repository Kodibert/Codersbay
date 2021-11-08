

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
 * Schreib einen Algorithmus der ein N X N Feld visualisert (z.B. # für lebende Zellen und Leerzeichen/'.' für tote Zellen)
 * und Generationen durchlaufen lässt. Entweder X Generationen oder bis das Programm mit Strg+C abgebrochen wird.
 **/

public class GameOfLife {
    public static final int ROWS =25;
    public static final int COLUMN = 100;
    public static final int TIME_DELAY = 500;

    /**
     * The intializeBoard static method sets up the initial board with a
     * random set of cells.
     *
     * @param b a Board, typically empty
     */
    public static void initializeBoard(Board b) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMN; c++) {
                int randomBoardValue = (int) (Math.random() *3);      // random number 0, 1 or 2
                if (randomBoardValue == 0) {                         // # 1/3 chance of having a life cell

                    b.set(r, c, 1);                          // 1 Life cell, 0

                }
            }
        }

    }
    /**
     * The static displayBoard method displays the board on screen. A Board
     * is a 2-dimensional int[][] array, so for the display to include other
     * characters--"." and "0", for example--characters will need to be printed
     * on the screen after checking the int value of that location.
     * @param board the board to be displayed
     */
    public static void displayBoard(Board board) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMN; c++)
                if (board.get(r, c) == 0) {
                    System.out.print('.');
                } else {
                    System.out.print('#');
                }
            System.out.println();
        }
    }
    /**
     * The static calculateNextGen method takes the current board and
     * a new (empty) board and calculates the next generation for that second
     * board based on the standard rules of Conway's Life:
     *
     * ist eine Zelle tot und hat genau 3 lebende Nachbarn, wird sie in der nächsten Generation geboren 👶
     * ""
     * ist eine Zelle am Leben und hat weniger als 2 Nachbarn stirbt sie an Einsamkeit 😔
     *
     *"if (b.get(r,c)" == 1 (Am Lebne) = bestehendes Board und "couuntNeighbors(r,c,b) < 2" weniger als 2 Nachbarn hat DANN "nextB.get(r,c, value: 0)" stirbt die Zelle =0
     *
     * else if
     * ist eine Zelle am Leben und hat 2 oder 3 Nachbarn, bleibt sie am Leben 🤝‍
     * else if
     *
     * 2 Nachbarn schon im ersten if statement abgefragt.. daher ist kleiner 4 in diesem Statement der bereich 2,3
     *
     * ist eine Zelle am Leben und hat mehr als 3 Nachbarn, stirbt sie an Überbevölkerung 💀
     *
     *
     * @param b the current board
     * @param nextB a board with the new generation on it
    **/

    public static void calculateNextgen(Board b, Board nextB) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMN; c++) {
                int neighborCount = countNeighbors(r, c, b);
                    if (b.get(r,c) == 1 && neighborCount <2){
                        nextB.set(r,c, 0);

                    } else if(b.get(r,c) == 1 && neighborCount <4){
                        nextB.set(r,c, 1);
                    }else if(b.get(r,c) == 1 && neighborCount <3){
                        nextB.set(r,c,0);
                    }else if(b.get(r,c) == 0 && neighborCount == 3){
                        nextB.set(r,c,1);
                    }else {
                        nextB.set(r,c,0);
                    }


            }
        }
    }




    /**
     * The static method countNeighbors counts the eight cells around a given
     * cell, making sure not to count outside of the bounds of the array and
     * not to count the current cell itself!
     * @param row the row of the current cell
     * @param column the col of the current cell
     * @param b the board we're investigating
     * @return the number of non-zero neighbors (minimum 0, maximum 8)
     */
public static int countNeighbors(int row, int column, Board b) {
    int count = 0;
    for(int r = row -1; r <= row + 1; r++)
    {
        for (int c = column - 1; c <= column + 1; c++)
        {
            if (r >= 0 && r < ROWS &&                //If row is withing the range &&
                    c >= 0 && c < COLUMN &&             //If column is withing the range &&
                    !(r == row && c == column) &&         //If position is not [0][0], [0][100], [100][0], [100][100] &&
                    b.get(r, c) == 1)
            {                                    // the taken field is 1 then count++
                count++;


            }

        }
    }
return count;
}
    /**
     * The static method transferNextToCurrent takes the board with the
     * next generation and copies it to the board for this generation so
     * that we can continue displaying and analyzing generations.
     * @param board the current board that we will copy to
     * @param nextBoard the next board containing a calculated new generation
     */
    static void transferNextToCurrent(Board board, Board nextBoard) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMN; c++) {
                board.set(r, c, nextBoard.get(r, c));       // The Board set on r,c to nextBoard get r,c
            }
        }

    }
    /**
     * The clearConsole method attempts to clear the Terminal so that
     * successive generations of the board can be displayed
     */
    private static void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void slow(int TIME_DELAY)
    {
        // Sleep for some amount of time to slow display down
        try
        {
            Thread.sleep(TIME_DELAY);
            // TIME_DELAY is an integer in milliseconds
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args)
    {
        Board board = new Board(ROWS, COLUMN);
        Board nextBoard = new Board(ROWS,COLUMN);
        initializeBoard(board);
        displayBoard(board);
       for(int i = 0; i < 100; i++){
           clearConsole();
           displayBoard(board);
           slow(TIME_DELAY);
           calculateNextgen (board, nextBoard);
           transferNextToCurrent(board, nextBoard);
       }

    }
}

