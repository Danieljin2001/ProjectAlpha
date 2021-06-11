package codes;

import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	public static void main(String []args) throws Exception{
		/*
		Deck deck = new Deck(1);
		HumanPlayer player = new HumanPlayer(deck, 1000.00, "Test Player");
        
		int play = 0;
		
		
		
		while (play != 10) {
			System.out.print("Hit? (10 to stop): ");
			Scanner p = new Scanner(System.in);
			play = p.nextInt();
			
			System.out.println("You hit: " + player.hit());
			System.out.println("Your hand: " + player.getHand());
			System.out.println("Your hand total value: " + player.getHandValue());
			if (player.getHandValue() > 21) {
				System.out.println("You Lost!");
				player.clearHand();
			}
			else if (player.getHandValue() == 21) {
				System.out.println("BLACKJACK!");
				player.clearHand();
			}
			
			if (play == 5) {
				System.out.println("Used Cards: \n");
				deck.getUsedDeckInfo();
				System.out.println("Unused Cards: \n");
				deck.getDeckInfo();
				
			}
			
		}
        
        
		
       
	}*/
	
	Deck deck = new Deck(1);
	ArrayList<Player> players = new ArrayList<Player>();
	HumanPlayer human = new HumanPlayer(deck,1000.00, "Daniel");
	AiPlayer ai = new AiPlayer(deck, 1000.00, "Robot");
	players.add(human);
	players.add(ai);
	
	for(Player player : players) {
		player.setup();
		System.out.println(player.toString());
		player.initialBet(100);
		System.out.println("First Card: "+player.drawCard());
		System.out.println("Second Card: "+player.drawCard());
		if(player.canSplit()) {
			int ok = 0;
			System.out.print("Split? (5 for yes)");
			Scanner p = new Scanner(System.in);
			ok = p.nextInt();
			if(ok == 5) {
				player.splitHand();
				player.splitHandBet(250.00);
				
			}
		}
		for (Hand h : player.getHands()) {
			
			int play = 0;
			while (play != 10) {
				if(h.getHand().size() >= 2) {
					if(h.canDouble()) {
						int yes = 0;
						System.out.print("Double? (3 for yes)");
						Scanner p = new Scanner(System.in);
						yes = p.nextInt();
						if(yes == 3) {
							h.doubleDown();
						}
					}
				System.out.print("Hit? (10 to stop): ");
				Scanner p = new Scanner(System.in);
				play = p.nextInt();
				}
				
				
	
				System.out.println("You hit: " + h.hit());
				System.out.println("Your hand: " + h.getHand());
				System.out.println("Your hand total value: " + h.getHandValue());
				if (h.getHandValue() > 21) {
					System.out.println("You Lost!");
					h.lose();
					play = 10;
				}
				else if (h.getHandValue() == 21) {
					System.out.println("BLACKJACK!");
					h.win();
					play = 10;
				}
				
				
			}
			
			
		}
		System.out.println(player.toString());
		player.clearHands();
		
		}
	System.out.println("USED CARDS: \n");
	deck.getUsedDeckInfo();
	}
}
