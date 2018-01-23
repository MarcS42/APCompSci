/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class ComplexNumbers {
    private int realPart;
    private int imagPart;
    private static final int ROOT_N1_SQRD = -1;

    public ComplexNumbers(int real, int imag) {
        realPart = real;
        imagPart = imag;
    }
    
    public int getRealPart() {
        return realPart;
    }
    
    public int getImagPart() {
        return imagPart;
    }
    
    
    /** This step not required in test question
     * @see java.lang.Object#toString()
     */
    public String toString() {
       int a = getRealPart();
       int b = getImagPart();
       if (b >= 0) {
           return (a + " +" + b + "i");
       } else {
           return (a + " " + b + "i");
       }
    }
    
    public ComplexNumbers add(ComplexNumbers toAdd) {
        int newA = getRealPart() + toAdd.getRealPart();
        int newB = getImagPart() + toAdd.getImagPart();
        ComplexNumbers sum = new ComplexNumbers(newA, newB);
        return sum;
    }
    
    public ComplexNumbers multiply(ComplexNumbers toMult) {
        int newReal = getRealPart()*toMult.getRealPart() + getImagPart()*toMult.getImagPart()*ROOT_N1_SQRD;
        int newImag = getRealPart()*toMult.getImagPart() + toMult.getRealPart()*getImagPart();
        ComplexNumbers multiply = new ComplexNumbers(newReal, newImag);
        return multiply;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        ComplexNumbers cNum1 = new ComplexNumbers(3, -5);
        System.out.println(cNum1);
        ComplexNumbers cNum2 = new ComplexNumbers(4, 6);
        System.out.println(cNum2);
        ComplexNumbers multiply = cNum1.multiply(cNum2);
        System.out.println("Multiply: " + multiply);
        ComplexNumbers sum = cNum1.add(cNum2);
        System.out.println("Add: " + sum);
    }

}
