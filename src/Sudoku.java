import java.util.*;

/**
 * Solves a Sudoku grid by using a BackTracking approach.
 */
public class Sudoku {

    /** List to hold the different puzzles */
    private static List<int[][]> list = new ArrayList<int[][]>(10);
    /** Puzzle to solve */
    public static int[][] PUZZLE1 = {
        {9,0,0,1,0,0,0,0,5},
        {0,0,5,0,9,0,2,0,1},
        {8,0,0,0,4,0,0,0,0},
        {0,0,0,0,8,0,0,0,0},
        {0,0,0,7,0,0,0,0,0},
        {0,0,0,0,2,6,0,0,9},
        {2,0,0,3,0,0,0,0,6},
        {0,0,0,2,0,0,9,0,0},
        {0,0,1,9,0,4,5,7,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE2 = {
        {3,0,2,0,0,1,0,9,0},
        {7,0,0,0,0,0,0,3,5},
        {0,0,6,0,9,8,0,2,0},
        {5,1,0,0,7,2,6,4,8},
        {0,0,0,0,0,0,0,0,0},
        {4,9,7,8,3,0,0,5,1},
        {0,3,0,1,8,0,5,0,0},
        {8,2,0,0,0,0,0,0,9},
        {0,7,0,5,0,0,3,0,4},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE3 = {
        {0,0,0,0,0,5,0,7,0},
        {0,0,5,0,0,0,9,0,8},
        {0,0,0,2,0,4,0,0,5},
        {0,0,0,0,7,0,6,0,4},
        {7,1,6,0,0,0,3,8,2},
        {4,0,8,0,2,0,0,0,0},
        {6,0,0,3,0,7,0,0,0},
        {3,0,7,0,0,0,5,0,0},
        {0,2,0,8,0,0,0,0,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE4 = {
        {0,0,5,2,0,0,0,0,8},
        {0,2,1,0,6,0,0,0,0},
        {0,0,0,7,1,5,3,0,0},
        {8,0,6,0,8,0,0,0,7},
        {2,9,0,0,7,0,0,5,1},
        {4,0,0,0,0,0,6,0,3},
        {0,0,8,6,2,7,0,0,0},
        {0,0,0,0,5,0,2,4,0},
        {1,0,0,0,0,3,7,0,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE5 = {
        {0,6,3,0,0,0,0,0,1},
        {5,0,0,0,0,0,0,0,0},
        {0,8,0,0,5,7,6,0,0},
        {0,0,5,2,0,1,0,0,0},
        {1,0,6,3,0,8,5,0,2},
        {0,0,0,5,0,6,4,0,0},
        {0,0,2,6,1,0,0,8,0},
        {0,0,0,0,0,0,0,0,7},
        {8,0,0,0,0,0,2,9,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE6 = {
        {0,0,0,0,0,8,1,5,3},
        {0,0,5,0,5,4,0,8,0},
        {0,0,0,3,7,0,0,6,0},
        {0,0,0,0,0,0,3,4,0},
        {0,0,7,6,0,9,2,0,0},
        {0,9,2,0,0,0,0,0,0},
        {0,1,0,0,8,3,0,0,0},
        {0,7,0,4,1,0,0,0,0},
        {4,5,3,7,0,0,0,0,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE7 = {
        {0,0,6,0,4,8,0,0,0},
        {0,2,0,1,0,0,0,0,0},
        {0,4,7,5,0,0,0,0,0},
        {0,7,0,9,5,0,0,3,0},
        {4,0,0,8,0,6,0,0,9},
        {0,9,0,0,1,4,0,8,0},
        {0,0,0,2,0,5,3,1,0},
        {0,0,0,0,0,9,0,2,0},
        {0,0,0,7,2,0,4,0,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE8 = {
        {9,0,0,1,0,0,0,0,5},
        {0,0,5,0,9,0,2,0,1},
        {8,0,0,0,4,0,0,0,0},
        {0,0,0,0,8,0,0,0,0},
        {0,0,0,7,0,0,0,0,0},
        {2,0,0,3,0,0,0,0,6},
        {0,0,0,2,0,0,9,0,0},
        {0,0,1,9,0,4,5,7,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE9 = {
        {0,0,4,0,5,0,0,9,0},
        {7,0,0,0,4,0,3,0,0},
        {1,0,0,0,0,8,0,4,0},
        {5,2,0,0,0,0,0,0,0},
        {0,8,0,5,0,2,0,3,0},
        {0,0,0,0,0,0,0,7,2},
        {0,6,0,1,0,0,0,0,3},
        {0,0,9,0,3,0,0,0,8},
        {0,7,0,0,8,0,9,0,0},
    };
    /** Puzzle to solve */
    public static int[][] PUZZLE10 = {
        {8,0,0,0,3,9,0,0,0},
        {7,0,6,0,0,0,0,0,3},
        {0,0,0,0,0,7,2,0,0},
        {0,0,7,0,0,0,5,0,8},
        {6,5,0,0,0,0,0,4,9},
        {1,0,3,0,0,0,7,0,9},
        {0,0,9,1,0,0,0,0,0},
        {4,0,0,0,0,0,6,0,1},
        {0,0,0,3,6,0,0,0,5},
    };

    private int[][] board;
    /** Empty cell */
    public static final int EMPTY = 0;
    /** Size of grid (9x9) */
    public static final int SIZE = 9;
    /** Maximum random number */
    public static final int MAX_RAND = 10;
    /** Converts to microseconds */
    public static final int MICRO = 1000;

    /**
     * Initializes the Sudoku board
     * @param board The Sudoku board;
     */
    public Sudoku(int[][] board) {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                this.board[i][j] = board[i][j];
    }


    /**
     * Checks if the possible number is in the row. Returns true if the number is in the row, false if not.
     * @param row The row to be checked
     * @param number The possible number being tested
     * @return True if the number is in the row, false if not
     */
    private boolean inRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;
        return false;
    }

    /**
     * Checks if the possible number is in the column. Returns true if the number is in the column, false if not.
     * @param col The column to be checked
     * @param number The possible number being tested
     * @return True if the number is in the column, false if not
     */
    private boolean inCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[i][col] == number)
                return true;
        return false;
    }

    /**
     * Checks if the possible number is in the 3x3 box.
     * @param row The row to be checked
     * @param col The column to be checked
     * @param number The possible number being tested
     * @return True if the number is in the 3x3 box, false if not
     */
    private boolean inBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;
        return false;
    }

    /**
     * Checks if the number being tested passes the three checks. Returns true if the number does, false otherwise.
     * @param row The row to be checked
     * @param col The column to be checked
     * @param number The possible number being tested
     * @return True if the number does, false otherwise
     */
    private boolean isGood(int row, int col, int number) {
        return !inRow(row, number) && !inCol(col, number) && !inBox(row, col, number);
    }

    /**
     * Recursive BackTracking algorithm. Improvements to be made.
     * @return True if solved, false if not.
     */
    public boolean solve() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                // Looks for next empty cell
                if (board[r][c] == EMPTY) {
                    // If found, try possible numbers
                    for (int num = 1; num <= SIZE; num++) {
                        // If it respects the constraints, place the number
                        if (isGood(r, c, num)) {
                            board[r][c] = num;
                            // Backtracking
                            if (solve()) {
                                return true;
                            // Empty the cell if the tested number isn't a solution
                            } else
                                board[r][c] = EMPTY;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Prints the board
     */
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Picks a puzzle to solve.
     * @return A random puzzle to solve.
     */
    private static int[][] pickPuzzle() {
        Random random = new Random();
        int rand = 0;
        while (true) {
            rand = random.nextInt(MAX_RAND);
            if (rand != 0)
                break;
        }
        return list.get(rand--);
    }

    /**
     * Populates the ArrayList with puzzles to solve
     */
    public static void addPuzzles() {
        list.add(PUZZLE1);
        list.add(PUZZLE2);
        list.add(PUZZLE3);
        list.add(PUZZLE4);
        list.add(PUZZLE5);
        list.add(PUZZLE6);
        list.add(PUZZLE7);
        list.add(PUZZLE8);
        list.add(PUZZLE9);
        list.add(PUZZLE10);
    }

    /**
     * Gets user input, prints the board and shows the solution.
     * @param args Default args
     */
    public static void main(String[] args) {
        addPuzzles();
        int[][] arr = pickPuzzle();
        System.out.println("Please press enter to see the solution to the below puzzle.");
        Sudoku s = new Sudoku(arr);
        s.display();
        new Scanner(System.in).nextLine();
        long startTime = System.nanoTime();
        if (s.solve()) {
            long endTime = System.nanoTime();
            long totalTime = (endTime - startTime) / MICRO;
            long totalTimeMilli = totalTime / MICRO;
            System.out.println("Sudoku puzzle solved in " + totalTime + " microseconds (" + totalTimeMilli + " milliseconds)!");
            s.display();
        } else {
            System.out.println("This puzzle is unsolvable");
        }
    }
}
