package APCompSciProblems;

public class HeightRunner {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
Height ht1 = new Height(3,26);
Height ht2 = new Height(23);
System.out.println("Feet =: " + ht2.getFeet()+ " inches =: " + ht2.getInches());
ht1.add(45);
System.out.println("Feet =: " + ht1.getFeet()+ " inches =: " + ht1.getInches());
ht1.add(ht2);
System.out.println("Feet =: " + ht1.getFeet()+ " inches =: " + ht1.getInches());
    }

}
