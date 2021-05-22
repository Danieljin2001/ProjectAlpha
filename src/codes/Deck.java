package codes;

import java.util.ArrayList;

public class Deck {
	private ArrayList<String> SUIT = new ArrayList<String>();
	private ArrayList<String> ELEMENT = new ArrayList<String>();
	private ArrayList<Card> CARDS = new ArrayList<Card>();
	
	//Constructor makes 52 cards
	public Deck() {
		//Adding to elements list
		ELEMENT.add("Ace");
		ELEMENT.add("Two");
		ELEMENT.add("Three");
		ELEMENT.add("Four");
		ELEMENT.add("Five");
		ELEMENT.add("Six");
		ELEMENT.add("Seven");
		ELEMENT.add("Eight");
		ELEMENT.add("Nine");
		ELEMENT.add("Ten");
		ELEMENT.add("Jack");
		ELEMENT.add("Queen");
		ELEMENT.add("King");
		
		//Adding to suit list
		SUIT.add("Heart");
		SUIT.add("Spade");
		SUIT.add("Clover");
		SUIT.add("Diamond");
		
		for(String suit : SUIT) {
			for(int i=0; i<13; i++) {
				if(i < 10) {
					CARDS.add(new Card(ELEMENT.get(i), suit, i+1));
				}
				else {
					CARDS.add(new Card(ELEMENT.get(i), suit, 10));
				}
			}
		}
	}
	
	public void getCardInfo() {
		for (Card card : CARDS) {
			System.out.println(card.toString());
		}
	}
	
}
