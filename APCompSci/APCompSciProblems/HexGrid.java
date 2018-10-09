package APCompSciProblems;
import java.util.ArrayList;

/**
 * Key is that grid[r][c] = null if there is not a GamePiece there,
 * so count the !null spaces.
 * 
 * Don't forget to return ArrayList, etc.
 * Don't forget to use number as a count-down counter
 *  in addRandom(int number)
 */

public class HexGrid {

    /**
     * A 2-D Array of GamePiece objects in the game. Each GamePiece is located in a
     * specific hex cell as determined by its row and column number.
     */
    private GamePiece[][] grid;

    /**
     * Returns the number of GamePiece objects currently occupying any Hex cell in
     * the grid.
     * 
     * @return the number of GamePiece objects currently in the grid
     */
    public int getGamePieceCount() {
        int count = 0;
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] != null)
                    count++;
            }
        }
        return count;
    }

    /**
     * Returns as an ArrayList of the GamePiece objects in the same column as, and
     * with a lower row number than, the GamePiece at the location specified by the
     * parameters. If there is no GamePiece at the specified location, the method
     * returns null.
     * 
     * @param row
     *            - the row of the GamePiece in question
     * @param col
     *            - the column of the GamePiece in question
     * @return an ArrayList of the GamePiece objects "above" the indicated
     *         GamePiece, or null if no such object exists.
     */
    public ArrayList<GamePiece> isAbove(int row, int col) {
        ArrayList<GamePiece> myGamePieceAL = new ArrayList<GamePiece>();
        if (grid[row][col] == null) {
            return null;
        } else {
            for (int r = row - 1; r >= 0; r--) {
                if (grid[r][col] != null) {
                    myGamePieceAL.add(grid[r][col]);
                }
            }
            return myGamePieceAL;
        }
    }

    /**
     * Adds GamePiece objects randomly to the grid
     * 
     * @param number
     *            of GamePiece Objects to add
     * @return true if GamePieces were added successfully false if there were not
     *         enough blank spaces in the grid to add the requested objects
     */
    public boolean addRandom(int number) {
        int gridBlankSpaces = grid.length * grid[0].length - getGamePieceCount();
        if (gridBlankSpaces < number) {
            return false;
        } else {
            while (number > 0) {

                int randRow = (int) (Math.random()) * (grid.length - 1);
                int randCol = (int) (Math.random()) * (grid[0].length - 1);

                if (grid[randRow][randCol] == null) {
                    grid[randRow][randCol] = new GamePiece();
                }
                number--;
            }
            return true;
        }
    }// end addRandom

}// end HexGrid class
