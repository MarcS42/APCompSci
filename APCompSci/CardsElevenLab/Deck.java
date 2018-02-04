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
        effSelectionShuffle(this);
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
    
    /**Swap Cards for Card objects. Not useful in shuffling
     * as card position in a card ArrayList is harder to access
     * and change. Need to use ArrayList set(location, object)
     * method in shuffling ALs.
     * @param c1
     * @param c2
     */
    public void swapCards(Card c1, Card c2) {
        Card temp = c1;
        c1 = c2;
        c2 = temp;
    }
    
    /**Shuffles Deck by splitting in two and alternating odd
     * and even card positions. Deck does not have to be 52 cards
     * @param cards52 - un-shuffled 52 card deck
     * @return shuffle - shuffled 52 card deck
     */
    public ArrayList<Card> perfectShuffle(Deck cards52){
        
        //initialize AL<Card> to null
        ArrayList<Card> shuffle = new 
                ArrayList<Card>(cards52.getCards().size());
        for(int i = 0; i < cards52.getCards().size(); i++) {
            shuffle.add(null);
        }
        
        int k = 0; //split deck in two halves, allowing for deck<52
        for(int j = 0; j < (cards52.getCards().size()+1)/2; j++) {
            shuffle.set(k,cards52.getCards().get(j));
            k +=2;
        }
        k = 1;
        for(int j = (cards52.getCards().size()+1)/2; //in case cards52 has odd number of cards
                j < cards52.getCards().size(); j++) {
            shuffle.set(k,cards52.getCards().get(j));
            k +=2;
        }
        return shuffle;
    }
    
    /**Selection Shuffle v0
     * @param cards un-shuffled deck
     * @return shuffled - shuffled deck, but not real efficient.
     * Accesses Math.random() too often
     */
    public ArrayList<Card> selectionShuffle(Deck cards){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        for(int i = 0; i < cards.getCards().size(); i++) {
            shuffled.add(null);
        }
        
        for(int k = 0; k < cards.getCards().size(); k++) {
            int j = (int)(Math.random()*cards.getCards().size());
            while(cards.getCards().get(j) == null) {
                j = (int)(Math.random()*cards.getCards().size());
            }
                shuffled.set(k, cards.getCards().get(j));
                cards.getCards().set(j, null);
        }
    return shuffled;  
    }
    
    /**Efficient shuffle using same input deck to swap 
     * positions efficiently 'r' is random index location
     * between 0 and k inclusively.
     * @param cards - input Deck
     * @return Shuffled Deck cards
     */
    public ArrayList<Card> effSelectionShuffle(Deck cards){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        for(int k = cards.getCards().size()-1; k >= 0; k--) {
            int r = (int)(Math.random()*(k + 1));
            
            //Swap sequence/snippet
            Card temp = cards.getCards().get(k);
            cards.getCards().set(k,cards.getCards().get(r));
            cards.getCards().set(r, temp);
        }
        shuffled = cards.getCards();
        return shuffled;
    }
    
    /**
     * @override toString()
     */
    public String toString() {
        return cards.toString();
    }
}
