package APCompSciProblems;

  
  import java.util.*;
  public class Wrappers
  {

    
    /**
     * Remove all whole numbers from the given list keeping it in the
     * same relative order and return the number of elements removed.
     * 
     * Precondition:    nums is not null
     *                  nums.size() > 0
     * 
     * Postcondition:   The list is in the same relative order with
     *                  all whole numbers removed.
     *                  
     * @param nums  A list of numbers
     * @return      The number of elements removed
     */
    public static int remWhole(List<Double> nums)
    {
      int count=0;
      for(int i=nums.size()-1; i>=0; i--)
      {
        if(nums.get(i)%1 == 0)
        {
          nums.remove(i);
          count++;
        }
      }
      return count;
    }

}
