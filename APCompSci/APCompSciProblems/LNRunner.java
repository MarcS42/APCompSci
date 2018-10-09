package APCompSciProblems;
/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class LNRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LocationNumerical ln1 = new LocationNumerical();
        String letter = "P";
        String testStr = "BAXFWJ";
        String num1 = "AB";
        String num2 = "ACD";
        int number = 65536;
        String numeral = "ABFCP";
        System.out.println("Value of: " + letter + "  " +
                  ln1.getLetterValue(letter));
        System.out.println("Letter of: " + number + "  " +
                ln1.getLetter(number));
        System.out.println("Letter of: " + testStr + "  " +
                ln1.sortLN(testStr));
        System.out.println("DecimalValue of: " + numeral + "  " +
                ln1.getDecimalValue(numeral));
        System.out.println("Test num1 In: " + num1 + " Test num2 in: "
                + num2 + " Equals "  + ln1.add(num1, num2));
    }

}
