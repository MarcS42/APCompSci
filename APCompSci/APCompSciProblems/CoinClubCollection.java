package APCompSciProblems;
import java.util.ArrayList;

/**
 * 
 */

/** Maintains ArrayLists of Coin objects by Country
 * Also constructs Coin ArrayLists from Coin Arrays
 * @author MarcSherman
 *
 */
public class CoinClubCollection {
    
    private ArrayList<Coin> country;
    
    /**
     * @param coins is an Array of coins generated in Coin class
     */
    public CoinClubCollection(Coin[] coins) {
        
        country = new ArrayList<Coin>();
        for(Coin coin : coins) {
            country.add(coin);
        }
    }
    
    /**
     * @return ArrayList of Coin objects from a given country
     * this is critical accessor method to printing members of the 
     * CoinClubCollection as the CCCollection is not an ArrayList itself, 
     * it just contains ArrayLists
     */
    public ArrayList<Coin> getArrayList() {
        return country;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
       CoinClubCollection US = new 
               CoinClubCollection(Coin.createCoinArrayUS());
       CoinClubCollection FR = new 
               CoinClubCollection(Coin.createCoinArrayFR());
       
       for (Coin us : US.getArrayList()) { //notice dataType is Coin
       System.out.println(us);
       }
       System.out.println();
       
       for (Coin fr : FR.getArrayList()) {
           System.out.println(fr);
           }

    }// end static main

}// End class
