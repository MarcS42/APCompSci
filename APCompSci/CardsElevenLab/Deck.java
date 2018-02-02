/**
 * 
 */
package CardsElevenLab;
import java.util.ArrayList;
/**
 * @author MarcSherman
 *
 */
public class Deck {
    
    private static final String SUITS[] = 
        {"Spades","Hearts", "Clubs", "Diamonds"};
    private static final String RANKS[] = 
        {"Ace", "2", "3", "4", "5", "6", "7", 
                "8", "9", "10", "Jack", "Queen", "King"};
    private static final int POINT_VALUES[] = 
        {1,2,3,4,5,6,7,8,9,10,10,10,10};
    
    private ArrayList<Card> cards; // Don't declare AL twice
    
    private int size;
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Deck Constructor
     * (not sure why they thought it needed 3 array params)
     */
    public Deck() {
        cards = new ArrayList<Card>();
        for (int s = 0; s < SUITS.length; s++) {
            for (int r = 0; r < RANKS.length; r++) {
                cards.add(new Card(SUITS[s], RANKS[r], POINT_VALUES[r]));
            }
        }
        size = cards.size();
    }

    
    public boolean isEmpty() {
        return size <= 0;
    }
    
    /**Deals a Card without removing it from the ArrayList
     * @return Card at position size-1 or Null if Deck isEmpty
     * Size tells you what card to deal and 
     * how many cards are left in the deck
     */
    public Card dealCard() {
        if (!isEmpty()) {
            size -= 1;
            return cards.get(size);
        }
        return null;
    }
    
    /**
     * @override toString()
     */
    public String toString() {
        return cards.toString();
    }
}
