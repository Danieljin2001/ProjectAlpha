package codes;

import java.util.ArrayList;

public class Test {
	public static void main(String []args) throws Exception{
		ArrayList<Player> players = new ArrayList<Player>();
		Menu test = new Menu();
		test.askPlayerNumber();
		test.askDeckNumber();
		Deck test1 = new Deck(test.getDECK_NUMBER());
		
		for(int i = 0; i < test.getPLAYER_NUMBER(); i++) {
			test.askName();
			test.askMoney();
			players.add(new Player(test1, test.getMONEY(), test.getNAME()));
		}
		
        
        
		
       
	}
}
