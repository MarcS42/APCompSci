package RandomizerLab;

public class TestPlayingCards {

  /**
   * @param args
   */
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    PlayingCards Tdeck0 = new PlayingCards();
    System.out.println((int)(Math.random()*Tdeck0.getDeck().size())+1);
    
    for(int i=1;i<Tdeck0.getDeck().size();i++)
    {
      System.out.print(Tdeck0.getDeck().get(i)+" ,");
    }
    System.out.println();
    
    for(int i=1;i<Tdeck0.getDeck().size();i++)
    {
      System.out.print(Tdeck0.getDeck().get(i).getFace()+" ,");
    }
    System.out.println();
    System.out.println(Tdeck0.getRandomCardIndex());
    System.out.println(Tdeck0.getDeck().get(Tdeck0.getRandomCardIndex()));
    System.out.println(Tdeck0.getCurrentValue());
    System.out.println(Tdeck0.getFace(Tdeck0.getRandomCardIndex()));
    System.out.println(Tdeck0.dealCard());
    
    /**
     * dealCard test
     */
    Card card = Tdeck0.dealCard();//***Still problems here*****
    int count=1;
    while(card != null) 
    { 
      System.out.print(card.getFace() + " "); 
      card = Tdeck0.dealCard();
      count++;
    }
    System.out.println("\n Cards Dealt: " + count);
    
    System.out.println("\nShuffling");
    Tdeck0.shuffle();
    for(int i=1;i<Tdeck0.getDeck().size();i++)
    {
      System.out.print(Tdeck0.getDeck().get(i).getFace()+" ,");
    }
    System.out.println();
  }

}
