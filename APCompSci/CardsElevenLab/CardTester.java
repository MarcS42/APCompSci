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
        Card fourDiam = new Card("Diamonds", "4", 4);
        Card kSpades = new Card("Spades","King", 10);
        Card[] testCardsArray = {qHearts, qHearts2, fourDiam, kSpades};
        for(Card card : testCardsArray) {
            System.out.println(card);
        }
        System.out.println(fourDiam.compareTo(qHearts));
        System.out.println(qHearts.compareTo(fourDiam));
        System.out.println(qHearts.compareTo(kSpades));
        System.out.println(qHearts.compareTo(fourDiam));
        System.out.println(Card.match(qHearts,fourDiam));
    }

}
