import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	
	
	public int findNumberOfBooksInYear(int year) {
		int count = 0;
		
		
		ArrayList<Book> books = (ArrayList<Book>) dataTier.getAllBooks();
		for (Book bk : books) {
			if (bk.getPublicationYear()==year) {
				count++;
			}
		}

		return count;
	}
	
	
	// Collection returned by findBookTitlesByAuthor contains incorrect number of book titles
	public Set<String> findBookTitlesByAuthor(String author)  {
		Set<String> titles = new HashSet();
		ArrayList<Book> books = (ArrayList<Book>) dataTier.getAllBooks();
		
		for (Book bk : books) {
			if (bk.getAuthor().contains(author.toLowerCase())) {
				titles.add(bk.getTitle());
			}
		}
		
		
		
		
		return titles;
	}
	
	

}
