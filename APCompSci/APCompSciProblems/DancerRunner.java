package APCompSciProblems;

public class DancerRunner {

  public static void main(String[] args)
  {
    /**
     * When picking a method, and IFF method
     * has been overridden by subclass,
     * run-time looks to instantiated object 
     * i.e. 'new Acrobat()' to decide which 
     * 'act()' method to call.
     * If method is not overridden, there is no 
     * potential conflict.
     */
    Dancer a = new Acrobat();
    a.act();
    System.out.println("--------");
    Acrobat b = new Acrobat();
    b.act();

  }

}
