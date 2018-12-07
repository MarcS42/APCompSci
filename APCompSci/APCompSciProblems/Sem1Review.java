package APCompSciProblems;

public class Sem1Review {
  public static int validPasswordCount(String[] passwords)
  {
    int count = 0;
    String countedPasswords="";
    String[] symbols = {"!","@","#","$","^","&","*"};
    for(String password:passwords)
    {
      for(String symbol:symbols)
      {
        if(password.length() >= 8 && password.indexOf(symbol)>=0)
        {
          if(countedPasswords.indexOf(password)<0)
          {
            count++;
            countedPasswords+=password;
          }
        }
      }
    }
    return count;
  }

  public static String[] addPhoneNumber(String[] phoneNumbers, String phoneNumber)
  {
    boolean areaCodeMatch=false;
    String[] nPhoneNumbers = new String[phoneNumbers.length + 1];
    if(phoneNumber.substring(1, 4).equals(phoneNumbers[0].substring(1, 4)))
    {
      nPhoneNumbers[nPhoneNumbers.length-1] = phoneNumber;
      areaCodeMatch=true;
    }else {
      areaCodeMatch=false;
    }

    for(int i=0; i<nPhoneNumbers.length; i++)
    {
      if(areaCodeMatch && i != nPhoneNumbers.length-1)
      {
        nPhoneNumbers[i]=phoneNumbers[i];
      }else if(!areaCodeMatch)
      {
        if(i < 1)
        {
          nPhoneNumbers[i]=phoneNumbers[i];
        }else if(i==1) 
        {
          nPhoneNumbers[1]=phoneNumber;
        }else { // ==> i > 1
          nPhoneNumbers[i]=phoneNumbers[i-1];
        }
      }
    }
    return nPhoneNumbers;
  }
  
  
  public static int[][] replaceSquareRoots(int[][] roots)
  {
    int i=0, j=0;
    int[][] rooted = new int[roots.length][roots[0].length];
    for(int[] root:roots)
    {
      for(int r:root)
      {
        if(Math.sqrt(r) != (int)Math.sqrt(r))
        {
          rooted[i][j]=r;
        }else 
          if(Math.sqrt(r) == (int)Math.sqrt(r))
        {
          rooted[i][j]=-1;
        }
        j++;
      }
      j=0;
      i++;
    }
    ReverseMatrixFrq.print2D(roots);
    ReverseMatrixFrq.print2D(rooted);
    return rooted;
  }
}
