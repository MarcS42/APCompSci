package APCompSciProblems;
import java.util.ArrayList;

/**
 * I am using TwoDArrays class to test drive other free-writing questions in
 * CS AP work book (not just 2D arrays).
 */

/**
 * @author MarcSherman
 *
 */
public class TwoDArrays {
    /**
     * In lieu of a TwoDArray Constructor, had to use this 2dArray method because,
     * to use constructor and instantiate class members, would have had to create
     * length instance variables and then getter methods to use for/next loops as
     * "length method" does not exist are not accessible in class TwoDArrays
     * 
     * @param rows
     * @param columns
     * @return
     */
    public static int[][] twoDArray(int rows, int columns) {
        int[][] myArrayIn = new int[rows][columns];
        for (int i = 0; i < myArrayIn.length; i++) {
            for (int j = 0; j < myArrayIn[0].length; j++) {
                myArrayIn[i][j] = (int) (Math.random() * 10);
            }
        }
        return myArrayIn;
    }
    
    /**Generates int 2DArray with a) unique values, and 
     * b) using only elements from numbers 0 to rows*columns.
     * Ex: arr2D is 3x4 implies elements from 0 to 11 will 
     * be randomly placed in the arr2D.
     * 
     * This makes it slower at the end as it tries to find last
     * few unique values
     * @param rows
     * @param columns
     * @return arr2D without duplicate int elements.
     */
    public static int[][] twoDArrayUnique(int rows, int columns) {
      int range = rows*columns, prospect;
      int[][] myArrayIn = new int[rows][columns];
      String elementsSoFar=" ";
      for (int r = 0; r < myArrayIn.length; r++) {
        for (int c = 0; c < myArrayIn[0].length; c++) {
          prospect=(int) (Math.random() * range);
          while(elementsSoFar.contains(" "+prospect + " "))
          {
            prospect=(int) (Math.random() * range);
          }
          myArrayIn[r][c] = prospect;
          elementsSoFar+=" " + prospect + " ";
        }
      }
      return myArrayIn;
    }
    
    /**Generates int 2DArray with a) unique values, and 
     * b) using only elements from numbers 0 to rows*columns.
     * Ex: arr2D is 3x4 implies elements from 0 to 11 will 
     * be randomly placed in the arr2D.
     * 
     * This makes it slower at the end as it tries to find last
     * few unique values
     * @param rows
     * @param columns
     * @param range- An int >= rows*columns.
     * @return arr2D without duplicate int elements.
     */
    public static int[][] twoDArrayUniqRng(int rows, int columns, int range) {
      int prospect;
      if(!(range>=rows*columns)) System.out.println("Invalid Range");
      int[][] myArrayIn = new int[rows][columns];
      String elementsSoFar=" ";
      for (int r = 0; r < myArrayIn.length; r++) {
        for (int c = 0; c < myArrayIn[0].length; c++) {
          prospect=(int) (Math.random() * range);
          while(elementsSoFar.contains(" "+prospect + " "))
          {
            prospect=(int) (Math.random() * range);
          }
          myArrayIn[r][c] = prospect;
          elementsSoFar+=" " + prospect + " ";
        }
      }
      return myArrayIn;
    }

    /**
     * Takes 2d integer array in and prints it as a matrix should look 
     * Notice the while statement and placement 
     * of println().
     * 
     * @param myArrayIn
     */

    public static void printMyArrayInV2(int[][] myArrayIn) {
        int row = 0;
        while (row < myArrayIn.length) {
            for (int column = 0; column < myArrayIn[0].length; column++) {
                System.out.print(myArrayIn[row][column] + "  ");
            }
            System.out.println();
            row++;
        }
    }

    /**
     * Print 2D String Array 
     * Overloads printMyArrayInV2 to print integers and Strings
     * 
     * @param myArrayIn 2D String
     */
    public static void printMyArrayInV2(String[][] myArrayIn) {
        int row = 0;
        while (row < myArrayIn.length) {
            for (int column = 0; column < myArrayIn[0].length; column++) {
                System.out.print(myArrayIn[row][column] + "  ");
            }
            System.out.println();
            row++;
        }
    }

    public static int[][] modify(int[][] arr) {
        int[][] modifArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[0].length; j++) {
                    modifArr[i][j] = arr[i][j];
                }
            } else {
                for (int j = 0; j < arr[0].length; j++) {
                    modifArr[i][j] = arr[i - 1][j];
                }
            }

        }
        return modifArr;
    }

    /**
     * This version is more efficient. Does not repeat the column for/next loop.
     * 
     * @param arr 2D int array
     * @return modified 2D int array
     */

    public static int[][] modifyV2(int[][] arr) {
        int[][] modifArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i % 2 == 0) {
                    modifArr[i][j] = arr[i][j];
                } else {
                    modifArr[i][j] = arr[i - 1][j];
                }
            }

        }
        return modifArr;
    }

    /**
     * Replace Highs and Lows method on int array
     */
    public static int[] replaceHighAndLow(int[] arr) {
        int[] myHighLow = new int[arr.length];
        for (int i = 0; i < myHighLow.length; i++) {
            if (arr[i] > 750) {
                myHighLow[i] = 1000;
            }
            if ((arr[i] >= 250) && (arr[i] <= 750)) {
                myHighLow[i] = arr[i];
            }
        }
        return myHighLow;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + "  ");

        }
        System.out.println();
    }

    public static ArrayList<Integer> buildArrayList(int[] arr0) {
        ArrayList<Integer> arrIn = new ArrayList<Integer>();
        for (int value : arr0) {
            arrIn.add(value);
        }
        return arrIn;
    }

    /**
     * overloads buildArrayList method to handle Doubles as well as Integers.
     * 
     * @param arr0
     * @return
     */
    public static ArrayList<Double> buildArrayList(double[] arr0) {
        ArrayList<Double> arrIn = new ArrayList<Double>();
        for (double value : arr0) {
            arrIn.add(value);
        }
        return arrIn;
    }

    /**
     * ArrayList element Integer values always increasing.
     */
    public static boolean isIncreasing(ArrayList<Integer> arr0) {
        int i = 0;
        while (i < arr0.size() - 1) {
            if (arr0.get(i) > arr0.get(i + 1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * ArrayList element Double values always increasing.
     *  
     * Appears that changing isIncreasing(ArrayList<Integer> arr) 
     * to isIncreasing(ArrayList<Double> arr)
     * is not enough of a signature change to allow overloading 
     * of isIncreasing method.
     */
    public static boolean isIncreasing2(ArrayList<Double> arr1) {
        int i = 0;
        while (i < arr1.size() - 1) {
            if (arr1.get(i) > arr1.get(i + 1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * Build 2dStringArrayIn Flawed because what happens if rows+cols >
     * oneDArraySongsIn.length? Would be better to have oneDArray as input param to
     * method
     */
    public static String[][] build2DStringArray(int rows, int cols) {
        String[][] twoDArraySongsOut = new String[rows][cols];
        String[] oneDArraySongsIn = { "We are the Champions |", "You Shook Me All Nigth Long |",
                "We Found Love |", "Bleeding Love |", "Stairway to Heaven |",
                "Won't Get Fooled Again |", "I'd Do Anything for Love |", "Stupid Crazy Love |",
                "Love in This Club |", "Since U Been Gone |", "One More Time |",
                "Walk This Way |" };
        int y = 0;
        while (y < oneDArraySongsIn.length) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    twoDArraySongsOut[i][j] = oneDArraySongsIn[y];
                    y++;
                }
            }
        }
        return twoDArraySongsOut;
    }

    /**
     * count target String occurrences in 2D String Array Would be more robust if it
     * handled "target", "Target", etc.
     * 
     * @param 2DStringArray
     * @param target
     *            String to be counted
     */
    public static int findCount(String[][] arr, String target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].contains(target)) { // uses .contains(Charseq) of String method.
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 
     */
    public static boolean rateIsIncreasing(ArrayList<Double> stockPrices) {
        ArrayList<Double> diff = new ArrayList<Double>();
        if(stockPrices.get(0) > stockPrices.get(1)) {
            System.out.println("false"); 
            return false;
        }
        for (int index = 0; index < stockPrices.size() - 1; index++) {
            Double diff0 = Math.round((stockPrices.get(index + 1) 
                    - stockPrices.get(index))*100)/100.0; //Need to do weird
                     //rounding calc to avoid getting numbers 6-8 decimal places
            diff.add(diff0);
        }
        System.out.println("Price Changes " + diff);
        System.out.println("Rate Is Increasing?: " + isIncreasing2(diff));
        return isIncreasing2(diff);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //
//        int[] arr0 = { 34, 35, 36, 35, 38, 40, 42, 43, 51, 52 };
//        ArrayList<Integer> arrIn = buildArrayList(arr0);
//        boolean isIncreasing = isIncreasing(arrIn);
//        System.out.println(isIncreasing);
        // int[] modifiedArray = replaceHighAndLow(arr);
        // printArray(arr);
        // printArray(modifiedArray);
//        String[][] twoDArraySongsIn = build2DStringArray(4, 3);
//        printMyArrayInV2(twoDArraySongsIn);
//        int count = findCount(twoDArraySongsIn, "Love");
//        System.out.println();
//        System.out.println("The word Love appears "+ count + 
//                " times in the song array above.");
        double [] stockPricesIn = {10.1, 12.2, 15.3, 20.4, 28.5, 40.6, 61.7, 85.8};
        ArrayList<Double> stockPrices = buildArrayList(stockPricesIn);
        System.out.println("Stock Prices " + stockPrices);
        rateIsIncreasing(stockPrices);
        printMyArrayInV2(twoDArray(3, 4));
        System.out.println();
        printMyArrayInV2(twoDArrayUniqRng(3, 4, 100));
    }

}
