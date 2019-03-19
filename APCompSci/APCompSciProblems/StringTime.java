package APCompSciProblems;

public class StringTime {
  private String[] schedule= {"Calculus", "History", "Biology", "Computer Science", "English", "PE"};
  
  public String getLocation(String time)
  {
      String sMilitary = time.substring(0,2)+time.substring(3);
      int military=Integer.parseInt(sMilitary);
      if(military>=0700 && military<=1559)
      {
        return "ClassRoom";
      } else return "Home";
  }
  
  public String getCurrentLocation(String time)
  {
    String sMilitary = time.substring(0,2)+time.substring(3);
    int military=Integer.parseInt(sMilitary);
      if(military>=800 && military<=859)  return schedule[0];
        
      else if(military>=900 && military<=959) return schedule[1];
        
      else if(military>=1000 && military<=1059) return schedule[2];
        
      else if(military>=1100 && military<=1159) return schedule[3];
        
      else if(military>=1200 && military<=1259) return "Lunch";
        
      else if(military>=1300 && military<=1359) return schedule[4];
        
      else if(military>=1400 && military<=1459) return schedule[5];
        
      else return "Home";
    
  }

  public static void main(String[] args)
  {
    String time="08:01";
    StringTime ST1 = new StringTime();
    System.out.println("At "+time+" is at "+ST1.getCurrentLocation(time));
    // TODO Auto-generated method stub

  }

}
