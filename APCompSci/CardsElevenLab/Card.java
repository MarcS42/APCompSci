/**
 * Builds Card objects
 */
package CardsElevenLab;

/**
 * @author MarcSherman
 *
 */
public class Card {
    
    private String suit;
    private String rank;
    private int pointValue;
    
    public Card(String s, String r, int v) {
        suit = s;
        rank =  r;
        pointValue = v;
    }
    
    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }
    
    /**
     * @param c1 = Card1
     * @param c2 = Card2
     * @return true if c1 matches c2 in rank and suit
     * (Not sure of the utility - 
     * in what card game would 2 cards match?)
     */
    public boolean match(Card that) {
        if(this.getRank()==that.getRank()) {
            if(this.getSuit() == that.getSuit()) {
                return true;
            }
        }
    return false;
    }
    
    /**
     * @param that - card being comparedTo
     * @return returns int > 0 if 
     * pointValue this > pointValue that. Returns int < 0
     * if pointValue this < pontValue that. Returns 0 if
     * pointValue this == pointValue that.
     */
    public int compareTo(Card that) {
        if(this.getPointValue()>that.getPointValue()) {
            return 1;
        }
        if(this.getPointValue() < that.getPointValue()) {
            return -1;
        }
        return 0;
    }
    
    /** 
     * @Override
     */
    public String toString() {
        return rank + " of " + suit + 
                " (point value = " + pointValue+ ")";
    }

}
