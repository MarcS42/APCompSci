package APCompSciProblems;
public class AlterImage {

    /**Converts 3 arrays of color values into one array
     * of Pixel objects
     * 
     * @param red the red color values
     * @param green the green color values
     * @param blue the blue color values
     * @return the Pixel array generated with information
     *      in the red, green, and blue arrays
     *      
     * Precondition: The 3 color arrays are all the same size
     *      and contain int values in the range 0 - 255.
     *      
     * Precondition: The return array is the same size as the
     *      3 color arrays.
     *      
     *   Needed to make method static to get it to run in runner class Main
     */
    public static Pixel[][] generatePixelArray(int[][] reds, int[][] greens,
                            int[][] blues){
        Pixel[][] pixel = new Pixel[reds.length][reds[0].length];
        for(int row =0; row < (pixel.length); row++) {
            for(int col = 0; col < (pixel[0].length); col++) {
                pixel[row][col] = new Pixel(reds[row][col], 
                        greens[row][col], blues[row][col]);
            }
        }
    return pixel;   
    }
    
    /**Flips a 2-D array of Pixel objects either
     * horizontally or vertically
     * 
     * @param image the 2-D array of Pixel objects to be processed
     * @param horiz true: flip image horizontally, false: flip vertically
     * @return the processed image
     * needed to make method static to get it to run in runner class Main
     */
    public static Pixel[][] flipImage(Pixel[][] image, boolean horiz){
        Pixel[][] imageOut = new Pixel[image.length][image[0].length];
        
        /**
         * Copy image to imageOut in case image is odd number
         *  length or width
         */
        for(int row =0; row < image.length; row++) {
            for(int col = 0; col < image[0].length; col++) {
                imageOut[row][col] = image[row][col];
            }
        }
        
        if(!horiz) {//!horiz: I did it backwards: this is a vertical flip
            for(int row = 0; row < image.length; row++) {
                for(int col = 0; col < image[0].length/2; col++) {
                    
                    imageOut[row][col] = 
                            image[row][(image[0].length-1)-col];
                    imageOut[row][(image[0].length-1)-col] = 
                            image[row][col];
                    
                }
            }
        }
        else {
            for(int col = 0; col < image[0].length; col++) {
                for(int row = 0; row < image.length/2; row++) {
                    
                    imageOut[row][col] = image[(image.length-1)-row][col];
                    imageOut[(image.length-1)-row][col] = 
                            image[row][col];
                }
            }
        }
    return imageOut;  
    }// end flipImage()
 }//End Class
