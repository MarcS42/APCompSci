import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class PrintingFactory {
    
    //All machines available in the company
    private Machine[] machines;
    
    /**
     * @return the machines
     */
    public Machine[] getMachines() {
        return machines;
    }

    //Available full paper rolls (1000 meters each)
    private ArrayList<PaperRoll> newRolls = new ArrayList<PaperRoll>();
    
    /**
     * @return the newRolls
     */
    public ArrayList<PaperRoll> getNewRolls() {
        return newRolls;
    }

    /**
     * @return the usedRolls
     */
    public ArrayList<PaperRoll> getUsedRolls() {
        return usedRolls;
    }

    //The used roll remnants (less than 4.0 meters each)
    private ArrayList<PaperRoll> usedRolls = new ArrayList<PaperRoll>();
    
    public PrintingFactory(int numMachines) {
        machines = new Machine[numMachines];
    }
    
    /**Replaces the PaperRoll for any Machine that has a
     * PaperRoll with less than 4.0 meters remaining.
     * The used roll is added to usedRolls.
     * A new roll is removed from newRolls.
     * 
     * Precondition: newRolls is not empty. 
     */
    public void replacePaperRolls() {
//        for(int i =0; i < machines.length; i++) {
//            if(machines[i].getPaperRoll().getMeters() 
//                    < 4.0 && newRolls.size()>0) {
//                usedRolls.add(machines[i].replacePaper(newRolls.remove(newRolls.size()-1)));
//            }
//        }
        for(Machine m : machines) {
            if(m.getPaperRoll().getMeters()<4.0 && 
                    !newRolls.isEmpty()) {
                usedRolls.add(m.replacePaper(newRolls.remove(
                        newRolls.size()-1)));
            }
        }
    }
    
    /**Returns the total amount of paper that has been used.
     * 
     * @return the total amount of paper that has been used from
     * the PaperRolls in the usedRolls list, plus the paper that
     * has been used from the PaperRolls on the machines.
     */
    public double getPaperUsed() {
        double sumMachines =0, sumUsed = 0;
        for(Machine m:machines) {
            sumMachines += (1000-m.getPaperRoll().getMeters());
        }
        for(PaperRoll u:usedRolls) {
            sumUsed += 1000-u.getMeters();
        }
    return sumUsed +sumMachines;    
    }
}
