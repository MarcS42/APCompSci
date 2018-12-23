package APCompSciProblems;

import java.util.List;

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

/**
 * Given an array of String values, return a String consisting of
 * only the values that meet all the criteria below separated by
 * commas:
 * 1. length is between 4 and 6 (inclusive)
 * 2. There are no "/" (backslash) characters
 * 3. It starts with "<" OR ends with ">"
 * 
 * @param   arr   the array of Strings
 * @return  A comma separated String with values that meet the criteria
 */
  public static String meetsCriteria(String[] arr)
  {
  String commas="";
  for(String s:arr)
  {
    if(s.length() >= 4 && s.length() <= 6)
    {
      if(!s.contains("/")) 
          if(s.startsWith("<") || s.endsWith(">"))
      {
        commas+= s+",";
      }
    }
  }
  commas=commas.substring(0,commas.length()-2);
  return commas;
  }
  
  /**
   * Given a list of strings -List<String> aList-, return the string that
   * is the longest String in aList.
   * 
   * Examples: aList=
   *           {"fall", "jumped", "high", "low"} => "jumped"
   *           {"field", "to", "Mustangs2018", "a", "MCHS2018"} => "Mustangs2018"
   * 
   * @param    aList a List collection of strings of various lengths
   * @return   the string in aList that has the longest length
   */
  public static String findLongest(List<String> aList)
  {
    String longest=aList.get(0);
    for(int i=1; i < aList.size(); i++)
    {
      if(aList.get(i).length() >= longest.length())
      {
        longest=aList.get(i);
      }
    }
    return longest;
  }
  
  /**
   * Return true if the parameter meets all the criteria below
   * and false otherwise:
   * 1. length is between 6 and 8 (incluseive)
   * 2. There are no "/" (fwd-slash) characters
   * 3. It starts with "{" OR ends with "}"
   * 
   * @param   check   the String to check
   * @return  true    if ALL the criteria are met
  */
  /**
   * @param check
   * @return
   */
  public static boolean meetsCriteria(String check)
  {
    if (check.length() >= 6 && check.length() <= 8 && check.indexOf("/") == -1)
    {
      if (check.substring(0,1).equals("{") || check.substring(check.length() - 1).equals("}"))
      {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Given a 2D array of non-negative int values return a new array
   * of the same size and shape containing the same odd values but
   * where even values have been replaced by the value raised to the
   * 5th power:
   *   7 remains 7
   *   8 becomes 32768
   * Precondition:    nums is not null
   *                  all elements of nums are >= 0
   *                  all elements of nums^5 <= Integer.MAX_VALUE   * 
   *                  nums.length > 0
   *                  nums[0].length > 0
   * 
   * Postcondition:   nums[] is unchanged
   *                  
   * @param nums      a 2D array of int values > 0
   * @return          a new 2D array
   */
  public static int[][] processNums(int[][] nums) {
    int[][] pNums = new int[nums.length][nums[0].length];
    for (int row = 0; row < nums.length; row++)
    {
      for (int col = 0; col < nums[row].length; col++)
      {
        int val = nums[row][col];
        if (val % 2 == 0)
        {
          pNums[row][col] = (int)Math.pow(val, 5);
        }
        else
        {
          pNums[row][col] = val;
        }
      }
    }
    return pNums;
  }
  
  /**
   * Given a list of Strings move the longest one to the end of the
   * list and return its original index.
   * 
   * If more than one string could be the longest return the index
   * of the one with the lowest(first) index.
   * 
   * Precondition:    items is not null
   *                  items.size() > 0
   * 
   * Postcondition:   the longest String is moved to the end
   *                  of the list with all other elements in the
   *                  same relative order
   *                  
   * @param items     a list of at least one String
   * @return          the longest String
   */ 
  public static int ordered(List<String> items)
  {
    int bsf = 0;;
    for(int index = 1; index < items.size(); index++)
    {
      if(items.get(index).length() > items.get(bsf).length())
      {
        bsf = index;
      }
    }
    String item = items.remove(bsf);
    items.add(item);
    return bsf;
  }
  
  /**
   * Given a 2D array return a 1D array whose elements are the sum of the squared values
   * in each row of the 2D array, where that sum is an even number.
   * 
   * Ex:{{2, 3, 5},   => 2^2+3^2+5^2 =4+9+25 = 38
   *     {12, 8, 9}   => 12^2+8^2+9^2 =144+64+81 =289
   *     }
   *     Returned array: {38}.
   * 
   * Precondition:    arr2D is not null
   *                  arr2D.length > 0
   *                  arr2D[0].length > 0
   *                  
   * @param arr2D     a 2D array of int values
   * @return          a 1D array
   */
  public static int[] sumRows(int[][] arr2D)
  {
    int count = 0;
    for (int r = 0; r < arr2D.length; r++)
    {
      int sum = 0;
      for (int c = 0; c < arr2D[r].length; c++)
      {
        sum += (int)Math.pow(arr2D[r][c],2);
      }
      if (sum % 2 == 0)
      {
        count++;
      }
    }
    int[] arr = new int[count];
    int index = 0;
    for (int r = 0; r < arr2D.length; r++)
    {
      int sum = 0;
      for (int c = 0; c < arr2D[r].length; c++)
      {
        sum += (int)Math.pow(arr2D[r][c],2);
      }
      if (sum % 2 == 0)
      {
        arr[index] = sum;
        index++;
      }
    }
    return arr;
  }
}