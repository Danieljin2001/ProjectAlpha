package codes;

public class HumanPlayer extends Player{
	public HumanPlayer(Deck deck, double startMoney, String name) {
		super(deck, startMoney, name);
		this.HUMAN = true;
		// TODO Auto-generated constructor stub
	}

	
	//player logic where it asks the player to hit, stand, bet (quitting will be in game logic?)
	//only moves
	public GameState play() {
		return null;
		
	}
	
	

}
