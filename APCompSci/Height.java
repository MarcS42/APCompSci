/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Height {
    private int feet;
    private int inches;
    
    public Height(int ft, int inch) {
        feet = ft;
        inches = inch;
        simplify();
    } // end 2 parameter constructor
    
    public Height (int inch) {
        feet = inch/12; // uses integer division
        inches = inch % 12;
    } // end 1 parameter constructor

    public final int getFeet() {
        return feet;
    }

    public final int getInches() {
        return inches;
    }
    
    public void simplify() {
        if(inches >= 12) {
            feet = feet + inches/12;
            inches = inches % 12;
        }//end if
    }//end simplify method
    
    public void add(int inch) {
        inches = this.getInches() + inch;
        this.simplify();
    }//end addInches
    
    public void add(Height ht) {
        this.inches = inches + ht.inches;
        this.feet = feet + ht.feet;
        this.simplify();
    }//end add Height objects

}// End class Height
