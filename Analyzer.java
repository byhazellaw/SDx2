
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		List<Sentence> result = new ArrayList<>();
		List<String> lines = new ArrayList<>();

		if (filename == null) {
			return new ArrayList<>();
		}
		Scanner input;
		try {
			input = new Scanner(new File(filename));

			while (input.hasNext()) {
				String line = input.nextLine();
				lines.add(line);
			}
			input.close();
		} catch (FileNotFoundException e1) {
			return new ArrayList<Sentence>();
			// e1.printStackTrace();
		}

		for (String line : lines) {

			int space = line.indexOf(" "); // find first space after score

			try {
				int score = Integer.parseInt(line.substring(0, space)); // get integer score
				String text = line.substring(space + 1); // get text after space

				if (score >= -2 && score <= 2 && !text.isEmpty()) {

					Sentence s = new Sentence(score, text);
					result.add(s);
				}
			} catch (Exception e) {
				continue;
			}
		}
		return result;
	}

	public static Set<Word> allWords(List<Sentence> sentences) {

		HashSet<Word> result = new HashSet<>();
		ArrayList<Word> words = new ArrayList<>();

		if (sentences == null || sentences.isEmpty()) {
			return new HashSet<>(); // return empty set if null or empty
		} else {

			// get word from sentence and add to word Array
			for (Sentence sentence : sentences) {

				if (sentence != null) {

					// stringtokenizer is discourages in new code
					String[] sen = sentence.getText().toLowerCase().split(" ");

					for (String wd : sen) {

						if (Character.isLetter(wd.charAt(0))) {
							Word w = new Word(wd);

							w.increaseTotal(sentence.getScore()); // the total cumulative score of all Sentences in
																	// which it appears

							// The Word objects should keep track of the number of occurrences of that word
							// in all Sentences,
							if (words.contains(w)) {
								words.get(words.indexOf(w)).increaseTotal(0); // increaseTotal ==count++ update count of
																				// that word
							} else {
								words.add(w);
							}
						}

					}
				}

			}
			result.addAll(words);
		}

		return result;
	}

	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		HashMap<String, Double> result = new HashMap<String, Double>();

		if (words == null || words.isEmpty()) {
			return new HashMap<String, Double>();
		} else {
			for (Word w : words) {
				if (w != null) {
					double score = w.calculateScore();
					String txt = w.getText();
					result.put(txt, score);
				}

			}
		}

		return result;

	}

	
	
	//return the average score of all the words in the input sentence.
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		double result = 0;
		
		int wordCount = 0;
	
		if (wordScores == null || wordScores.isEmpty() || sentence == null || sentence.isEmpty()) {
			return 0; 											//return 0
		} else {
			
			String[] str = sentence.toLowerCase().split(" "); // get token
			
			for (int i = 0; i < str.length; i++) {
				
				str[i].toLowerCase();						//you should convert them to lowercase 
				
				if (Character.isLetter(str[i].charAt(0))) { //ignore words that don't start with letter
					
					
					if (wordScores.containsKey(str[i])) {	//present in map	
						result +=  wordScores.get(str[i]);
						
					}
					wordCount++;
				}

			}
			
		}
		
		return wordCount ==0 ? 0 : result / wordCount; 

	}

	/*
	 * This method is here to help you run your program. Y You may modify it as
	 * needed.
	 */
	public static void main(String[] args) throws FileNotFoundException {

		try {

			if (args.length == 0) {
				System.out.println("Please specify the name of the input file");
				System.exit(0);
			}
			String filename = args[0];
			System.out.print("Please enter a sentence: ");
			Scanner in = new Scanner(System.in);
			String sentence = in.nextLine();
			in.close();
			List<Sentence> sentences = Analyzer.readFile(filename);
			Set<Word> words = Analyzer.allWords(sentences);
			Map<String, Double> wordScores = Analyzer.calculateScores(words);
			double score = Analyzer.calculateSentenceScore(wordScores, sentence);
			System.out.println("The sentiment score is " + score);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
