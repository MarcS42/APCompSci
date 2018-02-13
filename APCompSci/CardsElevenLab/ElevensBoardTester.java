package CardsElevenLab;
//import java.util.List;
//import java.util.ArrayList;


public class ElevensBoardTester {

    /**To run ElevensBoardTester, need to change helper methods in
     *     ElevensBoard.java to package visibility by removing 
     *     'private' access keywords.
     * @param args
     */
    public static void main(String[] args) {
       
        /** Testing Board.newGame()
         * 
         */
        Board board11 = new ElevensBoard();
        board11.newGame();
        
//        /**
//         * Testing isLegal(), containsJQK(), and containsPair11Sum()
//         */
//        int count =0;
//        for(int runs =0; runs < 10000; runs++) {
//        ElevensBoard board11 = new ElevensBoard();
//         int c1 = (int)(Math.random()*9);//You need the Para's to cast
//         int c2 = (int)(Math.random()*9);
//         int c3 = (int)(Math.random()*9);
//         int twoOrThreeCheck = (int)(Math.random()*2)+2;
//        List<Integer> selectedCards = new ArrayList<Integer>();
//        for(int i = 0; i < twoOrThreeCheck; i++ ) {//Need to initialize AL to use '.set'.
//            selectedCards.add(null);//cannot just add randomval c's as get 
//            //IndexOutofBounds error in JQK()
//        }
//        selectedCards.set(0, c1);
//        selectedCards.set(1, c2);
//        if(twoOrThreeCheck == 3) selectedCards.set(2, c3);
//        
////        List<Integer> selectedCards = board11.cardIndexes();
////            if(!board11.containsPairSum11(selectedCards)) {
////        if(board11.containsJQK(selectedCards)) {
////        if(!board11.anotherPlayIsPossible()) {
//        if(board11.isLegal(selectedCards)) {
//        count++;
//                ElevensBoard.printCards(board11);
////                System.out.println(board11.containsPairSum11(selectedCards));
////                System.out.println(board11.containsJQK(selectedCards));
////                System.out.println(board11.anotherPlayIsPossible());
//                System.out.println(board11.isLegal(selectedCards) + 
//                        " c1: " + c1 +" c2: " + c2 +" c3: " + 
//                        c3 +" twoThreeCheck: " + twoOrThreeCheck);
//                System.out.println();
//            }
//        }
//        System.out.println(count);
        

    }

}
