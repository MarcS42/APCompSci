/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class LocationNumerical {
    
    private static final String LN_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /**Returns the decimal value of a single LN letter
     * 
     * @param letter String containing a single LN letter
     * @return the decimal value of that letter
     * 
     * Precondition: the parameter contains a single uppercase letter
     */
    public int getLetterValue(String letter) {
        
        String letters = LN_LETTERS;
        int lnValue = (int)Math.pow(2, letters.indexOf(letter)); 
        return lnValue;
    }
    
    /**Return the LN letter representation for a
     *  decimal value that is a power of 2.
     *  
     * @param value the decimal value to be converted to an LN letter
     * @return the corresponding LN letter
     * Precondition: The parameter must be an integer power of 2, between
     *      2 raised to the power 0 and 2 raised to the power of 25. 
     */
    public String getLetter(int value) {
        String binary = "";
        if(value == 0) {
            return "A";
        }  // converts integer to binary, 
           //then uses the length of the binary string to convert
           //to a letter using substring methods.
        while(value > 0) {
            int rem = value % 2;
            binary += rem;
            value = value/2;
        }
        //need to use length()-1 and length in substring() 
        //                         (lgth-1=25, lgth=26).
        return LN_LETTERS.substring(binary.length()-1, binary.length()); 
    }
    
    /**Returns the decimal value of a simplified LN
     * 
     * @param numeral is String representing a LN
     * @return the decimal value of the LN.
     * 
     * Precondition: The characters in the parameter are
     *               uppercase letters A-Z only.
     */
    public int getDecimalValue(String numeral) {
        int sum = 0;
        for(int i =0; i < numeral.length(); i++) {
            sum += getLetterValue(numeral.substring(i, i+1));
        }
    return sum;
    }// end getDecimalValue(String numeral)
    
    /**Sorts the letters of an LN into alphabetical order.
     * 
     * Note:Strings are immutable => cannot be sorted; so
     * you need to convert the string to Char array, sort it,
     * and then convert Char array to String
     * 
     * @param numeral String representing an LN
     * @return sorted String in alphabetical order.
     */
    public String sortLN(String numeral) {
        return new String(charInsertionSort(numeral.toCharArray()));
    } //converts numeral to Char[], calls charInsSort().
    public String charInsertionSort(char[] array) {
         for(int i=1; i < array.length; i++) {
             char temp = array[i];
             int index = i;
             while(index > 0 && (temp < array[index-1])) {
                 array[index] = array[index-1];
                 index--;
             }
         array[index]= temp;
         }
    return new String(array); //converts Char array to String
    }//end charInsertionSort(char[] array)
    
    
    /** Adds two LNs and returns a simplified result(String)
     * 
     * @param num1 String representing first LN addend
     * @param num2 String representing second LN addend
     * @return A String which represents the sum as a simplified LN
     * 
     * Precondition: The characters in the parameters are
     *               uppercase letters A-Z only.
     * Postcondition: The letters in the return String are in
     *                alphabetical order and no letter occurs 
     *                more than once.              
     */
    public String add(String num1, String num2) {
        
        String simpleSum = num1 + num2;
        while(hasMatchingLetters(simpleSum) && simpleSum.length() > 1) {
            for (int i = 0; i < simpleSum.length()-1; i++) {
                simpleSum = sortLN(simpleSum);
                if (simpleSum.substring(i, i + 1).equals(
                        simpleSum.substring(i + 1, i + 2))) {
                    String newLetter = getLetter(getLetterValue(
                            simpleSum.substring(i, i + 1))*2);
                    simpleSum = simpleSum.substring(0,i) + 
                            simpleSum.substring(i + 2) + newLetter;
                }
            }
        }
        return simpleSum;
        }
    
    /**Returns true if stringIn has consecutive matching letters
     * 
     * @param stringIn
     * @return true if stringIn has consecutive letters that match
     * 
     * Precondition: stringIn only contains uppercase letters A-Z.
     */
    public boolean hasMatchingLetters(String stringIn) {
        String matchTest = sortLN(stringIn);
        if (matchTest.length() > 1) {
            for (int i = 0; i < matchTest.length() - 1; i++) {//need matchTest.length()-1 
                //or you get indexOutOfBounds error at (i+1, i+2) 
                //if length=2, i+2 = 3 => IndexOutOfBounds              
                if (matchTest.substring(i, i + 1).equals(
                        matchTest.substring(i + 1, i + 2))) {
                    return true;
                }
            }
        }
        return false;
    }
    
}// End LN class
