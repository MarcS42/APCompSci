import java.util.ArrayList;

public class CoinClubRunner {

    public static void main(String[] args) {
        CoinCollectionTools coinBox1 = new CoinCollectionTools("US",3,5);
        CoinCollectionTools coinBox2 = new CoinCollectionTools("FR",3,5);

//        for (int row = 0; row < coinBox1.getCoinBox().length; row++) {
//            for(int column = 0; column < 
//                    coinBox1.getCoinBox()[0].length; column++) {
//            System.out.println(coinBox1.getCoinBox()[row][column]+"  "
//                    +coinBox2.getCoinBox()[row][column]);
//            }
//        }
        CoinClubCollection US = new   // ArrayList of Coins from Coin class
                CoinClubCollection(Coin.createCoinArrayUS());
        CoinClubCollection FR = new 
                CoinClubCollection(Coin.createCoinArrayFR());
/**
 * you cannot assign coinbox1.fill() to another variable liked filledCoinBox
 * as that variable will not be known to the CCTools class and you will
 * not be able to use it again with the next CCTools method fillCoinType().
 * You might be able to Cast fillCoinBox1 to CCTools type and then use it
 * with other methods of CCTools class      
 */
        coinBox1.fillCoinBox(US.getArrayList());
        coinBox2.fillCoinBox(FR.getArrayList());
        
        System.out.println("FilledBox1: ");
        for (int column = 0; column < coinBox1.getCoinBox()[0].length; column++) {
            for(int row = 0; row < 
                    coinBox1.getCoinBox().length; row++) {
            System.out.println(coinBox1.getCoinBox()[row][column]);
            }
        }
        
        System.out.println();
        
        System.out.println("FilledBox2: ");
        for (int column = 0; column < coinBox2.getCoinBox()[0].length; column++) {
            for(int row = 0; row < 
                    coinBox2.getCoinBox().length; row++) {       
            System.out.println(coinBox2.getCoinBox()[row][column]);
            }
        }
        
/**
 * Can use arraylist coinType1/2 here as you are not going to use it again 
 * with the CCTools class methods.       
 */
        ArrayList<Coin> coinType1 = coinBox1.fillCoinType();
        ArrayList<Coin> coinType2 = coinBox2.fillCoinType();
        
        System.out.println();
        System.out.println("CoinType1: ");
        for (int index = 0; index < coinType1.size(); index++) {
            
            System.out.println(coinType1.get(index));
            
        }
        
        System.out.println();
        
        System.out.println("CoinType2: ");
        for (int index = 0; index < coinType2.size(); index++) {
            
            System.out.println(coinType2.get(index));
            
        }
    }// end Main

}//end runner
