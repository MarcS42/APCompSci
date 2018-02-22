/**
 * 
 */
package CardsElevenLab;

import java.util.ArrayList;

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
        Deck testDeck0 = new Deck(); // Constructed as a shuffled deck
       ArrayList<Card> sortedDeck = Deck.insertionSorted(testDeck0);
//       for(Card card : testDeck0.getCards()) {
//       System.out.println(card + ", ");
//       }
//       System.out.println(testDeck0.getSize());
//       System.out.println(testDeck0.isEmpty());
//       System.out.println(testDeck0.dealCard());
//       System.out.println(testDeck0.getSize());
//       ArrayList<Card> shuffled = testDeck0.
//               effSelectionShuffle(testDeck0);
       for(int i= 0; i < testDeck0.getCards().size(); i++) {
           System.out.println(testDeck0.getCards().get(i)+
                   "\t\t"+sortedDeck.get(i));
       }
    }

}
