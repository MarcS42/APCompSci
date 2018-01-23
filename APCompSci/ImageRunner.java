/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class ImageRunner {

    /**
     * prints 2-D array as a table
     * @param row from a 2-D Pixel Array (Pixel[][])
     */
    public static void printRow(Pixel[] row) {
        for (Pixel i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
      Pixel[][] image; 
      Pixel[][] imageOut;
      int[][] reds = new int[5][5];
      int[][] greens = new int[5][5];
      int[][] blues = new int[5][5];
      
      for(int row =0; row< reds.length; row++) {
          for(int col = 0; col < reds[0].length; col++) {
              reds[row][col] = (int)(Math.random()*256);
              greens[row][col] = (int)(Math.random()*256);
              blues[row][col] = (int)(Math.random()*256);
          }
      }
      
//      for(int row =0; row< reds.length; row++) {
//          for(int col = 0; col < reds[0].length; col++) { 
//          System.out.println(reds[row][col]);
//          }
//      }
      image = AlterImage.generatePixelArray(reds,greens,blues);
      for(Pixel[] row : image) {
          printRow(row);
      }
      
      System.out.println();
      
      imageOut = AlterImage.flipImage(image, false);
      for(Pixel[] row : imageOut) {
          printRow(row);
      }
    }//end Main
    

}//End runner class
