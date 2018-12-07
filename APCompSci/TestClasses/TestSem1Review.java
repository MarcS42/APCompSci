package TestClasses;

import java.util.Arrays;

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
    
    TestSem1Review ts1r = new TestSem1Review();
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
    String[] passwords1 = 
        {"ApCompSci116",
         "ApC@mpSci!16", 
         "Co$ta2018", "MCHS^&*", 
         "MCHS&tang$", "1mprove2018", 
         "lmpro^e18", "MCStangs","p@sword"
        };
    String[] phoneNumbers0=
      {"(310) 521-2703",
       "(562) 215-1692",
       "(213) 251-7181",
       "(310) 511-2043",
      };
    int[][] roots1= {
        {519, 588, 472},
        {647, 948, 49},
        {518, 239, 625}
    };
    int[][] roots2= {
        {278, 382, 71},
        {468, 814, 576},
        {169, 841, 361},
        {409, 971, 193}
    };
    int[][] roots3 = {{171,451,598,360,453},{417,430,289,793,923},{765,126,72,573,326}};
    String[] phoneNumbers1={"(562) 679-7230", "(310) 251-6129","(212) 796-7181","(213) 911-1071"};
    String phoneNumber0 = "(212) 796-7181";
    String phoneNumber1 = "(213) 962-5147";
//    int[][] roots=ts1r.generateMatrix(3,5);
//    System.out.println(roots1+" rooted equals: ");
    ReverseMatrixFrq.print2D(Sem1Review.replaceSquareRoots(roots3));
//    System.out.println(Arrays.toString(Sem1Review.addPhoneNumber(phoneNumbers1, phoneNumber0)));

  }

}
