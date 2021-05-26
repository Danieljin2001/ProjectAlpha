package data;

import java.io.IOException;

public class tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CSVReader csv = new CSVReader("DH");
		Probability prob = new Probability(csv.getDOUBLEHIT());
		//prob.tester("Ace", "7", "3");
		int p = prob.getRow("3", "3");
		System.out.println(p);
		
	}

}
