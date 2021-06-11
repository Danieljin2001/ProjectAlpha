package codes;

import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	public static void main(String []args) throws Exception{
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
        
        
		
       
	}
}
