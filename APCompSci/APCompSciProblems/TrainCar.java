package APCompSciProblems;

public abstract class TrainCar {
    
    private double baseWeight;
    
    public TrainCar(double baseWt) {
        baseWeight = baseWt;
    }
    
    public double getBaseWeight() {
        return baseWeight;
    }
    
    public abstract double getTotalWeight();

}
