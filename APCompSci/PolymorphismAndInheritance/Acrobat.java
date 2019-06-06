package PolymorphismAndInheritance;

public class Acrobat extends Dancer {
  
  public void act()
  {
    super.act();
    System.out.println(" flip");
  }
  
  public void doTrick()
  {
    System.out.println(" sommersault");
  }

}
