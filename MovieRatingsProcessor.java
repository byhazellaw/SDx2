
/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {

		ArrayList<String> result = new ArrayList<>();

		if (movieRatings != null && !movieRatings.isEmpty()) {
			Set<String> movies = movieRatings.keySet(); // get names
			result.addAll(movies); // add to list
			Collections.sort(result); // sort alphabetically
			return result;
		}
		return new ArrayList(); // return empty list if null or empty
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings,
			int rating) {

		List<String> result = new ArrayList<String>();

		if (movieRatings != null) {
			for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
				String name = entry.getKey();
				if (entry.getValue().peek() > rating) {
					result.add(name);
				}

			}
		}

		return result;
	}

	@SuppressWarnings("unlikely-arg-type")
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings,
			int rating) {

		TreeMap<String, Integer> result = new TreeMap<>(); // movies names with number of ratings removed

		if (movieRatings != null && !movieRatings.isEmpty()) {
			
			
			
			java.util.Iterator<Entry<String, PriorityQueue<Integer>>> entryList = movieRatings.entrySet().iterator();
			while (entryList.hasNext()) {
			
				Map.Entry<String, PriorityQueue<Integer>> entry = entryList.next();
				java.util.Iterator<Integer> rates = entry.getValue().iterator();
				Integer removed=0;
				
				while (rates.hasNext()) {
					if (rates.next() < rating) {
						rates.remove();
						removed++;
					}
				}
				if (removed != 0) {
					result.put(entry.getKey(), removed);
				}
				if (entry.getValue().isEmpty()) {
					entryList.remove();
				}
				
				/* for loop throws nullpointer when everything is removed: for loop cannot be used to remove objects
				 * 
				for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
					if (entry != null ) {
						String name = entry.getKey();
						Integer removed = 0;

						while (entry.getValue().peek() < rating) { 			//check ratings
							entry.getValue().remove();
							removed++;
						}
						if (removed != 0) {									//add movies to result
							result.put(name, removed);

						}
						if (entry.getValue().isEmpty()) {					//all ratings are removed
							movieRatings.remove(entry);
						}
					}

				}
				**
				**/
				
			}
			
			
			
		}
		return result;
	}

}
