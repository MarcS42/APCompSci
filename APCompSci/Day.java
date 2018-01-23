import java.util.List;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Day {
    
    private List<Order> ordersForTheDay;
    
    public Day() {
        ordersForTheDay = new ArrayList<Order>();
    }
    
    public void addOrder(Order order) {
        ordersForTheDay.add(order);
    }

    /**
     * @return the ordersForTheDay
     */
    public List<Order> getOrdersForTheDay() {
        return ordersForTheDay;
    }

    /**
     * @param ordersForTheDay the ordersForTheDay to set
     */
    public void setDaysOrders(List<Order> daysOrders) {
        this.ordersForTheDay = daysOrders;
    }
} //End class Day
