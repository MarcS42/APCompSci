package CSASearchSort;

public class Selection implements SortableArray {

  private int[] arr;
  private int iterations;
  private int sortedOrder;//1== ascending, else descending(highest-to-lowest)
  /**
   * @param numElements the number of elements to be generated
   * @param order 0 = random, 1 = ascending, 2 = descending
   */
  public Selection(int numElements, int order, int sortedOrder)
  {
      arr = new int[numElements];
      for (int index = 0; index < arr.length; index++)
      {
          if (order == 1)
          {
              arr[index] = index;//starts at 0 on left-side of arr, sorts ascending, populates arr
          }
          else if (order == 2)
          {
              arr[index] = arr.length - index - 1;//Starts at 0 on right-side of arr, sorts descending, populates arr

          }
          else
          {
              arr[index] = (int)(Math.random() * arr.length);//randomizes arr
          }
      }
      this.sortedOrder=sortedOrder;
  }
  
  

  public int getSortedOrder()
  {
    return sortedOrder;
  }



  public void sort()
  {
      // Set iterations to zero before beginning sort
      iterations = 0;

      // Loop through all elements from first to last
      for (int index = 0; index < arr.length; index++)
      {
          // Get the index of the best so far from the current index on
          int selected = select(index);

          // Swap the best so far with the current index
          swap(index, selected);
      }
  }
  /* Returns index of the element in the instance variable arr with the
   * lowest value starting at the index in the parameter from to the end
   * of the array.
   * Post-condition: iteration goes up by one for each iteration of a
   * loop inside the method
   * @param from the first element to check in the array
   * @return the index of the element with the lowest value
   */
  private int select(int from)
  {
      /* Complete this method */
    if(sortedOrder==1)
    {
      int lowest=from;
      while((from+1)<arr.length)
      {
        if(arr[lowest]>arr[from+1])
        {
          lowest=from+1;
          from++;
        }else{
          from++;
        }
      iterations++;
      }
      return lowest;
    }else
     {
      int highest=from;
      while((from+1)<arr.length)
      {
        if(arr[highest]<arr[from+1])
        {
          highest=from+1;
          from++;
        }else{
          from++;
        }
      iterations++;
      }
      return highest;
     }
  }

  /* The values at index1 and index2 are swapped
   * Pre-condition:  0 <= index1 < arr.length
   *                 0 <= index2 < arr.length
   * Post-condition: the value at index1 has the pre-condition value at index2
   *                 the value at index2 has the pre-condition value at index1
   * @param index1  a valid index of the instance variable arr
   * @param index2  a valid index of the instance variable arr
   */
  private void swap(int index1, int index2)
  {
      /* Complete this method */
      int temp = arr[index2];
      arr[index2]=arr[index1];
      arr[index1]=temp;
  }

  /* Returns the number of iterations recorded during the last call to sort() */
  public int getIterations()
  {
      return iterations;
  }

  /* Returns a copy of the values in the instance variable arr */
  public int[] getArray()
  {
      int[] temp = new int[arr.length];
      for (int index = 0; index < arr.length; index++)
      {
          temp[index] = arr[index];
      }
      return temp;
  }
  
  /* Returns a multi-line string containing the indices and values of
   * the instance variable arr
  */
  public String toString()
  {
      int padLen = ("" + arr.length).length();
      String l1 = "Index|";
      String l2 = "Value|";
      String l3 = "";
      for (int index = 0; index < arr.length; index++)
      {
          String s = "" + index;
          while (s.length() < padLen) s = " " + s;
          l1 += s + "|";

          s = "" + arr[index];
          while (s.length() < padLen) s = " " + s;
          l2 += s + "|";

      }
      while (l3.length() < l1.length()) l3 += "-";
      return l1 + "\n" + l2 + "\n" + l3;

  }

}
