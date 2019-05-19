package CSASearchSort;

public class SortableArrayRunner {

  public static void main(String[] args)
  {
    {//0== random; 1==ascending; 2 == ascending
      SortableArray arrayOb = new Selection(10, 0, 2);
      System.out.println("Before:");
      System.out.println(arrayOb.toString());
      arrayOb.sort();
      System.out.println("After:");
      System.out.println(arrayOb.toString());
  }

  }

}
