/**
 * 
 */
package APCompSciProblems;

/**
 * @author MarcSherman
 *
 */
public class Person2 {
//Declare instance variable(s)
 private String lName;
 private String fName;
 
 // Add the new Instance variables here
 private String schoolName;
 private String emailDomaine;
 // Add the new getters and setters here
 public String getSchoolName()
 {
   return schoolName;
 }
 public String getEmailDomaine()
 {
   return emailDomaine;
 }
 
 public void setSchoolName(String school)
 {
   schoolName=school;
 }
 
 public void setEmailDomaine(String emailDomaineName)
 {
   emailDomaine=emailDomaineName;
 }
 // Add the getEmailAddress method here
 public String getEmailAddress()
 {
   String emailAddress = getFirstName().substring(0,1)+getLastName()+"@"+getEmailDomaine();
   if(emailAddress.indexOf(" ")>0)
   {
     emailAddress=emailAddress.substring(0,emailAddress.indexOf(" "))+
       emailAddress.substring(emailAddress.indexOf(" ")+1);
   }
   return emailAddress;
 }

 // Constructor methods(s)
 // - Default Constructor
 public Person2()
 {
   lName = "Doe";
   fName = "J";
 }
 // - Overloaded Constructor(s)
 public Person2(String setLast, String setFirst)
 {
   lName = setLast;
   fName = setFirst;
 }

 // Setter method(s) 
 public void setLastName(String setLast) { lName = setLast;}
 public void setFirstName(String setFirst) { fName = setFirst;}

 // Getter method(s)
 /** @return the name in "First Last" format */ 
 public String getName()
 {
   return getFirstName() + " " + getLastName();
 }
 
 /** @return the name in "Last, First" format */
 public String getSortName()
 {
   return getLastName() + ", " + getFirstName();
 }
 public String getLastName() {return lName;}
 public String getFirstName() {return fName;}
}
