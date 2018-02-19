package junitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import CardsElevenLab.Card;

class CardTest {
    
//    public String suit;
//    
//    public String rank;
//    
//    public int pointValue;
//    
//    
//    
//    
//    public CardTest(String s, String r, int v) {
//        suit = s;
//        rank =  r;
//        pointValue = v;
//    }
//    CardTest fourDiamonds = new CardTest("Diamonds", "4", 4);
//    CardTest qHearts = new CardTest("Hearts", "Queen", 10);
//    CardTest qHearts2 = new CardTest("Hearts", "Queen", 10);
//    CardTest fourDiam = new CardTest("Diamonds", "4", 4);
//    CardTest kingSpades = new CardTest("Spades","King", 10);
    
    @Test
    final void testCard() {
        Card qHearts = new Card("Hearts", "Queen", 10);
        String shouldBeSuit = "Hearts";
        int shouldBePointValue = 10;

        assertEquals(qHearts.getSuit(), shouldBeSuit,
                "construtor failed Suit");
        assertEquals(qHearts.getRank(), "Queen",
                "constructor failed rank");
        assertEquals(qHearts.getPointValue(), shouldBePointValue,
                "constructor failed pointValue"); 
    }

    @Test
    final void testGetSuit() {
        Card kSpades = new Card("Spades","King", 10);
        assertTrue(kSpades.getSuit().equals("Spades"), 
                "getSuit() failed. Expected Spades");
    }

    @Test
    final void testGetRank() {
        Card fourDiam = new Card("Diamonds", "4", 4);
        String shouldBeRank = "4";
        assertEquals(fourDiam.getRank(), shouldBeRank,
                "getRank failed");
    }

    @Test
    final void testGetPointValue() {
        Card kSpades = new Card("Spades", "King", 10);
        int shouldBePointValue = 10;
        assertEquals(kSpades.getPointValue(), shouldBePointValue, 
                "getPointValue failed. expected 10");
    }

    @Test
    final void testMatch() {
        Card fourDiam = new Card("Diamonds", "4", 4);
        Card kSpades = new Card("Spades", "King", 10);
        assertFalse(fourDiam.match(kSpades), "expected false");
    }

    @Test
    final void testCompareTo() {
        Card fourDiam = new Card("Diamonds", "4", 4);
        Card qHearts = new Card("Hearts", "Queen", 10);
        assertTrue(fourDiam.compareTo(qHearts) < 0,
                "compareTo failed, expected -1");
    }

    @Ignore("testToString Not yet implemented")
    final void testToString() {
        fail("testToString Not yet implemented");
    }

}
