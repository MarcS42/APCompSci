package printingFactoryEx2Pgm3;
/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Machine {
    
    private PaperRoll paper;
    
    public Machine(PaperRoll roll) {
        paper = roll;
    }
    
    public PaperRoll getPaperRoll() {
        return paper;
    }
    
    /**Returns the current partial roll 
     *           and replaces it with the new roll
     * 
     * @param pRoll - a new full PaperRoll
     * @return PaperRoll the old nearly empty PaperRoll 
     */
    public PaperRoll replacePaper(PaperRoll pRoll) {
        PaperRoll usedRoll = getPaperRoll();
        paper = pRoll;
        
        return usedRoll;
    }//end replacePaper method


}// End Machine class
