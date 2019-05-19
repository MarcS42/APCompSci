package CSASearchSort;

public class Merge implements SortableArray {

  private int[] arr;
  private int arrIndex;
  private int[] leftArr;
  private int[] rightArr;
  private int padLen;
  private int iterations;
  private boolean seeIt;
  private boolean mergeOnly;
  
  @Override
  public void sort()
  {
      if (seeIt) System.out.println("Initial Array:");
      if (seeIt) System.out.println(arrayToString(arr,-1));
      for (int curr_size=1; curr_size < arr.length; curr_size *= 2)
      {
          if (mergeOnly) curr_size = arr.length / 2;
          if (seeIt) System.out.println("Merge with arrays of size " + curr_size);
          for (int left_start = 0; left_start < arr.length - 1; left_start += 2 * curr_size)
          {
              int mid = left_start + curr_size;
              int right_end = Math.min(mid + curr_size, arr.length);
              if (mid < right_end)
              {
                  if (seeIt) System.out.println("Merging elements " + left_start + " to " + mid + " with " + mid + " to " + right_end);
                  divide(left_start, mid, right_end);
                  arrIndex = left_start;
                  mergeArrays();
              }
          }
          if (mergeOnly) break;
      }
  }

  private void divide(int left_start, int mid, int right_end)
  {
      leftArr = new int[mid - left_start];
      rightArr = new int[right_end - mid];
      int leftIndex = 0, rightIndex = 0;
      while (left_start < mid)
      {
          leftArr[leftIndex] = arr[left_start];
          leftIndex++;
          left_start++;
      }
      while (mid < right_end)
      {
          rightArr[rightIndex] = arr[mid];
          rightIndex++;
          mid++;
      }
  }

  private void mergeArrays()
  {
      int leftIndex = 0, rightIndex = 0;
      while (leftIndex < leftArr.length && rightIndex < rightArr.length)
      {
          iterations++;
          if (seeIt) System.out.println("Iteration #" + iterations);
          if (seeIt) outputArrays(leftIndex,rightIndex);
          if (leftArr[leftIndex] < rightArr[rightIndex])
          {
              arr[arrIndex] = leftArr[leftIndex];
              leftIndex++;
          }
          else
          {
              arr[arrIndex] = rightArr[rightIndex];
              rightIndex++;
          }
          if (seeIt) System.out.println("Full Array:");
          if (seeIt) System.out.println(arrayToString(arr, arrIndex));
          arrIndex++;
      }
      while (leftIndex < leftArr.length)
      {
          iterations++;
          if (seeIt) System.out.println("Iteration #" + iterations);
          if (seeIt) outputArrays(leftIndex,rightIndex);
          arr[arrIndex] = leftArr[leftIndex];
          leftIndex++;
          arrIndex++;
          if (seeIt) System.out.println("Full Array:");
          if (seeIt) System.out.println(arrayToString(arr, arrIndex));
      }
      while (rightIndex < rightArr.length)
      {
          iterations++;
          if (seeIt) System.out.println("Iteration #" + iterations);
          if (seeIt) outputArrays(leftIndex,rightIndex);
          arr[arrIndex] = rightArr[rightIndex];
          if (seeIt) System.out.println("Full Array:");
          if (seeIt) System.out.println(arrayToString(arr, arrIndex));
          rightIndex++;
          arrIndex++;
      }
  }

  private void outputArrays(int leftIndex, int rightIndex)
  {

      System.out.println("Left Array:");
      System.out.println(arrayToString(leftArr, leftIndex));

      System.out.println("Right Array:");
      System.out.println(arrayToString(rightArr, rightIndex));
  }

  @Override
  public int getIterations()
  {
      return iterations;
  }

  @Override
  public int[] getArray()
  {
      int[] temp = new int[arr.length];
      for (int index = 0; index < arr.length; index++)
      {
          temp[index] = arr[index];
      }
      return temp;
  }
  /*
  public String toString()
  {
      return arrayToString(arr, -1);
  }
  */
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
  
  private String arrayToString(int[] arr, int markerIndex)
  {

      String l1 = "Index|";
      String l2 = "Value|";
      String l3 = "     |";
      for (int index = 0; index < arr.length; index++)
      {
          String s = "" + index;
          while (s.length() < padLen) s = " " + s;
          l1 += s + "|";

          s = "" + arr[index];
          while (s.length() < padLen) s = " " + s;
          l2 += s + "|";
          s = "";
          if (index == markerIndex)
          {
              while (s.length() < padLen) s += "^";
          }            
          else
          {
              while (s.length() < padLen) s += "-";
          }
          l3 += s + "|";
      }
      return l1 + "\n" + l2 + "\n" + l3;

  }

  /**
   * @param numElements the number of elements to be generated
   * @param order 0 = random, 1 = ascending, 2 = descending
   */
  public void make(int numElements, int order)
  {
      arr = new int[numElements];
      padLen = ("" + arr.length).length();
      for (int index = 0; index < arr.length; index++)
      {
          if (order == 1)
          {
              arr[index] = index;
          }
          else if (order == 2)
          {
              arr[index] = arr.length - index - 1;

          }
          else
          {
              arr[index] = (int)(Math.random() * arr.length);
          }
      }
  }
  /**
   * @param numElements the number of elements to be generated
   * @param order 0 = random, 1 = ascending, 2 = descending
   */
  public Merge(int numElements, int order)
  {
      make(numElements, order);
      seeIt = false;
      mergeOnly = false;
  }
  /**
   * @param numElements the number of elements to be generated
   * @param order 0 = random, 1 = ascending, 2 = descending
   */
  public Merge(int numElements, int order, boolean seeIt, boolean mergeOnly)
  {
      make(numElements, order);
      this.seeIt = seeIt;
      this.mergeOnly = mergeOnly;
  }
}
