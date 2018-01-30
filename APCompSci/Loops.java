
public class Loops {
    static void nestedLoopDemo(){

        for (int row = 1 ; row <= 4 ; row++)
        {
        System.out.print("row "+ row + " : ") ;
        for (int star = 1 ; star <= row ; star++)
            {
            System.out.print("* ") ;
            }
        System.out.println() ;
        }
    }
    
    public static void printSquare() {
        for (int row = 0; row < 6; row++) {
          for (int star = 0; star < 6; star++) {
              System.out.print("* ");
          }
          System.out.println();
      }
    }
    
    public static void diagAndBorders() {
        for (int r = 1; r <= 9; r++) {
            for( int c = 1; c <= 11; c++) {
                if(c == 1 || c== 11 ) {
                    System.out.print("|");
                }
                else if ((c-1)==(r)) {
                    System.out.print("*");
                }
            System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static void noDiag() {
        for (int r = 0; r < 9; r++) {
            for( int c = 0; c < 9; c++) {
                if ((c)==(r)) {
                    System.out.print(" ");
                }
            System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//    nestedLoopDemo();
//    printSquare();
    diagAndBorders();
    noDiag();
    }
}
