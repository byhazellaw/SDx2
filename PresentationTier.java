import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

/*
 * asks the user which feature they would like to use and invokes the appropriate
 *  methods in the appropriate classes
 */
public class PresentationTier {

	private LogicTier logicTier; // link to the Logic Tier

	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}

	public void start() {
		
		System.out.println("Enter A to show number of books in a year or B to show titles by author");
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.nextLine().toUpperCase();
		if (ans.equals("A")) {
			System.out.println("Please enter year");
			Scanner sc = new Scanner(System.in);
			int yr = sc.nextInt();
			System.out.println(showNumberOfBooksInYear(yr));
		} else if (ans.equals("B")) {
			System.out.println("Please enter author name");
			Scanner sc1 = new Scanner(System.in);
			String name = sc1.nextLine().toLowerCase();
			System.out.println(showBookTitlesByAuthor(name));
			
		} 
	
	}

	public Set showBookTitlesByAuthor(String author){
		
		//TODO sort list of books by year and alphabetically
		
		return logicTier.findBookTitlesByAuthor(author);
	
	}
	
	public int showNumberOfBooksInYear(int year){
		

		return logicTier.findNumberOfBooksInYear(year);
	}
	
}
