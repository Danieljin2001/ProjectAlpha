package codes;

import java.util.ArrayList;

public class Test {
	public static void main(String []args) throws Exception{
		ArrayList<Player> players = new ArrayList<Player>();
		Menu test = new Menu();
		int x = test.askPlayerNumber();
		Deck test1 = new Deck(test.askDeckNumber());
		
		for(int i = 0; i < x; i++) {
			players.add(new Player(test1, test.askName(),test.askMoney()));
		}
		for (Player p: players) {
			System.out.println("Player " + p.getNAME() +" " + p.getMoney());
			
			
		}
        
        
		
       
	}
}
