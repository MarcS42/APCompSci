/**
 * 
 */
package RandomizerLab;

/**
 * @author MarcSherman
 *
 */
public class Card {
  
  private String suit;
  private int value;
  public static final int[] VALUES = {999,1,2,3,4,5,6,7,8,9,10,11,12,13};
  public static final String[] SUITS = {"hearts" ,"clubs","spades","diamonds"};
  
  public Card(String suit, int value){
    this.suit=suit;
    this.value=value;
  }
  
  /**
   * @return returns the value of the card
   */
  public int getValue()
  {
    return value;
  }
  
  /**
   * @return returns the suit of the card

   */
  public String getSuit()
  {
    return suit;
  }
  
  /**
   * @return Returns String[] of static final SUITS
   */
  public static String[] getSUITS()
  {
    return SUITS;
  }
  
   /**
   * @return Returns int[] of static final VALUES
   */
  public static int[] getVALUES()
  {
    return VALUES;
  } 
  
  /**
   * @return Return the face of the card.  
   * This will be used to display a 
   * graphic representation of the card like 3♡ or A♠
   */
  public String getFace()
  {
    String asciiSuitSpades="\u2660", asciiSuitHearts="\u2661", 
              asciiSuitClubs="\u2663", asciiSuitDiamonds="\u2662", curSuit="", faceSuit="";
              
    curSuit=getSuit();
    
    switch(curSuit)
    {
      case "spades":
      faceSuit=asciiSuitSpades;
      break;
      
      case "hearts":
      faceSuit=asciiSuitHearts;
      break;
      
      case "clubs":
      faceSuit=asciiSuitClubs;
      break;
      
      case "diamonds":
        faceSuit=asciiSuitDiamonds;
        break;
        
    }
    
    switch(getValue())
    {
      case 1:
        return "A" + faceSuit;
        
      case 11:
        return "J" + faceSuit;
        
      case 12:
        return "Q" + faceSuit;
        
      case 13:
        return "K" + faceSuit;
        
        default:
          return ""+(VALUES[getValue()]) + faceSuit;
    }
  }
  
  
  /**
   * @param c2
   * @return return true if the card has 
   * the same suit as the parameter card
   */
  public boolean sameSuit(Card c2)
  {
    return getSuit().equals(c2.getSuit());
  }
  
  /**
   * @param c2
   * @return return true if the card 
   * has the same value as the parameter card
   */
  public boolean sameValue(Card c2)
  {
    return (getValue() == c2.getValue());
  }

  public String toString()
  {
    return getValue()+" of "+getSuit();
  }

}
