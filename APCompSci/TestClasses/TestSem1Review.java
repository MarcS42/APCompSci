package TestClasses;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import APCompSciProblems.ReverseMatrixFrq;
import APCompSciProblems.Sem1Review;

public class TestSem1Review {
  
  public int[][] generateMatrix(int rows, int cols)
  {
    int[][] mat = new int[rows][cols];
    for(int r=0; r<rows; r++)
    {
      for(int c=0; c<cols; c++)
      {
        mat[r][c]=(int)(Math.random()*1001+1);
      }
    }
    ReverseMatrixFrq.print2D(mat); 
    return mat;
  }

  public static void main(String[] args)
  {
    
    @SuppressWarnings("unused")
    TestSem1Review ts1r = new TestSem1Review();
    @SuppressWarnings("unused")
    String[] passwords =
      {"brownfox$",
       "thequ!c^k",
       "jum#ped",
       "@Overth&",
       "lazy^dog",
       "Milo&rocks",
       "m!dogRocks",
       "pas*word",
       "pass*word"
      };
    @SuppressWarnings("unused")
    String[] passwords1 = 
        {"ApCompSci116",
         "ApC@mpSci!16", 
         "Co$ta2018", "MCHS^&*", 
         "MCHS&tang$", "1mprove2018", 
         "lmpro^e18", "MCStangs","p@sword"
        };
    @SuppressWarnings("unused")
    String[] phoneNumbers0=
      {"(310) 521-2703",
       "(562) 215-1692",
       "(213) 251-7181",
       "(310) 511-2043",
      };
    @SuppressWarnings("unused")
    int[][] sumSqs1= {
        {2, 3, 5},
        {12, 8, 9},
        {18, 23, 11}
    };
    int[][] sumSqs2= {
        {8, 17, 12, 7},
        {14, 9, 13, 8},
        {10, 12, 7, 11},
    };
    
    @SuppressWarnings("unused")
    List<String> aList0 = Stream.of("foo","bar","bars", "futbol", "football")
        .collect(Collectors.toList());
    @SuppressWarnings("unused")
    List<String> aList1 = Stream.of("the","quick","brown", "fow", 
        "jumped","over","lazy", "dog")
        .collect(Collectors.toList());

//    int[][] roots3 = {{171,451,598,360,453},{417,430,289,793,923},{765,126,72,573,326}};
//    String[] str={"Hello>","<Hello","<Helo>","<He/o>"};
//    String phoneNumber0 = "(212) 796-7181";
//    String phoneNumber1 = "(213) 962-5147";
//    int[][] roots=ts1r.generateMatrix(3,5);
//    System.out.println(roots1+" rooted equals: ");
//    ReverseMatrixFrq.print2D(Sem1Review.replaceSquareRoots(roots3));
    System.out.println(Arrays.toString(Sem1Review.sumRows(sumSqs2)));

  }

}
