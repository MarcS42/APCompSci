package CardsElevenLab;
import java.util.List;

/**
 * The ElevensBoard class represents the board in 
 * a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
//	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
	    if(selectedCards.size() > 1 && selectedCards.size() 
	            < 4) {
	        if(selectedCards.size() < 3) {
	            return containsPairSum11(selectedCards);
	        }
	        return containsJQK(selectedCards);
	    }
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
	    if(containsPairSum11(cardIndexes()) || 
	            containsJQK(cardIndexes())) {
	        return true;
	    }
		return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                of indexes into this board that are searched
	 *                to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	/**To Do Return PairSum method to private
	 * 
	 * @param selectedCards
	 * @return
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		if(selectedCards.size()==3) {
		    return false;
		}
	    if(selectedCards.size()==2) {
		    if(cardAt(selectedCards.get(0)).getPointValue()  + 
		      cardAt(selectedCards.get(1)).getPointValue() == 11) {
		        return true;
		    }else {
		        return false;
		    }
		}
	    for(int i1=0; i1 < selectedCards.size(); i1++) {
		    for(int i2 = 0; i2 <selectedCards.size(); i2++) {
		        if(cardAt(selectedCards.get(i1)).getPointValue()  + 
		            cardAt(selectedCards.get(i2)).getPointValue() == 11) {
	                return true;
		        }
		    }
		}
	  return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * 
	 * Enhanced for loop doesn't work some times, so backed it up
	 * with regular For loop so that one or both get through.
	 * 
	 * @param selectedCards selects a subset of this board. 
	 *  It is a list of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 *private 
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
	    if(selectedCards.size() < 3) {
	        return false;
	    }
	    int j = 0, q = 0, k = 0;
	    if(selectedCards.size() > 3) {
	        for(Integer s : selectedCards) {
	            if(cardAt(selectedCards.get(s)).getRank().
	                    equals("jack")) j=1; 
	            if(cardAt(selectedCards.get(s)).getRank().
                        equals("queen")) q=1;
	            if(cardAt(selectedCards.get(s)).getRank().
                        equals("king")) k=1;
	        }
	    }
	        for(int i = 0; i < 3; i++) {
	        if(cardAt(selectedCards.get(i)).getRank().
                    equals("jack")) j=1;
            if(cardAt(selectedCards.get(i)).getRank().
                    equals("queen")) q=1;
            if(cardAt(selectedCards.get(i)).getRank().
                    equals("king")) k=1;
	        }
	    if((j + q + k)>=3) {
	        return true;
	    }
	return false;
	}
	
	public static void printCards(ElevensBoard board) {
	    List<Integer> cIndexes = board.cardIndexes();
	    for(Integer cIndex : cIndexes) {
	        System.out.println(board.cardAt(cIndex));
	    }
	}
}
