package RandomizerLab;

import java.util.*;
import java.lang.Math;;

public class PlayingCards implements Randomizer {

  private List<Card> deck;
  private int randomCardIndex;
  
  
  public List<Card> getDeck()
  {
    return deck;
  }

  public int getRandomCardIndex()
  {
    return randomCardIndex;
  }

  public PlayingCards(){
    
    buildDeck();
    
    randomize();//initializes randomCardIndex instance variable
    
  }

  /**
   * initializes deck for both new game and shuffle()
   */
  public void buildDeck()
  {
    deck=new ArrayList<Card>();
    
    deck.add(null);//occupy zero index position.
    for(int s=0; s< Card.getSUITS().length; s++)
    {
      for(int v=1; v < Card.getVALUES().length; v++)
      {
        deck.add(new Card(Card.getSUITS()[s], Card.getVALUES()[v] ));
      }
    }
  }
  
  public void shuffle()
  {
    buildDeck();
    randomize();
  }
  
  /**
   * @return Deals a card and removes it from the deck
   */
  public Card dealCard()
  {
    randomize();
    while(getRandomCardIndex()>deck.size()-1 && deck.size()-1>0) randomize();//sets currentRandomCardIndex variable
    if(getRandomCardIndex()<deck.size())
    {
      Card card = deck.remove(getRandomCardIndex()); 
      return card;
    }
    return null;
  }
  
  /**
   * Generates a random value between 1 and 52 (getNumFaces()).
   */
  @Override
  public void randomize()
  {
    randomCardIndex=(int)(Math.random()*deck.size()-1)+1;
  }

  /**
   *  Returns the position of the selected card in the deck
   */
  @Override
  public int getCurrentValue()
  {
    int index=1;
    while(!(deck.get(index).getFace().
        equals(deck.get(randomCardIndex).getFace())) && index<52)
    {
      index++;
    }
    return index;
  }

  /**
   * @return gets the current face 
   *    of the randomizer
   */
  @Override
  public String getCurrentFace()
  {
    return deck.get(randomCardIndex).getFace();
  }

  /**
  gets the number of possible 
  random values
   * @return
   */
  @Override
  public int getNumFaces()
  {
    return Math.min(deck.size(),52);
  }

  /**
   * @param faceNumber
   * @return Gets the face name for a 
   *     given possible value of faceNum
   */
  @Override
  public String getFace(int faceNum)
  {
    return deck.get(faceNum).getFace();
  }

}
