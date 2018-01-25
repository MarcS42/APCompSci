
public class PaperRoll {
    
    private double meters;
    
    /**
     * @param meters the meters to set
     */
    public void setMeters(double meters) {
        this.meters = meters;
    }

    public PaperRoll() {
        meters = 1000;
    }
    
    public double getMeters() {
        return meters;
    }
    
    public String toString() {
        return "Meters = : "+ getMeters()+"M";
    }

}
