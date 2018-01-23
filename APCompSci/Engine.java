/**
 * Precondition: maximumWeight is greater than or equal to 
 *      the weight of the engine.
 */

/**
 * @author MarcSherman
 *
 */
public class Engine {
    
    private double weight, maximumWeight;
    
    public Engine( double wt, double maxWt) {
        weight = wt;
        maximumWeight = maxWt;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public double getMaximumWeight() {
        return maximumWeight;
    }
    
    public String toString() {
        return "Weight: " + weight + " MaximumPull Weight: " +
                maximumWeight;
    }

}
