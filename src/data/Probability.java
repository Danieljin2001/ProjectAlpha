package data;

import java.util.ArrayList;
import java.util.Arrays;

public class Probability {
	
	private ArrayList<String[]> TABLE;
	public Probability(ArrayList<String[]> table) {
		this.TABLE = table;
	}
	public int getDealerCard(String cardName) {
		String[] dealerCardsRow = TABLE.get(0);
		int index = Arrays.asList(dealerCardsRow).indexOf(cardName);
		return index;
	}
	public int getRow(String i, String o) {
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
	public String getElement(int row, int column) {
		String[] t = TABLE.get(row);
		String move = t[column];
		return move;
	}
	
	public void tester(String d, String c1, String c2) {
		int x = getRow(c1, c2);		
		int y = getDealerCard(d);
		String move = getElement(x,y);
		System.out.println(move);
	}
	
}
