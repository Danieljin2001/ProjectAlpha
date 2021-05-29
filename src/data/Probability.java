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
		int card1 = 0;
		int card2 = 0;
		int counter = 0;
		int counter1 = 0;
		ArrayList<String> hand = new ArrayList<String>();
		hand.add(i);
		hand.add(o);
		if (i.equals(o)) {
			hand.add(0, i + "+" + o);
		} else if (hand.contains("Ace") == true) {
			int Ace = hand.indexOf("Ace");
			hand.remove(Ace);
			hand.add(0, "Ace");
			hand.add(0, hand.get(0) + "+" + hand.get(1));
		} else {
			card1 = Integer.valueOf(i);
			card2 = Integer.valueOf(o);
			hand.add(0, String.valueOf(card1 + card2));
		}
		for (String[] row : TABLE) {
			if(row[0].equals(hand.get(0))) {
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
	public void tester(String card1, String card2, String dcard) {
		int DealerCard = searchDealerCard(dcard);
		int PlayerCard = searchRow(card1, card2);
		String move = searchElement(PlayerCard, DealerCard);
		System.out.println(move);
	}
}
	

