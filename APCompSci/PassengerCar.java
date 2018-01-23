/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class PassengerCar extends TrainCar {
    
    private int numberOfSeats;
    private static final double AVG_WT_PAX = 300; 
    
    public PassengerCar(double baseWt, int numSeats) {
        super(baseWt);
        numberOfSeats = numSeats;
    }
    
    public String toString() {
    return "BaseWeight: " + getBaseWeight() + " NumberofSeats: " +numberOfSeats
            + " TotalWeight: " + getTotalWeight();
    }

    /* (non-Javadoc)
     * @see TrainCar#getTotalWeight()
     * notice use of super to access baseweight
     */
    @Override
    public double getTotalWeight() {
        double totalWeight = numberOfSeats * AVG_WT_PAX + super.getBaseWeight();
        return totalWeight;
    }

}
