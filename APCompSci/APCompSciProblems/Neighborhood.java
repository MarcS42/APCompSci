package APCompSciProblems;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Neighborhood {
    
    ArrayList<Family> families = new ArrayList<Family>();
    
    public void addFamily(Family newFamily) {
        families.add(newFamily);
    }
    
    public boolean isInNeighborhood(Person p) {
        for(Family f : families) {
              if(f.isInFamily(p)) {
                  return true;
              }
        }
    return false;
    }

}
