package APCompSciProblems;
import java.util.ArrayList;
/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Family {
    
    private String familyName;
    private ArrayList<Person> adults = new ArrayList<Person>();
    private ArrayList<Person> children = new ArrayList<Person>();
    
    public Family(Person p, String name) {
        add(p);
        familyName = name;
    }//end constructor
    
    public void add(Person p) {
        if(p.getAge() >= 18) {
            adults.add(p);
        } else {
            children.add(p);
        }
    }//end add() method
    
    public boolean isInFamily(Person p) {
        for(Person a:adults) {
            if(a.matches(p)) return true;
        }
            for(Person c:children) {
                if( c.matches(p)) return true;
            }
    return false;
    }
    
    public String getFamilyName() {
        return familyName;
    }

    public ArrayList<Person> getAdults() {
        return adults;
    }

    
    public ArrayList<Person> getChildren() {
        return children;
    }
 
}//End Family class
