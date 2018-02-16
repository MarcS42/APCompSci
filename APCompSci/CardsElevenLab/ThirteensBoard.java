package CardsElevenLab;
import java.util.List;

/**
 * The ThirteensBoard class represents the board in 
 * a game of Thirteens.
 */
public class ThirteensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 10;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", 
		        "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

	/**
	 * Flag used to control debugging print statements.
	 */
//	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ThirteensBoard</code> instance.
	 */
	 public ThirteensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteens, the legal groups are (1) a pair of  cards
	 * whose values add to 13, and (2) any King.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
	    if(selectedCards.size() > 0 && selectedCards.size() 
	            < 3) {
	        if(selectedCards.size() ==2) {
	            return containsPairSum13(selectedCards);
	        }
	        return containsKing(selectedCards);
	    }
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, there is a legal play if the board contains
	 * (1) a pair of cards whose values add to 13, or (2) a king.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
	    if(containsPairSum13(cardIndexes()) || 
	            containsKing(cardIndexes())) {
	        return true;
	    }
		return false;
	}

	/**
	 * Check for an 13-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  
	 * It is list of indexes into this board that are searched
	 *                to find a 13-pair.
	 * @return true if the board entries in selectedCards
	 *              contain a 13-pair; false otherwise.
	 */
	/**To Do Return PairSum method to private after debugging
	 * 
	 * @param selectedCards
	 * @return
	 */
	private boolean containsPairSum13(List<Integer> selectedCards) {
		if(selectedCards.size()==1) {
		    return false;
		}
	    if(selectedCards.size()==2) {
		    if(cardAt(selectedCards.get(0)).getPointValue()  + 
		      cardAt(selectedCards.get(1)).getPointValue() == 13) {
		        return true;
		    }else {
		        return false;
		    }
		}
	    /**
	     * When selectedCards equals all Cards on board
	     */
	    for(int i1=0; i1 < selectedCards.size(); i1++) {
		    for(int i2 = 0; i2 <selectedCards.size(); i2++) {
		        if(cardAt(selectedCards.get(i1)).getPointValue()  + 
		            cardAt(selectedCards.get(i2)).getPointValue() 
		            == 13) {
	            return true;
		        }
		    }
		}
	  return false;
	}

	/**
	 * Check for a King in the selected cards.
	 * @param selectedCards selects a subset of this board. 
	 *  It is a list of indexes into this board that are searched
	 *                      to find a King.
	 * @return true if the board entries in selectedCards
	 *              include a king; false otherwise.
	 *private needed if not debugging
	 */
	private boolean containsKing(List<Integer> selectedCards) {
        if (selectedCards.size() == 1) {
            if (cardAt(selectedCards.get(0)).getRank().equals("king")) {
                return true;
            } else {
                return false;
            }
        }  
        int k = 0;
        if (selectedCards.size() > 1) {
//            for (Integer s : selectedCards) {
//                if (cardAt(selectedCards.get(s)).getRank()
//                        .equals("king"))
//                    k++;
//            } for some reason you get indexoutofbounds with this if 4 kings are left on board
            int i;
            for (i = 0; i < selectedCards.size(); i++) {
                if (cardAt(selectedCards.get(i)).getRank().equals("king")) {
                    k++;
                }
            }
        }
        if (k >= 1) {
            return true;
        }
	return false;
	}
	
	public static void printCards(ThirteensBoard board) {
	    List<Integer> cIndexes = board.cardIndexes();
	    for(Integer cIndex : cIndexes) {
	        System.out.println(board.cardAt(cIndex));
	    }
	}
}
