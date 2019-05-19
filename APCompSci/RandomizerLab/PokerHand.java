package RandomizerLab;

public class PokerHand {

  private Card[] pokerHand=new Card[5];
  private boolean flush=false, straight=false, straightFlush=false, fourOAK=false, 
      threeOAK=false, twoPairs=false, pair=false,fullHouse=false, 
      firstIsAce=false, lastIsKing=false;  
  private int sMinus=0, cMinus=0;/**Accelerates Straight and Flush 
                 decisions once non-compliant # or suit is detected*/
  String suit="", consec="", isMatch="";

  public Card[] getPokerHand()
  {
    return pokerHand; 
  }

  public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5){
    pokerHand[0] = c1;
    pokerHand[1] = c2;
    pokerHand[2] = c3;
    pokerHand[3] = c4;
    pokerHand[4] = c5;
    selectionSort();
    pkHandAnalyzer(pokerHand);
  }

  public String toString()
  {
    String ans = "";
    for(Card p:pokerHand)
    {
      ans+=p.getFace()+" ";
    }
    return ans;
  }

  public void selectionSort()
  {
    Card lowest;
    for(int i=0; i<this.pokerHand.length-1;i++)
    {
      lowest=pokerHand[i];
      for(int j=i+1; j<this.pokerHand.length;j++)
      {
        if(pokerHand[j].getValue()<lowest.getValue())
        {
          lowest=pokerHand[j];
          swapC1C2(i,j);

        }
      }
    }
  }

  public void swapC1C2(int i, int j) 
  {
    Card temp= pokerHand[j];
    pokerHand[j]=pokerHand[i];
    pokerHand[i]= temp;
  }

  /**
   * @param pokerHand
   */
  public void pkHandAnalyzer(Card[] pokerHand)
  {
    /**
     * Are all suits the same
     */
    for(int c=0;c<pokerHand.length-1; c++)
    {
      /**
       * Is the first card Ace or the last Card a King?
       */
      if(pokerHand[pokerHand.length-1].getValue()==13) lastIsKing=true;
      if(pokerHand[0].getValue()==1) firstIsAce=true;
      
      if(pokerHand[c].getSuit().equals(pokerHand[c+1].getSuit()) 
          && sMinus==0)
      {
        suit+="S";
      }else {
        sMinus=1;
       }

      /**
       * straight? handling AceHi or AceLO
       */
      if((pokerHand[c].getValue()==pokerHand[c+1].getValue()-1 && cMinus==0)
          ||(firstIsAce && pokerHand[1].getValue()-9 ==1
          && lastIsKing && cMinus==0))
      {
        consec+="C";
      } else 
        {
          cMinus=1;
        }

      if(pokerHand[c].getValue()==pokerHand[c+1].getValue())
      {
        isMatch+= "M";
      }else {
        isMatch+="N";
      }
    }

    if(consec.length()==4) straight=true;
    if(suit.length()==4) flush=true;
    if(straight && flush) 
    {
      straightFlush=true;
      flush=false;
      straight=false;
    }
    if(isMatch.equals("MMNM") || isMatch.equals("MNMM")) 
      fullHouse=true;
    if(isMatch.equals("MMMN") || isMatch.equals("NMMM")) 
      fourOAK=true;
    if(isMatch.equals("MMNN") || isMatch.equals("NNMM") || 
        isMatch.equals("NMMN")) threeOAK=true;
    if(isMatch.equals("MNMN") || isMatch.equals("MNNM") || 
        isMatch.equals("NMNM")) twoPairs=true;
    if(isMatch.equals("MNNN") || isMatch.equals("NMNN") || 
      isMatch.equals("NNMN") || isMatch.equals("NNNM")) pair=true;
  }

  public boolean isStraightFlush()
  {
    return straightFlush;
  }
  
  public boolean isStraight()
  {
    return straight;
  }

  public boolean isFlush()
  {
    return flush;
  }

  public boolean isFullHouse()
  {
    return fullHouse;
  }

  public boolean isFourOAK()
  {
    return fourOAK;
  } 

  public boolean isThreeOAK()
  {
    return threeOAK;
  }

  public boolean istwoPairs()
  {
    return twoPairs;
  }

  public boolean isPair()
  {
    return pair;
  }


  //    if(straight && flush) straightFlush=true;
  //    if(isMatch.equals("MMNM") || isMatch.equals("MNMM")) fullHouse=true;
  //    if(isMatch.equals("MMMN") || isMatch.equals("NMMM")) fourOAK=true;
  //    if(isMatch.equals("MMNN") || isMatch.equals("NNMM") || isMatch.equals("NMMN")) threeOAK=true;
  //    if(isMatch.equals("MNMN") || isMatch.equals("MNNM") || isMatch.equals("NMNM")) twoPairs=true;
  //    if(isMatch.equals("MNNN") || isMatch.equals("NMNN") || 
  //        isMatch.equals("NNMN") || isMatch.equals("NNNM")) pair=true;

  public void pkAnalysisPrinter()
  {
    if(straight) System.out.println("Straight=: "+ straight);
    if(flush) System.out.println("Flush=: "+ flush);
    if(straightFlush) System.out.println("StraightFlush=: "+ straightFlush);
    if(fourOAK) System.out.println("FourOAK=: "+ fourOAK);
    if(fullHouse) System.out.println("FullHouse=: "+ fullHouse);
    if(threeOAK) System.out.println("ThreeOak=: "+ threeOAK);
    if(twoPairs) System.out.println("Two Pairs=: " + twoPairs);
    if(pair) System.out.println("pair=: "+ pair);
    if(!pair && !twoPairs && !threeOAK && !fourOAK
        && !fullHouse && !flush && !straightFlush && !straight) System.out.println("ButtKiss");
  }
}

