package TestClasses;

import java.util.Arrays;

import APCompSciProblems.Sem1Review;

public class TestSem1Review {
  

  public static void main(String[] args)
  {
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
    String[] phoneNumbers1={"(562) 679-7230", "(310) 251-6129","(212) 796-7181","(213) 911-1071"};
    String phoneNumber0 = "(212) 796-7181";
    String phoneNumber1 = "(213) 962-5147";
    System.out.println(Arrays.toString(Sem1Review.addPhoneNumber(phoneNumbers1, phoneNumber0)));

  }

}
