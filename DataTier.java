
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {

	private String fileName; // the name of the file to read

	public DataTier(String inputSource) {
		fileName = inputSource;

	}

	// return book objects when this method is called
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		List<String> lines = null;
		

		try {
			lines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String line : lines) {

			String[] txt = line.split("\t");
			Book bk = new Book(txt[0], txt[1].toLowerCase(), Integer.parseInt(txt[2]));
			bookList.add(bk);

		}

		return bookList;
	}

}

/*
 * if not using regex - \t = tab int tab1 = line.indexOf("	"); int tab2 =
 * line.lastIndexOf("	"); String title = line.substring(0, tab1); String
 * author = line.substring(tab1 + 1, tab2); int year =
 * Integer.parseInt(line.substring(tab2 + 1));
 */
