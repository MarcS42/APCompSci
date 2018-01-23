/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Order {
    private double amount;
   
    public Order(double cost) {
        amount = cost;
    }
    
    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double cost) {
        this.amount = cost;
    }
} // end class Order
