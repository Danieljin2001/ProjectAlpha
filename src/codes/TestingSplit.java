package codes;

public class TestingSplit {
	public static void recursion() {
		
		
	}
	
	public static void main(String []args) throws Exception{
		Deck deck = new Deck(1);
		HumanPlayer player = new HumanPlayer(deck, "Test Player", 10000);
		Menu menu = new Menu();
		
		player.playOrNo(true);
		System.out.println("First Card: " + player.drawCard());
		System.out.println("Second Card: " + player.drawCard());

	}


}
