package codes;

import java.util.ArrayList;

public class Test {
	public static void main(String []args) throws Exception{
		/*
        Deck firstDeck = new Deck(1);
        firstDeck.getDeckInfo();
        System.out.println("Number of Decks used: "+firstDeck.getNumberOfDecks()+ "\n");
        
        
        ArrayList<Card> drawnCards = new ArrayList<Card>();
        for (int i=0; i<26; i++) {
        	drawnCards.add(firstDeck.drawCard());
        }
        for(Card card: drawnCards) {
        	System.out.println("The card drawn is " + card.toString());
        }
        System.out.println("NON-USED CARDS: \n");
        
        firstDeck.getDeckInfo();
        
        System.out.println("USED CARDS: \n");
        firstDeck.getUsedDeckInfo();
        System.out.println("\nPercentage of used Cards: "+ firstDeck.getPercentageOfUsed());
        
        System.out.println("AFTER RESET.....\n");
        firstDeck.resetDeck();
        System.out.println("NON-USED CARDS: \n");
        
        firstDeck.getDeckInfo();
        
        System.out.println("USED CARDS: \n");
        firstDeck.getUsedDeckInfo();
        System.out.println("\nPercentage of used Cards: "+ firstDeck.getPercentageOfUsed());
        */
		
		
		Deck deck = new Deck(1);
		HumanPlayer HP = new HumanPlayer(deck);
		
		deck.getDeckInfo();
		
		HP.hit();
		System.out.println("Human Players card: " + HP.getHand());
		HP.hit();
		System.out.println("Human Players card: " + HP.getHand());
		
		
		deck.getDeckInfo();
		System.out.println("USED CARDS: \n");
        deck.getUsedDeckInfo();
        System.out.println("\nPercentage of used Cards: "+ deck.getPercentageOfUsed());
        
        
        deck.resetDeck();
        HP.clearHand();
        System.out.println("USED CARDS: \n");
        deck.getUsedDeckInfo();
        System.out.println("Human Players card: " + HP.getHand());
        
        deck.getDeckInfo();
        HP.hit();
		System.out.println("Human Players card: " + HP.getHand());
		HP.hit();
		System.out.println("Human Players card: " + HP.getHand());
		
		deck.getDeckInfo();
		System.out.println("USED CARDS: \n");
        deck.getUsedDeckInfo();
        
        
        
		
       
	}
}
