package data;

import java.io.IOException;

public class tester {

	public static void main(String[] args) throws IOException {
		CSVReader csv = new CSVReader("MH");
		Probability prob = new Probability(csv.getMULTIHIT());
		prob.tester("2", "8", "Two");
	}

}
