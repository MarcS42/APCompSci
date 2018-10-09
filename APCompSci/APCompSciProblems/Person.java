package APCompSciProblems;
/**
 * 
 */

/**
 * @author MarcSherman
 *
 */
public class Person {
    
    private String name;
    private int age;
    
    public Person(String myName, int myAge) {
        name = myName;
        age = myAge;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public boolean matches(Person p) {
        if(this.getName().equals(p.getName())){
            if(this.getAge()==p.getAge()) {
                return true;
            }
        }
    return false;
    } 
    
    public String toString() {
        return getAge() + " " + getName();
    }
}
