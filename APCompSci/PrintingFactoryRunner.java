import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class PrintingFactoryRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrintingFactory factory1 = new PrintingFactory(20);

        /**Now you have a factory with 20 machine slots, need to
         * install the machines. Couldn't get for-each to work 
         * Machines is a private Regular array object in 
         * PrintingFactory
         */
        for(int i=0; i < factory1.getMachines().length; i++) {
            factory1.getMachines()[i] = 
                    new Machine(new PaperRoll());
        }
        
        /**
         * PrintingFactory ArrayList(s) newRolls and usedRolls are
         * private instance variables, and not included in constructor,
         * so need to use full reference and access via getters().
         */
        ArrayList<PaperRoll> myNewRolls = factory1.getNewRolls();
        ArrayList<PaperRoll> myUsedRolls = factory1.getUsedRolls();
        for(int i=0; i < 25; i++) {//adds 25 newPaperRolls to AL
            myNewRolls.add(new PaperRoll());
        }
        for(Machine m : factory1.getMachines()) {
            m.getPaperRoll().setMeters(Math.random()*11);//set meters 0
                    //to 10 so that more will be < 4.0 - need changing
            System.out.printf("%10.2f",m.getPaperRoll().getMeters());
        }
        
        System.out.println();
        
        factory1.replacePaperRolls();
        for(Machine m : factory1.getMachines()) {
            System.out.printf("%10.2f",m.getPaperRoll()
                    .getMeters()); //%10.2f means 10spaces 
                            //with 2 digits after the decimal   
        }
        int usedRolls = myUsedRolls.size();
        System.out.println();
        System.out.printf("Paper Meters Used: %8.1f"+"M " + 
        "RollsUsed: %d"+" rolls",factory1.getPaperUsed(), usedRolls);
    }//end main(String[] args)

}//End PrintingFactoryRunner
