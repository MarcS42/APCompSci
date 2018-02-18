package CardsElevenLab;
import java.util.List;

/**
 * The TensBoard class represents the board in 
 * a game of Tens.
 */
public class TensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 13;

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
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = true;


	/**
	 * Creates a new <code>TensBoard</code> instance.
	 */
	 public TensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Tens, the legal groups are (1) a pair of  cards
	 * whose values add to 10, and (2) any quartet of Tens, Jacks, Queens,
	 *  Kings (i.e 10-hearts, 10- clubs, 10-diamonds, 10-spades, etc.).
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2) {
            return containsPairSum10(selectedCards);
        }
        if (selectedCards.size() == 4) {
            return containsQuartet(selectedCards);
        }
        return false;
    }

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Tens, there is a legal play if the board contains
	 * (1) a pair of cards whose values add to 10, or 
	 * (2) a quartet of 10's, jacks, queens, or kings.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
	    if(containsPairSum10(cardIndexes()) || 
	            containsQuartet(cardIndexes())) {
	        if(I_AM_DEBUGGING) {
                System.out.println("containsPairSum10: " + containsPairSum10(cardIndexes()));
            }
	        if(I_AM_DEBUGGING) {
                System.out.println("containsQuartet: " + containsQuartet(cardIndexes()));
            }
	        return true;
	    }
		return false;
	}

	/**
	 * Check for an 10-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  
	 * It is list of indexes into this board that are searched
	 *                to find a 10-pair.
	 * @return true if the board entries in selectedCards
	 *              contain a 10-pair; false otherwise.
	 */
	/**To Do: Return PairSum method to private after debugging
	 * 
	 * @param selectedCards
	 * @return
	 */
	private boolean containsPairSum10(List<Integer> selectedCards) {
	    if(selectedCards.size()==2) {
		    if(cardAt(selectedCards.get(0)).getPointValue()  + 
		      cardAt(selectedCards.get(1)).getPointValue() == 10) {
		        return true;
		    }else {
		        return false;
		    }
		}
	    /**
	     * When selectedCards equals all Cards on board as in
	     * anotherPlayIsPossible()
	     * 
	     * Interesting problem with this algorithm: since 10 is even:
	     *  need to filter if
	     * one card on board is a "five" or get 'false positive'!
	     */
        for (int i1 = 0; i1 < selectedCards.size(); i1++) {
            for (int i2 = 0; i2 < selectedCards.size(); i2++) {
                
                if (cardAt(selectedCards.get(i1)).getPointValue()
                        + cardAt(selectedCards.get(i2)).getPointValue() == 10) {
                    if(cardAt(selectedCards.get(i1)).equals(cardAt(selectedCards.get(i2)))) {
                        continue;// most elegant solution!
                    }else {
                    
                    if(I_AM_DEBUGGING) {
                        System.out.println("cardAt(i1) no 5 " + cardAt(selectedCards.get(i1)));
                        System.out.println("cardAt(i2) no 5 " + cardAt(selectedCards.get(i2)));
                    }
                    
                    return true;
                    }
                }
            }
        }
        return false;
    }

	/**
	 * Check for a Quartet in the selected cards.
	 * @param selectedCards selects a subset of this board. 
	 *  It is a list of indexes into this board that are searched
	 *           to find a quartet of tens, jacks, queens, or kings.
	 * @return true if the board entries in selectedCards
	 *              include a quartet; false otherwise.
	 *private needed if not debugging
	 */
	private boolean containsQuartet(List<Integer> selectedCards) {
        int ten = 0; int j=0; int q=0; int k=0;
        if (selectedCards.size() > 3) {
            int i;
            for (i = 0; i < selectedCards.size(); i++) {
                if (cardAt(selectedCards.get(i)).getRank().equals("10")) {
                    ten++;
                }
                if (cardAt(selectedCards.get(i)).getRank().equals("jack")) {
                    j++;
                }
                if (cardAt(selectedCards.get(i)).getRank().equals("queen")) {
                    q++;
                }
                if (cardAt(selectedCards.get(i)).getRank().equals("king")) {
                    k++;
                }
            }
        if (ten >= 4 || j >=4 || q >= 4 || k >= 4) {
            return true;
        }
	}
	return false;
	}
	
	public static void printCards(TensBoard board) {
	    List<Integer> cIndexes = board.cardIndexes();
	    for(Integer cIndex : cIndexes) {
	        System.out.println(board.cardAt(cIndex));
	    }
	}
}
