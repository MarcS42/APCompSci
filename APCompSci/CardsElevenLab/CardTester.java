/**
 * 
 */
package CardsElevenLab;

/**
 * @author MarcSherman
 *
 */
public class CardTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Card qHearts = new Card("Hearts", "Queen", 10);
        Card qHearts2 = new Card("Hearts", "Queen", 10);
        Card qHeartsV1 = new Card("Hearts", "Queen", 1);
        Card fourDiam = new Card("Diamonds", "4", 4);
        Card aceClubs = new Card("Clubs","Ace", 1);
        Card kSpades = new Card("Spades","King", 3);
        
        assert qHearts.getRank().equals("Queen") : 
            "Wrong rank: " + qHearts.getRank();
        assert qHearts.getSuit().equals("Hearts") : 
            "Wrong suit: " + qHearts.getSuit(); 
        assert qHearts.getPointValue() == 10 : 
            "Wrong point value: " + qHearts.getPointValue();
        
        assert kSpades.getRank().equals("King") : 
            "Wrong rank: " +kSpades.getRank();
        assert kSpades.getSuit().equals("Spades") : 
            "Wrong suit: " + kSpades.getSuit(); 
        assert kSpades.getPointValue() == 10 : 
            "Wrong point value: " + kSpades.getPointValue();
        
        assert qHearts.match(qHearts) : 
            "Card doesn't match itself " + qHearts;
        assert qHearts.match(qHearts2) : 
            "Duplicate cards aren't equal " + qHearts2;
        assert !qHearts.match(qHeartsV1) : 
            "Different cards are equal " + qHearts + ", " +qHeartsV1;
        assert qHearts.match(fourDiam) : 
            "Different cards are equal " + qHearts + ", " +fourDiam;
        assert qHearts.match(aceClubs) : 
            "Different cards are equal " + qHearts + ", " +aceClubs;
        assert qHearts.match(kSpades) : 
            "Different cards are equal " + qHearts + ", " +kSpades;
        
        assert qHearts.compareTo(fourDiam) > 0 : 
            "Lower card " + fourDiam + " greater than higher card " + qHearts;
        assert aceClubs.compareTo(fourDiam) < 0 : 
            "Lower card " + aceClubs + " greater than higher card " + fourDiam;
        assert kSpades.compareTo(qHearts) == 0 : 
            "Equal cards do not compareTo " + kSpades + " , " + qHearts;
        
        assert aceClubs.toString().equals("Ace of Clubs (point value = 1)") :
            "Wrong toString: " + aceClubs;
        assert kSpades.toString().equals("King of Spades (point value = 3)") :
            "Wrong toString: " + kSpades;
        
        System.out.println("All tests passed!");
//        Card[] testCardsArray = {qHearts, qHearts2, fourDiam, kSpades};
//        for(Card card : testCardsArray) {
//            System.out.println(card);
//        }
//        System.out.println(fourDiam.compareTo(qHearts));
//        System.out.println(qHearts.compareTo(fourDiam));
//        System.out.println(qHearts.compareTo(kSpades));
//        System.out.println(qHearts.compareTo(fourDiam));
//        System.out.println(Card.match(qHearts,fourDiam));
    }

}
