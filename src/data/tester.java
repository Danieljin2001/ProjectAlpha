package data;

import java.io.IOException;

public class tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CSVReader csv = new CSVReader("MH");
		Probability prob = new Probability(csv.getMULTIHIT());
		prob.tester("Two", "7", "2");

	}

}
