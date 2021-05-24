package codes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Dealer {
	
	static int handValue = 0;
	
	static int sum(ArrayList<Integer> list)  //method that returns the sum of the hand
	  {
	   int sum = 0;
	   for ( Integer d:list)
	     sum = sum + d;
	    return sum;
	  }
	
	public static void main(String []args) throws Exception{
		
        Deck firstDeck = new Deck(1);   
        ArrayList<Card> drawnCards = new ArrayList<Card>();
//list containing the integers of the cards so you can sum it
        ArrayList<Integer> drawnCardsInt = new ArrayList<Integer>();
        
        
        // dealer logic i guess
        //added a delay between outputs just to be dramatic
        int x = 0;
        boolean hitting = true;
		while (hitting == true){
			
			System.out.println("dealer hit"+ "\n");
			TimeUnit.SECONDS.sleep(1);
        	drawnCards.add(firstDeck.drawCard());

        	Card card = drawnCards.get(x);
        	
            System.out.println(drawnCards.get(x));
            
        	drawnCardsInt.addAll(card.getValue());
        	x += 1;
        	
        	double sum = 0;
            for (int i : drawnCardsInt) {
              sum += i;
            }
            handValue = (int) sum;
            if(sum > 17) {
            	hitting = false;
            }

            System.out.println("Total is " + handValue + "\n");
            TimeUnit.SECONDS.sleep(2);
        }
		if (handValue > 21){
			Lost();

		}
		if (handValue == 21){
			
			Win();
		}
		if (handValue <21)
		{
			Hold();
		}
       }
		
		
	public static void Win (){
		System.out.println("Dealer Won");
	}
	
	public static void Lost (){
		System.out.println("fuck");
	}
	
	public static void Hold (){
		System.out.println("Dealer holds");
	} 

        
}

