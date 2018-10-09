package APCompSciProblems;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class CoinCollectionTools {
    
    private Coin[][] coinBox;
    
/**Constructor instantiates coinBox and fills it with
 * default Coin objects
 * 
 * @param country the country of origin of the coins in this box
 * @param rows the number of rows in the coinBox
 * @param columns the number of columns in the coinBox
 */
    public CoinCollectionTools(String country, int rows, int columns) {
        coinBox = new Coin[rows][columns];
        for(int column = 0; column < coinBox[0].length; column++) {
            for(int row = 0; row < coinBox.length; row++) {
                coinBox[row][column] = new Coin(country,0,0);
            }
            
        }
    }
    
/**
 * @return the coinBox
 */
public Coin[][] getCoinBox() {
    return coinBox;
}



    /**
     * Creates and returns a completed coinBox grid by adding the Coin objects from
     * the parameter ArrayList to the coin box in column major-order.
     * 
     * @param myCoins
     *            the ArrayList of Coin objects to be added to the coinBox
     *            Precondition: myCoins is in order by year Precondition: the size
     *            of myCoins is not greater than the total number of compartments
     *            available
     * @return coinBox the completed 2-D array of Coin objects
     */
    public Coin[][] fillCoinBox(ArrayList<Coin> myCoins) {
        int count = 0;
        int row = 0;
        int column = 0;
        while (count < myCoins.size()) {
            while (column < coinBox[0].length) {
                while (row < coinBox.length) {
                    if (count < myCoins.size()) {
                        coinBox[row][column] = myCoins.get(count);
                    }
                    count++;
                    row++;
                }
                row = 0;
                column++;
            }
        }
        return coinBox;
    }
    
    /**
     * Returns an ArrayList of Coin objects sorted by coinType
     * 
     * @return ArrayList of Coin objects 
     * Precondition: all cells in coinBox contain
     *         a valid Coin object 
     * Precondition: coinBox is ordered by year in
     *         column-major order followed by default Coin objects 
     * Postcondition:
     *         Coins in ArrayList are in order grouped by coinType
     */
    public ArrayList<Coin> fillCoinType() {
        ArrayList<Coin> coinType = new ArrayList<Coin>();
        int count = 1;
        int coinTypes = 6;
        while (count <= coinTypes) {
            for (int column = 0; column < coinBox[0].length; column++) {
                for (int row = 0; row < coinBox.length; row++) {
                    if (coinBox[row][column].getCoinType() == count) {
                        coinType.add(coinBox[row][column]);
                    }
                }
            }
            count++;
        }
        return coinType;
    }
}
