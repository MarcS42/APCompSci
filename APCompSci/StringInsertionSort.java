
public class StringInsertionSort {

    
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
    }
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
    return new String(array);
    }//end sortLN and charInsertionSort(Char array)

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringInsertionSort strTest = new StringInsertionSort();
        String testStr = "BAXFWJ";
        System.out.print("Test String In: " + testStr + 
                " Equals "  + strTest.sortLN(testStr));

    }

}
