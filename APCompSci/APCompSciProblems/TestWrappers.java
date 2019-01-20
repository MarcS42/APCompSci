package APCompSciProblems;

import java.util.Arrays;
import java.util.List;

public class TestWrappers {

  public static void main(String[] args)
  {
    Double[] arrDoub = new Double[] {1.5,1.0,2.0,3.0,3.5};
    List<Double> nums = Arrays.asList(arrDoub);
    System.out.print(""+nums + Wrappers.remWhole(nums));

  }

}
