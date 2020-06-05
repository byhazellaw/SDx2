/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		TreeMap<String, PriorityQueue<Integer>> result = new TreeMap<>();
		
		
		if (allUsersRatings!=null) {
			for (UserMovieRating rating : allUsersRatings) {
				if (rating!=null && rating.getMovie()!=null && !rating.getMovie().isEmpty() && rating.getUserRating()>0) {
					
					PriorityQueue<Integer> ranks = new PriorityQueue<>(); //a queue for every movie
					
					String name = rating.getMovie().toLowerCase();
					ranks.add(rating.getUserRating());
					if (result.get(name)==null) {						//check if movie exists in the map
						result.put(name, ranks);
					} else {
						result.get(name).add(rating.getUserRating());
					}
				}
				
				
			}
			return result;
		}
		
		return new TreeMap<>(); 			//null result
	}

	

}
