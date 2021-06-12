package data;

import java.util.ArrayList;
import java.util.Arrays;

public class Probability {
	private ArrayList<String[]> TABLE;
	
	
	public Probability(ArrayList<String[]> table) {
		this.TABLE = table;
	}
	
	/**
	 * This method searches for the index number in the chart according to the faced up dealer card and returns int number
	 * @param cardName (Face up Dealer Card)
	 * @return
	 */
	public int searchDealerCard(String cardName) {
		String[] dealerCardsRow = TABLE.get(0);
		int index = Arrays.asList(dealerCardsRow).indexOf(cardName);
		return index;
	}
	/**
	 * This method searches for the row number (Excluding Ace combinations and splits), according to players cards and returns int number
	 * @param i (First Card)
	 * @param o (Second Card)
	 * @return
	 */
	public int searchRow(String i, String o) {
		int card1 = Integer.valueOf(i);
		int card2 = Integer.valueOf(o);
		String hand = String.valueOf(card1 + card2);
		int counter = 0;
		int counter1 = 0;
		
		for (String[] row : TABLE) {
			if(row[0].equals(hand)) {
				counter1 = counter;
			}
			counter ++;
		}
		return counter1;
	}
	/**
	 * This method searches for the specific element according to the players card and dealer's face up card, returning a string of what the AI s
	 * @param row Row number (Player Card)
	 * @param column Column number (Dealer Card)
	 * @return "S", "H", "SP", "D", "Ds"
	 */
	public String searchElement(int row, int column) {
		String[] t = TABLE.get(row);
		String move = t[column];
		return move;
	}
	
}
	

