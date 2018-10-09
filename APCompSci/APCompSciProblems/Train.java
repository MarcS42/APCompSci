package APCompSciProblems;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Train {
    
    private Engine engine;
    private ArrayList<TrainCar> trainCars;
    
    public Train(Engine e, ArrayList<TrainCar> tc) {
        engine = e;
        trainCars = tc;
    }
    
    
    /**Removes TrainCar objects from the end of the train until 
     * the train can be pulled by the Engine.
     * 
     * @return ArrayList<TrainCar> containing the removed cars 
     * in the order they were removed (the last car is item 0, etc.). 
     * If no cars are removed, the returned list will be empty.
     */
    public ArrayList<TrainCar> removeExcessTrainCars() {
        ArrayList<TrainCar> excessCars = new ArrayList<TrainCar>();
        
        double trainCarsWeight = 0.0;
        
        for(TrainCar c : trainCars) {
            trainCarsWeight += c.getTotalWeight(); 
        }
        
        double trainWeight = engine.getWeight() + trainCarsWeight;
        double maxTrainWeight = engine.getMaximumWeight();
        
        while (trainWeight > maxTrainWeight) {
            excessCars.add(trainCars.get(trainCars.size()-1));
            trainCars.remove(trainCars.size()-1);
            trainWeight -= excessCars.get(excessCars.size()-1).getTotalWeight();    
        }
    return excessCars;
    }//end removeXsTrainCars method
    
    

}// end Train class
