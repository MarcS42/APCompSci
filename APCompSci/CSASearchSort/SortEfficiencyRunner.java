package CSASearchSort;

public class SortEfficiencyRunner {

  public static void main(String[] args)
  {
   
    efficiencyByDataOrder();
    efficiencyNumElements();
  }
  
  public static void efficiencyByDataOrder()
  {
    for (int dataOrder = 0; dataOrder < 3; dataOrder++)
    {
      for(int sortedOrder=1; sortedOrder<3; sortedOrder++)
      {
        SortableArray arrayOb = new Selection(100, dataOrder, sortedOrder);
        System.out.print("Data Order: ");
        if (dataOrder == 1)
        {
          System.out.print("Ascending");
        }
        else if (dataOrder == 2)
        {
          System.out.print("Descending");

        }
        else
        {
          System.out.print("Random");
        }
        arrayOb.sort();
        System.out.println(" sorted in " + arrayOb.getIterations() + " iterations");
      }
    }
  }

  public static void efficiencyNumElements()
  {
    System.out.println("Elements / Iterations");
    for (int numElements = 100; numElements < 1000; numElements += 100)
    {
      SortableArray arrayOb = new Selection(numElements, 0, 2);
      arrayOb.sort();
      String line = "" + numElements;
      while (line.length() < "Elements".length()) 
      {
        line = " " + line;
      }
      line += " / ";
      String iterations = "" + arrayOb.getIterations();
      while (iterations.length() < "Iterations".length()) 
      {
        iterations = " " + iterations;
      }
      System.out.println(line + iterations);
    }
  }

}

