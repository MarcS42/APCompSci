package APCompSciProblems;

public class ArraysReview {

  /**
   * Given an array of names in lexicographic order and a
   * name, return the index to insert the name so that the
   * array would remain in lexicographic order
   * 
   * Return -1 if the name is a duplicate
   * 
   * NOTE: If the new name should be added to the end of the
   *       array the returned index would be equal to the
   *       length of the parameter array!
   * 
   * Precondition:    names is not null
   *                  names.length > 0
   *                  name is not null
   *                  name.length() > 0
   *                  
   * Postcondition:   names is unchanged
   *                  
   * @param names     an array of names in "Last, First" order
   * @param name      a name in "Last, First" order
   * @return          the index name could be inserted so that
   *                  names remains in lexicographic order or
   *                  -1 if name is already in names
   */
  public static int getInsertIndex(String[] names, String name)
  {
    int indexPosit=names.length;
    for(int i=0; i<names.length; i++)
    {
      if(names[i].equals(name)) return -1; //Duplicate name
      if(names[i].compareTo(name) > 0) return 0;
      if(names[i].compareTo(name) < 0 && names[i+1].compareTo(name) >0)
      {
        indexPosit=i+1;
        break;
      }
    }
    System.out.println(indexPosit);
    return indexPosit;
  }

  public static String[] insertName(String[] names, String name, int insertIndex)
  {
    String[] newArr = new String[names.length+1];
    for(int i=0, j=0; i<newArr.length; i++)
    {
      if(i != insertIndex)
      {
        newArr[i]=names[j++];
      }else if(i==insertIndex)
      {
        newArr[i]=name;
      }
    }
    return newArr;
  }
  
  public static int[][] addAssignment(int[][] scores, int[] assignment)
  {
    int[][] newAssign = new int[scores.length][scores[0].length+1];
    for(int r=0; r < newAssign.length; r++)
    {
      for(int c=0; c < newAssign[0].length; c++)
      {
        if(c != newAssign[0].length-1)
        {
          newAssign[r][c]=scores[r][c];        
        }else {
          newAssign[r][c]=assignment[r];
        }
      }
    }
    return newAssign;
  }
  
  /**
   * Given the 2D array of scores and a valid assignment index
   * return an array of double with 3 elements where:
   *    The first element is the average of the scores
   *    The second element is the lowest score
   *    The third element is the highest score
   * 
   * Scores with a value of -1 are exempt and should not be
   * counted when calculating the average, low, and high score.
   * 
   * Precondition:    scores is not null
   *                  scores.length > 0
   *                  scores[0].length > 0
   *                  0<= aIndex < scores[0].length
   *                  At least one score will not be exempt
   *                  
   * @param scores        a 2D array of scores
   * @param aIndex        the index of the assignment
   * @return              an array of 3 double values:
   *                       [0] average of scores on the assignment
   *                       [1] lowest score on the assignment
   *                       [2] highest score on the assignment
   */
  public static double[] getAssignmentStats(int[][] scores, int aIndex)
  {
    int count=0;
    double sum=0.0, average, hi=0.0, lo=110.0;
    double[] stats =new double[3];
    for(int c=0; c < scores[0].length; c++)
    {
      if(scores[aIndex][c] != -1)
      {
        count++;
        sum+=scores[aIndex][c];
        hi=Math.max(hi,(double)scores[aIndex][c]);
        lo=Math.min(lo,(double)scores[aIndex][c]);
      }
    }
    average=sum/count;
    stats[0]=average;
    stats[1]=lo;
    stats[2]=hi;
    return stats;
  }
  
  public static void main(String[] args)
  {
   int[][] scores= {{85,95,90}};
   int[] assignment={95};  
//   String[] names = {"Braskin, Aaron"}; 
//   String[] names2 = {"Abrahms, John","Braskin, Aaron","Brenan, Ken",
//       "Gaunt, Brandy","Sylvester, Jason"};
//    String name = "Abrahms, John", name2="Connor, David";

    ReverseMatrixFrq.print2D(addAssignment(scores, assignment));

  }

}
