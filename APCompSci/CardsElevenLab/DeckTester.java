/**
 * 
 */
package CardsElevenLab;

import java.util.ArrayList;

/**
 * @author MarcSherman
 *
 */
public class DeckTester {
    
//    private ArrayList<Integer> nums;
    
    /**
     * added this to test a question in College Board
     * AP CompSci sample questions
     */
    public static ArrayList<Integer> numsBuilder(){
        int[] numbers = {0,0,4,2,5,0,3,0};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int n : numbers) {
            nums.add(n);
        }
        return nums;
    }
    
    /**From CB APSci sample questions
     * @param nums ArrayList<Integer>
     * @return
     */
    public static ArrayList<Integer> numQuest(ArrayList<Integer> nums) {
        
        int k = 0;
        Integer zero = new Integer(0);
        
        while(k < nums.size()) {
            if( nums.get(k).equals(zero)) {
                nums.remove(k);
            }
            k++;
        }
        return nums;
    }

    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        ArrayList<Integer> nums = numsBuilder();
//        System.out.println(nums.toString());
//        numQuest(nums);
//        System.out.println(nums.toString());
        
        Deck testDeck0 = new Deck(); // Constructed as a shuffled deck
       for(Card card : testDeck0.getCards()) {
           System.out.println(testDeck0.getCards().
                   get(testDeck0.getCards().indexOf(card)));
       }
        ArrayList<Card> sortedDeck = Deck.insertionSorted(testDeck0);
        System.out.println("");
        for(Card card : sortedDeck) {
            System.out.println(sortedDeck.get(sortedDeck.indexOf(card)));
        }
//       for(Card card : testDeck0.getCards()) {
//       System.out.println(card + ", ");
//       }
//       System.out.println(testDeck0.getSize());
//       System.out.println(testDeck0.isEmpty());
//       System.out.println(testDeck0.dealCard());
//       System.out.println(testDeck0.getSize());
//       ArrayList<Card> shuffled = testDeck0.
//               effSelectionShuffle(testDeck0);
//       for(int i= 0; i < testDeck0.getCards().size(); i++) {
//           System.out.println(testDeck0.getCards().get(i)+
//                   "\t\t"+sortedDeck.get(i));
//       }
    }

}
