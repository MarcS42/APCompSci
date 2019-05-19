package RandomizerLab;


public class TestCard {

  public static void main(String[] args)
  {
    Card testCard0 = new Card("hearts",5);
    Card testCardA = new Card("hearts",1);
    Card testCardJ = new Card("spades",11);
    Card testCardQ = new Card("diamonds",12);
    Card testCardK = new Card("clubs",13);
    System.out.println(testCard0);
    for(int i=0;i<Card.SUITS.length;i++)
    {
      System.out.println(Card.SUITS[i]);
    }
    for(int i=1;i<Card.VALUES.length;i++)
    {
      System.out.print(Card.VALUES[i]+",");
    }
    
    System.out.println("\n"+testCard0.getFace());
    System.out.println(testCardA.getFace());
    System.out.println(testCardJ.getFace());
    System.out.println(testCardQ.getFace());
    System.out.println(testCardK.getFace());
    System.out.println(testCard0.sameSuit(testCardA));
    System.out.println(testCard0.sameValue(testCardA));
  }

}
