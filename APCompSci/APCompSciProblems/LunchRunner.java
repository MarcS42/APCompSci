package APCompSciProblems;
import java.util.ArrayList;

/**
 * Runner for finding Total of All orders in school lunch room.
 * accesses classes Order and Day(tracks all orders for given Day)
 */

/**
 * @author MarcSherman
 *
 */
/**
 * @author MarcSherman
 *
 */
public class LunchRunner {
    
    /**
     * This method must be part of lunch runner class and NOT part of
     * PublicstaticMain(Strings[] args)
     * @param allDays holds Day objects that contain all Order objects
     * for a given Day
     * @return $ Sum of all orders over all days
     */
    public static double getTotalOfOrders(ArrayList<Day> allDays) {
        double totalOrders = 0.0;
        for(Day day:allDays) {
            for(Order order:day.getOrdersForTheDay()) {
                totalOrders += order.getAmount();
            }
        }
        return totalOrders;   
    }

    /**
     * @param args
     * Created 3 Days with 3 Orders per Day
     */
    public static void main(String[] args) {
        Order order1 = new Order(12.50);
        Order order2 = new Order(11.25);
        Order order3 = new Order(9.75);
        
        Order order4 = new Order(10.50);
        Order order5 = new Order(13.25);
        Order order6 = new Order(7.75);
        
        Order order7 = new Order(15.50);
        Order order8 = new Order(14.25);
        Order order9 = new Order(8.75);
        
        Day day1 = new Day();
        day1.addOrder(order1);
        day1.addOrder(order2);
        day1.addOrder(order3);
        
        Day day2 = new Day();
        day2.addOrder(order4);
        day2.addOrder(order5);
        day2.addOrder(order6);
        
        Day day3 = new Day();
        day3.addOrder(order7);
        day3.addOrder(order8);
        day3.addOrder(order9);
        
        ArrayList<Day> allDays = new ArrayList<Day>();
        allDays.add(day1);
        allDays.add(day2);
        allDays.add(day3);
        
        System.out.println(getTotalOfOrders(allDays));
    }

}
