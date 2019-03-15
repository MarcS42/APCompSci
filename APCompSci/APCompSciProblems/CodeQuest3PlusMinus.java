package APCompSciProblems;

public class CodeQuest3PlusMinus {
  
  /**
   * @param strVals A String Array whose elements are numbers 
   * @return Statement  whether numbers are ascending, descending,
   * or random (up and down). 
   */
  public String ascendingDescending(String[] strVals)
  {
    String plusMinus="";
    int elemPrev, elemNext;
    for(int i=0; i<strVals.length-1;i++)
    {
        elemPrev = Integer.parseInt(strVals[i]);
        elemNext = Integer.parseInt(strVals[i+1]);
        if(elemPrev<elemNext)
        {
            plusMinus=plusMinus+"+";    
        }else 
          if(elemPrev>elemNext)
            {
                plusMinus=plusMinus+"-";
            }
    }
    
    if(plusMinus.indexOf("+")<0)
    {
        return "The numbers are in descending order";
    }else 
      if(plusMinus.indexOf("-")<0)
      {
        return "The numbers are in ascending order";
      }else if(plusMinus.indexOf("+")>=0 && plusMinus.indexOf("-")>=0)
        {
            return "The numbers are in random order";
        }
    return null;
  }
  

  public static void main(String[] args)
  {
    CodeQuest3PlusMinus cQ3 = new CodeQuest3PlusMinus();
    String[] strVals = {"5","6","9","13","17","15"};
    
    System.out.println(cQ3.ascendingDescending(strVals));
  }

  

}

