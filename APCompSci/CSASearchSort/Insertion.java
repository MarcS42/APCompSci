package CSASearchSort;

public class Insertion implements SortableArray {

  private int[] arr;
  private int iterations;
  
  /**
   * @param numElements the number of elements to be generated
   * @param order 0 = random, 1 = ascending, 2 = descending
   */
  public Insertion(int numElements, int order)
  {
    arr = new int[numElements];
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
  
  public void sort()
  {
    for (int outer = 1; outer < arr.length; outer++)
    {
      int insertionElement = arr[outer];

      int inner = outer - 1;

      while (inner >= 0 && arr[inner] > insertionElement)
      {
        iterations++;
        arr[inner + 1] = arr[inner];
        inner--;
      }
      arr[inner + 1] = insertionElement;
    }
  }
  
  public int getIterations()
  {
    return iterations;
  }

  public int[] getArray()
  {
    int[] temp = new int[arr.length];
    for (int index = 0; index < arr.length; index++)
    {
      temp[index] = arr[index];
    }
    return temp;
  }

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
