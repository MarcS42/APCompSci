package RandomizerLab;

public class TestPokerHand {

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    PlayingCards deck = new PlayingCards(); 
    /**
     * Deal 10 hands
     */
    for(int i = 1; i <= 10; i++) 
    { 
      /**
       * ph = 10 randomly dealt hands
       */
      System.out.print("Dealing hand " + i + ": "); 
      PokerHand ph = new PokerHand(deck.dealCard(), 
          deck.dealCard(), deck.dealCard(), deck.dealCard(),
          deck.dealCard());
      System.out.println(ph);
      ph.pkAnalysisPrinter();
    }
    System.out.println();
    
    /**
     * ph1 = flush 
     */
    PokerHand ph1 = new PokerHand(new Card("clubs", 4), 
        new Card("clubs",13), new Card("clubs",1), new Card("clubs",2),
        new Card("clubs",5));
    System.out.println(ph1);
    ph1.pkAnalysisPrinter();
    System.out.println();
    
    /**
     * ph2 straight
     */
    PokerHand ph2 = new PokerHand(new Card("clubs",5), 
        new Card("spades",2), new Card("diamonds",1), new Card("clubs",3),
        new Card("hearts",4));
    System.out.println(ph2);
    ph2.selectionSort();
    System.out.println(ph2);
    ph2.pkAnalysisPrinter();
    System.out.println();
    
    /**
     * ph3 straight flush
     */
    PokerHand ph3 = new PokerHand(new Card("spades",5), 
        new Card("spades",2), new Card("spades",1), new Card("spades",3),
        new Card("spades",4));
    System.out.println(ph3);
    ph3.selectionSort();
    System.out.println(ph3);
    ph3.pkAnalysisPrinter();
    System.out.println();
  
    /**
    * ph4 fourOAK
    */
   PokerHand ph4 = new PokerHand(new Card("spades",5), 
       new Card("hearts",8), new Card("clubs",8), new Card("spades",8),
       new Card("diamonds",8));
   System.out.println(ph4);
   ph4.selectionSort();
   System.out.println(ph4);
   ph4.pkAnalysisPrinter();
   System.out.println();
   
   /**
    * ph5 two pairs
    */
   PokerHand ph5 = new PokerHand(new Card("spades",5), 
       new Card("hearts",7), new Card("clubs",5), new Card("spades",8),
       new Card("diamonds",8));
   System.out.println(ph5);
   ph5.selectionSort();
   System.out.println(ph5);
   ph5.pkAnalysisPrinter();
   System.out.println();
   
   /**
    * ph6 pair
    */
   PokerHand ph6 = new PokerHand(new Card("spades",7), 
       new Card("hearts",6), new Card("clubs",7), new Card("spades",8),
       new Card("diamonds",8));
   System.out.println(ph6);
   ph6.selectionSort();
   System.out.println(ph6);
   ph6.pkAnalysisPrinter();
   System.out.println();
   
   /**
    * ph7 straight AceHi
    */
   PokerHand ph7 = new PokerHand(new Card("clubs",1), 
       new Card("spades",13), new Card("diamonds",10), new Card("clubs",12),
       new Card("hearts",11));
   System.out.println(ph7);
   ph7.selectionSort();
   System.out.println(ph7);
   ph7.pkAnalysisPrinter();
   System.out.println();
   
   /**
    * ph8 fourOAK
    */
   PokerHand ph8 = new PokerHand(new Card("spades",5), 
       new Card("hearts",5), new Card("clubs",5), new Card("diamonds",5),
       new Card("diamonds",8));
   System.out.println(ph8);
   ph8.selectionSort();
   System.out.println(ph8);
   ph8.pkAnalysisPrinter();
   System.out.println();
   
   /**
   * ph9 straight flush AceHi
   */
  PokerHand ph91 = new PokerHand(new Card("spades",13), 
      new Card("spades",10), new Card("spades",1), new Card("spades",12),
      new Card("spades",11));
  System.out.println(ph91);
  ph91.selectionSort();
  System.out.println(ph91);
  ph91.pkAnalysisPrinter();
  System.out.println();
 }
  
}
  
  
  

