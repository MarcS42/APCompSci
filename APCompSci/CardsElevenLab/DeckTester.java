/**
 * 
 */
package CardsElevenLab;

/**
 * @author MarcSherman
 *
 */
public class DeckTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Deck testDeck0 = new Deck();
       
//       for(Card card : testDeck0.getCards()) {
//       System.out.println(card);
//       }
       System.out.println(testDeck0.getSize());
       System.out.println(testDeck0.isEmpty());
       System.out.println(testDeck0.dealCard());
       System.out.println(testDeck0.getSize());
    }

}
