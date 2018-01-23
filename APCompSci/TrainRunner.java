import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class TrainRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Engine myEngine = new Engine(200000, 475000);
//        PassengerCar pax1 = new PassengerCar(100000,100);
        
        /**
         * Used all Pax Cars to make up test train
         */
        TrainCar trainCar0 = new PassengerCar(70000,100); // 100k TC
        TrainCar trainCar1 = new PassengerCar(120000, 100); // 150k TC
        TrainCar trainCar2 = new PassengerCar(20000, 100); //50k
        TrainCar trainCar3 = new PassengerCar(70000, 100); //100k
        TrainCar trainCar4 = new PassengerCar(20000, 100); //50k TC
        ArrayList<TrainCar> myTrain = new ArrayList<TrainCar>();
        myTrain.add(trainCar0);
        myTrain.add(trainCar1);
        myTrain.add(trainCar2);
        myTrain.add(trainCar3);
        myTrain.add(trainCar4);
        
        

//        System.out.println(pax1);
        Train train1 = new Train(myEngine, myTrain);
        System.out.println(myEngine);
        for(TrainCar t:myTrain)
        System.out.println(t);
        System.out.println();
        
        train1.removeExcessTrainCars();
        System.out.println(myEngine);
        for(TrainCar t:myTrain)
        System.out.println(t);
        
    }

}
